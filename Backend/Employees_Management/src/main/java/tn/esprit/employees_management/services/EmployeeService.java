package tn.esprit.employees_management.services;

import org.springframework.stereotype.Service;
import tn.esprit.employees_management.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository ;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


}
