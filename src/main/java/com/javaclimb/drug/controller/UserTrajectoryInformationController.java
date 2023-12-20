package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.ResultInfo;
import com.javaclimb.drug.entity.UserTrajectory;
import com.javaclimb.drug.entity.req.UserTrajectoryReq;
import com.javaclimb.drug.service.UserTrajectoryInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @author Smile
 */
@RestController
@RequestMapping("/trajectoryInformation")
@Validated
@Slf4j
public class UserTrajectoryInformationController {

    @Autowired
    private UserTrajectoryInformationService userTrajectoryInformationService;
    /**
     * 加载指定路径的Excel数据到数据库中
     */
    @GetMapping("/loadFileData")
    public void LoadFileDataToDataBase(@RequestParam(value = "url") String url){
        userTrajectoryInformationService.batchSaveTrajectory(url);

    }

    @PostMapping("/getTrajectoryInformationList")
    public ResultInfo<IPage<UserTrajectory>> getTrajectoryInformationList(@RequestBody UserTrajectoryReq req){
        try {
            IPage<UserTrajectory> userTrajectoryIPage=userTrajectoryInformationService.getTrajectoryList(req);
            return ResultInfo.success(userTrajectoryIPage);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.fail("查询失败");
        }
    }
}
