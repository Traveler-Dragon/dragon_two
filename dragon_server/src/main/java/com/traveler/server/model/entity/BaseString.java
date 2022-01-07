package com.traveler.server.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/***
 * @Author: haoyabo
 * @Date: 2021/3/19 10:07
 * @Description:
 */
@Data
public class BaseString implements Serializable {
    /**
     * 主键
     */
    @TableId(value="id",type = IdType.UUID)
    private String id;

    /**
     * 创建时间
     */
    @TableField(value="created_on",fill = FieldFill.INSERT)
    private Date createdOn;
    /**
     * 更新时间
     */
    @TableField(value="updated_on",fill = FieldFill.INSERT_UPDATE)
    private Date updatedOn;

}
