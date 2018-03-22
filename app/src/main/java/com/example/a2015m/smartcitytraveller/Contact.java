package com.example.a2015m.smartcitytraveller;

import java.util.Date;

public class Contact
{
    int number;
    String name, email, password;
    Date dob;

    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setDob(Date dob)
    {
        this.dob=dob;
    }
    public Date getDob()
    {
        return this.dob;
    }
    public void setNumber(int number)
    {
        this.number=number;
    }
    public int getNumber()
    {
        return this.number;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getPassword()
    {
        return this.password;
    }
}
