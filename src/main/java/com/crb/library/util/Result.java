package com.crb.library.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable { //序列化
    private int code; //200是正常 400表示异常
    private String msg;
    private Object data;//返回数据

    public static Result success( Object data){
        return success(200,"操作成功",data);
    }

    public static Result success( String message){
        return success(200,message,null);
    }

    public static Result success(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String msg){

        return fail(400,msg,null);
    }

    public static Result fail(String msg, Object data){

        return fail(400,msg,data);
    }

    public static Result fail(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}



