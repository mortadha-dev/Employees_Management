package tn.esprit.employeemicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import tn.esprit.employeemicroservice.controllers.EmployeeController;
import tn.esprit.employeemicroservice.entities.Employee;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeMicroServiceApplication {
    //N.B : les tests unitaires ne seront plus executés si on démarre cette classe EmployeeMicroServiceApplication
    public static void main(String[] args) {
        SpringApplication.run(EmployeeMicroServiceApplication.class, args);
    }

    //si active profile is test donc ce bean va etre éxecuté en persistant les donnés dans BDD test
    /*
    @Bean
    @Profile("test")
    CommandLineRunner starttest(EmployeeController employeeController){
        return  args -> {
            employeeController.createEmployee(new Employee("TestBean", "ISTQB", "test@esprit.tn"));
        };
    }
*/
    @Bean
    @Profile("staging")
    CommandLineRunner startstaging(EmployeeController employeeController){
        return  args -> {
            employeeController.createEmployee(new Employee("en mode staging", "stagingBean", "mortadha@esprit.tn"));
        };
    }


    //si active profile is not test donc ce bean va etre éxecuté en persistant les donnés dans BDD production
    @Bean
    @Profile("default")
    CommandLineRunner startdev(EmployeeController employeeController){
        return  args -> {
            employeeController.createEmployee(new Employee("en mode production", "productionBean", "mortadha@esprit.tn"));
        };
    }


}
