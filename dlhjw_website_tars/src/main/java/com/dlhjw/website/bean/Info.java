package com.dlhjw.website.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/4 19:26
 */
@Data //setter与getter方法
@NoArgsConstructor //无参构造
@AllArgsConstructor //全参构造
@ToString //toString方法
public class Info {

    //1.用户基础信息
    private User user;
    //2.联系方式
    private Contact contact;
    //3.教育经历
    private List<Education> educations;
    //4.工作经历
    private List<Work> works;
    //5.关键词
    private Keywords keywords;
    //6.特长
    private List<Specialty> specialties;
    //7.荣誉证书
    private List<Honour> honours;
    //8.留言消息
    private List<Message> messages;
    //9.版本信息
    private String version;
    //10.头像地址
    private String maskUrl;
    //11.荣誉-0荣誉证书  1-职业资格  2-专业技术
    private int haveHon0;
    private int haveHon1;
    private int haveHon2;
    //12. 判断是否有联系我
    private int haveContact;




}
