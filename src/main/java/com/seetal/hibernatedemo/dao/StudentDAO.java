package com.seetal.hibernatedemo.dao;

import com.seetal.hibernatedemo.entity.Student;

import java.util.List;

public interface StudentDAO {

     void save(Student student);

     Student findById(Integer id);

     List<Student> findAll();

     List<Student> findByLastname(String lastname);

}
