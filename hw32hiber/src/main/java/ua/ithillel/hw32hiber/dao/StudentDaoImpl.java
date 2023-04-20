package ua.ithillel.hw32hiber.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.ithillel.hw32hiber.db.HibernateSession;
import ua.ithillel.hw32hiber.entity.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentDaoImpl implements StudentDao {

    private static final SessionFactory sessionFactory = HibernateSession.buildSessionFactory();

    private Session sessionObj;

    @Override
    public Set<Student> getAllStudents() {
        Set<Student> students = new HashSet<>();
        try {
            sessionObj = sessionFactory.openSession();
            students = new HashSet<>(sessionObj.createQuery("FROM Student c", Student.class)
                    .list());
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return students;
    }

    @Override
    public Student findStudentById(int id) {
        Student student = null;
        try {
            sessionObj = sessionFactory.openSession();
            student = sessionObj.get(Student.class, id);
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return student;
    }

    @Override
    public boolean insertStudent(Student student) {
        boolean result = false;
        try {
            sessionObj = sessionFactory.openSession();
            sessionObj.beginTransaction();
            sessionObj.persist(student);

            sessionObj.getTransaction()
                    .commit();
            result = true;
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction()
                        .rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean result = false;
        try {
            sessionObj = sessionFactory.openSession();
            sessionObj.beginTransaction();
            sessionObj.merge(student);
            sessionObj.getTransaction()
                    .commit();
            result = true;
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction()
                        .rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean result = false;
        try {
            sessionObj = sessionFactory.openSession();
            sessionObj.beginTransaction();
            sessionObj.remove(sessionObj.get(Student.class, id));
            sessionObj.getTransaction()
                    .commit();
            result = true;
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                sessionObj.getTransaction()
                        .rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return result;
    }

}
