package com.practice;

import java.util.List;

public class Teacher {
    private String name;
    private String id;
    private double baseSalary;

    public Teacher(String name, String id, double baseS){
        this.name = name;
        this.id = id;
        this.baseSalary = baseS;
    }
    public Teacher(){
        this.id= "1";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
