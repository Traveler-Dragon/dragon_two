package com.traveler.server.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FamilyBalance implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 余额id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 钻石金额
     */
    private Integer diamondAmount;

    /**
     * 金币金额
     */
    private Integer goldAmount;

    private Integer version;

    /**
     * 创建时间
     */
    private Date createdOn;

    /**
     * 修改时间
     */
    private Date updatedOn;


}
