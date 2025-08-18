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
 * which is arguably the most complex of the five principles. Simply put, if
 * class A is a subtype of class B, we should be able to replace B with A
 * without disrupting the behavior of our program.
 */
//bad code
class EmployeeProcess {

    public void paySalary() {
    }

    public void payBounus() {
    }
}

class ContractEmployee extends EmployeeProcess {

    @Override
    public void payBounus() {
        System.out.println("Pay");
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

class BonusProcessor {

    public void payBounes(Employee employee) {
        if (employee.getType() == EmployeeTypes.ENGINEER) {
            double bonus = employee.getSalary() * 0.1;
            System.out.println(bonus);
            double name = employee.getSalary() + bonus;
            System.out.println(name);
        } else {
            System.out.println("Not eligible for bonus");
        }
    }

}

public class LSP {

    public static void main(String[] args) {
        Employee e = new Employee("Ravindu", 50000, EmployeeTypes.ENGINEER);
        BonusProcessor bonusProcessor = new BonusProcessor();
        bonusProcessor.payBounes(e);
    }

}
