package com.traveler.server.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Document(collection="words")
public class Words {

    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Indexed
    @Field(value = "id")
    private Integer id;

    /**
     * 道具id
     */
    @Indexed
    @Field(value = "word")
    private String word;
}
