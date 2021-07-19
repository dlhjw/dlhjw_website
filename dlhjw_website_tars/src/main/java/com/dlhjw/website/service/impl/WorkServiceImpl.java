package com.dlhjw.website.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlhjw.website.bean.Work;
import com.dlhjw.website.mapper.WorkMapper;
import com.dlhjw.website.service.WorkService;
import org.springframework.stereotype.Service;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/6/3 20:30
 */
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {
}
