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
 * @date 2021/5/30 19:09
 */
@Data //setter与getter方法
@NoArgsConstructor //无参构造
@ToString //toString方法
@TableName("work")
public class Work {
    //1.工作ID
    @TableId(value = "wid",type = IdType.AUTO)
    private Long wid;
    //2.用户ID
    private Long uid;
    //3.开始时间
    private String start;
    //4.结束时间
    private String end;
    //5.是否在校(0-否 1-是)
    private int isSchool;
    //6.公司名称
    private String company;
    //7.职位
    private String job;
    //8.说明介绍
    private String description;
    //9.添加日期
    private String addTime;
    //10.修改日期
    private String lastTime;


    public boolean isEmpty(Work work) {
        return "".equals(work.start) &&
                "".equals(work.end) &&
                "".equals(work.company) &&
                "".equals(work.job) &&
                "".equals(work.description);

    }
    @Override
    public int hashCode() {
        return Objects.hash(start, end, company, job, description);
    }

    public Work(Long uid, String start, String end, int isSchool, String company, String job, String description) {
        this.uid = uid;
        this.start = start;
        this.end = end;
        this.isSchool = isSchool;
        this.company = company;
        this.job = job;
        this.description = description;
    }
}
