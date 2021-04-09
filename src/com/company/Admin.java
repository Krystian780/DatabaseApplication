package com.company;
import java.util.ArrayList;
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
            System.out.println("Jesli chcesz sie zarejestrowac jako student kliknij 1");
            System.out.println("Jesli chcesz sie zarejestrowac jako professor kliknij 2");
            System.out.println("Jesli chcesz sie zalogowac jako student kliknij 3");
            System.out.println("Jesli chcesz sie zalogowac jako profesor kliknij 4");
            System.out.println("Jesli chcesz wyjsc z programu kliknij 5");
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
            if (number == 5) {
                loginAsStudent();
            }
        } while (number != 5);
    }


    // method to add a new student to the Array
    public void registerNewStudent() {
        System.out.println("Podaj imie studenta");
        Scanner n = new Scanner(System.in);
        String name = n.nextLine();
        System.out.println("Podaj nazwisko studenta");
        Scanner n2 = new Scanner(System.in);
        String surname = n2.nextLine();
        System.out.println("Podaj haslo, ktore bedzie uzyte przy logowaniu");
        Scanner n3 = new Scanner(System.in);
        String password = n2.nextLine();
        students.add(new Student(name, surname, password));

    }


    // method to login as a student and invoke some methods
    public void loginAsStudent() {
        System.out.println("Podaj imie");
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
                System.out.println("Podaj Haslo");
                Scanner w = new Scanner(System.in);
                String password = w.nextLine();
                if (password.equals(students.get(studentAtWhichIndex).getPassword())) {
                    System.out.println("Haslo poprawne");
                    int number;
                    do {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Wybierz 1 jesli chcesz zapisac sie na przedmiot");
                        System.out.println("Wybierz 2 jesli chcesz sprawdzic ocene z danego przedmiotu");
                        System.out.println("Wybierz 3 jesli chcesz sprawdzic na jakie przedmioty jestes zapisany");
                        System.out.println("Wybierz 4 jesli chcesz sie wylogowac ze swojego  konta do glownego menu");
                        Scanner w1 = new Scanner(System.in);
                        number = w1.nextInt();
                        if (number == 1) {
                            boolean b = false;
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
                            }
                            if (b) {
                                System.out.println("Przedmiot jest wykladany, zostajesz zapisany");
                                students.get(studentAtWhichIndex).signUpForSubject(subject);
                                System.out.println("Zostajesz dopisany do listy studentow u profesora, ktory wyklada ten przedmiot");
                                professors.get(index).addStudent(students.get(studentAtWhichIndex));
                            } else {
                                System.out.println("Przedmiot nie jest jeszcze wykladany przez zadnego profesora");
                            }

                        }
                        if (number == 2) {
                            System.out.println("Z jakiego przedmiotu chcesz sprawdzic ocene");
                            Scanner n2 = new Scanner(System.in);
                            String subject = n2.nextLine();
                            students.get(studentAtWhichIndex).checkMyGrade(subject);
                        }
                        if (number == 3) {
                            System.out.println("Na te przedmioty jestes zalogowany");
                            students.get(studentAtWhichIndex).getSubjects();
                        }

                    } while (number != 4);
                }
                else{
                    System.out.println("Haslo niepoprawne:");
                }
            }
            if (!isTrue) {
                System.out.println("Nie ma takiego studenta");
            }
        }


    public void registerProfessor() {
        System.out.println("Podaj imie");
        Scanner n = new Scanner(System.in);
        String name = n.nextLine();
        System.out.println("Podaj nazwisko");
        Scanner n2 = new Scanner(System.in);
        String surname = n2.nextLine();
        System.out.println("Podaj haslo");
        Scanner n3 = new Scanner(System.in);
        String password = n2.nextLine();
        professors.add(new Professor(name, surname, password));
    }

    public void loginAsProfessor() {
        System.out.println("Podaj imie");
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
            System.out.println("Podaj Haslo");
            Scanner w1 = new Scanner(System.in);
            String password = w1.nextLine();
            if (password.equals(professors.get(indexOfProfessor).getPassword())) {
                System.out.println("Haslo poprawne");
                int number;
                int indexOfStudent = 0;
                do {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Wybierz 1 jesli chcesz dodac ocene z przedmiotu studentowi");
                    System.out.println("Wybierz 2 jesli chcesz sprawdzic na jakie przedmioty dany student jest zapisany");
                    System.out.println("Wybierz 3 jesli chcesz sprawdzic srednia z przedmiotow danego studenta");
                    System.out.println("Wybierz 4 jesli chcesz dodac przedmiot jaki nauczasz");
                    System.out.println("Wybierz 5 jesli chcesz usunac przedmiot jaki nauczasz");
                    System.out.println("Wybierz 6 jesli chcesz sprawdzic wszystkie przedmioty ktore wykladasz");
                    System.out.println("Wybierz 7 jesli chcesz sprawdzic srednia z danego przedmiotu dla wszystkich uczniow");
                    System.out.println("Wybierz 8 jesli chcesz sprawdzic kto jest zapisany na dany przedmiot");
                    System.out.println("Wybierz 9 jesli chcesz wyjsc do menu glownego");
                    Scanner w3 = new Scanner(System.in);
                    number = w3.nextInt();
                    if (number == 1) {
                        System.out.println("Jakiemu studentowi chcesz wstawic ocene");
                        Scanner scanner = new Scanner(System.in);
                        String name = scanner.nextLine();
                        System.out.println("Z jakiego przedmiotu chcesz wstawic ocene ?");
                        Scanner scanner1 = new Scanner(System.in);
                        String studentGrade = scanner.nextLine();
                        System.out.println("Jaka ocene chcesz wstawic ?");
                        Scanner scanner2 = new Scanner(System.in);
                        number = scanner.nextInt();
                        professors.get(indexOfProfessor).setGradeByProfessor(name, studentGrade, number);
                        if(professors.get(indexOfProfessor).setGradeByProfessorisTrue(name, studentGrade, number)){
                            for(int x = 0; x< students.size(); x++){
                                if(students.get(x).getName().equalsIgnoreCase(name)){
                                    indexOfStudent = x;
                                }
                            }
                            students.get(indexOfStudent).setGrade(studentGrade, number);
                        }

                            /*
                            if (professors.get(indexOfProfessor).getName().equalsIgnoreCase(name)) {
                                System.out.println("Z jakiego przedmiotu chcesz wstawic ocene");
                                Scanner scanner = new Scanner(System.in);
                                String subject = scanner.nextLine();
                                System.out.println("Jaka Ocene chcesz wstawic");
                                Scanner scanner2 = new Scanner(System.in);
                                int grade = scanner2.nextInt();
                                students.get(y).setGrade(subject, grade);
                            }*/
                        }

                    if (number == 3) {
                        System.out.println("Srednia czyjego studenta chcesz sprawdzic ");
                        Scanner n2 = new Scanner(System.in);
                        String student = n2.nextLine();
                        for (int y = 0; y < students.size(); y++) {
                            if (students.get(y).getName().equalsIgnoreCase(student)) {
                                students.get(y).calculateAverage();
                            }
                        }
                    }
                    if (number == 4) {
                        System.out.println("Dodaj przedmiot jaki bedziesz nauczal");
                        Scanner scanner = new Scanner(System.in);
                        String subject = scanner.nextLine();
                        professors.get(indexOfProfessor).addSubject(subject);
                    }
                    if (number == 5) {
                        System.out.println("Podaj przedmiot do usuniecia");
                        Scanner scanner = new Scanner(System.in);
                        String subject = scanner.nextLine();
                        professors.get(indexOfProfessor).removeSubject(subject);
                    }
                    if(number == 6){
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Przedmioty, ktore nauczasz to:");
                        professors.get(indexOfProfessor).printAllSubjects();
                    }
                    if (number == 7) {
                        int sumOfGrades = 0;
                        int howManyGrades = 0;
                        System.out.println("Srednie z jakiego przedmiotu chcesz sprawdzic");
                        Scanner scanner = new Scanner(System.in);
                        String subject = scanner.nextLine();
                        for (int z = 0; z < students.size(); z++) {
                            howManyGrades++;
                            sumOfGrades = professors.get(z).checkGrade();
                        }
                        int finalAverage = sumOfGrades / howManyGrades;
                        System.out.println(finalAverage);
                    }
                    if (number == 8) {
                        int sumOfGrades = 0;
                        int howManyGrades = 0;
                        System.out.println("Srednie z jakiego przedmiotu chcesz sprawdzic");
                        Scanner scanner = new Scanner(System.in);
                        String subject = scanner.nextLine();
                        for (int z = 0; z < students.size(); z++) {
                            howManyGrades++;
                            sumOfGrades = professors.get(z).checkGrade();
                        }
                        int finalAverage = sumOfGrades / howManyGrades;
                        System.out.println(finalAverage);
                    }
                    if (number == 8) {
                        int sumOfGrades = 0;
                        int howManyGrades = 0;
                        System.out.println("Srednie z jakiego przedmiotu chcesz sprawdzic");
                        Scanner scanner = new Scanner(System.in);
                        String subject = scanner.nextLine();
                        for (int z = 0; z < students.size(); z++) {
                            howManyGrades++;
                            sumOfGrades = professors.get(z).checkGrade();
                        }
                        int finalAverage = sumOfGrades / howManyGrades;
                        System.out.println(finalAverage);
                    }
                } while (number != 9);
            }
        }
        if(!isTrue){
            System.out.println("Profesor o takim imieniu nie istnieje");
            }
        }


    }


