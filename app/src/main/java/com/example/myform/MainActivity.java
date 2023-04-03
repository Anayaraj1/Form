package com.example.myform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText  edusename,edemail,edpassword,edcnfpassword;
    Button btnsubmit;
    MyDatabase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edusename = findViewById(R.id.edName);
        edemail = findViewById(R.id.edemail);
        edpassword = findViewById(R.id.edpassword);
        edcnfpassword = findViewById(R.id.edcpassword);
        btnsubmit = findViewById(R.id.btnsubmit);
        mydb = new MyDatabase(MainActivity.this);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edpassword.getText().toString().equals(edcnfpassword.getText().toString()))
                {
                    long id= mydb.insertData(edusename.getText().toString(),edemail.getText().toString(),edpassword.getText().toString());
                    Log.d("mydata","id= " +id);
                    Toast.makeText(MainActivity.this, "Succesfully Data Insert", Toast.LENGTH_SHORT).show();

                }else
                {
                    Toast.makeText(MainActivity.this, "Password and Confirm Password are not same", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}