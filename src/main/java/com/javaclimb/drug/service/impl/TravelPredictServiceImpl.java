package com.javaclimb.drug.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaclimb.drug.entity.TravelPredict;
import com.javaclimb.drug.mapper.TravelPredictMapper;
import com.javaclimb.drug.service.TravelPredictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lwy
 */
@Service
@Slf4j
public class TravelPredictServiceImpl implements TravelPredictService {

    @Autowired
    private TravelPredictMapper travelPredictMapper;

    @Override
    public int saveToDatabase(TravelPredict travelPredict){
        return travelPredictMapper.saveToDatabase(travelPredict);
    }

    @Override
    public IPage<TravelPredict> selectPredictList(String userId, Integer pageNum, Integer pageSize) {
        QueryWrapper<TravelPredict> queryWrapper=new QueryWrapper<>();
        if (StrUtil.isNotBlank(userId)){
            queryWrapper.like("user_id",userId);
        }
        queryWrapper.orderByDesc("flag");
        Page<TravelPredict> page=new Page<>(pageNum,pageSize);
        return travelPredictMapper.selectPage(page,queryWrapper);
    }

    @Async("taskExecutor")
    @Override
    public void batchInsertDataToDataBase(List<TravelPredict> predictList) {
        travelPredictMapper.batchInsertDataToDataBase(predictList);
    }
}
