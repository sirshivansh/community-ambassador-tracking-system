package service;

import model.Ambassador;
import java.util.ArrayList;
import model.Student;

public class DataManager {
    public static ArrayList<Ambassador> ambassadors = new ArrayList<>();

    public static void addAmbassador(Ambassador a) {
        ambassadors.add(a);
    }

    public static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Student s){
        students.add(s);
    }
}