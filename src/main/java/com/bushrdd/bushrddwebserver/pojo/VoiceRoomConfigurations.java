package com.bushrdd.bushrddwebserver.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Bushrdd
 * @date : 2023/12/22
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "voice_room_config")
public class VoiceRoomConfigurations {
    @TableField(value = "appid")
    private String appid;

    @TableId(value = "channel", type = IdType.AUTO)//房间
    private String channel;

    @TableField(value = "token")//房间
    private String token;

    public String toString() {
        return "appid: " + appid
                + "\nchannel: " + channel
                + "\ntoken: " + token;
    }
}

