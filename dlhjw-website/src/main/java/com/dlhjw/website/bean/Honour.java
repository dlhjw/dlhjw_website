package com.dlhjw.website.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("honour")
public class Honour {
    //1.荣誉ID
    @TableId(value = "hid",type = IdType.AUTO)
    private Long hid;
    //2.用户ID
    private Long uid;
    //3.荣誉名称
    private String name;
    //4.荣誉类别（0-荣誉证书  1-职业能力证书）
    private int category;
    //5.荣誉描述
    private String description;
    //7.荣誉证书的PDF文件
    private String file;
    //是否上传相关文件（0-无  1-有）
    @TableField(exist = false)  //当前属性表中不存在
    private int haveFile;
    //文件编号
    @TableField(exist = false)  //当前属性表中不存在
    private int fileCode;
    //8.添加日期
    private String addTime;
    //9.修改日期
    private String lastTime;

    public boolean isEmpty(Honour honour){
        return "".equals(honour.name) &&
                "".equals(honour.description) &&
                "".equals(honour.file) &&
                honour.haveFile == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, file);
    }

    public Honour(Long uid, String name, int category, String description, String file) {
        this.uid = uid;
        this.name = name;
        this.category = category;
        this.description = description;
        this.file = file;
    }
}
