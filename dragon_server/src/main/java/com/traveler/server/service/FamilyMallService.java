package com.traveler.server.service;

import com.alipay.api.AlipayApiException;
import com.traveler.server.model.entity.FamilyGoods;
import com.traveler.server.model.entity.GoodsExcel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FamilyMallService {
    boolean diamondAdd();

    void addGoods(List<GoodsExcel> list);

    List<GoodsExcel> selectItemList(List<Integer> itemList);

    void updateGoods(List<GoodsExcel> updateGoods);

    void pay(Integer payType, HttpServletRequest request, HttpServletResponse response) throws AlipayApiException;
}
