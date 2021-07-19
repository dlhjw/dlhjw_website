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
 * @date 2021/5/30 19:10
 */
@Data //setter与getter方法
@NoArgsConstructor //无参构造
@ToString //toString方法
@TableName("specialty")
public class Specialty {
    //1.特长ID
    @TableId(value = "sid",type = IdType.AUTO)
    private Long sid;
    //2.用户ID
    private Long uid;
    //3.特长名称
    private String name;
    //4.特长描述
    private String description;
    //5.添加日期
    private String addTime;
    //6.修改日期
    private String lastTime;

    public boolean isEmpty(Specialty specialty) {
        return "".equals(specialty.name) &&
                "".equals(specialty.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    public Specialty(Long uid, String name, String description) {
        this.uid = uid;
        this.name = name;
        this.description = description;
    }
}
