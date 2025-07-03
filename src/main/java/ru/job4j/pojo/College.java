package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan Ivanovich");
        student.setGroup("26");
        student.setDateOfreceipt("03.07.2025");
        System.out.println("Student :" + student.getName() + ";" + " Group :" + student.getGroup() + ";" + "DateOfreceipt : " + student.getDateOfreceipt());
    }
}

