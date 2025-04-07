package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("category")
public class CategoryPO {

    @TableId(type = IdType.AUTO)
    private Long id; // 主键ID

    private String image; // 分类图标

    private Integer level; // 层级

    private String name; // 分类名称

    private Long parentId; // 父分类ID

    private Integer sortOrder; // 排序值

    private Long createTime; // 创建时间（时间戳）

    private Long updateTime; // 更新时间（时间戳）

    @TableLogic
    private Boolean deleteFlag; // 逻辑删除标识
}

