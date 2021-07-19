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
@TableName("keywords")
public class Keywords {
    //1.关键词ID
    @TableId(value = "kid",type = IdType.AUTO)
    private Long kid;
    //2.用户ID
    private Long uid;
    //3.性格关键词
    private String disposition;
    //4.能力关键词
    private String ability;
    //5.添加日期
    private String addTime;
    //6.修改日期
    private String lastTime;

    public boolean isEmpty( Keywords keywords){
        return "".equals(keywords.disposition) &&
                "".equals(keywords.ability);

    }

    public Keywords(Long uid, String disposition, String ability) {
        this.uid = uid;
        this.disposition = disposition;
        this.ability = ability;
    }
}
