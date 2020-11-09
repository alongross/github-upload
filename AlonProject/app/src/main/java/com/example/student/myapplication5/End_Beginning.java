package com.example.student.myapplication5;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class End_Beginning extends AppCompatActivity {

    public static User currentuser;
    Button c;

    Uri selectedImageUri;
    String selectedPath;
    ImageView preview;
    Button b;
    Button bCam;
    RelativeLayout r;
    public static final int FROM_CAMERA = 111, FROM_GALLERY = 222;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_beginning);
      //  b = (Button) findViewById(R.id.bGallery);
      //  bCam = (Button) findViewById(R.id.bCamera);
      //  preview = (ImageView) findViewById(R.id.preview);
        r=(RelativeLayout) findViewById(R.id.activity_main2);
        final Button btn = (Button) findViewById(R.id.Start);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(End_Beginning.this, Choosing_Workout.class);
                startActivity(intent);
            }
        });
        final Button info = (Button) findViewById(R.id.information);
        info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(End_Beginning.this, information.class);
                startActivity(intent);
            }
        });
        final Button end = (Button) findViewById(R.id.end);
        end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(End_Beginning.this, end.class);
                startActivity(intent);
            }
        });
/*
        bCam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                from_camera();

            }
        });

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                from_gallery();

            }
        });
    }


        public void from_camera ()
        {

            Intent cameraIntent = new Intent(
                    android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

            startActivityForResult(cameraIntent, FROM_CAMERA);

        }


        public void from_gallery () {
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, FROM_GALLERY);


        }


        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            // TODO Auto-generated method stub

            if (resultCode == RESULT_OK && requestCode == FROM_CAMERA) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                preview.setImageBitmap(photo);
                Uri selectedImageUri = data.getData();
                Log.e("uriError",""+selectedImageUri);
                Drawable bg;
                try {
                    InputStream inputStream = getContentResolver().openInputStream(selectedImageUri);
                    bg = Drawable.createFromStream(inputStream, selectedImageUri.toString());
               //     r.setBackground
                } catch (FileNotFoundException e) {
                    bg = ContextCompat.getDrawable(this, R.drawable.imagei1);
                }
            } else if (resultCode == RESULT_OK && requestCode == FROM_GALLERY) {
                Uri selectedImageUri = data.getData();
                Drawable bg;
                try {
                    InputStream inputStream = getContentResolver().openInputStream(selectedImageUri);
                    bg = Drawable.createFromStream(inputStream, selectedImageUri.toString());
                } catch (FileNotFoundException e) {
                  bg = ContextCompat.getDrawable(this, R.drawable.imagei1);
                }



                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();

                preview.setImageBitmap(BitmapFactory.decodeFile(picturePath));

                super.onActivityResult(requestCode, resultCode, data);
            }*/
        }

   /* public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.logout)
            Intent intent = new Intent(End_Beginning.this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "logout - complete code", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }*/
    }
