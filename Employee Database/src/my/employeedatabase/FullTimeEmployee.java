/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.employeedatabase;

/**
 * Subclass of the Employee class for full time employees.
 *
 * @author Yi Mang Yang
 * @author Max Xiong
 * @version 2.0 Dec 19, 2014.
 */
public class FullTimeEmployee extends Employee {

    public float annualSalary;

    /**
     * Creates an object representing a full time employee.
     *
     * @param n The employee's number.
     * @param s The employee's sex.
     * @param fN The employee's first name.
     * @param mN The employee's middle name.
     * @param lN The employee's last name.
     * @param dR The employee's deductions rate.
     * @param aS The employee's annual salary.
     */
    FullTimeEmployee(int n, char s, String fN, String mN, String lN, float dR, float aS) {
        empNumber = n;
        sex = s;
        firstName = fN;
        middleName = mN;
        lastName = lN;
        deductionsRate = dR;
        annualSalary = aS;
    }

    /**
     * Used to differentiate between part time employees and full time
     * employees.
     *
     * @return	"FullTimeEmployee".
     */
    public String getClassName() {
        return "FullTimeEmployee";
    }
    
    public float getAnnualSalary () {
        return annualSalary;
    }
    public float getHourlyWage () {
        return 0;
    }
    
    public float getHrsPerWeek () {
        return 0;
    }
    
    public float getWeeksPerYear () {
        return 0;
    }
}
