package com.example.pranesh.firstapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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


public class signup extends Activity {


    private EditText userName, userPassword, userEmail;
    private Button SignUpbtn;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        SignUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //register to the database
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(signup.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signup.this, MainActivity.class));
                            } else {
                                Toast.makeText(signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }


                        }


                    });

                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this, MainActivity.class));
            }
        });
    }

/*
        //Name = (EditText) findViewById(R.id.fpName);
        Password = (EditText) findViewById(R.id.TFpass1);
        Email = (EditText) findViewById(R.id.TFemail);
       //
        // Login = (Button) findViewById(R.id.fpbtnLogin);
        Signup = (Button) findViewById(R.id.fpbtnSignup);
        Info = (TextView) findViewById(R.id.fptvInfo);
        firebaseAuth = FirebaseAuth.getInstance();


        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validate()) {

                    String user_email = Email.getText().toString().trim();
                    String user_password = Password.getText().toString().trim();
                    //   String user_name = Name.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(this, "Registration  Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent());
                            } else {
                                Toast.makeText(MainActivity.this, "Registration  Failed", Toast.LENGTH_SHORT).show();

                            }


                        }
                    });


                }
            }
        });
    }

*/
    private void setupUIViews(){
        userName = (EditText) findViewById(R.id.TFname);
        userPassword = (EditText) findViewById(R.id.TFpass);
        userEmail = (EditText) findViewById(R.id.TFemail);
        SignUpbtn = (Button) findViewById(R.id.Bsignupbutton);
        userLogin = (TextView) findViewById(R.id.sptvInfo);
    }

    private Boolean validate(){
        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Please enter the valid details correctly",Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
    return result;
    }
}
