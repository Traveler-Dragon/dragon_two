package com.traveler.server.service.impl;


import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.traveler.server.mapper.FamilyMomentsMapper;
import com.traveler.server.model.dto.FamilyCommentsDto;
import com.traveler.server.model.entity.FamilyComments;
import com.traveler.server.model.entity.FamilyMoments;
import com.traveler.server.service.FamilyMomentsService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宫蒙恩
 * @since 2021-07-09
 */
@Service
public class FamilyMomentsServiceImpl extends ServiceImpl<FamilyMomentsMapper, FamilyComments> implements FamilyMomentsService {

    @Autowired
    private FamilyMomentsMapper familyMomentsMapper;

    @Override
    public void sendComments(String momentId, String userId, String toUserId, Integer parentId, String content) {
        FamilyComments comments = new FamilyComments();
        comments.setCommentId(UUID.randomUUID().toString().replace("-",""));
        comments.setUserId(userId);
        comments.setToUserId(toUserId);
        comments.setContent(content);
        comments.setParentId(parentId);
        comments.setMomentId(momentId);

        familyMomentsMapper.insert(comments);
        familyMomentsMapper.insertMomentWithComment(comments.getMomentId(),comments.getCommentId());
    }

    @Override
    public List<FamilyCommentsDto> getComments(String momentId) {
        List<String> commentsList = familyMomentsMapper.selectByMomentId(momentId);
        List<FamilyCommentsDto> result1 = new ArrayList<>();
        List<FamilyCommentsDto> result2 = null;
        QueryWrapper<FamilyComments> wrapper = new QueryWrapper<>();
        wrapper.in("comment_id",commentsList);
        wrapper.eq("parent_id",1);
        List<FamilyComments> familyCommentsList1 = familyMomentsMapper.selectList(wrapper);
        QueryWrapper<FamilyComments> wrapper2 = new QueryWrapper<>();
        wrapper.in("comment_id",commentsList);
        wrapper.eq("parent_id",2);
        List<FamilyComments> familyCommentsList2 = familyMomentsMapper.selectList(wrapper2);
        for (FamilyComments familyComments : familyCommentsList1) {
            for (FamilyComments comments : familyCommentsList2) {
                if (familyComments.getUserId().equals(comments.getToUserId())){
                    result2 = new ArrayList<>();
                    FamilyCommentsDto familyCommentsDto = new FamilyCommentsDto();
                    familyCommentsDto.setContent(comments.getContent());
                    familyCommentsDto.setUserId(comments.getUserId());
                    result2.add(familyCommentsDto);
                }
            }
            FamilyCommentsDto familyCommentsDto = new FamilyCommentsDto();
            familyCommentsDto.setUserId(familyComments.getUserId());
            familyCommentsDto.setContent(familyComments.getContent());
            familyCommentsDto.setSecondComments(result2);
            result1.add(familyCommentsDto);
        }

        return result1;
    }
}
