package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            createMultipleStudent(studentDAO);
            //findStudent(studentDAO);
            //findAllStudent(studentDAO);
            //findByLastName(studentDAO, "zz");
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudent(studentDAO);
        };
    }

    private void findStudent(StudentDAO studentDAO) {
        System.out.println(studentDAO.findById(1));
    }
    private void createMultipleStudent(StudentDAO studentDAO) {
        Student tempStudent1 = new Student("Paul", "ZZ", "CTS");
        Student tempStudent2 = new Student("Joan", "CC", "CTS");
        Student tempStudent3 = new Student("Bonita", "XX", "CTS");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    public void createStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Winston", "Lin", "CTS");
        studentDAO.save(tempStudent);
        System.out.println(tempStudent.getId());
    }

    public void findAllStudent(StudentDAO studentDAO) {
        List<Student> allStudent = studentDAO.findAll();

        for(Student s : allStudent) {
            System.out.println(s);
        }
    }

    public void findByLastName(StudentDAO studentDAO, String lastName) {
        List<Student> allStudent = studentDAO.findByLastName(lastName);
        for(Student s : allStudent) {
            System.out.println(s);
        }
    }

    public void updateStudent(StudentDAO studentDAO) {
        Integer studentId = 1;
        Student theStudent = studentDAO.findById(studentId);

        theStudent.setFirstName("CTS");
        theStudent.setLastName("IT");
        theStudent.setEmail("Team");

        studentDAO.update(theStudent);

    }

    public void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;

        studentDAO.delete(studentId);
        System.out.println("Delete Successfully");
    }

    public void deleteAllStudent(StudentDAO studentDAO) {
        int num_of_deletion = studentDAO.deleteAll();

        System.out.println("number of deletion: " + num_of_deletion);
    }
}
