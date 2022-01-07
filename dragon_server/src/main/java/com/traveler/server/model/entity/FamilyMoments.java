package com.traveler.server.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 动态表
 * </p>
 *
 * @author 宫蒙恩
 * @since 2021-07-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class FamilyMoments  extends BaseString  implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 文字信息(base64 转码)
     */
    private String title;

    /**
     * 原始文字信息(base64 转码)
     */
    @TableField(value = "title_original")
    private String titleOriginal;

    /**
     * 是否置顶（1置顶，0不置顶 默认）
     */
    private Integer topStatus;

    /**
     * 位置信息
     */
    private String baiduRegionMessage;

    /**
     * 审核状态【1：通过 | 2：审核中 | 3：未通过】
     */
    private Integer verifyStatus;

    /**
     * 人工审核状态【1：通过 | 2：审核中 | 3：未通过】
     */
    private Integer adminVerifyStatus;

    /**
     * 逻辑删除【 0：未删除 | 1：删除 】
     */
    @TableLogic
    @TableField(value = "`is_deleted`")
    private Integer isDeleted;

    /**
     * 内容类型 （运营后台条件筛选字段）
     */
    @TableField(value = "`content_type`")
    private String contentType;

    /**
     * 人工审核时间
     */
    @TableField(value = "`admin_verify_time`")
    private Date adminVerifyTime;
    /**
     * 人工审核不通过的原因
     */
    @TableField(value = "`admin_no_pass_reason`")
    private  String adminNoPassReason;
    /**
     * 人工审核-审核人id(关联sys_user表主键)
     */
    @TableField(value = "`admin_id`")
    private  String adminId;
    /**
     * 申诉过期时间(默认7天,以最后一次审核的时间加上7天 , 无论人工审核还是AI审核只要不通过的时候都需要更新这个字段)
     */
    @TableField(value = "`appeal_expire_time`")
    private Date appealExpireTime;

    /**
     * 第一次审核时间（运营后台排序字段）
     */
    @TableField(value = "`first_verify_time`")
    private  Date firstVerifyTime;


    public FamilyMoments(String userId, String title, String titleOriginal, Integer topStatus, String baiduRegionMessage, Integer verifyStatus, Integer adminVerifyStatus, Integer isDeleted, String contentType) {
        this.userId = userId;
        this.title = title;
        this.titleOriginal = titleOriginal;
        this.topStatus = topStatus;
        this.baiduRegionMessage = baiduRegionMessage;
        this.verifyStatus = verifyStatus;
        this.adminVerifyStatus = adminVerifyStatus;
        this.isDeleted = isDeleted;
        this.contentType = contentType;
    }

    public FamilyMoments(String userId, String title, String titleOriginal, String baiduRegionMessage) {
        this.userId = userId;
        this.title = title;
        this.titleOriginal = titleOriginal;
        this.baiduRegionMessage = baiduRegionMessage;
        this.adminVerifyStatus = ConstantType.VERIFY_STATUS_BLOCK;
        this.verifyStatus = ConstantType.VERIFY_STATUS_BLOCK;
        this.topStatus = ConstantType.FAMILY_MOMENT_TOP_STATUS_OFF;


    }

    public static FamilyMoments instanceDefault(String userId, String title,String titleOriginal, String baiduRegionMessage){
        return new FamilyMoments(userId,title,titleOriginal,baiduRegionMessage);
    }


}
