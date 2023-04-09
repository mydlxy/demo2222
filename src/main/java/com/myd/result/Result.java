package com.myd.result;

import lombok.Data;

/**
 * @author myd
 * @date 2023/4/9  11:59
 */


@Data
public class Result<T> {

    String message;

    Integer code;

    T data;

    public Result(T t,String message,Integer code){
        this.data = t;
        this.message = message;
        this.code  = code;
    }

    public Result(T data){
        this(data,"success",200);
    }

    public static <T>Result<T> ok(T data){
        return new Result<>(data);
    }

    public static <T>Result<T> fail(String message){
        return new Result<>(null,message,500);
    }

}
