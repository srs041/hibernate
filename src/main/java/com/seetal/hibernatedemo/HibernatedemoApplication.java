package com.seetal.hibernatedemo;

import com.seetal.hibernatedemo.dao.StudentDAO;
import com.seetal.hibernatedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernatedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernatedemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            System.out.println("inside commandLineRunner");
//            createStudents(studentDAO);
//            readStudent(studentDAO);
//            displayStudents(studentDAO);
//            displayLastStudents(studentDAO);
            //updateStudent(studentDAO);
            deleteAstudent(studentDAO);


        };
    }

    private void deleteAstudent(StudentDAO studentDAO) {

        int id=4;

        studentDAO.deleteStudent(id);

        List<Student> l1 = studentDAO.findAll();
        for (Student fs1 : l1) {
            System.out.println("Display ALL student after delete by id :" + fs1);
        }

    }

    private void updateStudent(StudentDAO studentDAO) {
//retrive the student by id
        Student rs1=studentDAO.findById(1);
        System.out.println("Initial student info "+rs1);
        rs1.setFirstname("Scobby");
        studentDAO.updateStudent(rs1);
        System.out.println("Final student info "+rs1);
    }

    private void displayLastStudents(StudentDAO studentDAO) {
        String lastname = "Sahoo";
        List<Student> ll1 = studentDAO.findByLastname(lastname);
        for (Student ls1 : ll1) {
            System.out.println("Display LASTNAME student " + ls1);
        }
    }

    private void displayStudents(StudentDAO studentDAO) {
        List<Student> l1 = studentDAO.findAll();
        for (Student fs1 : l1) {
            System.out.println("Display ALL student  :" + fs1);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Reading student object");
        Student s4 = new Student("Jegan", "Muthusamy", "jm@gmail.com");
        System.out.println("Saving student object");
        studentDAO.save(s4);
        System.out.println("Student generated ID :" + s4.getId());
        int id = s4.getId();
        Student readStudent = studentDAO.findById(id);
        System.out.println("Retrieve student  :" + readStudent);
    }

    private void createStudents(StudentDAO studentDAO) {
        System.out.println("Creating all student object");
        Student s1 = new Student("Seetal", "Sahoo", "ss@gmail.com");
        Student s2 = new Student("Bonita", "Appleubom", "ba@gmail.com");
        Student s3 = new Student("John", "Paul", "jp@gmail.com");
        Student s4 = new Student("Lipu", "Deo", "ld@gmail.com");
        Student s5 = new Student("Sipu", "Sahoo", "ss1@gmail.com");
        Student s6 = new Student("Liku", "Dutta", "ld1@gmail.com");
        System.out.println("Saving all student object");
        studentDAO.save(s1);
        studentDAO.save(s2);
        studentDAO.save(s3);
        studentDAO.save(s4);
        studentDAO.save(s5);
        studentDAO.save(s6);

    }

}
