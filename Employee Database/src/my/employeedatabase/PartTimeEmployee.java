/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.employeedatabase;

/**
 * Subclass of the Employee class for part time employees.
 *
 * @author Yi Mang Yang
 * @author Max Xiong
 * @version 2.0 Dec 19, 2014.
 */
public class PartTimeEmployee extends Employee {

    public float hourlyWage;
    public float hrsPerWeek;
    public float weeksPerYear;

    /**
     * Creates an object representing a full time employee.
     *
     * @param n The employee's number.
     * @param s The employee's sex.
     * @param fN The employee's first name.
     * @param mN The employee's middle name.
     * @param lN The employee's last name.
     * @param dR The employee's deductions rate.
     * @param hW The employee's hourly wage.
     * @param hPW The number of hours the employee works per week.
     * @param wPY The number of weeks the employee works per year.
     */
    PartTimeEmployee(int n, char s, String fN, String mN, String lN, float dR, float hW, float hPW, float wPY) {
        empNumber = n;
        sex = s;
        firstName = fN;
        middleName = mN;
        lastName = lN;
        deductionsRate = dR;
        hourlyWage = hW;
        hrsPerWeek = hPW;
        weeksPerYear = wPY;
    }

    /**
     * Used to differentiate between part time employees and full time
     * employees.
     *
     * @return	"FullTimeEmployee".
     */
    public String getClassName() {
        return "PartTimeEmployee";
    }
    
    public float getAnnualSalary () {
        return 0;
    }
    
    public float getHourlyWage(){
        return hourlyWage;
    }
    
    public float getHrsPerWeek(){
        return hrsPerWeek;
    }
    
    public float getWeeksPerYear(){
        return weeksPerYear;
    }
}
