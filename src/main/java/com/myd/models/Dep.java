package com.myd.models;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author myd
 * @date 2023/4/5  10:17
 */


@Data
@TableName("dep")
public class Dep {


    @TableId(value = "id",type= IdType.ASSIGN_ID)
    private String id;

    private String depName;

    @TableField(value = "dep_code")
    private String depNo;
}
