package tn.esprit.employeemicroservice.services;

import org.springframework.stereotype.Service;
import tn.esprit.employeemicroservice.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository ;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


}
