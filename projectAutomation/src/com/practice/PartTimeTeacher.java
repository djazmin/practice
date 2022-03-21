package com.practice;

public class PartTimeTeacher extends Teacher{
    private int activeHours;

    public PartTimeTeacher(int activeHours, String name, String id, double baseSalary){
        super(name,id,baseSalary);
        this.activeHours = activeHours;
    }

    public int getActiveHours() {
        return activeHours;
    }

    public void setActiveHours(int activeHours) {
        this.activeHours = activeHours;
    }

    public double getSalary(){
        double salary;
        salary = this.getBaseSalary() * this.activeHours;
        return salary;
    }

    public void printTeacher(){
        System.out.println("Teacher: "+ this.getName()+", ID:"+this.getId()+
                ", Salary: "+ this.getSalary());
    }
}
