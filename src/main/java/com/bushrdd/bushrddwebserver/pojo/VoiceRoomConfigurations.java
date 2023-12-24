package com.bushrdd.bushrddwebserver.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Bushrdd
 * @date : 2023/12/22
 **/

@Data
@NoArgsConstructor
@TableName(value = "voice_room_config")
public class VoiceRoomConfigurations {
    @TableId(value = "channel", type = IdType.AUTO)//房间
    private String channel;

    @TableField(value = "user_count")//房间人数
    private int userCount;

    public VoiceRoomConfigurations(String channel, int userCount) {
        this.channel = channel;
        this.userCount = userCount;
    }

    public String toString() {
        return "channel: " + channel
                + "\nuserCount: " + userCount;
    }
}