package com.service.Impl;

import com.dao.Impl.UserDaoImpl;
import com.entity.Student;
import com.exception.SeException;
import com.service.UserService;
import com.dao.UserDao;

public class UserServiceImpl implements UserService {

    @Override
    public boolean register(Student student) throws SeException{
        boolean flag = false;
        UserDao userDao = new UserDaoImpl();
        String stunam = student.getStunam();
        if(userDao.findByName(stunam).getStunam() == null){
            flag = userDao.addStudent(student);
        }
        else{
            throw new SeException("用户已被注册");
        }
        return flag;
    }

    @Override
    public Student login(Student student) throws SeException {
        UserDao userDao = new UserDaoImpl();
        String stunam = student.getStunam();  //用户输入的stunam
        Student loginStudent = userDao.findByName(stunam);
        if(loginStudent.getStunam() == null){
            throw new SeException("账户名不存在!");
        }
        if(!student.getPassword().equals(loginStudent.getPassword())){
            throw new SeException("密码输入错误!");
        }
        return loginStudent;
    }
}
