package com.example.collections;

import com.example.collections.exception.EmployeeInvalidInputException;
import com.example.collections.exception.EmployeeNotFoundException;
import com.example.collections.exception.EmployeeAlreadyAddedException;
import com.example.collections.exception.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();


    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        String key = buildKey(firstName, lastName);
        String modifiedFirstName = StringUtils.lowerCase(firstName);
        String modifiedLastName = StringUtils.lowerCase(lastName);
        final int LIMIT = 3;
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        } else if (employees.size() >= LIMIT) {
            throw new EmployeeStorageIsFullException("Штат заполнен");
        } else {
            return employees.put(key, new Employee(modifiedFirstName,modifiedLastName,department,salary));
        }
    }

    @Override
    public Employee removeEmployee(String fistName, String lastName) {
        String key = buildKey(fistName, lastName);
        if (employees.containsKey(key)) {
            return employees.remove(key);
        } else {
            throw new EmployeeNotFoundException("Удаляемый сотрудник не найден");
        }
    }

    @Override
    public Employee findEmployee(String fistName, String lastName) {
        String key = buildKey(fistName, lastName);
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
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
        String modifiedFirstName = StringUtils.lowerCase(firstName);
        String modifiedLastName = StringUtils.lowerCase(lastName);
        if (!StringUtils.isAlpha(StringUtils.trim(modifiedFirstName)) && !StringUtils.isAlpha(StringUtils.trim(modifiedLastName))) {
            throw new EmployeeInvalidInputException("Имя или фамилия содержит не допустимые символы");
        } else if (StringUtils.isNumeric(StringUtils.trim(modifiedFirstName))&&StringUtils.isNumeric(StringUtils.trim(modifiedLastName))) {
            throw new EmployeeInvalidInputException("Имя или фамилия содержит числа");
        }else {
            return StringUtils.capitalize(StringUtils.trim(modifiedFirstName)) + " "
                    + StringUtils.capitalize(StringUtils.trim(lastName));
        }
    }


}
