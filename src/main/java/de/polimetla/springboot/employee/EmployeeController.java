package de.polimetla.springboot.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("")
    public void createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = new Employee();
        newEmployee.setEmployeeId(employee.getEmployeeId());
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setAge(employee.getAge());        
        employeeService.createEmployee(newEmployee);
    }

    @PutMapping("/{employeeId}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Long employeeId) {
        employeeService.updateEmployee(employee, employeeId);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
