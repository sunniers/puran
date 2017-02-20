/**
 * RequirementManageController.java
 * Created at 2016-11-05
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

import com.shdatabank.puruan.model.ProjectEnroll;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementRecommend;
import com.shdatabank.puruan.model.ProjectRequirementUndertake;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.RequirementManage;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.TalentEnroll;
import com.shdatabank.puruan.model.TalentRequirementRecommend;
import com.shdatabank.puruan.model.TalentTransaction;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.IRequirementManageService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 需求管理controller层
 */
@RequestMapping(value="/requirementManage")
@Controller
public class RequirementManageController {

    /** 需求管理service */
    @Autowired
    private IRequirementManageService iRequirementManageService;
    
    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 查询用户的需求
     * @return 
     */
    @RequestMapping(value="/selectRequirementManage",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectRequirementManage(@RequestBody RequirementManage requirementManage) throws Exception {
        if (null == requirementManage) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        } else {
            requirementManage.setUserId(user.getUserId());
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iRequirementManageService.selectRequirementManage(requirementManage));
    }
    
    /**
     * 查询交易完成的需求
     * @param requirementManage
     * @return 
     */
    @RequestMapping(value="/selectRransactionEnd",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectRransactionEnd(@RequestBody RequirementManage requirementManage) throws Exception {
        if (null == requirementManage) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
        } else {
            requirementManage.setUserId(user.getUserId());
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iRequirementManageService.selectRransactionEnd(requirementManage));
    }
    
    /**
     * 删除需求
     * @param requirementManage 需求信息
     * @return 
     */
    @RequestMapping(value="/deleteRequirement",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject deleteRequirement(@RequestBody RequirementManage requirementManage) throws Exception {
        if (null == requirementManage) {
            return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
        } else {
            if (iRequirementManageService.deleteRequirement(requirementManage)) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
            }
        }
    }
    
    /**
     * 插入创意需求推荐
     * @param projectRequirementRecommend 推荐信息
     * @return 是否成功
     */
    @RequestMapping(value="/insertProjectRequirementRecommend",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertProjectRequirementRecommend(@RequestBody 
            ProjectRequirementRecommend projectRequirementRecommend) throws Exception {
        if (null == projectRequirementRecommend) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        } else {
            if (iRequirementManageService.insertProjectRequirementRecommend(projectRequirementRecommend)) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        }
    }
    
    /**
     * 插入人才需求推荐
     * @param talentRequirementRecommends 推荐信息
     * @return 是否成功
     */
    @RequestMapping(value="/insertTalentRequirementRecommend",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertTalentRequirementRecommend(@RequestBody 
            TalentRequirementRecommend talentRequirementRecommend) throws Exception {
        if (null == talentRequirementRecommend) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        } else {
            if (iRequirementManageService.insertTalentRequirementRecommend(talentRequirementRecommend)) {
                return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        }
    }
    
    /**
     * 查询企业推荐信息
     * @param projectRequirementRecommend
     * @return 
     */
    @RequestMapping(value="/selectCompany",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectCompany(
            @RequestBody ProjectRequirementRecommend projectRequirementRecommend) throws Exception {
        if (null == projectRequirementRecommend) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG); 
        }
        if (null == projectRequirementRecommend.getType()) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        
        if ("700001".equals(projectRequirementRecommend.getType())) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                    iRequirementManageService.selectProjectCompany(projectRequirementRecommend.getProjId()));
        } else if ("700002".equals(projectRequirementRecommend.getType())) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                    iRequirementManageService.selectTalentCompany(projectRequirementRecommend.getProjId()));
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        }
    }
    
    /**
     * 查询个人推荐信息
     * @param projectRequirementRecommend
     * @return 
     */
    @RequestMapping(value="/selectUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectUser(
            @RequestBody ProjectRequirementRecommend projectRequirementRecommend) throws Exception {
        if (null == projectRequirementRecommend) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG); 
        }
        if (null == projectRequirementRecommend.getType()) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        
        if ("700001".equals(projectRequirementRecommend.getType())) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                    iRequirementManageService.selectProjectUser(projectRequirementRecommend.getProjId()));
        } else if ("700002".equals(projectRequirementRecommend.getType())) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                    iRequirementManageService.selectTalentUser(projectRequirementRecommend.getProjId()));
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        }
    }

    /**
     * 查询创意需求报名信息
     * @param projId 需求ID
     * @return 报名人信息
     */
    @RequestMapping(value="/selectProjectEnroll",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectEnroll(
            @RequestBody ProjectEnroll projectEnroll) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iRequirementManageService.selectProjectEnroll(projectEnroll));
    }
    
    /**
     * 查询人才需求报名信息
     * @param projId 需求ID
     * @return 报名人信息
     */
    @RequestMapping(value="/selectTalentEnroll",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectTalentEnroll(
            @RequestBody TalentEnroll talentEnroll) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iRequirementManageService.selectTalentEnroll(talentEnroll));
    }
    
    /**
     * 插入创意需求承接
     * @param projectRequirementUndertake 创意需求承接
     * @return 是否成功
     */
    @RequestMapping(value="/insertProjectRequirementUndertake",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertProjectRequirementUndertake(
            @RequestBody ProjectRequirementUndertake projectRequirementUndertake) throws Exception{
        if (null == projectRequirementUndertake) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        if (iRequirementManageService.insertProjectRequirementUndertake(projectRequirementUndertake)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);            
        }
    }
    
    /**
     * 插入人才需求交易
     * @param talentTransaction 人才交易信息
     * @return 是否成功
     */
    @RequestMapping(value="/insertTalentTransaction",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertTalentTransaction(
            @RequestBody TalentTransaction talentTransaction) throws Exception {
        if (null == talentTransaction) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        
        if (iRequirementManageService.insertTalentTransaction(talentTransaction)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);            
        }
    }
    
    /**
     * 查询评价内容
     * @param projectUserReleation 评价内容
     * @return 评价内容
     */
    @RequestMapping(value="/selectProjectUserReleation",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectUserReleation(
            @RequestBody ProjectUserReleation projectUserReleation) throws Exception {
        if (null == projectUserReleation) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iRequirementManageService.selectProjectUserReleation(projectUserReleation));
    }
    
    /**
     * 酬金托管
     * @param projectRequirement 托管项目
     * @return 托管信息
     */
    @RequestMapping(value="/selectProjectRequirement2",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectRequirement2(
            @RequestBody ProjectRequirement projectRequirement) throws Exception {
        if (null == projectRequirement) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iRequirementManageService.selectProjectRequirement2(projectRequirement));
    }
    
    /**
     * 更新酬金托管状态
     * @param projectRequirement 酬金托管状态
     * @return 是否成功
     */
    @RequestMapping(value="/updateProjectRequirement",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateProjectRequirement(
            @RequestBody ProjectRequirement projectRequirement) throws Exception {
        if (null == projectRequirement) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        if (iRequirementManageService.updateProjectRequirement(projectRequirement)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS); 
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
}
