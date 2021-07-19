package com.dlhjw.website.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/1 20:42
 */
@Data //setter与getter方法
@NoArgsConstructor //无参构造
@ToString //toString方法
@TableName("contact")
public class Contact {

    //1.联系方式ID
    @TableId(value = "cid",type = IdType.AUTO)
    private Long cid;
    //2.用户ID
    private Long uid;
    //3.邮箱
    private String email;
    //4.电话
    private String phone;
    //5.微信
    private String wechat;
    //6.微信公众号
    private String wechatOfficial;
    //7.QQ
    private String qq;
    //8.微博地址
    private String weibo;
    //9.github地址
    private String github;
    //10.博客地址
    private String blog;
    //11.头像地址
    private String mask;
    //12.添加日期
    private String addTime;
    //13.修改日期
    private String lastTime;

    public Contact(Long uid){
        this.uid = uid;
    }

    public boolean isEmpty( Contact contact){
        return "".equals(contact.email) &&
                "".equals(contact.phone) &&
                "".equals(contact.wechat) &&
                "".equals(contact.wechatOfficial) &&
                "".equals(contact.qq) &&
                "".equals(contact.weibo) &&
                "".equals(contact.github) &&
                "".equals(contact.blog) &&
                contact.mask == null;
    }

    public boolean haveContact( Contact contact){
        return !(("".equals(contact.email) || contact.email == null) &&
                ("".equals(contact.phone) || contact.phone == null) &&
                ("".equals(contact.wechat) || contact.wechat == null) &&
                ("".equals(contact.wechatOfficial) || contact.wechatOfficial == null) &&
                ("".equals(contact.qq) || contact.qq == null) &&
                ("".equals(contact.weibo) || contact.weibo == null) &&
                ("".equals(contact.github) || contact.github == null) &&
                ("".equals(contact.blog) || contact.blog == null));
    }


}
