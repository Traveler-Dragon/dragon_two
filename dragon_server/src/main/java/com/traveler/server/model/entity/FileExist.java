package com.traveler.server.model.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

@Data
public class FileExist {

    @ExcelProperty(value = "文件名")
    @ColumnWidth(20)
    private String fileName;

    @ExcelProperty(value = "文件地址")
    @ColumnWidth(50)
    private String fileAddress;
}
