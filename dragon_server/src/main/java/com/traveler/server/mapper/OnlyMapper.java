package com.traveler.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.traveler.server.model.entity.FamilyComments;
import com.traveler.server.model.entity.Words;

import java.util.List;

/**
 * @author DELL
 */
public interface OnlyMapper extends BaseMapper<Words> {

    void addList(List<Words> wordsList);
}
