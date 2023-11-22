package com.example.collections;

import com.example.collections.exception.EmployeeNotFoundException;

import com.example.collections.exception.EmployeeAlreadyAddedException;
import com.example.collections.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>(List.of(new Employee("ivan", "ivanov"),
            new Employee("dobrinya", "nikitich"),
            new Employee("aleha", "popovich")));


    private boolean employeeAvailabilityCheck(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String addEmployee(String fistName, String lastName) throws RuntimeException {
        Employee employee = new Employee(fistName, lastName);
        final int LIMIT = 3;
        if (employees.size() > LIMIT) {
            throw new EmployeeStorageIsFullException();
        } else if (employeeAvailabilityCheck(fistName, lastName)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.add(employee);
        }
        return "Сотрудник " + fistName + " " + lastName + " добавлен";
    }

    @Override
    public String removeEmploy(String firstName, String lastName) throws RuntimeException {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employees.remove(employee);
                return employee + " удален";
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String findEmployee(String firstName, String lastName) throws RuntimeException {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee + " найден";
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String print() {
        for (int i = 0; i < employees.size(); i++) {
            return employees.toString();
        }
        return "Сотрудники: ";
    }
}
