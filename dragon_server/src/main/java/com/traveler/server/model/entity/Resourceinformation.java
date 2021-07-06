package com.traveler.server.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "resourceinformation")
public class Resourceinformation {

    //用于标识
    private String uuid;

    //文件一级目录
    private String class1;

    //文件二级目录
    private String class2;

    //文件名
    private String filename;

    //文件物理地址
    private String physicaladdress;

    //缩略图地址

    private String thumbnail;

    private String chainCode;

    //是否激活
    private Integer active;

}
