package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.UserTrajectory;
import com.javaclimb.drug.entity.req.UserTrajectoryReq;

/**
 * @author Smile
 */
public interface UserTrajectoryInformationService {

    int batchSaveTrajectory(String url);

    IPage<UserTrajectory> getTrajectoryList(UserTrajectoryReq req);
}
