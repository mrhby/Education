package com.dao.Impl;

import com.dao.UserDao;
import com.entity.Course;
import com.entity.Student;
import com.util.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public Student findByName(String stunam) {
        Connection connection = getConnection.buildConnection();
        String sql = "select * from Student where stunam = ?";
        Student student = new Student();
        try{
            PreparedStatement preparedStatement = getConnection.getPreparedStatement(connection,sql,stunam);
            ResultSet resultSet= getConnection.getResult(preparedStatement);
            if(resultSet.next()){
                student.setPassword(resultSet.getString("password"));
                student.setStunam(resultSet.getString("stunam"));
                student.setStuid(resultSet.getInt("stuid"));
                student.setStugra(resultSet.getString("stugra"));
                student.setStusex(resultSet.getString("stusex"));
                student.setStubir(resultSet.getDate("stubir"));
            }
            getConnection.close(connection);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean addStudent(Student student) {
        boolean flag = false;
        Connection connection = getConnection.buildConnection();
        String sql = "insert into Student(stunam,password) values(?,?)";
        PreparedStatement preparedStatement = getConnection.getPreparedStatement(connection,sql,student.getStunam(),student.getPassword());
        int i = getConnection.execute(preparedStatement);
        if(i > 0 ){
            flag = true;
        }
        getConnection.close(connection);
        return flag;
    }

    @Override
    public void updateByName(String stunam,String password) {
        Connection connection = getConnection.buildConnection();
        String sql = "update Student set password = ? where stunam = ?";
        PreparedStatement preparedStatement = getConnection.getPreparedStatement(connection,sql,password,stunam);
        getConnection.execute(preparedStatement);
        getConnection.close(connection);
    }

    @Override
    public List<Course> selectAllCourse() {
        ResultSet resultSet;
        Connection connection = getConnection.buildConnection();
        String sql = "select * from Course";
        List<Course> courseList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection.getPreparedStatement(connection, sql);
            resultSet = getConnection.getResult(preparedStatement);
            while (resultSet.next()) {
                Course course = new Course();
                course.setCouid(resultSet.getInt("couid"));
                course.setCounam(resultSet.getString("counam"));
                course.setCouroom(resultSet.getString("couroom"));
                course.setCoutimes(resultSet.getInt("coutimes"));
                course.setCourtea(resultSet.getString("courtea"));
                courseList.add(course);
            }
            getConnection.close(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public List<Course> findStudentCourse(String stunam) {
        ResultSet resultSet;
        Connection connection = getConnection.buildConnection();
        String sql = "select Course.* from Course,Student,plan_study_course where Course.couid=plan_study_course.couid " +
                "and Student.stuid = plan_study_course.stuid and Student.stunam = ?";
        List<Course> courseList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = getConnection.getPreparedStatement(connection,sql,stunam);
            resultSet = getConnection.getResult(preparedStatement);
            while(resultSet.next()){
                Course course = new Course();
                course.setCouid(resultSet.getInt("couid"));
                course.setCounam(resultSet.getString("counam"));
                course.setCouroom(resultSet.getString("couroom"));
                course.setCourtea(resultSet.getString("courtea"));
                course.setCoutimes(resultSet.getInt("coutimes"));
                courseList.add(course);
            }
            getConnection.close(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public void deleteCourse(int stuid,int couid) {
        Connection connection = getConnection.buildConnection();
        String sql = "delete from plan_study_course where stuid = ? and couid = ? ";
        PreparedStatement preparedStatement = getConnection.getPreparedStatement(connection,sql,stuid,couid);
        getConnection.execute(preparedStatement);
        getConnection.close(connection);
    }

    @Override
    public void addCourse(int stuid, int couid) {
        Connection connection = getConnection.buildConnection();
        String sql = "insert into plan_study_course(couid,stuid) values(?,?)";
        PreparedStatement preparedStatement = getConnection.getPreparedStatement(connection,sql,couid,stuid);
        getConnection.execute(preparedStatement);
        getConnection.close(connection);
    }

    @Override
    public int findCourseById(int stuid, int couid) {
        ResultSet resultSet;
        int i = 0;
        Connection connection = getConnection.buildConnection();
        String sql = "select * from  plan_study_course where couid = ? and stuid = ?";
        PreparedStatement preparedStatement = getConnection.getPreparedStatement(connection,sql,couid,stuid);
        resultSet = getConnection.getResult(preparedStatement);
        try {
            if (resultSet.next()) {
                i = 1;
            }
            getConnection.close(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Student> showStudent(int couid) {
        ResultSet resultSet;
        Connection connection = getConnection.buildConnection();
        String sql = "select student.* from Student,plan_study_course where student.stuid = plan_study_course.stuid and plan_study_course.couid = ?";
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection.getPreparedStatement(connection, sql, couid);
            resultSet = getConnection.getResult(preparedStatement);
            while(resultSet.next()) {
                Student student = new Student();
                student.setStuid(resultSet.getInt("stuid"));
                student.setStunam(resultSet.getString("stunam"));
                student.setStusex(resultSet.getString("stusex"));
                student.setStubir(resultSet.getDate("stubir"));
                student.setStugra(resultSet.getString("stugra"));
                studentList.add(student);
            }
            getConnection.close(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return studentList;
    }
}
