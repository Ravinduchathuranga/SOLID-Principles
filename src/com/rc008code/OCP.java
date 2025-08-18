/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rc008code;

/**
 *
 * @author rc007
 */

/*
It’s now time for the O in SOLID, known as the open-closed principle. 
Simply put, classes should be open for extension but closed for modification. 
In doing so, we stop ourselves from modifying existing code and causing potential new bugs in an otherwise happy application.
Of course, the one exception to the rule is when fixing bugs in existing code.
 */

//Bad code 
class PayCalculator {

    public double calculatePay(Employee employee) {
        if (employee instanceof Manager) {
            //calculate Manager's salary
        } else if (employee instanceof Engineer) {
            //calculate Engineer's salary
        }

        return 0;
    }
}

//open close principle
interface Employee {

    double calculatePay();

    String userType();
}

class Manager implements Employee {

    @Override
    public double calculatePay() {
        double d = 300000;
        System.out.println("Engineer Pay " + d);
        return d;
    }

    @Override
    public String userType() {
        String s = "Manager";
        System.out.println("this is " + s);
        return s;
    }
}

class Engineer implements Employee {

    @Override
    public double calculatePay() {
        double d = 5000000;
        System.out.println("Engineer Pay " + d);
        return d;
    }

    @Override
    public String userType() {
        String s = "Engineer";
        System.out.println("this is " + s);
        return s;
    }
}

class Paycalculator {

    public double calculatePay(Employee e) {
        return e.calculatePay();
    }

    public String checkUser(Employee e) {
        return e.userType();
    }

}

public class OCP {

    public static void main(String[] args) {
        Paycalculator p = new Paycalculator();
        p.calculatePay(new Engineer());
        p.calculatePay(new Manager());
        p.checkUser(new Manager());
        p.checkUser(new Engineer());
    }

}
