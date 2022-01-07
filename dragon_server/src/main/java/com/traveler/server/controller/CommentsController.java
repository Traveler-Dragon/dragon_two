package com.traveler.server.controller;

import com.alibaba.fastjson.JSON;
import com.traveler.server.model.bo.BaseResponse;
import com.traveler.server.model.entity.FamilyMoments;
import com.traveler.server.model.entity.OrderInfo;
import com.traveler.server.service.FamilyMomentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 伏守龙
 */
@RestController
@RequestMapping("/comments")
@Slf4j
public class CommentsController {
    @Autowired
    private FamilyMomentsService familyMomentsService;

    @PostMapping("sendComments")
    public BaseResponse sendComments(@NotBlank(message = "参数不能为空") @RequestParam("momentId") String momentId,
                                     @NotBlank(message = "参数不能为空") @RequestParam("userId") String userId,
                                     @NotBlank(message = "参数不能为空") @RequestParam("toUserId") String toUserId,
                                     @NotBlank(message = "参数不能为空") @RequestParam("parentId") Integer parentId,
                                     @NotBlank(message = "参数不能为空") @RequestParam("content") String content){
        Map<String,Object> param = new HashMap<>(4);
        param.put("momentId",momentId);
        param.put("userId",userId);
        param.put("toUserId",toUserId);
        param.put("parentId",parentId);
        param.put("content",content);
        log.info("/sendComments 入参: " + JSON.toJSONString(param));
        familyMomentsService.sendComments(momentId,userId,toUserId,parentId,content);
        return BaseResponse.success();
    }

    @PostMapping("getComments")
    public BaseResponse getComments(@RequestParam("momentId") String momentId){
        return BaseResponse.success(familyMomentsService.getComments(momentId));
    }
    @RequestMapping(value = "/testAspect",method = RequestMethod.POST)
    public BaseResponse testAspect(@RequestBody @Validated OrderInfo orderInfo){
        return BaseResponse.success(JSON.toJSON(orderInfo));
    }
}
