package com.dlhjw.website.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/5/30 19:10
 */
@Data //setter与getter方法
@NoArgsConstructor //无参构造
@ToString //toString方法
@TableName("message")
public class Message {
    //1.留言ID
    @TableId(value = "mid",type = IdType.AUTO)
    private Long mid;
    //2.用户ID
    private Long uid;
    //3.留言者
    private String name;
    //4.留言
    private String message;
    //5.添加日期
    private String addTime;
    //6.修改日期
    private String lastTime;

    public boolean isEmpty(Message message){
        return "".equals(message.name) &&
                "".equals(message.message);
    }

    public Message(Long uid, String name, String message) {
        this.uid = uid;
        this.name = name;
        this.message = message;
    }

}
