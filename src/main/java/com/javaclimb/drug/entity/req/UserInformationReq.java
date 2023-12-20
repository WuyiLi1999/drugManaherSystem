package com.javaclimb.drug.entity.req;


import com.javaclimb.drug.entity.PageInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Smile
 */
@Data
@Getter
@Setter
public class UserInformationReq extends PageInfo {
    private String userId;
    private Integer sex;
    private String countryName;
    private Integer incomeLevel;
    private String orderBy;
    private Boolean isDesc;

}
