package ua.ithillel.hw32hiber;

import org.w3c.dom.ls.LSOutput;
import ua.ithillel.hw32hiber.dao.StudentDao;
import ua.ithillel.hw32hiber.dao.StudentDaoImpl;
import ua.ithillel.hw32hiber.entity.Student;

public class StudentDaoRunner {

    public static StudentDao sd = new StudentDaoImpl();
    public static boolean res;

    public static void main(String[] args) {
        Student st1 = new Student("Ivan", "ivan@aa.com");
        Student st2 = new Student("Petro", "");
        Student st3 = new Student("", "");

        res = sd.insertStudent(st1);
        res = sd.insertStudent(st2);
        res = sd.insertStudent(st3);
        res = sd.deleteStudent(3);
        st2.setEmail("petro@ee.com");
        res = sd.updateStudent(st2);
        System.out.println(sd.getAllStudents());
        System.out.println(sd.findStudentById(2));

    }
}
