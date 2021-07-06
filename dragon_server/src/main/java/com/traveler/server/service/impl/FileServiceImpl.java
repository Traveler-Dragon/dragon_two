package com.traveler.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.traveler.server.mapper.FileMapper;
import com.traveler.server.model.entity.FileExist;
import com.traveler.server.model.entity.Resourceinformation;
import com.traveler.server.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FileServiceImpl  implements FileService {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public List<FileExist> selectAddressByActive(int active) {
        List<FileExist> fileNames = new ArrayList<>();
        QueryWrapper<Resourceinformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("active",active);

        List<Resourceinformation> address =fileMapper.selectList(queryWrapper);
        if (address.size() == 0 ){
            return null;
        }
        for (Resourceinformation resourceinformation : address) {
            long length = new File(resourceinformation.getPhysicaladdress()).length();
            log.info("文件为: {},  大小为: {}",resourceinformation.getFilename(),length);
            if (length ==0){
                log.info("文件为: {}, 该文件不存在,请检查一下文件!",resourceinformation.getFilename());
                FileExist fileExist = new FileExist();
                fileExist.setFileName(resourceinformation.getFilename());
                fileExist.setFileAddress(resourceinformation.getPhysicaladdress());
                fileNames.add(fileExist);
            }
        }

        return fileNames;
    }
}
