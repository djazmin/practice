package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleInformation {

    public HandleInformation(){

    }

    /**
     * method that initializes full-time teachers
     * @return Full Time Teachers
     */
    public List<FullTimeTeacher> createTeachersFullTime(){
        List<FullTimeTeacher> teachers = new ArrayList<>();
        FullTimeTeacher fullTeacher1 = new FullTimeTeacher(2,"Pedro Perez", "12345",120000 );
        FullTimeTeacher fullTeacher2 = new FullTimeTeacher(2,"Jaime Lopez", "12346",130000 );
        teachers.add(fullTeacher1);
        teachers.add(fullTeacher2);
        return teachers;
    }

    /**
     * method that initializes part-time teachers
     * @return Part time teachers
     */
    public List<PartTimeTeacher> createTeachersPartTime(){
        List<PartTimeTeacher> teachers = new ArrayList<>();
        PartTimeTeacher partTimeTeacher1 = new PartTimeTeacher(10,"Maria Martinez","12347",140000);
        PartTimeTeacher partTimeTeacher2 = new PartTimeTeacher(36,"Sandra Gomez","12348",140000);
        teachers.add(partTimeTeacher1);
        teachers.add(partTimeTeacher2);
        return teachers;
    }

    /**
     * method that initializes Students
     * @return Students
     */
    public List<Student> createStudents(){
        List<Student> students = new ArrayList<>();
        Student firstStuden = new Student("Camila Valencia","98765",19);
        Student secondStuden = new Student("Juliana Valencia","98764",20);
        Student thirdStuden = new Student("Andres Valencia","98763",23);
        Student fourthStuden = new Student("Camilo Andrade","98762",20);
        Student fifthdStuden = new Student("Maria Jimenez","98761",22);
        Student sixthStuden = new Student("Angie Gutierrez","98760",21);

        students.add(firstStuden);
        students.add(secondStuden);
        students.add(thirdStuden);
        students.add(fourthStuden);
        students.add(fifthdStuden);
        students.add(sixthStuden);
        return students;
    }

    /**
     * Method that print all the teachers and their data
     * @param teachersFull
     * @param teachersPart
     */
    public void printTeachers(List<FullTimeTeacher> teachersFull, List<PartTimeTeacher> teachersPart){

        for (int i=0;i<teachersFull.size(); i++){
            teachersFull.get(i).printTeacher();
        }
        for (int i=0;i<teachersPart.size(); i++){
            teachersPart.get(i).printTeacher();
        }
    }

    /**
     * Method that prints all the students and their data
     * @param students
     */
    public void printStudents(List<Student> students){

        for (int i=0;i<students.size(); i++){
            students.get(i).printStudent();
        }
    }

    /**
     * method that initializes Classes
     * @param teachersFull
     * @param teacherPart
     * @param students
     * @return Classes
     */
    public List<Class> createClasses(List<FullTimeTeacher> teachersFull, List<PartTimeTeacher> teacherPart, List<Student> students){
        List<Class> classes = new ArrayList<>();
        List<Teacher> teachers = this.addTeachers(teachersFull,teacherPart);
        List<Student> studentsClass = new ArrayList<>();
        int i=0;

        for(int j=0;j<students.size();j++){
            studentsClass.add(students.get(j));
        }

        while(i<4){
            Class classUniversity = new Class("MATH"+i,"22B","M"+i);
            classUniversity.setTeacher(teachers.get(i));
            classUniversity.setStudentList(studentsClass);
            classes.add(classUniversity);
            i++;
        }
        return classes;
    }

    /**
     * Method that unifies part time and full time teachers
     * @param teachersFull
     * @param teachersPart
     * @return
     */
    public List<Teacher> addTeachers(List<FullTimeTeacher> teachersFull, List<PartTimeTeacher> teachersPart){
        List<Teacher> teachers = new ArrayList<>();
        int i = 0,j=0;
        while ( i<teachersFull.size()){
            teachers.add(teachersFull.get(i));
            i++;
        }
        while (j<teachersPart.size()){
            teachers.add(teachersPart.get(j));
            j++;
        }
        return teachers;
    }

    /**
     * Method that prints all the classes and their basic information (name and code)
     * @param classes
     */
    public void printClasses(List<Class> classes){
        System.out.println("Classes: \n");
        for (int i=0;i<classes.size(); i++){
            classes.get(i).printBasicInfo();
        }

    }

    /**
     * Method that finds a class with its class code
     * @param classes
     * @param classCode
     * @return boolean
     */
    public boolean findClass(List<Class> classes, String classCode){
        boolean findElement = false;
        for(int i=0; i<classes.size();i++){
            if(classes.get(i).getCodigo().equalsIgnoreCase(classCode)){
                findElement = true;
                classes.get(i).printClass();
            }
        }
        if(findElement==false){
            System.out.println("Class Not Found");
        }
        return findElement;
    }

    /**
     *Method that finds a teacher full or part time using the ID
     * @param teachersFull
     * @param teachersPart
     * @param id
     * @return
     */
    public Teacher findTeacher(List<FullTimeTeacher> teachersFull, List<PartTimeTeacher> teachersPart, String id){
        Teacher foundTeacher = null;
        List<Teacher> teachers = addTeachers(teachersFull,teachersPart);
        int i = 0;

        while (i<teachers.size()) {
           if (teachers.get(i).getId().equalsIgnoreCase(id)) {
                    foundTeacher = teachers.get(i);
                    i=teachers.size();
                }
                i++;
            }
        return foundTeacher;
    }

    /**
     * Method that finds a Student using the ID
     * @param students
     * @param id
     * @return
     */
    public Student findStudent(List<Student> students, String id){
        Student student  = null;
        int i = 0;

        while (i<students.size()) {
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                student = students.get(i);
                i=students.size();
            }
            i++;
        }
        return student;
    }

    /**
     * Metthod that creates a new student
     * @param students
     * @return List with the new student added
     */
    public List<Student> createStudent(List<Student> students){
        String name;
        String id;
        int age;
        Scanner sn;

        System.out.println("Enter the student name: ");
        sn = new Scanner(System.in);
        name = sn.nextLine();
        System.out.println("Enter the student id: ");
        sn = new Scanner(System.in);
        id = sn.nextLine();
        System.out.println("Enter the student age: ");
        sn = new Scanner(System.in);
        age = sn.nextInt();

        Student newStudent = new Student(name,id,age);
        students.add(newStudent);
        System.out.println("Student Created: ");
        newStudent.printStudent();

        return students;
    }

    /**
     * Method that add a new student to the first class
     * @param students
     * @param classes
     * @return classes with the first class modified
     */
    public List<Class> addStudentToClass(List<Student> students, List<Class> classes){
        Student newStudent = students.get(students.size()-1);
        List<Student> studentsClass = addToList(classes.get(0).getStudentList());

        studentsClass.add(newStudent);
        classes.get(0).setStudentList(studentsClass);
        System.out.println("The student was added to class: "+classes.get(0).getName());
        classes.get(0).printClass();
        return classes;
    }

    public List<Student> addToList(List<Student> students){
        List<Student> newListStudents = new ArrayList<>();

        for (int i=0;i<students.size();i++){
            newListStudents.add(students.get(i));
        }
        return newListStudents;
    }

    /**
     * Method that create a new class with its teacher and its students
     * @param classes
     * @param teacherFull
     * @param teacherPart
     * @param students
     * @return list of classes with the new one created
     */
    public List<Class> createClass(List<Class> classes, List<FullTimeTeacher> teacherFull, List<PartTimeTeacher> teacherPart, List<Student> students){
       String name,classroom,code;
        Scanner sn;

        System.out.println("Enter the class name: ");
        sn = new Scanner(System.in);
        name = sn.nextLine();
        System.out.println("Enter the class code: ");
        sn = new Scanner(System.in);
        code = sn.nextLine();
        System.out.println("Enter the classroom: ");
        sn = new Scanner(System.in);
        classroom = sn.nextLine();
        Class newClass = new Class(name,classroom,code);

        printTeachers(teacherFull,teacherPart);
        newClass.setTeacher(chooseTeacher(teacherFull, teacherPart));
        printStudents(students);
        newClass.setStudentList(chooseStudents(students));
        classes.add(newClass);
        System.out.println("The new class was created with the following info: ");
        newClass.printClass();
        return classes;
    }

    /**
     * Method that allows to choose a Part or full teacher using the ID
     * @param teacherFull
     * @param teacherPart
     * @return Chosen teacher
     */
    public Teacher chooseTeacher(List<FullTimeTeacher> teacherFull, List<PartTimeTeacher> teacherPart){
        Scanner sn;
        Teacher teacher = null;
        boolean out = false;

        while (!out){
            System.out.println("Enter the teacher's ID to add it to the new class: ");
            sn = new Scanner(System.in);
            String id = sn.nextLine() ;
            teacher = findTeacher(teacherFull,teacherPart,id);

            if (teacher!=null){
                out = true;
            }
            else{
                System.out.println("Teacher not found");
            }
        }
        return teacher;
    }

    /**
     * Method that allows to choose a student using the ID
     * @param students
     * @return chosen student
     */
    public List<Student> chooseStudents(List<Student> students){
        List<Student> studentsClass = new ArrayList<>();
        boolean out = false;
        Scanner sn;

        while (!out){
            System.out.println("Enter the student's ID to add it to the new class: ");
            sn = new Scanner(System.in);
            String id = sn.nextLine() ;
            Student student = findStudent(students,id);

            if (student!=null){
                if(studentsClass.contains(student)){
                    System.out.println("The student already exist in the class ");
                }
                else {
                    studentsClass.add(student);
                    System.out.println("Do you want to continue adding students? Y/N ");
                    sn = new Scanner(System.in);
                    String cont = sn.nextLine();

                    if (cont.equalsIgnoreCase("N")) {
                        out = true;
                    }
                }
            }
            else{
                System.out.println("Studen not found ");
            }
        }
        return studentsClass;
    }

    /**
     * Method that print all the classes in which a given student is included
     * @param classes
     * @param students
     */
    public void findClassStudent(List<Class> classes,List<Student> students){
        List<Class> studentsClass = new ArrayList<>();
        Scanner sn;
        String idStudent;
        int i = 0;

        System.out.println("Enter the student's ID to find his classes: ");
        sn = new Scanner(System.in);
        idStudent = sn.nextLine();
        Student studentFound = findStudent(students,idStudent);

        while(i<classes.size()){
            List<Student> studentsList = classes.get(i).getStudentList();
            if(studentsList.contains(studentFound)){
                studentsClass.add(classes.get(i));
            }
            i++;
        }
        printClasses(studentsClass);
    }

}
