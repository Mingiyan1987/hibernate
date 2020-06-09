package ru.basanov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        StringBuilder name = new StringBuilder("Student");
        int rand;
        Random random = new Random();
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 1000; i++) {
            Student student = new Student();
            rand = random.nextInt(100) + 1;
            name.append(rand);
            student.setMark(rand);
            student.setName(name.toString());
            student.setMark(rand);
            students.add(student);
        }


        StudentDAO studentDAO = new StudentDAO();
        Session session = studentDAO.openCurrentSessionWithTransaction();
        for (Student student: students) {
            session.persist(student);
        }
        studentDAO.closeCurrentSessionWithTransaction();
        studentDAO.openCurrentSessionWithTransaction();
        studentDAO.deleteAll();
        studentDAO.closeCurrentSessionWithTransaction();
    }
}
