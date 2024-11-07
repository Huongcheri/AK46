package org.example;

import java.util.Random;

public class Student {
    protected String name;
    protected String id;
    protected int math;
    protected int physic;
    protected int chemistry;
public Student(String name){
    this.name = name;
    Random random = new Random();
    this.id =  "TVN" + random.nextInt(1000);
    this.math = random.nextInt(10);
    this.physic = random.nextInt(10);
    this.chemistry = random.nextInt(10);
}
public void info() {
    System.out.printf("Student name :" + this.name);
    System.out.printf("Id name :" + this.id);
    System.out.printf("Math:" + this.math);
    System.out.printf("Chemistry :" + this.chemistry);
    System.out.printf("Physic :" + this.physic);
    }
    public int getMath(){return math;}
    public int getPhysic(){return physic;}
    public int getChemistry(){
    return chemistry;
    }


}
