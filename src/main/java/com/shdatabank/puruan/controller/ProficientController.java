package com.shdatabank.puruan.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.LoginDao;
import com.shdatabank.puruan.model.Proficient;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.service.ProficientService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
import com.shdatabank.puruan.util.UserUtil;

/**
 * 专家库管理controller层
 */
@RequestMapping(value = "/proficient")
@Controller
public class ProficientController {

	/** 专家库管理service层 */
	@Autowired
	private ProficientService proficientService;

	/** 前后台用户登录dao */
	@Autowired
	private LoginDao loginDao;

	/**
	 * 新增专家
	 * 
	 * @param Proficient：
	 *            专家
	 * @return 结果对象
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertBackRole(@RequestBody Proficient proficient) throws Exception {
		// 有效性验证
		if (StringUtils.isBlank(proficient.getUserName())) {
			return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "用户名不能为空");
		}
		if (StringUtils.isBlank(proficient.getUserPwd())) {
			return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "用户密码不能为空");
		}
		// 从数据库中查询用户名
		String userName = loginDao.compareUserName(proficient.getUserName());
		if (userName != null) {
			return RetObjectBuilder.generateRetObject(SystemConstant.NORMAL_ERROR, "用户名已存在");
		}
		boolean falg = proficientService.registerProficien(proficient);
		if (falg == false) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
		
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
	}

	/**
	 * 删除专家
	 * 
	 * @param Proficient
	 *            专家
	 * @return 结果对象
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject deleteProficient(@RequestBody Proficient proficient) throws Exception {
		if (proficientService.deleteProficien(proficient)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR, SystemConstant.DELETE_ERROR_MSG);
		}
	}

	/**
	 * 更新专家的信息
	 * 
	 * @param Proficient
	 *            专家实体类
	 * @return 返回结果对象
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateProficient(@RequestBody Proficient proficient) throws Exception {
		if (proficientService.updateProficien(proficient)) {
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		} else {
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR, SystemConstant.SAVE_ERROR_MSG);
		}
	}

	/**
	 * 查询专家信息列表
	 * 
	 * @param Proficient：
	 *            专家实体类
	 * @return 结果对象
	 * @throws Exception
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectProficients(@RequestBody Proficient proficient) throws Exception {
		PageInfo<Proficient> proficients = proficientService.selectProficients(proficient);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", proficients);
	}

	/**
	 * 查询单个专家信息
	 * 
	 * @param Proficient：
	 *            专家实体类
	 * @return 结果对象
	 * @throws Exception
	 */
	@RequestMapping(value = "/findOne", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectProficient(@RequestBody Proficient proficient) throws Exception {
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "",
				proficientService.selectProficientById(proficient));
	}

	/**
	 * 专业领域列表
	 * 
	 * @return 结果对象集合
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject findProficientList() throws Exception {
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", proficientService.findProficientList());
	}
}
