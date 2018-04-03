package com.example.pranesh.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**
 * Created by Pranesh on 21-Mar-18.
 */

public class signup extends Activity {
    private EditText Name;
    private EditText userName;
    private EditText Password1;
    private EditText Password2;
    private EditText Email;
    private Button Signup;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mChildReference = mRootReference.child("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(validate()){
                    //register to the database
                    String full_name = Name.getText().toString().trim();
                    String user_email = Email.getText().toString().trim();
                    String user_password1 = Password1.getText().toString().trim();
                    String user_password2 = Password2.getText().toString().trim();
                    String user_name = userName.getText().toString().trim();


                    if (!user_password1.equals(user_password2)) {
                        Toast pass = Toast.makeText(signup.this, "Password don't match!!", Toast.LENGTH_SHORT);
                        pass.show();
                    }
                    firebaseAuth.createUserWithEmailAndPassword(user_name, user_password1).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task){
                            if(task.isSuccessful()){
                                Toast.makeText(signup.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signup.this,MainActivity.class ));
                            } else {
                                Toast.makeText(signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }

        });



    }
    private void setupUIViews(){
        Name = (EditText) findViewById(R.id.TFname);
        userName = (EditText) findViewById(R.id.TFuname);
        Password1 = (EditText) findViewById(R.id.TFpass1);
        Password2 = (EditText) findViewById(R.id.TFpass2);
        Email = (EditText) findViewById(R.id.TFemail);
        Signup = (Button) findViewById(R.id.Bsignupbutton);
        firebaseAuth = FirebaseAuth.getInstance();

    }
    private Boolean validate() {
        Boolean result = false;
        String name = Name.getText().toString();
        String password2 = Password2.getText().toString();
        String username = userName.getText().toString();
        String password1 = Password1.getText().toString();
        String email = Email.getText().toString();

        if(name.isEmpty() || password1.isEmpty() || email.isEmpty() || password2.isEmpty() || username.isEmpty()){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }
        return result;
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.Bsignupbutton) {
            Intent i = new Intent(signup.this, MainActivity.class);
            startActivity(i);
        }
    }

}
