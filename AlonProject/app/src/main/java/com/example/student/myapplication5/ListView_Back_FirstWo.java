package com.example.student.myapplication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListView_Back_FirstWo extends AppCompatActivity {
    Button back;
    ListView ExerciseListView;
    ArrayList<BodyParts> bodyparts;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_back_firstwo);
        this.back = (Button) findViewById(R.id.back9);
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ListView_Back_FirstWo.this, End_Beginning.class);
                startActivity(intent);
            }
        });
        this.ExerciseListView = (ListView) findViewById(R.id.Listview5);
        adapter = new CustomAdapter();
        bodyparts = new ArrayList<>();
        BodyParts bodyparts1 = new BodyParts(false, "מתח ");
        bodyparts.add(bodyparts1);
        BodyParts bodyparts2 = new BodyParts(false, "פולי עליון ");
        bodyparts.add(bodyparts2);
        BodyParts bodyparts3 = new BodyParts(false, " משיכה עילית בזרועות כפופות בשכיבה ");
        bodyparts.add(bodyparts3);
        BodyParts bodyparts4 = new BodyParts(false, "חתירה ביד אחת בהטיית גב ");
        bodyparts.add(bodyparts4);
        BodyParts bodyparts5 = new BodyParts(false, "חתירה בישיבה בכבל");
        bodyparts.add(bodyparts5);
        BodyParts bodyparts6 = new BodyParts(false, "חתירה כנגד מוט בהטיית גו");
        bodyparts.add(bodyparts6);
        BodyParts bodyparts7 = new BodyParts(false, "מתח ליד קדמית");
        bodyparts.add(bodyparts7);
        ExerciseListView.setAdapter(adapter);
    }
    class CustomAdapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return bodyparts.size();
        }

        @Override
        public Object getItem(int position)
        {
            return bodyparts.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
            {
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.rowlayout, null);
            }
            final TextView nameTv;
            CheckBox checkboxCb;
            nameTv = (TextView) convertView.findViewById(R.id.namelayout);
            checkboxCb = (CheckBox) convertView.findViewById(R.id.checkboxlayout);
            checkboxCb.setChecked(Model.getInstance().exerciseExistsInFirstWo(Model.Back,bodyparts.get(position).getExercise()));
            checkboxCb.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Model.getInstance().addOrRemoveFromFirstWo(Model.Back, nameTv.getText().toString());
                }
            });
            nameTv.setText(bodyparts.get(position).getExercise());
            return convertView;
        }
    }
}
