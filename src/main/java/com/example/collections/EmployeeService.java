package com.example.collections;

import java.util.Collection;

public interface EmployeeService {

    String addEmployee(String firstName, String lastName, int department, int salary);

    String removeEmployee(String fistName, String lastName);

    String findEmployee(String fistName, String lastName);

    String print();

    Collection<Employee> findAll();
}
