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

public class ListView_ChestShoulders_SecondWo extends AppCompatActivity {
    Button back;
    ListView ExerciseListView;
    ArrayList<BodyParts> bodyparts;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_chestshoulders_secondwo);
        this.back = (Button) findViewById(R.id.back12);
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ListView_ChestShoulders_SecondWo.this, End_Beginning.class);
                startActivity(intent);
            }
        });
        this.ExerciseListView = (ListView) findViewById(R.id.Listview8);
        adapter = new CustomAdapter();
        bodyparts = new ArrayList<>();
        BodyParts bodyparts1 = new BodyParts(false, "לחיצת חזה");
        bodyparts.add(bodyparts1);
        BodyParts bodyparts2 = new BodyParts(false, "שכיבות שמיכה");
        bodyparts.add(bodyparts2);
        BodyParts bodyparts3 = new BodyParts(false, "מקבילים");
        bodyparts.add(bodyparts3);
        BodyParts bodyparts4 = new BodyParts(false, "לחיצת כתפיים ");
        bodyparts.add(bodyparts4);
        BodyParts bodyparts5 = new BodyParts(false, "הרחקת משקולות לצדדים");
        bodyparts.add(bodyparts5);
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
            checkboxCb.setChecked(Model.getInstance().exerciseExistsInSecondWo(Model.Chest_Shoulders,bodyparts.get(position).getExercise()));
            checkboxCb.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Model.getInstance().addOrRemoveFromSecondWo(Model.Chest_Shoulders, nameTv.getText().toString());
                }
            });
            nameTv.setText(bodyparts.get(position).getExercise());
            return convertView;
        }
    }
}
