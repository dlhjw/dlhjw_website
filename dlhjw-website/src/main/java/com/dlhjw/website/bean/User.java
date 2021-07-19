package com.dlhjw.website.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/5/30 19:09
 */
@Data //setter与getter方法
@NoArgsConstructor //无参构造
@ToString //toString方法
@TableName("user")
public class User {
    //1.用户ID
    @TableId(value = "uid",type = IdType.AUTO)
    private Long uid;
    //2.用户姓名
    private String name;
    //3.出生日期
    private String birth;
    //3.1年龄
    @TableField(exist = false)  //当前属性表中不存在
    private int age;
    //4.政治面貌
    private String political;
    //5.地区城市
    private String city;
    //6.详细地址
    private String address;
    //7.性别（0-女  1-男）
    private int sex;
    //8.是否开启留言（0-关闭  1-开启）
    //@TableField("is_message")
    private int isMessage;
    //9.个人简介
    private String info;
    //10.添加日期
    private String addTime;
    //11.修改日期
    private String lastTime;

    public boolean isRepeat(User user){
        return user.getUid() != 0;
    }

}
