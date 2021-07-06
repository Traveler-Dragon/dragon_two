package com.traveler.server.quartz;

import com.alibaba.excel.EasyExcel;
import com.traveler.server.model.entity.FileExist;
import com.traveler.server.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class ScheduleTask {
	private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTask.class);
	@Autowired
	private FileService fileService;

	public void sayHello(){

		List<FileExist> fileExists = fileService.selectAddressByActive(1);

		if (!(fileExists.size() > 0)) return;

		LOGGER.info("不存在的文件有: {}",fileExists.toString());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");


		String fileName = "FileExist"+simpleDateFormat.format(new Date())+".xlsx";
		String path = "C:\\Users\\DELL\\Desktop\\FileExist\\"+fileName;
		EasyExcel.write(path,FileExist.class).sheet("不存在文件").doWrite(fileExists);
	}
}
