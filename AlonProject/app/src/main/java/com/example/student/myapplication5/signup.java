package com.example.student.myapplication5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class signup extends AppCompatActivity
{
    Firebase myFirebaseRef = new Firebase("https://holidays-project-683bf.firebaseio.com/");
    public EditText name, password;
    String names, passwords;
    boolean flag1 = true, flag2 = true, flag3 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        code();
    }

    public void chack()
    {
        String names = name.getText().toString();
        String passwords = password.getText().toString();
        if (names.length() == 0)
        {
            flag1 = false;
        }
        if (passwords.length() == 0)
        {
            flag3 = false;
        }
    }


    public void code()
    {
        final Button cancelbtn = (Button) findViewById(R.id.coooooo);
        cancelbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(signup.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        name = (EditText) findViewById(R.id.nameedit);
        password = (EditText) findViewById(R.id.passedit);
        Button acceptbtn = (Button) findViewById(R.id.accept);
        acceptbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                chack();
                if (flag1 && flag2 & flag3)
                {
                    names = name.getText().toString();
                    passwords = password.getText().toString();
                    final User user = new User(names, passwords);
                    Firebase firesave = myFirebaseRef.child("users").child(names);
                    firesave.setValue(user, new Firebase.CompletionListener()
                    {
                        @Override
                        public void onComplete(FirebaseError firebaseError, Firebase firebase)
                        {
                            finish();
                        }
                    });
                } else
                {
                    Toast.makeText(signup.this, "please fill the missing lines", Toast.LENGTH_LONG).show();
                    flag1 = true;
                    flag2 = true;
                    flag3 = true;
                    ((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(100);
                }

            }
        });

    }


}
