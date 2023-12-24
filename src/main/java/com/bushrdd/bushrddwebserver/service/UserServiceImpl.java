package com.bushrdd.bushrddwebserver.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bushrdd.bushrddwebserver.dao.SongDao;
import com.bushrdd.bushrddwebserver.dao.VoiceRoomConfigurationsDao;
import com.bushrdd.bushrddwebserver.dao.VoiceRoomUsersDao;
import com.bushrdd.bushrddwebserver.pojo.Songs;
import com.bushrdd.bushrddwebserver.pojo.VoiceRoomConfigurations;
import com.bushrdd.bushrddwebserver.pojo.VoiceRoomUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bushrdd.bushrddwebserver.utils.VoiceCallTokenManager.appId;

@Service
public class UserServiceImpl {

    SongDao songDao;
    VoiceRoomUsersDao voiceRoomUsersDao;
    VoiceRoomConfigurationsDao voiceRoomConDao;

    @Autowired
    public UserServiceImpl(SongDao songDao, VoiceRoomUsersDao voiceRoomUsersDao, VoiceRoomConfigurationsDao voiceRoomConDao) {
        this.songDao = songDao;
        this.voiceRoomUsersDao = voiceRoomUsersDao;
        this.voiceRoomConDao = voiceRoomConDao;
    }

    // public void addUser(String username, String password) {
    //     userDao.insert(new UserPojo(username, password));
    // }
    //
    // public void findUserByName(String username) {
    //     UserPojo userPojo = userDao.selectOne(new QueryWrapper<UserPojo>().eq("username", username));
    //     System.out.println(userPojo);
    // }

    public List<Songs> getSongList() {
        List<Songs> songs = songDao.selectList(null);
        System.out.println(songs);
        return songs;
    }

    public void setTodaySong(int id) {
        QueryWrapper<Songs> oldSongWrapper = new QueryWrapper<Songs>().eq("today", 1);
        Songs oldSong = songDao.selectOne(oldSongWrapper);//旧的今日歌曲
        oldSong.setToday(0);
        songDao.update(oldSong, oldSongWrapper);

        QueryWrapper<Songs> newSongWrapper = new QueryWrapper<Songs>().eq("song_id", id);
        Songs newSong = songDao.selectOne(newSongWrapper);
        newSong.setToday(1);
        songDao.update(newSong, newSongWrapper);
    }

    public List<VoiceRoomUsers> getVoiceRoomUsersInfo() {
        List<VoiceRoomUsers> voiceRoomUsers = voiceRoomUsersDao.selectList(null);
        System.out.println(voiceRoomUsers);
        return voiceRoomUsers;
    }

    public List<VoiceRoomUsers> getVoiceRoomUsersInfoByChannel(String channel) {
        QueryWrapper<VoiceRoomUsers> wrapper = new QueryWrapper<VoiceRoomUsers>().eq("channel", channel);
        List<VoiceRoomUsers> voiceRoomUsers = voiceRoomUsersDao.selectList(wrapper);
        System.out.println(voiceRoomUsers);
        return voiceRoomUsers;
    }

    public List<VoiceRoomConfigurations> getVoiceRoomConfigurations() {
        List<VoiceRoomConfigurations> voiceRoomCon = voiceRoomConDao.selectList(null);
        System.out.println(voiceRoomCon);
        return voiceRoomCon;
    }

    public VoiceRoomConfigurations getVoiceRoomConfigurationsByChannel(String channel) {
        QueryWrapper<VoiceRoomConfigurations> wrapper = new QueryWrapper<VoiceRoomConfigurations>().eq("channel", channel);
        VoiceRoomConfigurations voiceRoomCon = voiceRoomConDao.selectOne(wrapper);
        System.out.println(voiceRoomCon);
        return voiceRoomCon;
    }

    //向数据库中添加房间配置
    public void addVoiceCallCon(String channelName) {
        QueryWrapper<VoiceRoomConfigurations> wrapper = new QueryWrapper<VoiceRoomConfigurations>().eq("channel", channelName);
        voiceRoomConDao.delete(wrapper);
        voiceRoomConDao.insert(new VoiceRoomConfigurations(channelName, 0));
    }

    //查询用户是否存在
    public boolean judgeExists(String channelName, String userName) {
        QueryWrapper<VoiceRoomUsers> wrapper = new QueryWrapper<VoiceRoomUsers>().eq("user_name", userName).eq("channel", channelName);
        return voiceRoomUsersDao.exists(wrapper);
    }

    //向数据库中添加用户
    public void addVoiceCallUser(VoiceRoomUsers voiceRoomUsers) {
        //添加用户
        voiceRoomUsersDao.insert(voiceRoomUsers);
        //增加房间人数
        QueryWrapper<VoiceRoomConfigurations> wrapper = new QueryWrapper<VoiceRoomConfigurations>().eq("channel", voiceRoomUsers.getChannel());
        VoiceRoomConfigurations voiceRoomConfigurations = voiceRoomConDao.selectOne(wrapper);
        voiceRoomConfigurations.setUserCount(voiceRoomConfigurations.getUserCount() + 1);
        voiceRoomConDao.update(voiceRoomConfigurations, wrapper);
    }
}
