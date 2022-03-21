package com.practice;

import java.util.List;

public class Class {
    private String name;
    private String classroom;
    private String codigo;
    private Teacher teacher;
    private List<Student> studentList;

    public Class (String name, String classroom, String codigo){
        this.classroom = classroom;
        this.name = name;
        this. codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void asigneTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public void printBasicInfo(){
        System.out.println("Class: "+this.name+ " , Code: "+this.codigo);
    }

    public void printClass(){
        System.out.println("Class information");
        System.out.println("Name: "+this.name);
        System.out.println("Code: "+this.codigo);
        System.out.println("Classroom: "+this.classroom);
        System.out.println("Teacher: "+this.getTeacher().getName() +"- id: "+this.getTeacher().getId());
        for(int i=0;i<this.getStudentList().size();i++){
            System.out.println("Student: "+": "+this.studentList.get(i).getName()+" - id: "+this.studentList.get(i).getId());
        }
    }


}
