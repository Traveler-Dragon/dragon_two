package com.traveler.server.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author 伏守龙
 */
@Data
public class FamilyComments {
    @TableField(value = "comment_id")
    private String commentId;

    @TableField(value = "user_id")
    private String userId;

    @TableField(value = "to_user_id")
    private String toUserId;

    @TableField(value = "content")
    private String content;

    @TableField(value = "parent_id")
    private Integer parentId;

    @TableField(value = "moment_id")
    private String momentId;
}
