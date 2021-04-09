package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Person {

    private ArrayList<Student> x;
    private ArrayList<String> subjects;

    public Professor(String name, String surname, String password) {
        super(name, surname, password);
        x = new ArrayList<>();
        subjects = new ArrayList<>();
    }


    public boolean checkIfProfessorTeachesASubject(String name){
        return subjects.contains(name);
    }

    public void addStudent(Student student){
        x.add(student);
    }

    public void setGradeByProfessor(String name, String subject, int grade) {
        boolean isTrue = false;
        for(int y  = 0; y < x.size(); y++){
            if(x.get(y).getName().equalsIgnoreCase(name)){
                x.get(y).setGrade(subject, grade);
                isTrue = true;
            }
        }
        if(!isTrue){
            System.out.println("Nie ma ucznia o takim imieniu");
        }
    }

    public boolean setGradeByProfessorisTrue(String name, String subject, int grade) {
        boolean isTrue = false;
        for(int y  = 0; y < x.size(); y++){
            if(x.get(y).getName().equalsIgnoreCase(name)){
                x.get(y).setGrade(subject, grade);
                isTrue = true;
            }
        }
        return isTrue;
    }


    public void addSubject(String subject){
        boolean x = true;
        for(int z = 0; z<subjects.size(); z++){
            if(subjects.get(z).equalsIgnoreCase(subject)){
                x = false;
                break;
            }
        }
        if(x = true){
             subjects.add(subject);
        }
        else{
            System.out.println("Taki przedmiot juz istnieje");
        }

    }

    public void removeSubject(String subject){
        for(int x = 0; x<subjects.size(); x++){
            if(subjects.get(x).equalsIgnoreCase(subject)){
                subjects.remove(x);
                break;
            }
        }
    }

    public void printAllSubjects(){
        for(String s: subjects){
            System.out.println(s);
        }
    }

    public void calculateAverage(String name) {
        for (int y = 0; y < x.size(); y++) {
            if (x.get(y).getName().equalsIgnoreCase(name)) {
                x.get(y).calculateAverage();
            }
        }
    }

    public int checkGrade(){
        int grade = 0;
        System.out.println("Ocene jakiego studenta chcesz sprawdzic");
        Scanner scanner1 = new Scanner(System.in);
        String w = scanner1.nextLine();
        for(int y = 0; y<x.size(); y++){
            if(x.get(y).getName().equalsIgnoreCase(w)){
                System.out.println("Z jakiego przedmiotu chcesz sprawdzic ocene");
                Scanner scanner2 = new Scanner(System.in);
                String person = scanner2.nextLine();
                grade = x.get(y).checkMyGrade(person);
            }
        }
            return grade;
    }

}
