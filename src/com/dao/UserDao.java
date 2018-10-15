package com.dao;

import com.entity.Course;
import com.entity.Student;
import java.util.List;

public interface UserDao {

    Student findByName(String stunam);

    boolean addStudent(Student student);

    void updateByName(String stunam,String password);

    List<Course> selectAllCourse();

    List<Course> findStudentCourse(String stunam);

    void deleteCourse(int stuid,int couid);

    void addCourse(int stuid,int couid);

    int findCourseById(int stuid,int couid);

    List<Student> showStudent(int couid);

}
