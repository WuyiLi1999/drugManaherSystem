package com.javaclimb.drug.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaclimb.drug.entity.ScenicSpot;
import com.javaclimb.drug.entity.req.ScenicSpotReq;
import com.javaclimb.drug.entity.req.ScenicSpotUpdateReq;
import com.javaclimb.drug.mapper.ScenicSpotMapper;

import com.javaclimb.drug.service.ScenicSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScenicSpotServiceImpl implements ScenicSpotService {

    @Autowired
    private ScenicSpotMapper scenicSpotMapper;
    @Override
    public int insertScenicSpot(ScenicSpot scenicSpot) {
        return scenicSpotMapper.insert(scenicSpot);
    }

    @Override
    public IPage<ScenicSpot> queryList(ScenicSpotReq req) {
        QueryWrapper<ScenicSpot> queryWrapper=new QueryWrapper<>();
        if (StrUtil.isNotBlank(req.getSpotName())){
            queryWrapper.like("spot_name",req.getSpotName());
        }
        if(StrUtil.isNotBlank(req.getAddress())){
            queryWrapper.like("address",req.getAddress());
        }
        if(StrUtil.isNotBlank(req.getSpotLevel())){
            queryWrapper.eq("spot_level",req.getSpotLevel());
        }
        queryWrapper.eq("is_delete",0);
        Page<ScenicSpot> page=new Page<>(req.getPageNum(),req.getPageSize());
        return scenicSpotMapper.selectPage(page,queryWrapper);
    }
    @Override
    public Boolean deleteSpot(Long id,int flag){
        ScenicSpot scenicSpot=new ScenicSpot();
        scenicSpot.setId(id);
        if (flag==0){
            scenicSpot.setIsDelete(1);
        }else {
            scenicSpot.setIsDelete(0);
        }
        return scenicSpotMapper.updateById(scenicSpot)>0;
    }

    @Override
    public Boolean updateSpotById(ScenicSpotUpdateReq req) {
        ScenicSpot scenicSpot=new ScenicSpot();
        try{
            BeanUtils.copyProperties(req,scenicSpot);
        }catch (Exception e){
            e.printStackTrace();
        }

        return scenicSpotMapper.updateById(scenicSpot)>0;
    }

}
