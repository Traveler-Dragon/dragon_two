package com.traveler.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.traveler.server.model.entity.FamilyComments;
import com.traveler.server.model.entity.FamilyMoments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 宫蒙恩
 * @since 2021-07-09
 */
public interface FamilyMomentsMapper extends BaseMapper<FamilyComments> {


    void insertMomentWithComment(@Param("momentId") String momentId, @Param("commentId") String commentId);

    List<String> selectByMomentId(@Param("momentId") String momentId);
}
