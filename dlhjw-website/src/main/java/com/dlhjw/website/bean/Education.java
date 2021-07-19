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
@TableName("education")
public class Education {
    //1.教育ID
    @TableId(value = "eid",type = IdType.AUTO)
    private Long eid;
    //2.用户ID
    private Long uid;
    //3.开始时间
    private String start;
    //4.结束时间
    private String end;
    //5.学校
    private String school;
    //6.专业名称
    private String study;
    //7.说明
    private String description;
    //8.添加日期
    private String addTime;
    //9.修改日期
    private String lastTime;

    public boolean isEmpty(Education education) {
        return "".equals(education.start) &&
                "".equals(education.end) &&
                "".equals(education.school) &&
                "".equals(education.study);
    }


    @Override
    public int hashCode() {
        return Objects.hash(start, end, school, study);
    }

    public Education(Long uid, String start, String end, String school, String study, String description) {
        this.uid = uid;
        this.start = start;
        this.end = end;
        this.school = school;
        this.study = study;
        this.description = description;
    }


}
