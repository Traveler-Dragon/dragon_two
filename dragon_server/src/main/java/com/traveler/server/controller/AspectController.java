package com.traveler.server.controller;

import com.traveler.server.model.bo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 伏守龙
 */
@RestController
@RequestMapping("/aspect")
@Slf4j
public class AspectController {


    @RequestMapping(value = "/web",method = RequestMethod.POST)
    public BaseResponse webExchangeGold(){
        log.info("访问到web接口啦");
        return BaseResponse.success();
    }
    @RequestMapping(value = "/back",method = RequestMethod.POST)
    public BaseResponse backExchangeGold(){
        log.info("访问到后台接口啦");
        return BaseResponse.success();
    }
}
