package com.company;
import java.util.*;

public class Student extends Person{


   HashMap<String, Integer> subjects;


   public Student(String name, String surname, String password) {
        super(name, surname, password);
        subjects = new LinkedHashMap<>();
    }

// method for student
    public void signUpForSubject(String subject) {
        subjects.put(subject, 0);
    }

    public boolean checkSubject(String subject) {
       boolean isTrue = false;
        for(Map.Entry<String, Integer> entry : subjects.entrySet()){
            if(entry.getKey() == subject){
                isTrue = true;
                break;
            }
        }
        return isTrue;
    }

    public void printAllNamePlusSubject() {
        for(Map.Entry<String, Integer> entry : subjects.entrySet()){
            System.out.println(entry.getKey() + " " + getName());
        }
    }



    public void printGrade() {
        ArrayList<String> subjects2 = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : subjects.entrySet()) {
            subjects2.add(entry.getKey());
        }

        System.out.println("Lista przedmiotow na jakie jestes zapisany");
        for(int x = 0; x<subjects2.size(); x++){
            System.out.println(x+1 + " " + subjects2.get(x));
        }

        System.out.println("");
        System.out.println("Wpisz cyfre jaka jest przyporzadkowana do danego przedmiotu aby sprawdzic ocene");
        Scanner sc1 = new Scanner(System.in);
        int number3 = sc1.nextInt();

        String subject = subjects2.get(number3-1);

        for(Map.Entry<String, Integer> entry : subjects.entrySet()) {
            if(subject.equalsIgnoreCase(entry.getKey())){
                System.out.println(entry.getValue());
                break;
            }
        }
    }

    public void printAllSubjects() {
        for(Map.Entry<String, Integer> entry : subjects.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

// method for student
    public int checkMyGrade(String subject) {
        int grade = 0;
        for(Map.Entry<String, Integer> entry : subjects.entrySet()){
            if (entry.getKey().equalsIgnoreCase(subject)){
                grade = entry.getValue();
                break;
            }
        }
        return grade;
    }

//method for Professor
    public void setGrade(String subject, int grade) {
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
    public void getSubjects() {
        for(Map.Entry<String, Integer> entry : subjects.entrySet() ) {
            System.out.println(entry.getKey());
        }
    }

//method for Professor
    public void calculateAverage() {
        int sumOfValues = 0;
        int sumOfSubjects = 0;
        int average;
        for(Map.Entry<String, Integer> entry : subjects.entrySet()){
            sumOfValues = sumOfValues + entry.getValue();
            sumOfSubjects++;
        }
        average = sumOfValues/sumOfSubjects;
        System.out.println("Average of all of your grades is: " + average);
    }


/*two methods*/
    public String subjectsInHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        int w = 0;
        for (Map.Entry<String, Integer> entry : subjects.entrySet()) {
            w++;
            map.put(w, entry.getKey());
        }

        System.out.println("Which subjects you want to mark, type number");

        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }
        Scanner sc1 = new Scanner(System.in);
        int scanner = sc1.nextInt();

        return retrieve(map, scanner);
    }

    public int getGradeOfaSubject(String subject){
        int grade = 0;
        for (Map.Entry<String, Integer> entry : subjects.entrySet()){
            if(entry.getKey().equalsIgnoreCase(subject)){
                grade = entry.getValue();
            }
        }
        return grade;
    }

    public String retrieve(HashMap<Integer,String> x, int index) {
       return x.get(index);
    }




    @Override
    public String toString() {
        return "Student{" +
                "subjects=" + subjects +
                '}';
    }
}
