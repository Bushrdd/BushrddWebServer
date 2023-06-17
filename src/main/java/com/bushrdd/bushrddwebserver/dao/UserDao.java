package com.bushrdd.bushrddwebserver.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bushrdd.bushrddwebserver.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserPojo> {
    // @Select("SELECT * FROM user")
    // public List<UserPojo> selectUser;


}
