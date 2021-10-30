package com.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeWageSimulation implements IComputeEmpWage{
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private int numOfCompany=0;
    private ArrayList<CompanyEmpWage> companyEmpWageList;
    private Map<String, CompanyEmpWage> companyToEmpWageMap;

    public EmployeeWageSimulation(){
        companyEmpWageList =  new ArrayList<>();
        companyToEmpWageMap = new HashMap<>();
    }

    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);

        companyEmpWageList.add(companyEmpWage);
        companyToEmpWageMap.put(company, companyEmpWage);
    }

    public void computeEmpWage(){
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage + "\n");
        }
    }

    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs,
                totalEmpHrs = 0,
                totalWorkingDays = 0;
                int day = 1;

        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;


            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day-"+day+": Total working days: "+ totalWorkingDays + ", Emp Hrs:" + empHrs);
            day++;
        }

        return  totalEmpHrs * companyEmpWage.empRatePerHour;
    }

    public int getTotalWage(String company) {
        return companyToEmpWageMap.get(company).totalEmpWage;
    }

    public static void main(String[] args) {
        EmployeeWageSimulation employeeWageSimulation=new EmployeeWageSimulation();
        employeeWageSimulation.addCompanyEmpWage("Dmart", 20, 2, 10);
        employeeWageSimulation.addCompanyEmpWage("Reliance",10,4,20);
        employeeWageSimulation.computeEmpWage();
        System.out.println("\nTotal Wage for DMart Company: " + employeeWageSimulation.getTotalWage("Dmart"));
    }
}