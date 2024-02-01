package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            findStudent(studentDAO);
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

}
