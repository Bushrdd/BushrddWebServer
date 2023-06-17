package com.bushrdd.bushrddwebserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bushrdd.bushrddwebserver.dao.UserDao;
import com.bushrdd.bushrddwebserver.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserDao userDao;

    public void addUser(String username,String password){
        userDao.insert(new UserPojo(username,password));
    }

    public void findUserByName(String username){
       UserPojo userPojo= userDao.selectOne(new QueryWrapper<UserPojo>().eq("username",username));
       System.out.println(userPojo);
    }
}
