package com.example.pranesh.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by Pranesh on 22-Mar-18.
 */

public class display extends Activity {

    private EditText Name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);


        Name = (EditText) findViewById(R.id.fpName);


    }
}