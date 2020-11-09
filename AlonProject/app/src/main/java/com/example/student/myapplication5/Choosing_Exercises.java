package com.example.student.myapplication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choosing_Exercises extends AppCompatActivity
{
    private boolean value;
    private boolean value2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosing_exercises);
        Button btn4 = (Button) findViewById(R.id.legsabs);
        Button btn5 = (Button) findViewById(R.id.arms);
        Button btn6 = (Button) findViewById(R.id.Back20);
        Button btn7 = (Button) findViewById(R.id.chestshoulders);
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            value = extras.getBoolean("checkBox1");
            value2 = extras.getBoolean("checkBox2");
        }
        btn4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (value == true)
                {
                    Intent intent = new Intent(Choosing_Exercises.this, ListView_LegsAbs_FirstWo.class);
                    startActivity(intent);
                } else
                {
                    Intent intent = new Intent(Choosing_Exercises.this, ListView_LegsAbs_SecondWo.class);
                    startActivity(intent);
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (value == true)
                {
                    Intent intent = new Intent(Choosing_Exercises.this, ListView_Arms_FirstWo.class);
                    startActivity(intent);
                }
                if (value2 == true)
                {
                    Intent intent = new Intent(Choosing_Exercises.this, ListView__Arms_SecondWo.class);
                    startActivity(intent);
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (value == true)
                {
                    Intent intent = new Intent(Choosing_Exercises.this, ListView_Back_FirstWo.class);
                    startActivity(intent);
                }
                if (value2 == true)
                {
                    Intent intent = new Intent(Choosing_Exercises.this, ListView_Back_SecondWo.class);
                    startActivity(intent);
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (value == true)
                {
                    Intent intent = new Intent(Choosing_Exercises.this, ListView_ChestShoulders_FirstWo.class);
                    startActivity(intent);
                }
                if (value2 == true)
                {
                    Intent intent = new Intent(Choosing_Exercises.this, ListView_ChestShoulders_SecondWo.class);
                    startActivity(intent);
                }
            }
        });
    }
}
