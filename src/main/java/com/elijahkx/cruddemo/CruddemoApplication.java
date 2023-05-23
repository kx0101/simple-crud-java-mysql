package com.elijahkx.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.elijahkx.cruddemo.dao.StudentDAO;
import com.elijahkx.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            // createStudent(studentDAO);

            createMultipleStudents(studentDAO);

            // readStudent(studentDAO);

            // queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO);

            // updateStudent(studentDAO);

            // deleteStudent(studentDAO);

            // deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all the students..");
        int rowsDeleted = studentDAO.deleteAll();

        System.out.println("Deleted: " + rowsDeleted + " students");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 1;

        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;

        System.out.println("Getting the student with id: " + studentId);
        Student student = studentDAO.findById(studentId);

        System.out.println("Updating student..");
        student.setFirstName("Changed");

        studentDAO.update(student);

        System.out.println("Updated student: " + student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("koulaxis");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new object..");
        Student student = new Student("hix", "hix", "test@test.com");

        System.out.println("Saving the student...");
        studentDAO.save(student);

        int theId = student.getId();
        System.out.println("Saved student. Generated id: " + theId);

        System.out.println("Reading object with id: " + theId);
        Student foundStudent = studentDAO.findById(theId);

        System.out.println("Found the student: " + foundStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 new students..");
        Student studentA = new Student("Alpha", "idk", "test@idk.com");
        Student studentB = new Student("Beta", "idc", "test@idc.com");
        Student studentC = new Student("Sigma", "oh", "test@oh.com");

        System.out.println("Saving the students...");
        studentDAO.save(studentA);
        studentDAO.save(studentB);
        studentDAO.save(studentC);

        System.out.println("Saved all 3 students");
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student..");
        Student student = new Student("liakos", "koulaxis", "test@test.com");

        System.out.println("Saving the student...");
        studentDAO.save(student);

        System.out.println("Saved student. Generated id: " + student.getId());
    }
}
