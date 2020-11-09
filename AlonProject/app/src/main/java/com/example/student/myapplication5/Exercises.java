package com.example.student.myapplication5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 */

public class Exercises {
    private HashMap<String, String> second, first;

    public Exercises(HashMap<String, String> second, HashMap<String, String> first) {
        this.second = second;
        this.first = first;
    }

    public Exercises() {
        this.second = new HashMap<>();
        this.first = new HashMap<>();
    }

    public ArrayList<String> getSecondExercises(String bodypart) {
        ArrayList<String> lst = new ArrayList<>();
        String str = second.get(bodypart);
        if (str == null)
            return lst;
        String[] exercises = str.split(",");
        for (String exercise : exercises) {
            lst.add(exercise);
        }
        return lst;
    }

    public ArrayList<String> getFirstExercises(String bodypart) {
        ArrayList<String> lst = new ArrayList<>();
        String str = first.get(bodypart);
        if (str == null)
            return lst;
        String[] exercises = str.split(",");
        for (String exercise : exercises) {
            lst.add(exercise);
        }
        return lst;
    }

    public HashMap<String, String> getSecond() {
        return second;
    }

    public void setSecond(HashMap<String, String> second) {
        this.second = second;
    }

    public HashMap<String, String> getFirst() {
        return first;
    }

    public void setFirst(HashMap<String, String> mother) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "Second=" + second +
                ", First=" + first +
                '}';
    }
}
