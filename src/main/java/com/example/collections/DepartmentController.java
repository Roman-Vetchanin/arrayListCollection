package com.example.collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeeWithMaxSalary(department);
    }
    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeeWithMinSalary(department);
    }
    @GetMapping(value = "/printDepartmentAll", params = "departmentId")
    public List<Employee> getEmployeesFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeesFromDepartment(department);
    }
    @GetMapping(value = "/printDepartmentAll")
    public Map<Integer, List<Employee>> getEmployeesFromDepartment() {
        return departmentService.getEmployeesFromDepartment();
    }
}
