package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lwy
 */
@TableName("country")
@Data
public class Country {
    @TableField(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String countryCode;
    private String countryName;
}
