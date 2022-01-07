package com.traveler.server.model.dto;



import com.traveler.server.model.entity.FamilyMoments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * 动态基本信息包含热度值
 * </p>
 *
 * @author 宫蒙恩
 * @date: Created in 2021-07-16 10:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyMomentWithHeatValueDTO extends FamilyMoments {


    /**
     * 分享数
     */
    private long shareCount;

    /**
     * 评论数
     */
    private long commentCount;

    /**
     * 点赞数
     */
    private long likeCount;

    /**
     * 热度值
     */
    private double heatValue;


    public FamilyMomentWithHeatValueDTO(String userId, String title, String titleOriginal, Integer topStatus, String baiduRegionMessage, Integer verifyStatus, Integer adminVerifyStatus, Integer isDeleted, String contentType, long shareCount, long commentCount, long likeCount, double heatValue, String id, Date createdOn, Date updatedOn) {
        super(userId, title,titleOriginal, topStatus, baiduRegionMessage, verifyStatus, adminVerifyStatus, isDeleted,contentType);
        super.setId(id);
        super.setCreatedOn(createdOn);
        super.setUpdatedOn(updatedOn);
        this.shareCount = shareCount;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.heatValue = heatValue;
    }

    public static FamilyMomentWithHeatValueDTO instanceDefaultFamilyMomentWithHeatValueDTO(FamilyMoments moments, long shareCount, long commentCount, long likeCount, double heatValue){
        return new FamilyMomentWithHeatValueDTO(moments.getUserId(), moments.getTitle(), moments.getTitleOriginal(), moments.getTopStatus(), moments.getBaiduRegionMessage(), moments.getVerifyStatus(), moments.getAdminVerifyStatus(), moments.getIsDeleted(), moments.getContentType(), shareCount, commentCount, likeCount, heatValue, moments.getId(), moments.getCreatedOn(), moments.getUpdatedOn());
    }
}
