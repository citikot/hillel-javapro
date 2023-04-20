package ua.ithillel.hw32hiber.dao;

import ua.ithillel.hw32hiber.entity.Student;

import java.util.Set;

public interface StudentDao {

    Set<Student> getAllStudents();

    Student findStudentById(int id);

    boolean insertStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudent(int id);
}
