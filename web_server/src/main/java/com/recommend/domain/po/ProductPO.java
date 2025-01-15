package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "product")
public class ProductPO {
    @TableId(type = IdType.AUTO)
    private Long id;  // 主键ID
}
