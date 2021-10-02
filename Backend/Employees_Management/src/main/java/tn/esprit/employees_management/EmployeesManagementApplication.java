package tn.esprit.employees_management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tn.esprit.employees_management.controllers.EmployeeController;
import tn.esprit.employees_management.entities.Employee;

@SpringBootApplication
@EnableEurekaClient
public class EmployeesManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeesManagementApplication.class, args);
    }

    @Bean

    CommandLineRunner start(EmployeeController employeeController){
        return  args -> {
            employeeController.createEmployee(new Employee("T01a", "Mortadhaa", "mortadha@esprit.tn"));
            employeeController.createEmployee(new Employee("T02e", "Oussemaf", "Oussema@esprit.tn"));

        };
    }

}
