/**
 * EvaluateController.java
 * Created at 2016-11-02
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

import com.shdatabank.puruan.model.CeativeResourceTransaction;
import com.shdatabank.puruan.model.CreativeResourceEvaluate;
import com.shdatabank.puruan.model.CreativeTalentEvaluate;
import com.shdatabank.puruan.model.ProjectEvaluate;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.CeativeResourceTransactionService;
import com.shdatabank.puruan.service.IEvaluateService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 评价controller层
 */
@RequestMapping(value="/evaluate")
@Controller
public class EvaluateController {

    /** 评价service */
    @Autowired
    private IEvaluateService iEvaluateService;
    
    /** httpServletRequest */
    @Autowired
    private HttpServletRequest httpServletRequest;
    
    /** ceativeResourceTransactionService */
    @Autowired
    private CeativeResourceTransactionService ceativeResourceTransactionService;
    
    /**
     * 新增项目评价
     * @param projectEvaluate 评论信息
     * @return 是否成功
     */
    @RequestMapping(value="/insertProjectEvaluate",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertProjectEvaluate(@RequestBody ProjectEvaluate projectEvaluate) throws Exception{
        if (null != projectEvaluate) {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (null != user) {
                projectEvaluate.setUserId(user.getUserId());
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        
        if (iEvaluateService.insertProjectEvaluate(projectEvaluate)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 新增创意人才评论
     * @param creativeTalentEvaluate 评论信息
     * @return 是否成功
     */
    @RequestMapping(value="/insertCreativeTalentEvaluate",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertCreativeTalentEvaluate(@RequestBody CreativeTalentEvaluate creativeTalentEvaluate)
        throws Exception {
        if (null != creativeTalentEvaluate) {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (null != user) {
                creativeTalentEvaluate.setUserId(user.getUserId());
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        
        if (iEvaluateService.insertCreativeTalentEvaluate(creativeTalentEvaluate)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 新增创意资源的评价
     * @param CreativeResourceEvaluate 评论信息
     * @return 是否成功
     */
    @RequestMapping(value="/insertCreativeResourceEvaluate",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject insertCreativeResourceEvaluate(@RequestBody CreativeResourceEvaluate creativeResourceEvaluate)
        throws Exception {
        if (null != creativeResourceEvaluate) {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (null != user) {
                creativeResourceEvaluate.setUserId(user.getUserId());
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        
        if (iEvaluateService.insertCreativeResourceEvaluate(creativeResourceEvaluate)) {
            CeativeResourceTransaction ceativeResourceTransaction = new CeativeResourceTransaction();
            ceativeResourceTransaction.setResourceTransactionId(creativeResourceEvaluate.getTransactionId());
            ceativeResourceTransaction.setTransactionStatus("400505");
            ceativeResourceTransactionService.updateCeativeResourceTransaction(ceativeResourceTransaction);
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 更新追评
     * @param CreativeResourceEvaluate 追评信息
     * @return 是否成功
     */
    @RequestMapping(value="/updateEvaluateAppend",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateEvaluateAppend(@RequestBody CreativeResourceEvaluate creativeResourceEvaluate) throws Exception {
        if (null != creativeResourceEvaluate) {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (null != user) {
                creativeResourceEvaluate.setUserId(user.getUserId());
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        
        if (iEvaluateService.updateEvaluateAppend(creativeResourceEvaluate)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 更新解释
     * @param CreativeResourceEvaluate 解释信息
     * @return 是否成功
     */
    @RequestMapping(value="/updateExplain",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject updateExplain(@RequestBody CreativeResourceEvaluate creativeResourceEvaluate) throws Exception {
        if (null != creativeResourceEvaluate) {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (null != user) {
                creativeResourceEvaluate.setUserId(user.getUserId());
            } else {
                return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
            }
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
        
        if (iEvaluateService.updateExplain(creativeResourceEvaluate)) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
        }
    }
    
    /**
     * 查询项目评论信息
     * @param projectEvaluate 评论信息
     * @return 评论信息
     */
    @RequestMapping(value="/selectProjectEvaluate",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectProjectEvaluate(@RequestBody ProjectEvaluate projectEvaluate) throws Exception {
        if (null != projectEvaluate) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                    iEvaluateService.selectProjectEvaluate(projectEvaluate));
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
    }
    
    /**
     * 查询创意资源评论信息
     * @param CreativeResourceEvaluate 评论信息
     * @return 评论信息
     */
    @RequestMapping(value="/selectCreativeResourceEvaluates",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectCreativeResourceEvaluates(@RequestBody CreativeResourceEvaluate creativeResourceEvaluate)
        throws Exception {
        if (null != creativeResourceEvaluate) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                    iEvaluateService.selectCreativeResourceEvaluates(creativeResourceEvaluate));
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
    }
    
    /**
     * 查询创意资源评论信息
     * @param CreativeResourceEvaluate 评论信息
     * @return 评论信息
     */
    @RequestMapping(value="/selectCreativeResourceEvaluate",method=RequestMethod.POST)
    @ResponseBody
    public ReturnObject selectCreativeResourceEvaluate(@RequestBody CreativeResourceEvaluate creativeResourceEvaluate)
        throws Exception {
        if (null != creativeResourceEvaluate) {
            return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
                    iEvaluateService.selectCreativeResourceEvaluate(creativeResourceEvaluate));
        } else {
            return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
        }
    }
}
