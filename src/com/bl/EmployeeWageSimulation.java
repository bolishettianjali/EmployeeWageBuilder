package com.bl;

public class EmployeeWageSimulation {
    int empPresent=1;
    int empAbsent=0;
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Progam");
        int empCheck = (int) Math.floor(Math.random() * 10) % 2;
        System.out.println(empCheck);
    }

}
