package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import java.util.*;
public interface StudentDAO {

    public void save(Student theStudent);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    public void update(Student student);

    public void delete(Integer id);

    public int deleteAll();
}
