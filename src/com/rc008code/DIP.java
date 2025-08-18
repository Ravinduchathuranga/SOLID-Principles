/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rc008code;

/**
 *
 * @author rc007
 */
/**
 * The principle of dependency inversion refers to the decoupling of software
 * modules. This way, instead of high-level modules depending on low-level
 * modules, both will depend on abstractions.
 */
//bad code
class EmailSender {

    public void sendPromotionEmail() {
        System.out.println("send");
    }
}

class AEmployee {

    public void notifyPromotion(EmailSender emailSender) {
        emailSender.sendPromotionEmail();

    }
}

//solution
enum EmployeeTypes {
    MANAGER, ENGINEER;
}

class Employee {

    private String name;
    private double salary;
    private EmployeeTypes type;

    //parameterize constructor to handle object's data
    public Employee(String name, double salary, EmployeeTypes type) {
        this.name = name;
        this.salary = salary;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public EmployeeTypes getType() {
        return type;
    }

}

interface Notify {

    void sendNotification(Employee employee);
}

class MailNotify implements Notify {

    @Override
    public void sendNotification(Employee employee) {
        System.out.println("email");
    }
}

class SMSSender implements Notify {

    @Override
    public void sendNotification(Employee employee) {
        System.out.println("sms");
    }
}

public class DIP {

    public static void main(String[] args) {
        Employee employee = new Employee("ravindu", 55550, EmployeeTypes.MANAGER);
        MailNotify mailNotify=new MailNotify();
        mailNotify.sendNotification(employee);
    }

}