package com.example.pranesh.firstapp;


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


public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private EditText Email;
    private TextView Info;
    //private Button Signup;
    private int counter = 5;
    private Button userRegister;
    //private FirebaseAuth firebaseAuth;
    //private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    //private DatabaseReference mRootReference = firebaseDatabase.getReference();
    //private DatabaseReference mChildReference = mRootReference.child("message");

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = (EditText) findViewById(R.id.fpName);
        Password = (EditText) findViewById(R.id.fpPassword);
        //Email = (EditText) findViewById(R.id.fpEmail);
        Login = (Button) findViewById(R.id.fpbtnLogin);
        //Signup = (Button) findViewById(R.id.fpbtnSignup);
        Info = (TextView) findViewById(R.id.fptvInfo);
        //firebaseAuth = FirebaseAuth.getInstance();
        userRegister = (Button) findViewById(R.id.fpbtnSignup);


        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*if (validate()) {

                    String user_email = Email.getText().toString().trim();
                    String user_password = Password.getText().toString().trim();
                 //   String user_name = Name.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                          if(task.isSuccessful()){
                              Toast.makeText(MainActivity.this, "Registration  Successful", Toast.LENGTH_SHORT).show();
                              startActivity(new Intent(MainActivity.this, display.class));
                          }else{
                              Toast.makeText(MainActivity.this, "Registration  Failed", Toast.LENGTH_SHORT).show();

                          }


                        }
                    });


                }
            }
        });
    }
*/

                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, signup.class));
            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("pranesh")) && (userPassword.equals("1234"))) {
            Intent i = new Intent(MainActivity.this, display.class);
            startActivity(i);
        } else {
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if (counter == 0) {
                Login.setEnabled(false);
            }
        }
    }
}

   /* public void onButtonClick(View v) {
        if (v.getId() == R.id.fpbtnSignup) {
            Intent i = new Intent(MainActivity.this, signup.class);
            startActivity(i);
        }
    }
}*/
