package com.javaclimb.drug.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.InternetInformation;
import com.javaclimb.drug.entity.req.InternetInformationReq;

/**
 * @author Smile
 * @description 用户上网信息业务层
 */
public interface InternetInformationService {
    /**
     * 导入用户上网数据
     * @param internetInformation
     * @return
     */
    int insertInternetInformation(InternetInformation internetInformation);

    /**
     * 查询用户上网信息列表
     * @param req
     * @return
     */
    IPage<InternetInformation> selectInternetInformation(InternetInformationReq req);

    IPage<InternetInformation> selectInternetInformationPageList(int pageNum, int pageSize, String param);
}
