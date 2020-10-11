package com.nltd12345679.setstringcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        double a = intent.getDoubleExtra("var1",0);
        double b = intent.getDoubleExtra("var2",0);
        double res= a+b;
        Intent intent1 = new Intent();
        intent1.putExtra("res",res);
        setResult(RESULT_OK,intent1);
        finish();
       // setContentView(R.layout.activity_main2);
    }
}