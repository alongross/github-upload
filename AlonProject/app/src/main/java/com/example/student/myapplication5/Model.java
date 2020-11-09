package com.example.student.myapplication5;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * .
 */
public class Model {
    public static String Chest_Shoulders = "chestshoulders";//newYear
    public static String Back = "back";//sukot
    public static String Arms = "arms";//passover
    public static String Legs_Abs = "legsabs";//weeks
    public static String[] Body_Parts = {Chest_Shoulders, Back, Arms, Legs_Abs};//HOLIDAYS_ARRAY
    private static final Model ourInstance = new Model();

    public static Model getInstance() {
        return ourInstance;
    }

    private HashMap<String, ArrayList<String>> firstwo, secondwo;

    private Model() {
        initHashMaps();
    }

    private void initHashMaps() {
        this.firstwo = new HashMap<>();
        this.secondwo = new HashMap<>();
        for (int i = 0; i < Model.Body_Parts.length; i++) {
            this.firstwo.put(Model.Body_Parts[i], new ArrayList<String>());
            this.secondwo.put(Model.Body_Parts[i], new ArrayList<String>());
        }
    }

    public boolean exerciseExistsInFirstWo(String bodypart, String exercise) {
        return this.firstwo.get(bodypart).contains(exercise);
    }

    public boolean exerciseExistsInSecondWo(String bodypart, String exercise) {
        return this.secondwo.get(bodypart).contains(exercise);
    }

    public void addOrRemoveFromFirstWo(String bodypart, String exercise) {
        ArrayList<String> exercises = this.firstwo.get(bodypart);
        if (exercises.contains(exercise))
            exercises.remove(exercise);
        else
            exercises.add(exercise);
    }

    public void addOrRemoveFromSecondWo(String bodypart, String exercise) {
        ArrayList<String> exercises = this.secondwo.get(bodypart);
        if (exercises.contains(exercise))
            exercises.remove(exercise);
        else
            exercises.add(exercise);
    }

    public ArrayList<String> FirstWoExercises(String bodypart) {
        return this.firstwo.get(bodypart);
    }

    public ArrayList<String> SecondWoExercises(String bodypart) {
        return this.secondwo.get(bodypart);
    }

    public void updateExercisesByUser(User user) {
        this.firstwo = new HashMap<>();
        this.secondwo = new HashMap<>();
        for (int i = 0; i < Model.Body_Parts.length; i++) {
            this.firstwo.put(Model.Body_Parts[i], user.getExercises().getFirstExercises(Model.Body_Parts[i]));
            this.secondwo.put(Model.Body_Parts[i], user.getExercises().getSecondExercises(Model.Body_Parts[i]));
        }
    }

    public Exercises getExercises() {
        HashMap<String, String> second, first;
        second = new HashMap<>();
        first = new HashMap<>();
        for (int i = 0; i < Model.Body_Parts.length; i++) {
            ArrayList<String> f = SecondWoExercises(Model.Body_Parts[i]);
            if (f != null) {
                second.put(Body_Parts[i], listToString(f));
            }
            ArrayList<String> m = FirstWoExercises(Model.Body_Parts[i]);
            if (m != null) {
                first.put(Body_Parts[i], listToString(m));
            }
        }
        return new Exercises(second, first);
    }

    private String listToString(ArrayList<String> lst) {
        if (lst == null || lst.size() == 0)
            return "";
        String str = "";
        for (String s : lst) {
            str += "," + s;
        }
        return str.substring(1);
    }
}
