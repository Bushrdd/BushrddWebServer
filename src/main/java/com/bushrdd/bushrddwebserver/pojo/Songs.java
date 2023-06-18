package com.bushrdd.bushrddwebserver.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "songs")
public class Songs {
    @TableId(value = "song_id", type = IdType.AUTO)
    private String songId;

    @TableField(value = "song_name")
    private String songName;

    @TableField(value = "song_singer")
    private String songSinger;

    @TableField(value = "song_url")
    private String songUrl;

    @TableField(value = "lyric_url")
    private String lyricUrl;
}
