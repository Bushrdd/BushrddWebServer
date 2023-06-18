package com.bushrdd.bushrddwebserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bushrdd.bushrddwebserver.pojo.Songs;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Bushrdd
 * @date : 2023/06/18
 **/
@Mapper
public interface SongDao extends BaseMapper<Songs> {
}