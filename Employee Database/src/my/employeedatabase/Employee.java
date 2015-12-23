/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.employeedatabase;

/**
 * Abstract class for the employee. Holds the common employee attributes.
 *
 * @author Yi Mang Yang
 * @author Max Xiong
 * @version 2.0 Dec 19, 2014.
 */
public abstract class Employee {

    public int empNumber;
    public char sex;
    public String firstName;
    public String middleName;
    public String lastName;
    public float deductionsRate;

    /**
     * Used to differentiate between part time employees and full time
     * employees.
     *
     * @return	The subclass name.
     */
    abstract String getClassName();
    
    abstract float getAnnualSalary();
    
    abstract float getHourlyWage ();
    
    abstract float getHrsPerWeek();
    
    abstract float getWeeksPerYear();

}
