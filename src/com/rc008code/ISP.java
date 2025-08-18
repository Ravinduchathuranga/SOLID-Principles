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
 * The I in SOLID stands for interface segregation, and it simply means that
 * larger interfaces should be split into smaller ones. By doing so, we can
 * ensure that implementing classes only need to be concerned about the methods
 * that are of interest to them.
 */
//bad code
interface Employee {

    void work();

    void attendMeetings();

    void timeSheetSubmitter();

}

class AManager implements Employee {

    @Override
    public void work() {
        System.out.println("work");
    }

    @Override
    public void attendMeetings() {
        System.out.println("attend meetings");
    }

    @Override
    public void timeSheetSubmitter() {
        //No need to do this as a manager
    }
}

//solution code
interface Worker {

    void work();
}

interface MeetingAttende {

    void attendMeetings();
}

interface TimeSheetSubmitter {

    void timeSheetSubmitter();
}

class BManager implements Worker, MeetingAttende {

    @Override
    public void work() {
        System.out.println("work");
    }

    @Override
    public void attendMeetings() {
        System.out.println("attendMeetings");
    }

}

public class ISP {

    public static void main(String[] args) {
        BManager bManager = new BManager();
        bManager.work();
        bManager.attendMeetings();
    }
}
