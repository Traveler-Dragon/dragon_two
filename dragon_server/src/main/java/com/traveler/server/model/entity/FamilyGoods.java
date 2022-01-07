package com.traveler.server.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 家园商品表
 * </p>
 *
 * @author 伏守龙
 * @since 2021-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Document(collection="family_goods")
public class FamilyGoods implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Indexed
    @Field(value = "id")
    private Long id;

    /**
     * 道具id
     */
    @Indexed
    @Field(value = "item_id")
    private Long itemId;

    /**
     * 商品名称
     */
    @Indexed
    @Field(value = "goods_name")
    private String goodsName;

    /**
     * 商品图标
     */
    @Indexed
    @Field(value = "icon")
    private String icon;

    /**
     * 财富值
     */
    @Indexed
    @Field(value = "wealth_value")
    private Integer wealthValue;

    /**
     * 金币价格
     */
    @Indexed
    @Field(value = "gold_price")
    private Integer goldPrice;

    /**
     * 钻石价格
     */
    @Indexed
    @Field(value = "diamond_price")
    private Integer diamondPrice;

    /**
     * 货币类型  1->金币  2->钻石
     */
    @Indexed
    @Field(value = "price_type")
    private Integer priceType;

    /**
     * 商品状态 0->未上架  1->已上架  2->有折扣
     */
    @Indexed
    @Field(value = "status")
    private Integer status;

    /**
     * 商品类型 0->不限量  1->商品限量  2->用户限量  3->限时
     */
    @Indexed
    @Field(value = "goods_type")
    private Integer goodsType;

    /**
     * 商品数量
     */
    @Indexed
    @Field(value = "goods_stock")
    private Integer goodsStock;

    /**
     * 库存预警值
     */
    @Indexed
    @Field(value = "low_stock")
    private Integer lowStock;

    /**
     * 用户购买数量
     */
    @Indexed
    @Field(value = "user_stock")
    private Integer userStock;

    /**
     * 促销程度
     */
    @Indexed
    @Field(value = "promotion")
    private Integer promotion;

    /**
     * 促销开始时间
     */
    @Indexed
    @Field(value = "promotion_start_time")
    private Date promotionStartTime;

    /**
     * 促销结束时间
     */
    @Indexed
    @Field(value = "promotion_end_time")
    private Date promotionEndTime;

    /**
     * 商品描述
     */
    @Indexed
    @Field(value = "description")
    private String description;

    /**
     * 商品排序
     */
    @Indexed
    @Field(value = "sort")
    private Integer sort;

    /**
     * 分类id
     */
    @Indexed
    @Field(value = "category_id")
    private Long categoryId;

    /**
     * 道具来源  1->家园游戏  2->NFT商城
     */
    @Indexed
    @Field(value = "item_source")
    private Integer itemSource;

    @Indexed
    @Field(value = "version")
    private Integer version;

    /**
     * 创建时间
     */
    @Indexed
    @Field(value = "created_on")
    private Date createdOn;

    /**
     * 修改时间
     */
    @Indexed
    @Field(value = "updated_on")
    private Date updatedOn;


}
