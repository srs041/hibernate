package com.seetal.hibernatedemo;

import com.seetal.hibernatedemo.dao.StudentDAO;
import com.seetal.hibernatedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernatedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernatedemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            System.out.println("inside commandLineRunner");

            createStudents(studentDAO);
            readStudent(studentDAO);


        };
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Reading student object");
        Student s4 = new Student("Jegan", "Muthusamy", "jm@gmail.com");
        System.out.println("Saving student object");
        studentDAO.save(s4);
        System.out.println("Student generated ID :" + s4.getId());
        int id=s4.getId();
        Student readStudent=studentDAO.findById(id);
        System.out.println("Retrieve student  :" + readStudent);
    }

    private void createStudents(StudentDAO studentDAO) {

        System.out.println("Creating student object");
        Student s1 = new Student("Seetal", "Sahoo", "ss@gmail.com");
        Student s2 = new Student("Bonita", "Appleubom", "ba@gmail.com");
        Student s3 = new Student("John", "Deo", "jd@gmail.com");
        System.out.println("Saving student object");
        studentDAO.save(s1);
        studentDAO.save(s2);
        studentDAO.save(s3);



    }

}
