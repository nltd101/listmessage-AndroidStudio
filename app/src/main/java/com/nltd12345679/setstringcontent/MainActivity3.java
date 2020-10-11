package com.nltd12345679.setstringcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.nltd12345679.setstringcontent.Adapter.MessageArrayAdapter;
import com.nltd12345679.setstringcontent.Object.Message;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private ArrayList<Message> arr = new ArrayList<>();
    private MessageArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initDynamicListview();
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgbtnSend:
                EditText edtMgs = findViewById(R.id.edtMessage);
                String content = String.valueOf(edtMgs.getText());
                adapter.add(new Message(R.drawable.google,content,"me","Facebook"));
                edtMgs.setText("");
                break;
        }
    }
    private void initDynamicListview() {
        ListView listView = findViewById(R.id.listViewChat);
        arr = new ArrayList<>();
        arr.add(new Message(R.drawable.facebook,"Hiiiii","Facebook","me"));
        arr.add(new Message(R.drawable.facebook,"Can I have a really good snack?","Facebook","me"));
        arr.add(new Message(R.drawable.google,"Uh","me","Facebook"));
        arr.add(new Message(R.drawable.google,"We’d better wait","me","Facebook"));
        arr.add(new Message(R.drawable.google,"I think it’s going on dinner","me","Facebook"));
        arr.add(new Message(R.drawable.google,"Uh, it’s three thirty","Facebook","me"));
        arr.add(new Message(R.drawable.google,"Three thirty. Uh . . . We’d better wait.","me","Facebook"));
        arr.add(new Message(R.drawable.google,"Well, what kind of snack do you want?","me","Facebook"));
        arr.add(new Message(R.drawable.facebook,"Candy?","Facebook","me"));
        adapter = new MessageArrayAdapter(this, arr);
        listView.setAdapter(adapter);
    }


}