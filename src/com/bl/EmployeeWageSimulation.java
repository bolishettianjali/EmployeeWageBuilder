package com.bl;

public class EmployeeWageSimulation {
    static int workdayPerMon = 20;
    static int fullDayHr = 8;
    static int ParttimeHrs = 4;
    static int totalworkhrs;
    static int wagePerHr = 20;
    private static int empCheck;

    public static void main(String[] args) {
        System.out.println("Welcome to employee wage computation");
        for (int i = 0; i <= workdayPerMon; i++) {
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            if (totalworkhrs + fullDayHr > 100 || totalworkhrs + ParttimeHrs > 100) {
                totalworkhrs = 100;
                break;
            }

            switch (empCheck) {
                case 1:
                    totalworkhrs += fullDayHr;
                case 2:
                    totalworkhrs += ParttimeHrs;
            }
        }
        System.out.println(totalworkhrs);
        System.out.println(totalworkhrs * wagePerHr);


    }
}