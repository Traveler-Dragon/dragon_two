package com.traveler.server.model.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("family_goods")
public class GoodsExcel {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @ExcelProperty("道具Id")
    @ColumnWidth(20)
    private Long itemId;

    @ExcelProperty("商品名称")
    @ColumnWidth(20)
    private String goodsName;

    @ExcelProperty("商品图标")
    @ColumnWidth(20)
    private String icon;

    @ExcelProperty("财富值")
    @ColumnWidth(20)
    private Integer wealthValue;

    @ExcelProperty("金币价格")
    @ColumnWidth(20)
    private Integer goldPrice;

    @ExcelProperty("钻石价格")
    @ColumnWidth(20)
    private Integer diamondPrice;

    @ExcelProperty("货币类型")
    @ColumnWidth(20)
    private Integer priceType;

    @ExcelProperty("商品状态")
    @ColumnWidth(20)
    private Integer status;

    @ExcelProperty("商品类型")
    @ColumnWidth(20)
    private Integer goods_type;

    @ExcelProperty("商品数量")
    @ColumnWidth(20)
    private Integer goods_stock;

    @ExcelProperty("用户购买数量")
    @ColumnWidth(20)
    private Integer user_stock;

    @ExcelProperty("促销价格")
    @ColumnWidth(20)
    private String promotion;

    @ExcelProperty("促销开始时间")
    @ColumnWidth(20)
    private Date promotion_start_time;

    @ExcelProperty("促销结束时间")
    @ColumnWidth(20)
    private Date promotion_end_time;

    @ExcelProperty("商品描述")
    @ColumnWidth(20)
    private String description;

    @ExcelProperty("商品分类")
    @ColumnWidth(20)
    private Integer categoryId;

    @ExcelProperty("道具来源")
    @ColumnWidth(20)
    private Integer itemSource;

    private Date createdOn;

    private Date updatedOn;
}
