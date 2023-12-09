package com.example.collections;

import com.example.collections.exception.EmployeeAlreadyAddedException;
import com.example.collections.exception.EmployeeNotFoundException;
import com.example.collections.exception.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String fistName, @RequestParam("lastName") String lastName
            ,@RequestParam("departmetn") int department, @RequestParam("salary") int salary) {
        try {
            return employeeService.addEmployee(fistName, lastName,department,salary);
        } catch (
                EmployeeStorageIsFullException e) {
            return "Штат заполнен";
        } catch (
                EmployeeAlreadyAddedException e) {
            return "Такой сотрудник уже есть";
        }
    }
@GetMapping("/remove")
    public String remove(@RequestParam("firstName") String fistName, @RequestParam("lastName") String lastName) {
        try {
            return employeeService.removeEmployee(fistName, lastName);
        } catch (
                EmployeeNotFoundException e) {
            return "Удаляемый сотрудник не найден";
        }
    }
@GetMapping("/find")
    public String find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        }catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден";
        }
    }
@GetMapping("/print")
    public String print() {
        return employeeService.print();
    }
}
