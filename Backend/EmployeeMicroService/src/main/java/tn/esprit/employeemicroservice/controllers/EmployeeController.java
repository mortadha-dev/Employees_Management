package tn.esprit.employeemicroservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.employeemicroservice.entities.Employee;
import tn.esprit.employeemicroservice.exceptions.ResourceNotFoundException;
import tn.esprit.employeemicroservice.repositories.EmployeeRepository;
import tn.esprit.employeemicroservice.services.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
@CrossOrigin
public class EmployeeController {
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;

    }

    @PostMapping("/Create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/List")
    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("Find/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not found with this id : " + id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("Update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee newemployee, @PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not found with this id : " + id));
        employee.setFirstName(newemployee.getFirstName());
        employee.setLastName(newemployee.getLastName());
        employee.setEmail(newemployee.getEmail());
        Employee updatedemployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedemployee);
    }

    @DeleteMapping("Delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not found with this id : " + id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
