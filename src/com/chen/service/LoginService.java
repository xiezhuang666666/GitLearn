package com.chen.service;

import com.chen.pojo.Student;
import com.chen.pojo.User;

public interface LoginService
{

    boolean login(String name, String password);

    boolean studentlogin(String name, String password);

    public Student queryStudentById(String loginUser);

    public User queryByName(String name);

    public int updateStudentPad(String id, String newPad);

    public int updateUserPad(String name, String newPad);

    boolean studentRegister(String name, String password);

}
