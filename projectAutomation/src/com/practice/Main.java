package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static HandleInformation handler = new HandleInformation();
    static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        int option;

        List<FullTimeTeacher> teachersFull = new ArrayList<>();
        List<PartTimeTeacher> teacherPart = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Class> classes = new ArrayList<>();

        teachersFull = handler.createTeachersFullTime();
        teacherPart = handler.createTeachersPartTime();
        students = handler.createStudents();
        classes = handler.createClasses(teachersFull, teacherPart, students);

        while(!salir) {
            System.out.println(" |----------------   MENU   -------------------|");
            System.out.println(" | 1. Print all the professors with its data   |");
            System.out.println(" | 2. Print all the classes                    |");
            System.out.println(" | 3. Create a new student                     |");
            System.out.println(" | 4. Create a new class                       |");
            System.out.println(" | 5. List all the classes for a given student |");
            System.out.println(" | 6. Exit                                     |");
            System.out.println(" |---------------------------------------------|");
            System.out.println("Choose one of the options");
            option = sn.nextInt();

            switch(option){
                case 1:
                    System.out.println("----- TEACHERS DATA  ------");
                    handler.printTeachers(teachersFull,teacherPart);
                    break;
                case 2:
                    System.out.println("----- CLASSES DATA ------");
                    handler.printClasses(classes);
                    submenu(classes);
                    break;
                case 3:
                    System.out.println("----- CREATE A NEW STUDENT  ------");
                    students = handler.createStudent(students);
                    classes = handler.addStudentToClass(students,classes);
                    break;
                case 4:
                    System.out.println("----- CREATE A NEW CLASS  ------");
                    classes = handler.createClass(classes,teachersFull, teacherPart,students);
                    break;
                case 5:
                    System.out.println("----- SEARCH THE STUDENT'S CLASSES  ------");
                    handler.findClassStudent(classes,students);

                    break;
                case 6:
                    salir=true;
                    break;
                default:
                    System.out.println("Please enter numbers between 1 and 6");
            }
        }


    }
    public static void submenu(List<Class> classes){
        Scanner option = new Scanner(System.in);
        String classCode, menu;
        boolean out = false;
        while(!out){
            System.out.println("Enter the class code: ");
            classCode = option.nextLine();
            handler.findClass(classes, classCode);
            sn = new Scanner(System.in);
            System.out.println("Do you want to exit the submenu? Y/N");
            menu = sn.nextLine();
            if (menu.equalsIgnoreCase("Y")){
                out=true;
            }
        }


    }
}
