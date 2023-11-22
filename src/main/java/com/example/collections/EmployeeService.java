package com.example.collections;

import com.example.collections.exception.EmployeeStorageIsFullException;

public interface EmployeeService {
    String addEmployee(String fistName, String lastName) throws EmployeeStorageIsFullException;


    String removeEmploy(String firstName, String lastName) throws RuntimeException;

    String findEmployee(String firstName, String lastName) throws RuntimeException;

    String print();
}
