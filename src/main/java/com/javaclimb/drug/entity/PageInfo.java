package com.javaclimb.drug.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Smile
 */
@Data
@Getter
@Setter
public class PageInfo {
    private int pageNum=1;
    private int pageSize=10;

}
