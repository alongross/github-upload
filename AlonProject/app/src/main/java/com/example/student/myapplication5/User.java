package com.example.student.myapplication5;

import java.util.ArrayList;

/**
 * .
 */
public class User
{
    private String name;
    private String password;
    private ArrayList<String> whatexercises;
    private ArrayList<Boolean> b;
    private Exercises exercises;
    private ArrayList<Boolean> lst;
    public ArrayList<Boolean> getLst()
    {
        return lst;
    }

    public void setLst(ArrayList<Boolean> lst)
    {
        this.lst = lst;
    }

    public String getName()
    {
        return name;
    }

    public User()
    {
        this.exercises=new Exercises();
    }
    public ArrayList<Boolean> getB()
    {
        return b;
    }

    public void setB(ArrayList<Boolean> b)
    {
        this.b = b;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
        this.exercises=new Exercises();
    }

    public Exercises getExercises()
    {
        return exercises;
    }

    public void setExercises(Exercises exercises)
    {
        this.exercises = exercises;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name=" + name +
                ", password=" + password +
                '}';
    }
    public ArrayList<String> getWhatexercisess()
    {
        return whatexercises;
    }

    public void setWhatexercisess(ArrayList<String> whatexercises)
    {
        this.whatexercises = whatexercises;
    }
}
