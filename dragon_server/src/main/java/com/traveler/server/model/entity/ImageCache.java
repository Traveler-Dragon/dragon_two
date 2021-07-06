package com.traveler.server.model.entity;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;

public class ImageCache {
    static TimedCache<String,String> timedCache = CacheUtil.newTimedCache(1000);

    public static void setCache(String key,String value){
        timedCache.put(key,value);
    }

    public static String getCache(String key){
        return timedCache.get(key,false);
    }

}
