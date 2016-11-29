package udem.gymtrack_workoutlog;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.io.Serializable;

import static udem.gymtrack_workoutlog.MainActivity.ANONYMOUS;

public class WorkoutActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private String mUsername;
    private GoogleApiClient mGoogleApiClient;
    private static final String TAG = "WorkoutActivity";

    // Firebase instance variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Workout, MainActivity.ExerciseViewHolder>
            mFirebaseAdapter;

    //Global variables
    Workout workout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        Bundle extras = getIntent().getExtras();
          // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
           //setSupportActionBar(toolbar);
        authenticate();
        CalendarDay day = (CalendarDay) extras.get("Day");
        if (day != null) {
            System.out.println("El día de hoy es "+day.toString());
        }
        workout = new Workout(day);
    }

    //Initialize menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //Menu option events
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_out_menu:
                mFirebaseAuth.signOut();
                Auth.GoogleSignInApi.signOut(mGoogleApiClient);
                mFirebaseUser = null;
                mUsername = ANONYMOUS;
                startActivity(new Intent(this, SignInActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void authenticate(){
        // Initialize Firebase Auth
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        } else {
            mUsername = mFirebaseUser.getDisplayName();
        }

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API)
                .build();
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }

    public void addExersice(View view) {
        Intent intent = new Intent(this, SelectCategoryActivity.class);
        startActivityForResult(intent, 777);
    }

    @Override
    protected void onActivityResult (int requestCode,
                                     int resultCode, Intent data){
        if (requestCode==777 && resultCode==RESULT_OK) {
            Exercise exercise = (Exercise) data.getExtras().get("Exersice");
            System.out.println("Se creo el ejercicio! "+exercise.toString());
        }}
}
