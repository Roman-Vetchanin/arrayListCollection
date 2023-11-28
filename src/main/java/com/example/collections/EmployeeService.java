package com.example.collections;

import com.example.collections.exception.EmployeeStorageIsFullException;

public interface EmployeeService {

    String addEmployee(String firstName, String lastName);

    String removeEmployee(String fistName, String lastName);

    String findEmployee(String fistName, String lastName);

    String print();
}
