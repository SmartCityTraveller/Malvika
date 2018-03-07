package com.example.a2015m.smartcitytraveller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class firstActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Attempt;
    private Button Login;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Username=(EditText)findViewById(R.id.etusername);
        Password=(EditText)findViewById(R.id.etpassword);
        Attempt=(TextView)findViewById(R.id.tvinfo);
        Login=(Button)findViewById(R.id.btnlogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(),Password.getText().toString());
            }
        });


    }

    public void validate(String username,String password){
        if ((username.equals("Malvika")) && (password.equals("1234"))){
            Intent intent = new Intent (firstActivity.this,secondActivity.class);
            startActivity(intent);
        }
        else{
            counter--;
            Attempt.setText("NO. of remaming attempts:"+String.valueOf(counter));
            if (counter==0){
                Login.setEnabled(false);
            }
        }
    }
}
