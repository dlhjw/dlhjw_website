package com.dlhjw.website.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dlhjw.website.bean.*;
import com.dlhjw.website.service.*;
import com.dlhjw.website.utils.AgeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/4 22:07
 */
@Slf4j
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    UserService userService;

    @Autowired
    ContactService contactService;

    @Autowired
    EducationService educationService;

    @Autowired
    WorkService workService;

    @Autowired
    KeywordsService keywordsService;

    @Autowired
    SpecialtyService specialtyService;

    @Autowired
    HonourService honourService;

    @Autowired
    MessageService messageService;

    @Value("${my-config.version}")
    public String version;

    @Value("${my-config.contact.mask-url-download}")
    public String maskUrlDownload;



    @Override
    public Info getInfoByUid(Long uid) {

        //1.根据uid查找用户，如果没有此用户，则返回null
        User user = userService.getById(uid);
        if( user == null){
            return null;
        }
        log.info("查找到的用户:" + user);

        //2.为查询创建wrapper条件封装
        //3.根据uid查找用户其他信息
        QueryWrapper<Contact> contactWrapper = new QueryWrapper<>();
        contactWrapper.eq("uid",uid);
        Contact contact = contactService.getOne(contactWrapper);
        log.info("查找到的联系方式:" + contact);

        QueryWrapper<Education> educationWrapper = new QueryWrapper<>();
        educationWrapper.eq("uid",uid);
        List<Education> educations = educationService.list(educationWrapper);
        log.info("查找到的教育经历:" + educations);

        QueryWrapper<Work> workWrapper = new QueryWrapper<>();
        workWrapper.eq("uid",uid);
        List<Work> works = workService.list(workWrapper);
        log.info("查找到的工作经历:" + works);

        QueryWrapper<Keywords> keywordsWrapper = new QueryWrapper<>();
        keywordsWrapper.eq("uid",uid);
        Keywords keywords = keywordsService.getOne(keywordsWrapper);
        log.info("查找到的关键词:" + keywords);

        QueryWrapper<Specialty> speciatyWrapper = new QueryWrapper<>();
        speciatyWrapper.eq("uid",uid);
        List<Specialty> specialties = specialtyService.list(speciatyWrapper);
        log.info("查找到的特长:" + specialties);

        QueryWrapper<Honour> honourWrapper = new QueryWrapper<>();
        honourWrapper.eq("uid",uid);
        List<Honour> honours = honourService.list(honourWrapper);
        log.info("查找到的荣誉证书:" + honours);

        //如果用户的isMessage设置为0，则对应Message为null
        List<Message> messages = null;
        if( user.getIsMessage() == 1 ){
            QueryWrapper<Message> messageWrapper = new QueryWrapper<>();
            messageWrapper.eq("uid",uid);
            messageWrapper.orderBy(true,false,"mid");
            messages = messageService.list(messageWrapper);
        }
        log.info("留言消息为:" + messages);

        //4.对查找的数据做处理（年龄、判断contact是否为空）
        //4.1 根据生日获取年龄
        if( !"".equals(user.getBirth()) && user.getBirth() != null ){
            user.setAge(AgeUtil.getAge(AgeUtil.parse(user.getBirth())));
        }
        //4.2 判断contact是否为空，是则赋值uid，此处不赋值前端thymeleaf报错
        if( contact == null ){
            contact = new Contact();
        }
        //4.3 给haveHon赋值
        int haveHon0 = 0;
        int haveHon1 = 0;
        int haveHon2 = 0;
        if( honours != null ){
            for (int i = 0; i < honours.size(); i++) {
                int category = honours.get(i).getCategory();

                if( category == 0){
                    haveHon0 = 1;
                } else if(category ==1) {
                    haveHon1 = 1;
                } else if( category == 2){
                    haveHon2 = 1;
                }
            }

        }
        //4.4 判断是否有联系我页面
        int haveContact = 0;
        boolean haveContactBool = contact.haveContact(contact);
        if( haveContactBool ){
            haveContact = 1;
        }
        //5.将信息封装到Info里，返回json给前端
        Info info = new Info(user, contact, educations, works, keywords, specialties, honours, messages, version, maskUrlDownload, haveHon0, haveHon1, haveHon2, haveContact);
        return info;
    }


}
