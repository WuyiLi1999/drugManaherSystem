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
public class InternetInformationReq extends PageInfo {
    private String userId;
}
