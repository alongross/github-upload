package com.example.student.myapplication5;

/**
 *
 */

public class BodyParts
{
    private boolean flag;
    private String exercise;
    public BodyParts()
    {
    }
    public BodyParts(boolean flag, String exercise)
    {
        this.flag = flag;
        this.exercise = exercise;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public String getExercise()
    {
        return exercise;
    }

    public void setExercise(String exercise)
    {
        this.exercise = exercise;
    }
}
