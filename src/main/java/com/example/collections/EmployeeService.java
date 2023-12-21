package com.example.collections;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int department, int salary);

    Employee removeEmployee(String fistName, String lastName);

    Employee findEmployee(String fistName, String lastName);

    String print();

    Collection<Employee> findAll();
}
