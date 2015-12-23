/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.employeedatabase;

import java.util.ArrayList;

/**
 * Class for the hash table so employees can be stored in it through open
 * hashing/closed addressing.
 *
 * @author Yi Mang Yang
 * @author Max Xiong
 * @version 2.0 Dec 19, 2014.
 */
public class HashTable {

    public ArrayList<Employee>[] hashTable;
    private int numBuckets;
    public int numItems;

    @SuppressWarnings("unchecked")

    /**
     * Creates a hash table with two buckets.
     */
    public HashTable() {
        numBuckets = 2;
        hashTable = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            hashTable[i] = new ArrayList<Employee>(); //each bucket contains an arraylist
        }
    }

    /**
     * Adds an employee into a hash table.
     *
     * @param employee The employee to be added to the hash table.
     */
    public void addToTable(Employee employee) {
        hashTable[employee.empNumber % 2].add(employee);
        numItems++;
    }

}
