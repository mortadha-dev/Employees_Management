package tn.esprit.employeemicroservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import tn.esprit.employeemicroservice.controllers.EmployeeController;
import tn.esprit.employeemicroservice.entities.Employee;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class EmployeeMicroServiceApplicationTests {
    /*
    mon environemet est de test et je lance test unitaire : junit : oui
                                                            beanTest : oui
                                                            BeanProd : Non
    mon environemt est de production et je lance test unitaire : junit : oui
                                                                 beanTest : oui
                                                                 BeanProd : oui
     */





    @Autowired
    public EmployeeController employeeController ;
    public EmployeeMicroServiceApplicationTests () {
    }
    @Test
    public void addEmployee( ){
        Employee employee = new Employee();
        employee.setFirstName("testeur1Junit");
        employee.setLastName("ISTQB");
        employee.setEmail("testeur1@ISTQB.tn");
        employeeController.createEmployee(employee);
    }

}
