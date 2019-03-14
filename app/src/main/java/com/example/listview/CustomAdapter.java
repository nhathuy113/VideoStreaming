package com.example.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;


    //to store the list of
    private final String[] nameArray;

    //to store the list of
    private final String[] infoArray;

    // Constructor
    public CustomAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam){
        super(context,R.layout.activity_main , nameArrayParam);

        this.context=context;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
    }

    // map Properties to View fields
    public View getView(int position, View view, ViewGroup parent) {
        // get the current View
        LayoutInflater inflater = context.getLayoutInflater();

        // attach template xml file to the current View
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.infoTextViewID);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        infoTextField.setText(infoArray[position]);

        return rowView;
    };
}