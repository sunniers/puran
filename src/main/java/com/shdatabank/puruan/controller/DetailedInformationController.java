/**
 * DetailedInformationController.java
 * Created at 2016-10-29
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

import com.shdatabank.puruan.model.GetTalents;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementDetails;
import com.shdatabank.puruan.model.ProjectUserReleation;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.model.UserCreativeTalent;
import com.shdatabank.puruan.model.UserInformation;
import com.shdatabank.puruan.model.Util;
import com.shdatabank.puruan.service.IDetailedInformationService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 各种详细信息controller层
 */
@RequestMapping(value="/detailedInformation")
@Controller
public class DetailedInformationController {

    /** 各种详细信息service */
    @Autowired
    private IDetailedInformationService iDetailedInformationService;
    
    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /**
     * 查询用户的信息
     * @param userInformation 用户信息
     * @return 用户信息
     */
    @RequestMapping(value="/selectUserInformation",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectUserInformation(@RequestBody UserInformation userInformation) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iDetailedInformationService.selectUserInformation(userInformation));
    }
    
    /**
     * 查看创意需求信息和进度
     * @param projectRequirement 创意需求信息
     * @return 创意需求信息
     */
    @RequestMapping(value="/selectProjectRequirementDetails",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectRequirementDetails(@RequestBody ProjectRequirementDetails projectRequirementDetails) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,
                    SystemConstant.SESSION_ERROR_MSG);
        }
        projectRequirementDetails.setUserId(user.getUserId());
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iDetailedInformationService.selectProjectRequirementDetails(projectRequirementDetails));
    }
    
    /**
     * 查看创意人才信息
     * @param talentRequirement 创意人才
     * @return 创意人才信息
     */
    @RequestMapping(value="/selectTalentRequirement",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectTalentRequirement(@RequestBody TalentRequirement talentRequirement) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (null == user) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,
                    SystemConstant.SESSION_ERROR_MSG);
        }
        talentRequirement.setUserId(user.getUserId());
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iDetailedInformationService.selectTalentRequirement(talentRequirement));
    }
    
    /**
     * 查看创意人才信息
     * @param talentRequirement 创意人才
     * @return 创意人才信息
     */
    @RequestMapping(value="/selectTalentRequirement2",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectTalentRequirement2(@RequestBody TalentRequirement talentRequirement) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iDetailedInformationService.selectTalentRequirement2(talentRequirement));
    }
    
    /**
     * 查询需要修改的创意需求的信息
     * @param ProjectRequirement 创意需求信息
     * @return 创意需求信息
     */
    @RequestMapping(value="/selectModifyProjectRequirement",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectModifyProjectRequirement(@RequestBody ProjectRequirement ProjectRequirement) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iDetailedInformationService.selectModifyProjectRequirement(ProjectRequirement));
    }
    
    /**
     * 查创意需求的详细信息
     * @param projectRequirement 创意需求信息
     * @return 创意需求信息
     */
    @RequestMapping(value="/selectProjectRequirement",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectRequirement(@RequestBody ProjectRequirement ProjectRequirement) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iDetailedInformationService.selectProjectRequirement(ProjectRequirement));
    }
    /**
     * 查创意人才的详细信息
     * @param userCreativeTalent
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectUserCreativeTalent",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectUserCreativeTalent(@RequestBody UserCreativeTalent userCreativeTalent) throws Exception {
    	return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
    			iDetailedInformationService.selectUserCreativeTalent(userCreativeTalent));
    }
    /**
     * 查询项目名
     * @param projectUserReleation
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectProjectUserReleation",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectUserReleation(@RequestBody ProjectUserReleation projectUserReleation) throws Exception {
    	   User user = (User) httpServletRequest.getSession().getAttribute("user");
           if (null == user) {
               return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,
                       SystemConstant.SESSION_ERROR_MSG);
           }
           projectUserReleation.setUserId(user.getUserId());
    	return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
    			iDetailedInformationService.selectProjectUserReleation(projectUserReleation));
    }
    
    /**
     * 点击招募按钮时添加到项目用户关系表中
     * @param projectUserReleation
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/insertProjectUserReleation",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertProjectUserReleation(@RequestBody ProjectUserReleation projectUserReleation) throws Exception {
    	User user = (User) httpServletRequest.getSession().getAttribute("user");
    	if(null == user){
    		return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SAVE_ERROR_MSG);
    	}
    	projectUserReleation.setUserId(user.getUserId());
    	if(iDetailedInformationService.insertProjectUserReleation(projectUserReleation)){
    		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
    	}else {
    		return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
    	
    }
    
    /**
     * 随机交易订单号
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/selectRandNumber",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectRandNumber() throws Exception {
        Util util = new Util();
        util.setRandNumber(UserUtil.getRandName());
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",util); 
    }
    
    /**
     * 查看创意需求信息和进度
     * @param projectRequirement 创意需求信息
     * @return 创意需求信息
     */
    @RequestMapping(value="/selectProjectRequirementDetails2",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectRequirementDetails2(@RequestBody ProjectRequirementDetails projectRequirementDetails) throws Exception {
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iDetailedInformationService.selectProjectRequirementDetails2(projectRequirementDetails));
    }
    
    /**
     * 查询创意人才的详细信息
     * @param getTalents 创意人才
     * @return 创意人才的详细信息
     */
    @RequestMapping(value="/selectGetTalents",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectGetTalents(@RequestBody GetTalents getTalents) throws Exception {
        if (null == getTalents) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR, SystemConstant.SAVE_ERROR_MSG);
        }
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                iDetailedInformationService.selectGetTalents(getTalents));
    }
}
