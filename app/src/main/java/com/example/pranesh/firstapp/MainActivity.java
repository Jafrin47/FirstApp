package com.example.pranesh.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.Bsignup) {
            EditText a = (EditText) findViewById(R.id.TFusername);
            String str = a.getText().toString();

            Intent i = new Intent(MainActivity.this, Display.class);
            i.putExtra("Username", str);
            startActivity(i);
        }
        if (v.getId() == R.id.Bsignup) {
            Intent i = new Intent(MainActivity.this, signup.class);
            startActivity(i);
        }
    }


    public void onButtonClick1(View v) {
        if (v.getId() == R.id.Blogin) {
            EditText a = (EditText) findViewById(R.id.TFusername);
            String s = a.getText().toString();

            Intent i = new Intent(MainActivity.this, Display.class);
            i.putExtra("Username", s);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Uncomment the below code to Set the message and title from the strings.xml file
        //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        builder.setMessage("Do you want to close this application ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("AlertDialogExample");
        alert.show();
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
}
