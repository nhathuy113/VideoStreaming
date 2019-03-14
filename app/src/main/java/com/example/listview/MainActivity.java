package com.example.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
//import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = { "channel 1" , "channel 2"};
    String[] infoArray = { "Vinh Long 1" , "Vinh Long 2" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // show layout/activity_main.xml
        setContentView(R.layout.activity_main);

        // List View
        // call the class
        CustomAdapter customAdapter = new CustomAdapter(this, nameArray, infoArray);
        // change the view
        ListView listView = findViewById(R.id.listViewId);
        listView.setAdapter(customAdapter);
        // ===========


        // Channel
        // on click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set Activity
                Intent intent = new Intent(MainActivity.this, StreamActivity.class);
                // save the onClick channel
                String message = nameArray[position];
                // transfer the saved
                intent.putExtra("bleh", message);
                // switch Activity
                startActivity(intent);
            }
        });
        // ===========
    }



}
