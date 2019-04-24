package com.example.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
//import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = { "HTV1", "HTV2", "HTV3", "Vinh Long 1" , "Vinh Long 2" };
    //String[] infoArray = { "VTV1", "VTV2", "VTV3", "Vinh Long 1" , "Vinh Long 2" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // show layout/activity_main.xml
        setContentView(R.layout.activity_main);

        // List View
        // call the class
        CustomAdapter customAdapter = new CustomAdapter(this, nameArray);
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
                String message1 = nameArray[position];
                String message2 = Integer.toString(position);
                // transfer the saved
                intent.putExtra("bleh1", message1);
                intent.putExtra("bleh2", message2);
                // switch Activity
                startActivity(intent);
            }
        });
        // ===========
    }



}
