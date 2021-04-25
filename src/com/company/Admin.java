package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin extends Person {


    ArrayList<Student> students;
    ArrayList<Professor> professors;


    public Admin(String name, String surname, String password) {
        super(name, surname, password);
        students = new ArrayList<>();
        professors = new ArrayList<>();
    }


    public void programStart() {
        System.out.println("PROGRAM START");
        int number;
        do {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("If you want to register as a student click 1");
            System.out.println("If you want to register as a professor click 2");
            System.out.println("if you want to log in as a student click 3");
            System.out.println("If you want to log in as a professor click 4");
            System.out.println("if you want to leave the programme click 5");
            Scanner nnumber = new Scanner(System.in);
            number = nnumber.nextInt();
            if (number == 1) {
                registerNewStudent();
            }
            if (number == 2) {
                registerProfessor();
            }
            if (number == 3) {
                loginAsStudent();
            }
            if (number == 4) {
                loginAsProfessor();
            }

        } while (number != 5);
    }


    // method to add a new student to the Array
    public void registerNewStudent() {
        System.out.println("Give the student name");
        Scanner n = new Scanner(System.in);
        String name = n.nextLine();
        System.out.println("Give the surname");
        Scanner n2 = new Scanner(System.in);
        String surname = n2.nextLine();
        System.out.println("Give password which will you will be asked for during logging");
        Scanner n3 = new Scanner(System.in);
        String password = n2.nextLine();
        students.add(new Student(name, surname, password));
    }


    // method to login as a student and invoke some methods
    public void loginAsStudent() {
        System.out.println("Give name");
        Scanner n = new Scanner(System.in);
        String name = n.nextLine();
        boolean isTrue = false;
        int studentAtWhichIndex = 0;
        for (int x = 0; x < students.size(); x++) {
            if (students.get(x).getName().equalsIgnoreCase(name)) {
                studentAtWhichIndex = x;
                isTrue = true;
                break;
            }
        }
            if(isTrue) {
                System.out.println("Give Password");
                Scanner w = new Scanner(System.in);
                String password = w.nextLine();
                if (password.equals(students.get(studentAtWhichIndex).getPassword())) {
                    System.out.println("Password correct");
                    int number;
                    do {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Click 1 if you want to sign up for a subject");
                        System.out.println("Click 2 If you want to check a grades of all subjects");
                        System.out.println("Click 3 if you want to check which subject you have signed up for");
                        System.out.println("Click 4 if you want to log out from your account");
                        Scanner w1 = new Scanner(System.in);
                        number = w1.nextInt();
                        if (number == 1) {
                            /*boolean b = false;
                            int index = 0;
                            System.out.println("Na jaki przedmiot chcesz sie zapisac");
                            Scanner sc1 = new Scanner(System.in);
                            String subject = sc1.nextLine();
                            for (int y = 0; y < professors.size(); y++) {
                                if (professors.get(y).checkIfProfessorTeachesASubject(subject)) {
                                    b = true;
                                    index = y;
                                    break;
                                }
                            }*/
                            ArrayList<String> subjects = new ArrayList<>();
                            System.out.println("");
                            System.out.println("A list of subject you can sign up for ");
                            for(int x = 0; x<professors.size(); x++){
                                professors.get(x).copyArray(subjects);
                            }
                            //copying subjects from all professors from subjects ArrayList to subjects2 HashMap
                            HashMap<Integer, String> subjects2 = new HashMap<>();
                            for(int y = 0; y < subjects.size(); y++){
                                subjects2.put(y+1, subjects.get(y));
                            }

                            //printing all subjects you can sign up for
                            for(Map.Entry<Integer, String> entry : subjects2.entrySet() ) {
                                System.out.println(entry.getKey() + " " + entry.getValue());
                            }

                            System.out.println("Choose which subject you want to sign up for (click the number assigned to the subject");
                            Scanner sc1 = new Scanner(System.in);
                            int subject = sc1.nextInt();
                            String sUbject;

                            //looking for chosen subject in the hashmap and assigning this subject to Subject String
                            for(Map.Entry<Integer, String> entry : subjects2.entrySet() ) {
                                if(entry.getKey() == subject){
                                    sUbject = entry.getValue();
                                    students.get(studentAtWhichIndex).signUpForSubject(sUbject);
                                    int subjectAtWhichIndex = 0;
                                    for(int x = 0; x < professors.size(); x++){
                                        if(professors.get(x).doesProfessorTeachThatSubject(sUbject));
                                        subjectAtWhichIndex = x;
                                        break;
                                    }
                                        if(professors.get(subjectAtWhichIndex).checkIfStudentExists(students.get(studentAtWhichIndex))){
                                            System.out.println("Already signed to a professor");
                                        }
                                        else{
                                            for(int y = 0; y<professors.size(); y++){
                                                if(professors.get(y).doesProfessorTeachThatSubject(sUbject)){
                                                    professors.get(y).addStudent(students.get(studentAtWhichIndex));
                                                }
                                            }
                                        }
                                }
                            }

                        }
                        if (number == 2) {
                            students.get(studentAtWhichIndex).printAllSubjects();
                        }
                        if (number == 3) {
                            System.out.println("");
                            System.out.println("You have singed up for the following subjects");
                            students.get(studentAtWhichIndex).getSubjects();
                        }
                    } while (number != 4);
                }
                else{
                    System.out.println("");
                    System.out.println("Password is incorrect");
                }
            }
            if (!isTrue) {
                System.out.println("No such student");
            }
        }


    public void registerProfessor() {
        System.out.println("Give name");
        Scanner n = new Scanner(System.in);
        String name = n.nextLine();
        System.out.println("Give surname");
        Scanner n2 = new Scanner(System.in);
        String surname = n2.nextLine();
        System.out.println("Give password");
        Scanner n3 = new Scanner(System.in);
        String password = n2.nextLine();
        professors.add(new Professor(name, surname, password));
    }

    public void loginAsProfessor() {
        System.out.println("Give name");
        Scanner n1 = new Scanner(System.in);
        String w = n1.nextLine();
        int indexOfProfessor = 0;
        boolean isTrue = false;
        for (int x = 0; x < professors.size(); x++) {
            if (professors.get(x).getName().equalsIgnoreCase(w)) {
                indexOfProfessor = x;
                isTrue = true;
                break;
            }
        }

        if(isTrue){
            System.out.println("Give password");
            Scanner w1 = new Scanner(System.in);
            String password = w1.nextLine();
            if (password.equals(professors.get(indexOfProfessor).getPassword())) {
                System.out.println("Password is correct");
                int number;
                int indexOfStudent = 0;
                do {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Click 1 to add subject that you will be teaching");
                    System.out.println("Click 2 to remove a subject from the list of subject you are teaching");
                    System.out.println("Click 3 to check all subject you are teaching along with current grades");
                    System.out.println("Click 4 to check who you will be teaching");
                    System.out.println("Click 5 to set a grade of a particular student");
                    System.out.println("Click 6 to check average grade from all subject of a particular student");
                    System.out.println("Click 7 to check average grade of a subject of all students");
                    System.out.println("Click 8 to leave to the main menu");
                    Scanner w3 = new Scanner(System.in);
                    number = w3.nextInt();
                    if (number == 1) {
                        System.out.println("Write a subject you will be teaching");
                        Scanner scanner = new Scanner(System.in);
                        String subject = scanner.nextLine();
                        professors.get(indexOfProfessor).addSubject(subject);
                    }
                    if (number == 2) {
                        System.out.println("Give the subject you want to remove from the list");
                        Scanner scanner = new Scanner(System.in);
                        String subject = scanner.nextLine();
                        professors.get(indexOfProfessor).removeSubject(subject);
                    }
                    if(number == 3){
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Subjects you are teaching:");
                        professors.get(indexOfProfessor).printAllSubjects();
                    }
                    if (number == 4) {
                        System.out.println("List of all student with subject they have signed up for");
                        professors.get(indexOfProfessor).print();
                    }
                    if (number == 5) {
                        int whichStudentIndex = professors.get(indexOfProfessor).retrieveWhichStudent();
                        String student = professors.get(indexOfProfessor).printStudents1(whichStudentIndex);
                        String whichSubject = professors.get(indexOfProfessor).whichSubject(student);
                        System.out.println("Jaka ocene chcesz wstawic");
                        Scanner sc1 = new Scanner(System.in);
                        int grade = sc1.nextInt();
                        professors.get(indexOfProfessor).setGrade(student,whichSubject,grade);
                        int y = 0;
                        for(int x = 0; x<students.size(); x++){
                            if(students.get(x).getName().equalsIgnoreCase(student)){
                                y = x;
                                students.get(y).setGrade(whichSubject, grade);
                                break;
                            }
                        }
                    }
                    if (number == 6) {
                        int whichStudentIndex = professors.get(indexOfProfessor).retrieveWhichStudent();
                        String student = professors.get(indexOfProfessor).printStudents1(whichStudentIndex);
                        professors.get(indexOfProfessor).average(student);
                    }

                    if (number == 7) {
                        professors.get(indexOfProfessor).calculateAverage();

                    }
                } while (number != 8);
            }

        }
        if(!isTrue){
            System.out.println("No such Professor");
            }
        }


    }


