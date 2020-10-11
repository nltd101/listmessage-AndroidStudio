package com.nltd12345679.setstringcontent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button)findViewById(R.id.buttonAdd);
        btn1.setOnClickListener(this);


        btn1 = (Button)findViewById(R.id.buttonNavigate);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.buttonAdd)
        {
            add2Numbers();
        }
        else if (v.getId()==R.id.buttonNavigate)
        {
            navigate2WebPage();
        }
        else if (v.getId()==R.id.buttonOpenCamera){

            dispatchTakePictureIntent();
        }
        else if (v.getId()==R.id.buttonNavigateListMessage)
        {
            startActivity(new Intent(this,MainActivity3.class));
        }
    }

    private void navigate2WebPage() {
        EditText edit = findViewById(R.id.editURL);
//        Uri uri = Uri.parse(String.valueOf(edit.getText()));
//        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//        startActivity(intent);
        Double x,y;
        x=5.0;
        y=x;
        y=6.0;
        edit.setText(String.valueOf(y));
    }

    private void add2Numbers() {
        double x = getDoubleFromEditText(R.id.editNumber1);
        double y = getDoubleFromEditText(R.id.editNumber2);
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("var1",x);
        intent.putExtra("var2",y);
        Log.d("Main", "add2Numbers: "+x);
        startActivityForResult(intent,req);
    }

    private double getDoubleFromEditText(int editNumber2) {
        EditText editText = findViewById(editNumber2);
        return Double.parseDouble(String.valueOf(editText.getText()));
    }
    private int req = 3009;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==req&& resultCode==RESULT_OK)
        {
            double res =data.getDoubleExtra("res",0);
            EditText editText = findViewById(R.id.editURL);
            editText.setText(String.valueOf(res));
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView img = findViewById(R.id.image);
            img.setImageBitmap(imageBitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}




