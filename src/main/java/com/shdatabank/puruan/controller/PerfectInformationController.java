/**
 * PerfectInformationController.java
 * Created at 2016-10-19
 * Created by gaodisheng
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shdatabank.puruan.model.Company;
import com.shdatabank.puruan.model.InvestCompany;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IPerfectInformationService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 完善个人和企业信息controller层
 */
@RequestMapping(value="/perfectInformation")
@Controller
public class PerfectInformationController {

    /** 完善个人和企业信息service */
    @Autowired
    private IPerfectInformationService iPerfectInformationService;
    
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 查询用户和企业信息
     * @param user 用户信息
     * @return 返回结果对象
     */
    @RequestMapping(value="/selectUserInfo",method=RequestMethod.GET)
    @ResponseBody
    public ReturnObject selectUserInfo() throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
        }
        //判断用户id是否为空
        if (null != user.getUserId()) {
            //查询用户信息
            user = iPerfectInformationService.selectUserInfo(user);
            //判断查询结果是否为空
            if (null != user) {
                //判断用户类型
                if (null == user.getUserType() || SystemConstant.USER.equals(user.getUserType())) {
                    //返回用户信息
                    return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", user);
                } else {
                    //查询企业信息
                    Company company = iPerfectInformationService.selectCompany(user);
                    //判断企业信息是否为空
                    if (null != company) {
                        httpServletRequest.getSession().setAttribute("company", company);
                        //返回企业信息
                        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", company);
                    } else {
                        return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
                    }
                }
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
            }
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
        }
    }
    
    /**
     * 更新用户信息
     * @param user 用户信息
     */
    @RequestMapping(value="/updateUserInformation",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateUserInformation(@RequestBody User user) throws Exception {
        User user2 = (User) httpServletRequest.getSession().getAttribute("user");
        if (null != user2) {
            user.setUserId(user2.getUserId());            
            return iPerfectInformationService.updateUserInformation(user);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 更新用户信息
     * @param user 用户信息
     */
    @RequestMapping(value="/putUserInformaton",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject putUserInformaton(@RequestBody User user) throws Exception {
        User user2 = (User) httpServletRequest.getSession().getAttribute("user");
        if (null != user2) {
            user.setUserId(user2.getUserId());            
            return iPerfectInformationService.putUserInformation(user);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 更新企业信息
     * @param company 企业信息
     */
    @RequestMapping(value="/updateCompanyInfo",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateCompanyInfo(@RequestBody Company company) throws Exception {
        Company company2 = (Company) httpServletRequest.getSession().getAttribute("company");
        if (null != company2) {
            company.setCompanyId(company2.getCompanyId());            
            return iPerfectInformationService.updateCompanyInfo(company);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 插入投资机构
     * @param investCompany 投资机构
     * @return 是否成功
     */
    @RequestMapping(value="/insertInvestCompany",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertInvestCompany(@RequestBody InvestCompany investCompany) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
        }
        if (null == investCompany) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        } else {
            investCompany.setCompanyId(user.getCompanyId());
            if (iPerfectInformationService.insertInvestCompany(investCompany)) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        }
    }
    
    /**
     * 查询投资机构信息
     * @param investCompany 投资机构
     * @return 投资机构
     */
    @RequestMapping(value="/selectInvestCompanys",method=RequestMethod.GET)
    @ResponseBody
    public ReturnObject selectInvestCompanys() throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SEARCH_ERROR_MSG);
        }
        InvestCompany investCompany = new InvestCompany();
        investCompany.setCompanyId(user.getCompanyId());
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iPerfectInformationService.selectInvestCompanys(investCompany));
    }
    
    /**
     * 查询人才技能
     * @return 人才技能
     */
    @RequestMapping(value="/selectTalentTechnology",method=RequestMethod.GET)
    @ResponseBody
    public ReturnObject selectTalentTechnology() throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iPerfectInformationService.selectTalentTechnology());
    }
    
    /**
     * 查询投资机构偏好
     * @return 投资偏好
     */
    @RequestMapping(value="/selectInvestPreferences",method=RequestMethod.GET)
    @ResponseBody
    public ReturnObject selectInvestPreferences() throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iPerfectInformationService.selectInvestPreferences());
    }
}
