package com.example.student.myapplication5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class end extends AppCompatActivity {
    ListView[]  secondwoExercises, firstwoExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        initWidgets();
    }

    private void initWidgets() {
        this.secondwoExercises = new ListView[Model.Body_Parts.length];
        for (int i = 0; i < this.secondwoExercises.length; i++) {
            int id = getResources().getIdentifier(Model.Body_Parts[i] + "_secondwo_listView", "id", getPackageName());
            this.secondwoExercises[i] = (ListView) findViewById(id);
            final ArrayList<String> items = Model.getInstance().SecondWoExercises(Model.Body_Parts[i]);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout2, R.id.namelayout2, items);
            this.secondwoExercises[i].setAdapter(adapter);
        }

        this.firstwoExercises = new ListView[Model.Body_Parts.length];
        for (int i = 0; i < this.firstwoExercises.length; i++) {
            int id = getResources().getIdentifier(Model.Body_Parts[i] + "_firstwo_listView", "id", getPackageName());
            this.firstwoExercises[i] = (ListView) findViewById(id);
            final ArrayList<String> items = Model.getInstance().FirstWoExercises(Model.Body_Parts[i]);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout2, R.id.namelayout2, items);
            this.firstwoExercises[i].setAdapter(adapter);
        }
        User currentUser = End_Beginning.currentuser;
        currentUser.setExercises(Model.getInstance().getExercises());
        MainActivity.myFirebaseRef.child("users").child(currentUser.getName()).child("exercises").setValue(currentUser.getExercises());
    }
}
