package com.dlhjw.website.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 18:57
 */
@Data //setter与getter方法
@NoArgsConstructor //无参构造
@AllArgsConstructor //全参构造
@ToString //toString方法
public class Result {

    private int status;
    private String msg;
    private Object data;
    //开发者uid
    private Long devUid;

    public Result(int status) {
        this.status = status;
    }

    public Result(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Result(int status, String msg, Object data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


}
