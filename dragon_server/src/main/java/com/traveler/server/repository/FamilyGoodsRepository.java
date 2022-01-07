package com.traveler.server.repository;

import com.traveler.server.model.entity.FamilyGoods;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author 伏守龙
 */
public interface FamilyGoodsRepository extends MongoRepository<FamilyGoods,Long> {

    List<FamilyGoods> findByCategoryId(Integer categoryId);

    FamilyGoods findById(Integer goodsId);
}
