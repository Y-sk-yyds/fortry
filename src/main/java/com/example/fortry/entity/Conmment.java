package com.example.fortry.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("comment")
public class Conmment {
    private Long id;
    private Long parentId;
    private String content;
    private LocalDateTime createTime=LocalDateTime.now();

    public Conmment(long id, long parentId, String content) {
        this.id = id;
        this.parentId = parentId;
        this.content = content;
    }
}
