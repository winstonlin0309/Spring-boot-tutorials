package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @PostConstruct to load the student data ....Only run once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Winston", "Lin"));
        theStudents.add(new Student("CTS", "IT"));
        theStudents.add(new Student("CTS", "Marketing"));
    }
    //define endpoint for "/student" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if(studentId >= theStudents.size() | studentId < 0 ) {
            throw  new StudentNotFoundException("Student id not found: " + studentId);
        }
        return theStudents.get(studentId);
    }


}
