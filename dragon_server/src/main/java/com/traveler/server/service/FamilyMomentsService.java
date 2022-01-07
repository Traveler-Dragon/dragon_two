package com.traveler.server.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.traveler.server.model.dto.FamilyCommentsDto;
import com.traveler.server.model.entity.FamilyComments;
import com.traveler.server.model.entity.FamilyMoments;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宫蒙恩
 * @since 2021-07-09
 */
public interface FamilyMomentsService extends IService<FamilyComments> {

//    /**
//     *  发动态综合接口
//     * @param userId
//     * @param userNickName
//     * @param content
//     * @param atList
//     * @param topicList
//     * @param location
//     * @param voiceSize
//     * @param voiceFile
//     * @param imgFiles
//     * @return
//     */
//    FamilyMomentsMaterialDTO publishMoment(String userId, String userNickName, String content, String atList, String topicList, String location, Long voiceSize, MultipartFile voiceFile, MultipartFile[] imgFiles) throws ImcoreBusinessException;
//
//    /**
//     *  推荐动态列表
//     * @param commonBasePageRequestDTO
//     * @return
//     */
//    List<FamilyMomentsMaterialDTO> momentByRecommend(FamilyMomentBasePageRequestDTO commonBasePageRequestDTO) throws ImcoreBusinessException;
//
//    /**
//     * 获取动态点赞状态 【  1：已点赞 | 2：未点赞  】
//     * @param currentUserId     当前用户id
//     * @param momentId          动态id
//     * @return
//     */
//    Integer getMomentLikeStatus(String currentUserId, String momentId);
//
//    /**
//     * 获取动态|评论点赞数
//     * @param momentId
//     * @param authorId
//     * @param includeAuthor
//     * @return
//     */
//    Long countFamilyMomentOrCommentLike(String momentId, String authorId, boolean includeAuthor);
//
//    /**
//     * 评论热度计算公式
//     * @param likeCount         点赞数
//     * @param commentCount      评论数
//     * @return
//     */
//    double computeCommentHeatValue(double likeCount, double commentCount);
//
//    /**
//     * 动态热度计算公式
//     * @param likeCount         点赞数
//     * @param commentCount      评论数
//     * @param createMomentTime  动态发布时间
//     * @return
//     */
//    double computeMomentHeatValue(double likeCount, double commentCount, Date createMomentTime);
//
//    /**
//     * 获取动态分享数
//     * @param momentId
//     * @return
//     */
//    long countFamilyMomentShare(String momentId);
//
//    /**
//     *  关注动态列表
//     * @param commonBasePageRequestDTO
//     * @return
//     */
//    List<FamilyMomentsMaterialDTO> momentByFollow(FamilyMomentBasePageRequestDTO commonBasePageRequestDTO) throws ImcoreBusinessException;
//
//    /**
//     * 动态分享
//     * @param momentId
//     * @param userId
//     */
//    void insertShare(String momentId, String userId) throws ImcoreBusinessException;
//
//    /**
//     *  动态|评论点赞
//     * @param type
//     * @param identifier
//     * @param toUserId
//     * @param toUserNickName
//     * @param fromUserId
//     * @param fromUserNickName
//     * @return
//     */
//    Integer likeForMomentOrComment(Integer type, String identifier, String toUserId, String toUserNickName, String fromUserId, String fromUserNickName) throws ImcoreBusinessException;
//
//    /**
//     *  动态|评论取消点赞
//     *
//     * @param type
//     * @param identifier
//     * @param toUserId
//     * @param fromUserId
//     * @return
//     */
//    Integer unlikeForMomentOrComment(int type, String identifier, String toUserId, String fromUserId) throws ImcoreBusinessException;
//
//    /**
//     * 发布评论 - 评论动态的评论 （一级评论）
//     * @param momentId
//     * @param fromUserId
//     * @param fromUserNickName
//     * @param toUserId
//     * @param toUserNickName
//     * @param content
//     * @param atList
//     * @param voiceSize
//     * @param voiceFile
//     * @param imgFiles
//     */
//    void publishCommentOnOneLevel(String momentId, String fromUserId, String fromUserNickName, String toUserId, String toUserNickName, String content, String atList, long voiceSize, MultipartFile voiceFile, MultipartFile[] imgFiles) throws ImcoreBusinessException;
//
//    /**
//     * 获取话题分类
//     * @return
//     */
//    List<FamilyTopicKind> getAllTopicKind();
//
//    /**
//     * 获取话题
//     *
//     * @param pageRequestDTO @return
//     * @return
//     */
//    List<FamilyTopicDTO> getTopicByKind(FamilyMomentBasePageRequestDTO pageRequestDTO) throws ImcoreBusinessException;
//
//    /**
//     * 添加话题 - （仅话题名称）
//     * @param kindName
//     * @return
//     */
//    FamilyTopic addTopic(String kindName) throws ImcoreBusinessException;
//
//    /**
//     * 关注话题
//     * @param topicId
//     * @param userId
//     * @return
//     */
//    Integer followTopic(String topicId, String userId) throws ImcoreBusinessException;
//
//    /**
//     * 取关话题
//     * @param topicId
//     * @param userId
//     * @return
//     */
//    Integer unFollowTopic(String topicId, String userId) throws ImcoreBusinessException;
//
//    /**
//     * 获取关注话题
//     *
//     * @param pageRequestDTO
//     * @return
//     */
//    List<FamilyTopicDTO> getFollowTopic(FamilyMomentBasePageRequestDTO pageRequestDTO) throws ImcoreBusinessException;
//
//    /**
//     * 搜索话题
//     * @param pageRequestDTO
//     * @return
//     */
//    List<FamilyTopicDTO> searchTopic(FamilyMomentBasePageRequestDTO pageRequestDTO) throws ImcoreBusinessException;
//
//    /**
//     * 话题详情
//     * @param pageRequestDTO
//     * @return
//     */
//    FamilyTopicDetailDTO getDetailTopic(FamilyMomentBasePageRequestDTO pageRequestDTO) throws ImcoreBusinessException;
//
//    /**
//     * 动态列表-相同圈层
//     * @param pageRequestDTO
//     * @return
//     */
//    List<FamilyMomentsMaterialDTO> momentBySameLevel(FamilyMomentBasePageRequestDTO pageRequestDTO) throws ImcoreBusinessException;
//
//    /**
//     * 动态搜索
//     * @param commonBasePageRequestDTO
//     * @return
//     */
//    Map search(FamilyMomentBasePageRequestDTO commonBasePageRequestDTO) throws ImcoreBusinessException;
//
//    List<FamilyNotifyAtDto> getNotifyAtList(FamilyMomentBasePageRequestDTO commonBasePageRequestDTO) throws ImcoreBusinessException;
//
//    List<FamilyNotifyCommentDto> getNotifyCommentList(FamilyMomentBasePageRequestDTO commonBasePageRequestDTO) throws ImcoreBusinessException;
//
//    List<FamilyNotifyMomentLikeDto> getFamilyNotifyLikeList(FamilyMomentBasePageRequestDTO commonBasePageRequestDTO) throws ImcoreBusinessException;
//
//    /**
//     * 通过动态id获取动态数据
//     * @param momentId
//     * @param currentUserId
//     * @return
//     */
//    FamilyMomentsMaterialDTO singleRefresh(String momentId, String currentUserId) throws ImcoreBusinessException;
//
//    /**
//     * 运营后台审核通过
//     * @param identify
//     * @param adminUser
//     * @param type
//     */
//    void adminVerifyPass(String[] identify, String adminUser, Integer type) throws ImcoreBusinessException;
//
//    /**
//     * 运营后台审核不通过
//     * @param identify
//     * @param currentUserId
//     * @param adminUser
//     * @param noPassReason
//     * @param type
//     */
//    void adminVerifyNoPass(String[] identify, String currentUserId, String adminUser, String noPassReason, Integer type) throws ImcoreBusinessException;
//
//
//    /**
//     * 运营后台申诉不通过
//     * @param identify
//     * @param currentUserId
//     * @param adminUser
//     * @param type
//     */
//    void adminAppealNoPass(String[] identify, String currentUserId, String adminUser, Integer type) throws ImcoreBusinessException;
//
//    /**
//     * 运营后台申诉通过
//     * @param identify
//     * @param adminUser
//     * @param type
//     * @param currentUserId
//     */
//    void adminAppealPass(String[] identify, String adminUser, Integer type, String currentUserId) throws ImcoreBusinessException;

    void sendComments(String momentId, String userId, String toUserId, Integer parentId, String content) ;

    List<FamilyCommentsDto> getComments(String momentId);
}
