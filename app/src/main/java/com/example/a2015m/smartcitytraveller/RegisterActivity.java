package com.example.a2015m.smartcitytraveller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity
{
    DatabaseHelper helper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onregisterbuttonClick(View v) throws ParseException
    {
        if (v.getId() == R.id.registerbutton)
        {
            EditText name = (EditText) findViewById(R.id.etname);
            EditText dob = (EditText) findViewById(R.id.etdob);
            EditText number = (EditText) findViewById(R.id.etnumber);
            EditText email = (EditText) findViewById(R.id.etemail);
            EditText password = (EditText) findViewById(R.id.etpassword);
            EditText cpassword = (EditText) findViewById(R.id.etcpassword);

            String namestr = name.getText().toString();
            String dobstr = dob.getText().toString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
            Date dobdate = dateFormat.parse(dobstr);
            String numberstr = number.getText().toString();
            int numberint = Integer.parseInt(numberstr);
            String emailstr = email.getText().toString();
            String passwordstr = password.getText().toString();
            String cpasswordstr = cpassword.getText().toString();

            if (!(passwordstr.equals(cpasswordstr))) {
                //toast is used to display popup msg
                Toast popup = Toast.makeText(RegisterActivity.this, "Passwords don't Match!", Toast.LENGTH_SHORT);
                popup.show();
            }
            else
            {
                Contact c = new Contact();
                c.setName(namestr);
                c.setDob(dobdate);
                c.setNumber(numberint);
                c.setEmail(emailstr);
                c.setPassword(passwordstr);

                helper.insertContact(c);
            }
        }
    }
}
