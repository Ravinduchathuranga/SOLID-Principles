/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rc008code;

/**
 *
 * @author rc007
 */
//each class responsible for single process of program

/*
Let’s begin with the single responsibility principle. 
As we might expect, this principle states that a class should only have one responsibility. 
Furthermore, it should only have one reason to change.
How does this principle help us to build better software? Let’s see a few of its benefits:

* Testing – A class with one responsibility will have far fewer test cases.
* Lower coupling – Less functionality in a single class will have fewer dependencies.
* Organization – Smaller, well-organized classes are easier to search than monolithic ones.
 */


//code with issue to manage processes | Bad code
class SPEmployee {

    private String name;
    private double salary;

    public double calculatePay() {

        return 40000;
    }

    public void saveToDatabase() {

    }

    public String generateReport() {
        return "done";
    }
}

//solution
class Employee {

    //attributes only
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class PayCalculator {

    public double calculatePay(Employee employee) {
        System.out.println("Salary    " + employee.getName() + "  " + employee.getSalary());
        return 4000000;
    }
}

class EmployeeRepository {

    public void save(Employee employee) {
        System.out.println("Employee saved");
    }
}

class EmployeeReportGenerator {

    public String generateReport(Employee employee) {
        System.out.println("Report generated!");
        return "Done";
    }
}

public class SPR {
    public static void main(String[] args) {
        Employee e = new Employee("ravindu", 2800000);
        PayCalculator calculator = new PayCalculator();
        calculator.calculatePay(e);
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.save(e);
    }

}
