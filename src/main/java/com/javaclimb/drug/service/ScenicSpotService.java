package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.ScenicSpot;
import com.javaclimb.drug.entity.req.ScenicSpotReq;
import com.javaclimb.drug.entity.req.ScenicSpotUpdateReq;


/**
 * @author Smile
 */
public interface ScenicSpotService {
    int  insertScenicSpot(ScenicSpot scenicSpot);
    IPage<ScenicSpot> queryList(ScenicSpotReq scenicSpot);
    Boolean deleteSpot(Long id,int flag);

    Boolean updateSpotById(ScenicSpotUpdateReq req);
}
