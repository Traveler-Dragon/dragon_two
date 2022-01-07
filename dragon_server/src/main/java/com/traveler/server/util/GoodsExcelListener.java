package com.traveler.server.util;


import cn.hutool.db.nosql.mongo.MongoDS;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.traveler.server.model.entity.FamilyGoods;
import com.traveler.server.model.entity.GoodsExcel;
import com.traveler.server.service.FamilyMallService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class GoodsExcelListener extends AnalysisEventListener<GoodsExcel> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsExcelListener.class);
    private final String ali_url = "https://imcore-jiayuan-dev.oss-cn-beijing.aliyuncs.com/homeicon/";
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 3000;
    List<GoodsExcel> list = new ArrayList<>();
    List<Long> itemList = new ArrayList<>();
    static List<GoodsExcel> errorList = new ArrayList<>();
    static List<Integer> rowList = new ArrayList<>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private FamilyMallService familyMallService;
    
    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     * @param
     */
    public GoodsExcelListener(FamilyMallService familyMallService) {
        this.familyMallService = familyMallService;
    }
    
    @Override
    public void invoke(GoodsExcel goodsExcel, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(goodsExcel));
        goodsExcel.setIcon(ali_url+goodsExcel.getIcon()+".png");
        goodsExcel.setCreatedOn(new Date());
        goodsExcel.setUpdatedOn(new Date());
        list.add(goodsExcel);
        itemList.add(goodsExcel.getItemId());

        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
            itemList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }
    /**

     * 加上存储数据库

     */
    public static List<GoodsExcel> getErrorList(){
        return errorList;
    }
    public static List<Integer> getRowList(){
        return rowList;
    }

    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
//        List<FamilyGoods> updateGoods = new ArrayList<>();
//        if (itemList.size()>0){
//            List<FamilyGoods> existList = familyMallService.selectItemList(itemList);
//            List<FamilyGoods> resultList = existList.stream()
//                    .map(l -> list.stream().filter(e -> Objects.nonNull(l.getItemId()) && Objects.nonNull(e.getItemId()) && Objects.equals(l.getItemId(), e.getItemId())).findAny().orElse(null))
//                    .filter(Objects::nonNull)
//                    .collect(Collectors.toList());
//            for (FamilyGoods goodsExcel : resultList) {
//                updateGoods.add(goodsExcel);
//                list.remove(goodsExcel);
//            }
//        }
//        familyMallService.updateGoods(updateGoods);
        familyMallService.addGoods(list);
        LOGGER.info("存储数据库成功！");
    }

}
