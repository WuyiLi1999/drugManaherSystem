package com.javaclimb.drug.controller;


import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.ResultInfo;
import com.javaclimb.drug.entity.UserInformation;
import com.javaclimb.drug.entity.req.UserInformationReq;
import com.javaclimb.drug.service.CountryService;
import com.javaclimb.drug.service.UserInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 * @author lwy
 * @description 用户信息管理控制层
 */
@Controller
@Validated
@Slf4j
@RequestMapping("/userInformation")
public class UserInformationController {
    @Resource
    private UserInformationService userInformationService;
    @Autowired
    private CountryService countryService;

    /**
     * 单一加载用户数据
     * @param url 文件路径
     * @return
     */
    @GetMapping("/save")
    public ResultInfo<Boolean> insertUserInformation(String url){
        url="D:\\UserInformation.txt";
        int num=0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(url));

            String line;
            while ((line=br.readLine())!=null){
                num++;
                line.trim();
                String [] data=line.split(",");
                UserInformation userInformation=new UserInformation();
                userInformation.setUserId(data[0]);

                userInformation.setAge((int) Double.parseDouble(data[1]));
                userInformation.setSex((int) Double.parseDouble(data[2]));
                userInformation.setCityName(data[3]);
                userInformation.setCountryName(data[4]);
                userInformation.setInnerDur((int)Double.parseDouble(data[5]));
                userInformation.setIsMarr((int)Double.parseDouble(data[6]));
                userInformation.setFertile((int)Double.parseDouble(data[7]));
                userInformation.setHaveOld((int)Double.parseDouble(data[8]));
                userInformation.setHaveCar((int)Double.parseDouble(data[9]));
                userInformation.setIncomeLevel((int)Double.parseDouble(data[10]));
                userInformation.setFirImelBrand(data[11]);
                userInformation.setFirImelPrice(Double.parseDouble(data[12]));
                userInformationService.save(userInformation);
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.fail("保存失败");
        }

        return ResultInfo.success(num>0?true:false);
    }

    /**
     * 用户信息更新
     * @param userInformation 更新的用户信息
     * @return
     */
    @PostMapping("/update")
    public Object updateUserInformation(@RequestBody UserInformation userInformation) {
        Integer num =userInformationService.update(userInformation);
        return ResultMapUtil.getHashMapSave(num);
    }

    /**
     * 查询用户信息列表
     * @param
     * @return
     */
    @RequestMapping("/query_list")
    @ResponseBody
    public Object queryStudentList(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize) {
        return ResultMapUtil.getHashMapMysqlPage(userInformationService.getPageList(pageNum,pageSize,param));

    }

    /**
     * 批量异步加载用户数据
     * @param url 文件路径
     * @return
     */
    @GetMapping(value = "/loadDataToDateBase")
    @ResponseBody
    public Object loadUserInformationToDateBase(@RequestParam("url") String url){
        userInformationService.batchInsertUserInformation(url);
        return ResultMapUtil.getHashMapSave(1);
    }
    @RequestMapping(value = "/importData")
    public String owinfoPage(){
        return "/owinfoPage";
    }


}
