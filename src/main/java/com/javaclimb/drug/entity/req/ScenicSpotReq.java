package com.javaclimb.drug.entity.req;

import com.javaclimb.drug.entity.PageInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Smile
 */
@Data
@Setter
@Getter
public class ScenicSpotReq extends PageInfo {
    private String spotName;
    private String address;
    private String spotLevel;
}
