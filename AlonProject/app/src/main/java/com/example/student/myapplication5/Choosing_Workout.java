package com.example.student.myapplication5;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
public class Choosing_Workout extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosing_workout);
        final CheckBox c1=(CheckBox) findViewById(R.id.first);
        final CheckBox c2=(CheckBox) findViewById(R.id.second);
        Button btn4=(Button) findViewById(R.id.continue_Button3);
        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (c1.isChecked() || c2.isChecked())
                {
                    if (c1.isChecked() && c2.isChecked())
                    {
                        Toast.makeText(Choosing_Workout.this, "אתה חייב לילחוץ על אחד מה הסימונים", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        if ((c1.isChecked()))
                        {
                            Intent intent = new Intent(Choosing_Workout.this, Choosing_Exercises.class);
                            intent.putExtra("checkBox1", c1.isChecked());
                            startActivity(intent);
                        }
                        else
                        {
                            Intent intent = new Intent(Choosing_Workout.this, Choosing_Exercises.class);
                            intent.putExtra("checkBox2", c2.isChecked());
                            startActivity(intent);

                        }
                    }
                }
                else
                {
                    Toast.makeText(Choosing_Workout.this, "אתה חייב לילחוץ על אחד מה הסימונים", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
