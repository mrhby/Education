package com.service;

import com.entity.Student;
import com.exception.SeException;

public interface UserService {

    boolean register(Student student) throws SeException; //用户注册

    Student login(Student student) throws SeException;

}
