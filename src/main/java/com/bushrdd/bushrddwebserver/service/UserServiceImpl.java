package com.bushrdd.bushrddwebserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bushrdd.bushrddwebserver.dao.SongDao;
import com.bushrdd.bushrddwebserver.pojo.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    SongDao songDao;

    // public void addUser(String username, String password) {
    //     userDao.insert(new UserPojo(username, password));
    // }
    //
    // public void findUserByName(String username) {
    //     UserPojo userPojo = userDao.selectOne(new QueryWrapper<UserPojo>().eq("username", username));
    //     System.out.println(userPojo);
    // }

    public  List<Songs> getSongList() {
        List<Songs> songs = songDao.selectList(null);
        System.out.println(songs);
        return songs;
    }
}
