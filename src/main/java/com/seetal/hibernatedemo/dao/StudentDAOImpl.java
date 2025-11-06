package com.seetal.hibernatedemo.dao;

import com.seetal.hibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //Difine filed for entitymanager
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student",Student.class);//sTUDENT NAME NOT TABLE NAME ITS ENTITY
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastname(String lastname) {

        TypedQuery<Student> theLatNameQuery=entityManager.createQuery("From Student where lastname=:theData", Student.class);
        theLatNameQuery.setParameter("theData",lastname);
        return theLatNameQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }
}
