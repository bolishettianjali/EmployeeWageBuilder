package com.bl;

public class EmployeeWageSimulation implements IComputeEmpWage{
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private int numOfCompany=0;
    private CompanyEmpWage[] companyEmpWageArray;

    public EmployeeWageSimulation(){
        companyEmpWageArray=new  CompanyEmpWage[5];
    }
    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        companyEmpWageArray[numOfCompany]=new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
        numOfCompany++;
    }
    public void computeEmpWage(){
        for(int i=0;i<numOfCompany;i++) {
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i] + "\n");
        }
    }


    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs = 0,
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


    public static void main(String[] args) {
        EmployeeWageSimulation employeeWageSimulation=new EmployeeWageSimulation();
        employeeWageSimulation.addCompanyEmpWage("Dmart", 20, 2, 10);
        employeeWageSimulation.addCompanyEmpWage("Reliance",10,4,20);
        employeeWageSimulation.computeEmpWage();
    }
}