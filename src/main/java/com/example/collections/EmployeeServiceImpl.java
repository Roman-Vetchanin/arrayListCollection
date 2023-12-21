package com.example.collections;

import com.example.collections.exception.EmployeeNotFoundException;
import com.example.collections.exception.EmployeeAlreadyAddedException;
import com.example.collections.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();


    @Override
    public String addEmployee(String firstName, String lastName, int department, int salary) {
        String key = buildKey(firstName, lastName);
        final int LIMIT = 3;
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        } else if (employees.size() >= LIMIT) {
            throw new EmployeeStorageIsFullException();
        } else {
            employees.put(key, new Employee(firstName,lastName,department,salary));
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();


    @Override
    public String addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        final int LIMIT = 2;
        if (employees.containsValue(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else if (employees.size() > LIMIT) {
            throw new EmployeeStorageIsFullException();
        } else {
            employees.put(employee.hashCode(), employee);
        }
        return "Сотрудник " + firstName +" "+ lastName + " добавлен";
    }

    @Override
    public String removeEmployee(String fistName, String lastName) {

        String key = buildKey(fistName, lastName);
        if (employees.containsKey(key)) {
            employees.remove(key);

        Employee employee = new Employee(fistName, lastName);
        if (employees.containsValue(employee)) {
            employees.remove(employee.hashCode());

        } else {
            throw new EmployeeNotFoundException();
        }
        return "Сотрудник " + fistName +" " + lastName + " удален";
    }

    @Override
    public String findEmployee(String fistName, String lastName) {

        String key = buildKey(fistName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(key).toString();

        Employee employee = new Employee(fistName, lastName);
        if (employees.containsKey(employee.hashCode())) {
            return employee+" найден";

        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String print() {
        return employees.values().toString();
    }
    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private String buildKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }


    }


}
