package com.company;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person{

    HashMap<String, Integer> subjects;

    public Student(String name, String surname, String password) {
        super(name, surname, password);
        subjects = new HashMap<>();
    }

// method for student
    public void signUpForSubject(String subject){
        subjects.put(subject, 0);
    }

// method for student
    public int checkMyGrade(String subject){
        int grade = 0;
        for(Map.Entry<String, Integer> entry : subjects.entrySet() ){
            if (entry.getKey().equalsIgnoreCase(subject)){
                grade = entry.getValue();
                break;
            }
        }
        return grade;
    }

//method for Professor
    public void setGrade(String subject, int grade){
        boolean isTrue = false;
        for(Map.Entry<String, Integer> entry : subjects.entrySet() ){
            if (entry.getKey().equalsIgnoreCase(subject)){
                isTrue = true;
                entry.setValue(grade);
                break;
            }
        }
        if(!isTrue){
            System.out.println("Student nie jest zapisany na ten przedmiot");
        }
    }

//method for Professor
    public void getSubjects(){
        for(Map.Entry<String, Integer> entry : subjects.entrySet() ) {
            System.out.println(entry.getKey());
        }
    }

//method for Professor
    public void calculateAverage(){
        int sumOfValues = 0;
        int sumOfSubjects = 0;
        int average;
        for(Map.Entry<String, Integer> entry : subjects.entrySet()){
            sumOfValues = sumOfValues + entry.getValue();
            sumOfSubjects++;
        }
        average = sumOfValues/sumOfSubjects;
        System.out.println(average);
    }

}
