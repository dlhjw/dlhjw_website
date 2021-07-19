package com.dlhjw.website.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlhjw.website.bean.Education;
import com.dlhjw.website.mapper.EducationMapper;
import com.dlhjw.website.service.EducationService;
import org.springframework.stereotype.Service;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:26
 */
@Service
public class EducationServiceImpl  extends ServiceImpl<EducationMapper, Education> implements EducationService {
}
