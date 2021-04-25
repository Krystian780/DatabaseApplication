package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Professor extends Person {

    private ArrayList<Student> x;
    private ArrayList<String> subjects;


    public Professor(String name, String surname, String password) {
        super(name, surname, password);
        x = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    public boolean doesProfessorTeachThatSubject(String subject){
        boolean isTrue = false;
        for(int x = 0; x<subjects.size(); x++){
            if(subjects.get(x).equalsIgnoreCase(subject)){
                isTrue = true;
            }
        }
        return isTrue;
    }



    public boolean checkIfStudentExists(Student student){
        boolean isTrue = false;
        for(int y = 0; y<x.size(); y++){
            if(x.get(y).getName() == student.getName()){
                isTrue = true;
                break;
            }
        }
        return isTrue;
    }

    //xx

    public boolean checkIfProfessorTeachesASubject(String name){
        return subjects.contains(name);
    }

    public void addStudent(Student student){
        x.add(student);
    }

    public void printStudentBySubject(String subject){
        ArrayList<String> list = new ArrayList<>();
        for(int y = 0; y < x.size(); y++){
            if(x.get(y).checkSubject(subject)){
                list.add(x.get(y).getName().toLowerCase());
            }
        }
        for(int w = 0; w < list.size(); w++){
            System.out.println(list.get(w));
        }
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
            System.out.println("Uczen o takim imieniu nie uczeszcza na twoje zajecia");
        }
    }

    public boolean setGradeByProfessorisTrue(String name) {
        boolean isTrue = false;
        for(int y  = 0; y < x.size(); y++){
            if(x.get(y).getName().equalsIgnoreCase(name)){
                isTrue = true;
                break;
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
        for(int x = 0; x<subjects.size(); x++){
            System.out.println(x + 1 + " " + subjects.get(x));
        }
    }

    public String returnSubjectName(int x){
        return subjects.get(x);
    }

    public void calculateAverage(String name) {
        for (int y = 0; y < x.size(); y++) {
            if (x.get(y).getName().equalsIgnoreCase(name)) {
                x.get(y).calculateAverage();
                break;
            }
        }
    }

    public String getSubjectByIndex(int id){
        return subjects.get(id);
    }


    public void copyArray(ArrayList<String> list){
        for(int x = 0; x<subjects.size(); x++){
            list.add(subjects.get(x));
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

    public void printByAStudent(String name) {
        for (int y = 0; y < x.size(); y++) {
            if (x.get(y).getName().equalsIgnoreCase(name)) {
                x.get(y).getSubjects();
            }
        }
    }

    public void printAllStudents(){
            for(int y = 0; y<x.size(); y++){
                x.get(y).printAllNamePlusSubject();
            }
        }

    public void studentPlus(String subject){
        HashMap<String, Integer> map = new HashMap<>();
        for(int y = 0; y < x.size(); y++){
            if(x.get(y).checkSubject(subject)){
                map.put(x.get(y).getName(), x.get(y).checkMyGrade(subject));
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void print(){
        for(int w = 0; w < subjects.size(); w++){
            System.out.println(subjects.get(w));
            studentPlus(subjects.get(w));
        }
    }

    public int retrieveWhichStudent() {
        ArrayList<String> names = new ArrayList<>();
        for (int y = 0; y < x.size(); y++) {
            names.add(x.get(y).getName());
        }
        System.out.println("Choose a student from the list");
        for (int w = 0; w < x.size(); w++) {
            System.out.println(w + 1 + " " + names.get(w));
        }
        Scanner sc1 = new Scanner(System.in);
        int student;
        return student = sc1.nextInt();
    }

    public String printStudents1(int student) {
        ArrayList<String> names = new ArrayList<>();
        for (int y = 0; y < x.size(); y++) {
            names.add(x.get(y).getName());
        }
        for (int w = 0; w < x.size(); w++) {
            System.out.println(w + 1 + " " + names.get(w));
        }

        String student2 = null;
        for(int z = 0; z < names.size(); z++){
            if(student-1==z){
                student2 = names.get(z);

            }
        }
        return student2;
    }

    public String whichSubject(String student){
        String subject = null;
        for(int y = 0; y < x.size(); y++){
            if(student.equalsIgnoreCase(x.get(y).getName())){
                subject = x.get(y).subjectsInHashMap();
            }
        }
        return subject;
    }


    public void setGrade(String student, String subject, int grade) {
        for ( int p = 0; p<x.size (); p++){
            if (x.get(p).getName().equalsIgnoreCase(student)) {
                x.get(p).setGrade(subject, grade);
            }
        }
    }

    public void average(String student){
        for(int y = 0; y < x.size(); y++){
            if(x.get(y).getName().equalsIgnoreCase(student)){
                x.get(y).calculateAverage();
                break;
            }
        }
    }

    public String getSubject(){
        String x = null;

        for(int y = 0; y < subjects.size(); y++){
            System.out.println(y + 1 + subjects.get(y));
        }
        System.out.println("");
        System.out.println("Which subject you want to check grade");
        Scanner sc1 = new Scanner(System.in);
        int ExtremeSportChannel = sc1.nextInt();

        return x = subjects.get(ExtremeSportChannel-1);

    }

    public void calculateAverage(){
        String subject = getSubject();
        int sumOfGrades = 0;
        int amount = 0;

        for(int y = 0; y < x.size(); y++){
            if(x.get(y).checkSubject(subject)){
                amount ++;
                sumOfGrades = sumOfGrades + x.get(y).getGradeOfaSubject(subject);
            }
        }
        System.out.println("Average of " + subject + " " + (sumOfGrades/amount));
    }






 }

