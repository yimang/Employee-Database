/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.employeedatabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for file input and output. Able to store the employee data from a hash
 * table in a file and load the data from a file into a hash table.
 *
 * @author Yi Mang Yang
 * @author Max Xiong
 * @version 2.0 Dec 19, 2014.
 */
public class InputOutput {

    private BufferedReader input;
    private BufferedWriter output;
    private File file;

    /**
     * Creates a object for input and output to a file.
     */
    public InputOutput() {
        file = new File("data.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            input = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            output = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Outputs a line to a file.
     */
    public void addLine(String line) {
        try {
            output.write(line);
            output.newLine();
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clears the data on a file.
     */
    public void clearData() {
        try {
            BufferedWriter temp = new BufferedWriter(new FileWriter(file, false));
            temp.write("");
            temp.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the employee data from a hash table in a file.
     */
    public void saveData(HashTable table) {

        clearData();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < table.hashTable[i].size(); j++) {
                if (table.hashTable[i].get(j).getClassName().equals("PartTimeEmployee")) { //for part time employee
                    PartTimeEmployee pEmployee = (PartTimeEmployee) table.hashTable[i].get(j);
                    addLine(pEmployee.empNumber + "//" + pEmployee.sex + "//" + pEmployee.firstName + "//" + pEmployee.middleName + "//" + pEmployee.lastName + "//" + pEmployee.deductionsRate + "//" + pEmployee.hourlyWage + "//" + pEmployee.hrsPerWeek + "//" + pEmployee.weeksPerYear);
                } else { //for full time employee
                    FullTimeEmployee fEmployee = (FullTimeEmployee) table.hashTable[i].get(j);
                    addLine(fEmployee.empNumber + "//" + fEmployee.sex + "//" + fEmployee.firstName + "//" + fEmployee.middleName + "//" + fEmployee.lastName + "//" + fEmployee.deductionsRate + "//" + fEmployee.annualSalary + "//");
                }

            }
        }
    }

    /**
     * Loads employee data from a file into a hash table.
     */
    public void loadData(HashTable hashTable) {
        String temp = null;
        while (true) {
            try {
                temp = input.readLine(); //reads a line from file

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (temp != null) { //will separate the different components of an employee using indexes
                int initIndex = 0;
                int finalIndex = temp.indexOf("//", initIndex);

                Integer empNumber = new Integer(temp.substring(initIndex, finalIndex));
                initIndex = finalIndex + 2;
                finalIndex = temp.indexOf("//", initIndex);

                char empSex = temp.substring(initIndex, finalIndex).charAt(0);

                initIndex = finalIndex + 2;
                finalIndex = temp.indexOf("//", initIndex);

                String empFirstName = temp.substring(initIndex, finalIndex);

                initIndex = finalIndex + 2;
                finalIndex = temp.indexOf("//", initIndex);
                String empMiddleName = temp.substring(initIndex, finalIndex);

                initIndex = finalIndex + 2;
                finalIndex = temp.indexOf("//", initIndex);
                String empLastName = temp.substring(initIndex, finalIndex);

                initIndex = finalIndex + 2;
                finalIndex = temp.indexOf("//", initIndex);

                Float empDeductionsRate = new Float(temp.substring(initIndex, finalIndex));

                initIndex = finalIndex + 2;
                finalIndex = temp.indexOf("//", initIndex);

                if (temp.endsWith("//")) { //for full time employee
                    Float empYearlySalary = new Float(temp.substring(initIndex, finalIndex));

                    FullTimeEmployee fEmployee = new FullTimeEmployee(empNumber, empSex, empFirstName, empMiddleName, empLastName, empDeductionsRate, empYearlySalary);
                    hashTable.addToTable(fEmployee);
                } else { //for part time employee
                    Float empHourlyWage = new Float(temp.substring(initIndex, finalIndex));

                    initIndex = finalIndex + 2;
                    finalIndex = temp.indexOf("//", initIndex);
                    Float empHoursPerWeek = new Float(temp.substring(initIndex, finalIndex));

                    initIndex = finalIndex + 2;

                    Float empWeeksPerYear = new Float(temp.substring(initIndex));

                    PartTimeEmployee pEmployee = new PartTimeEmployee(empNumber, empSex, empFirstName, empMiddleName, empLastName, empDeductionsRate, empHourlyWage, empHoursPerWeek, empWeeksPerYear);
                    hashTable.addToTable(pEmployee);
                }
            } else {
                break;
            }

        }
    }

}
