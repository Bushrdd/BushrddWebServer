package com.bushrdd.bushrddwebserver.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName(value = "voice_room_users")
public class VoiceRoomUsers {
    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "channel")//房间
    private String channel;

    @TableId(value = "token", type = IdType.AUTO)
    private String token;

    public VoiceRoomUsers(String userName, String channel, String token) {
        this.userName = userName;
        this.channel = channel;
        this.token = token;
    }

    public String toString() {
        return "userName: " + userName
                + "\nchannel: " + channel
                + "\ntoken: " + token;
    }
}
