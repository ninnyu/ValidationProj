package com.example.potatopaloozac.validationproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.*;

/**
 * This is Mikki's Review.
 */

public class MainActivity extends AppCompatActivity {

    EditText username, password, email, dob;
    Button ub, pb, eb, db;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        dob = findViewById(R.id.dateofbirth);
        ub = findViewById(R.id.submit_user);
        pb = findViewById(R.id.submit_password);
        eb = findViewById(R.id.submit_email);
        db = findViewById(R.id.submit_dob);

        ub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUser(username.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Valid username", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Invalid username", Toast.LENGTH_SHORT).show();
            }
        });

        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validatePassword(password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Valid password", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
            }
        });

        eb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateEmail(email.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Valid email", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Invalid email", Toast.LENGTH_SHORT).show();
            }
        });

        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateDob(dob.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Valid date of birth", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Invalid date of birth", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean validateUser(String s) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]{4,20}$");
        return pattern.matcher(s).matches();
    }

    public boolean validatePassword(String s) {
        Pattern pattern = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_+,?-]).{10,20}");
        return pattern.matcher(s).matches();
    }

    public boolean validateEmail(String s) {
        Pattern pattern = Pattern.compile("^[a-zA-z0-9_-]+(\\.[a-zA-z0-9_-]+)*@[a-zA-z0-9_-]+(\\.[a-zA-z0-9]+)*(\\.[a-zA-z]{2,})$");
        return pattern.matcher(s).matches();
    }

    public boolean validateDob(String s) {
        Pattern pattern = Pattern.compile("^(0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])[/](19|20[0-9][0-9])$");
        return pattern.matcher(s).matches();
    }
}
