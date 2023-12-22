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

    @TableField(value = "token")//房间
    private String token;

    @TableField(value = "user_count")//房间人数
    private int userCount;

    @TableField(value = "appid")
    private String appid;

    @TableField(value = "invalid_date")//失效日期
    private String invalidDate;

    public VoiceRoomConfigurations(String channel, String token, int userCount, String appid, String invalidDate) {
        this.channel = channel;
        this.token = token;
        this.userCount = userCount;
        this.appid = appid;
        this.invalidDate = invalidDate;
    }

    public String toString() {
        return "channel: " + channel
                + "\ntoken: " + token
                + "\nuserCount: " + userCount
                + "\nappid: " + appid
                + "\ninvalidDate: " + invalidDate;
    }
}