package com.chen.dao;

import org.apache.ibatis.annotations.Param;

import com.chen.pojo.Student;
import com.chen.pojo.User;

public interface LoginMapper
{
    public User findUserByName(String name);

    public Student findUserById(String studentId);

    public int addInfo(@Param("name") String name, @Param("password") String password);

    public int changeUserPwd(@Param("name") String name, @Param("password") String newPad);
}
