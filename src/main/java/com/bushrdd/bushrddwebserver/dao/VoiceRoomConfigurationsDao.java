package com.bushrdd.bushrddwebserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bushrdd.bushrddwebserver.pojo.VoiceRoomConfigurations;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VoiceRoomConfigurationsDao extends BaseMapper<VoiceRoomConfigurations> {
    // void insertOrUpdate(VoiceRoomConfigurations con);
}
