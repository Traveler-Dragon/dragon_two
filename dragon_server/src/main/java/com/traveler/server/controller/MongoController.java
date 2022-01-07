package com.traveler.server.controller;

import com.mongodb.client.result.UpdateResult;
import com.traveler.server.model.bo.BaseResponse;
import com.traveler.server.model.entity.FamilyGoods;
import com.traveler.server.repository.FamilyGoodsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mongo")
@Slf4j
public class MongoController {

    @Autowired
    private FamilyGoodsRepository goodsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @RequestMapping("/add")
    public BaseResponse add(){
        FamilyGoods familyGoods = new FamilyGoods();
        goodsRepository.save(familyGoods);
        return BaseResponse.success();
    }

    @RequestMapping("/find")
    public BaseResponse find(@RequestParam("categoryId") Integer categoryId){
        return BaseResponse.success(goodsRepository.findByCategoryId(categoryId));
    }

    @RequestMapping("/update")
    public BaseResponse update(@RequestParam("goodsId") Integer goodsId,
                               @RequestParam("count") Integer count){
        FamilyGoods familyGoods = goodsRepository.findById(goodsId);

        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(goodsId));
        Update update = new Update();
        update.set("goods_stock",familyGoods.getGoodsStock() - count);
        mongoTemplate.upsert(query, update, FamilyGoods.class);
        return BaseResponse.success();
    }

    @RequestMapping("/findLimit")
    public BaseResponse findLimit(@RequestParam("categoryId") Integer categoryId,
                               @RequestParam("count") Integer count){
//        FamilyGoods familyGoods = goodsRepository.findById(categoryId);

        Query query = new Query();
        query.addCriteria(Criteria.where("category_id").is(categoryId));
        Sort sort = Sort.by("created_on").descending();
//        query.limit(5);
//        Update update = new Update();
//        update.set("goods_stock",familyGoods.getGoodsStock() - count);
        List<FamilyGoods> familyGoods1 = mongoTemplate.find(query.with(sort).limit(count), FamilyGoods.class);
        return BaseResponse.success(familyGoods1);
    }


}
