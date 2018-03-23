package com.example.pranesh.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Pranesh on 22-Mar-18.
 */

public class display extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display1);
        String username = getIntent().getStringExtra("Username");


        TextView tv = (TextView) findViewById(R.id.TVtextview);
        tv.setText(username);
    }
}