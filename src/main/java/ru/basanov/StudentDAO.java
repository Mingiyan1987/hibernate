package ru.basanov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentDAO{

    private Session currentSession;

    private Transaction currentTransaction;

    public StudentDAO() {

    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Student entity) {
        getCurrentSession().save(entity);
    }

    public void update(Student entity) {
        getCurrentSession().update(entity);
    }

    public Student findById(String id) {
        Student student = getCurrentSession().get(Student.class, id);
        return student;
    }

    public void delete(Student entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Student> findAll() {
        List<Student> students = getCurrentSession().createQuery("from Student").list();
        return students;
    }

    public void deleteAll() {
        List<Student> studentList = findAll();
        for (Student student : studentList) {
            delete(student);
        }
    }
}
