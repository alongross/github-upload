package com.example.student.myapplication5;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{

    public static Firebase myFirebaseRef;
    public EditText nameedt, passwordedt;
    public String name, password;
    public Button loginbtn, sighinbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://holidays-project-683bf.firebaseio.com/");
        initWidgets();
        Intent intent=new Intent(this,SoundService.class);
        startService(intent);
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,12);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);

        Intent intent1=new Intent(getApplicationContext(),Notification_reciver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.logout)
            Toast.makeText(this, "logout - complete code", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


    private void initWidgets()
    {
        logincode();
    }

    public void login(String name, String password)
    {
        checkUser(name, password, new UserCheckListener()
        {
            @Override
            public void onUserChecked(boolean userCorrect, User user)
            {
                if (userCorrect)
                {
                    End_Beginning.currentuser = user;
                    Model.getInstance().updateExercisesByUser(user);
                    Intent intent = new Intent(MainActivity.this, End_Beginning.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    interface UserCheckListener
    {
        void onUserChecked(boolean userCorrect, User user);
    }

    private void checkUser(final String name, final String password, final UserCheckListener listener)
    {
        myFirebaseRef.child("users").child(name).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                User user = dataSnapshot.getValue(User.class);
                listener.onUserChecked(name.equals(user.getName()) && password.equals(user.getPassword()), user);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {

            }
        });
    }

    public void logincode()
    {
        nameedt = (EditText) findViewById(R.id.UserName_Login);
        passwordedt = (EditText) findViewById(R.id.Password_Login);
        sighinbtn = (Button) findViewById(R.id.register_button1);
        sighinbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            }
        });
        loginbtn = (Button) findViewById(R.id.Login_Button);
        loginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                name = nameedt.getText().toString();
                password = passwordedt.getText().toString();
                login(name, password);
            }
        });
    }

}
