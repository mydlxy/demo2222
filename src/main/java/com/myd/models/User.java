package com.myd.models;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author myd
 * @date 2023/4/5  10:16
 */
@Data
@TableName("user")
public class User {

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    private String depId;

    private int age;

    private String name;

    /**
     * mybatis-plus会将字段值不为null的字段，insert到表中；
     *
     */
    private String hh;
}
