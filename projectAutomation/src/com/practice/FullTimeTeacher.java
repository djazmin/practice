package com.practice;

public class FullTimeTeacher extends Teacher{
    private int experienceYears;

    public FullTimeTeacher(int experience, String name, String id, double baseSalary){
        super(name,id,baseSalary);
        this.experienceYears = experience;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public double getSalary(){
        double salary;
        salary = this.getBaseSalary() * (1.10*getExperienceYears());
        return salary;
    }

    public void printTeacher(){
        System.out.println("Teacher: "+ this.getName()+", ID:"+this.getId()+
                ", Salary: "+ this.getSalary());
    }
}
