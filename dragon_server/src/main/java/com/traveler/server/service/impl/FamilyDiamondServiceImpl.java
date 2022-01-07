package com.traveler.server.service.impl;

import com.traveler.server.mapper.FamilyDiamondMapper;
import com.traveler.server.model.entity.FamilyDiamond;
import com.traveler.server.service.FamilyDiamondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FamilyDiamondServiceImpl implements FamilyDiamondService {
    @Autowired
    private FamilyDiamondMapper familyDiamondMapper;

    @Override
    public void add() {

        List<FamilyDiamond> diamondListAndroid = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            FamilyDiamond familyDiamond = new FamilyDiamond();
            familyDiamond.setId(UUID.randomUUID().toString().replace("-",""));
            familyDiamond.setDiamondName("10钻石");
            familyDiamond.setDiamondAmount(new BigDecimal(10));
            familyDiamond.setPayAmount(new BigDecimal(1));
            familyDiamond.setIcon("图标地址");
            familyDiamond.setSystem(0);
            familyDiamond.setCreatedOn(new Date());
            familyDiamond.setUpdatedOn(new Date());
            familyDiamondMapper.insert(familyDiamond);
        }

        List<FamilyDiamond> diamondListIos = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            FamilyDiamond familyDiamond = new FamilyDiamond();
            familyDiamond.setId(UUID.randomUUID().toString().replace("-",""));
            familyDiamond.setDiamondName("10钻石");
            familyDiamond.setDiamondAmount(new BigDecimal(10));
            familyDiamond.setPayAmount(new BigDecimal(1));
            familyDiamond.setIcon("图标地址");
            familyDiamond.setSystem(1);
            familyDiamond.setCreatedOn(new Date());
            familyDiamond.setUpdatedOn(new Date());
            familyDiamondMapper.insert(familyDiamond);
        }

    }
}
