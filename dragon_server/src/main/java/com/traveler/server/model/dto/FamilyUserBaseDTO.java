package com.traveler.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

/**
 * <p>
 * 用户基本数据 DTO
 * </p>
 *
 * @author 宫蒙恩
 * @date: Created in 2021-03-27 14:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyUserBaseDTO {

    /**
     * 用户id
     */
    @NotNull
    private String userId;

    /**
     * 用户头像
     */
    private String homeImgUrl;

    /**
     * 昵称
     */
    @NotNull
    private String homeNickname;

    /**
     * 圈层等级
     */
    private Integer homelandLevel;

    /**
     * 关注状态
     */
    private Integer starsStatus;

    /**
     * 关注状态
     */
    private Integer likeStatus;

    /**
     * 家园id
     */
    private String homelandNumber;

    /**
     * 家园id
     */
    private Integer sex;

    /**
     *
     */
    private Date CreatedOn;


    /**
     * 最后一条数据的唯一标识 | 第二排序字段 | 必传
     */

    private String lastIdentifier;

    /**
     *  最后一条数据的时间   | 第一排序字段 | 非必传
     */
    private long lastDateTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyUserBaseDTO that = (FamilyUserBaseDTO) o;
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
