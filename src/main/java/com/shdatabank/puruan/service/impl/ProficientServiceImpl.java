package com.shdatabank.puruan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.dao.LoginDao;
import com.shdatabank.puruan.dao.ProficientDao;
import com.shdatabank.puruan.model.Proficient;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.ProficientService;

/**
 * 专家库service实现类
 */
@Service
public class ProficientServiceImpl implements ProficientService {
	private Logger logger = Logger.getLogger(ProficientServiceImpl.class);

	/** 专家库dao对象 */
	@Autowired
	private ProficientDao proficientDao;

	/** 前后台用户登录dao */
	@Autowired
	private LoginDao loginDao;

	/**
	 * 新增专家
	 * 
	 * @param Proficient：
	 *            专家信息
	 * @return 新增记录数
	 */
	@Transactional
	@Override
	public boolean registerProficien(Proficient proficient) throws Exception {
		// 从数据库中查询用户名
		String userName = loginDao.compareUserName(proficient.getUserName());
		if (userName != null) {
			logger.debug("--用户名已存在--");
			return false;
		}
		User user = new User();
		user.setUserName(proficient.getUserName());
		user.setUserAlias(proficient.getUserAlias());
		user.setUserMobile(proficient.getUserMobile());
		user.setUserEmail(proficient.getUserEmail());
		// 转换md5
		user.setUserPwd(DigestUtils.md5DigestAsHex(proficient.getUserPwd().getBytes()));
		// 添加到数据库
		int count = loginDao.register(user);
		logger.debug("--添加专家:"+user.getUserAlias());
		// 注册成功
		if (0 == count) {
			return false;
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", user.getUserId());
		params.put("professionalValue", proficient.getProfessionalValue());
		// 添加专家的专业领域
		boolean flag = proficientDao.proficientProfessionalField(params);
		logger.debug("--添加专家专业领域--");
		if (flag == false) {
			return false;
		}
		return true;
	}

	/**
	 * 删除专家
	 * 
	 * @param Proficient：
	 *            角色对象
	 * @return 删除记录数
	 */
	@Transactional
	@Override
	public boolean deleteProficien(Proficient proficient) throws Exception {
		logger.debug("--删除专家:"+proficient.getUserAlias());
		return proficientDao.deleteProficient(proficient.getUserId());
	}

	/**
	 * 修改专家信息
	 * 
	 * @param Proficient：
	 *            专家
	 * @return 更新记录数
	 */
	@Transactional
	@Override
	public boolean updateProficien(Proficient proficient) throws Exception {
		if (proficientDao.deleteProficientFile(proficient.getUserId()) == false) {
			return false;
		}
		
		int count = proficientDao.updateProficienUser(proficient);
		logger.debug("--更新专家信息:"+proficient.getUserAlias());
		if (0 == count) {
			return false;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", proficient.getUserId());
		params.put("professionalValue", proficient.getProfessionalValue());
		// 添加专家的专业领域
		return  proficientDao.proficientProfessionalField(params);
	}

	/**
	 * 查询专家列表
	 * 
	 * @param Proficient：
	 *            角色对象
	 * @return 结果对象集合
	 */
	@Override
	public PageInfo<Proficient> selectProficients(Proficient proficient) throws Exception {
		PageHelper.startPage(proficient.getPage(), proficient.getPageSize());
		List<Proficient> proficients = proficientDao.selectAllProficient(proficient);
		for (int i = 0; i < proficients.size(); i++) {
			if (proficients.get(i) != null) {
				proficients.get(i).setProfessionalValue((spliteUse(proficients.get(i).getProfessionalField())));
			}
		}
		return new PageInfo<Proficient>(proficients);
	}

	/**
	 * 根据ID查询专家
	 * 
	 * @param Proficient：
	 *            角色对象
	 * @return 后台角色对象
	 */
	@Override
	public Proficient selectProficientById(Proficient proficient) throws Exception {
		Proficient prof = proficientDao.selectProficientById(proficient.getUserId());
		prof.setProfessionalValue(spliteUse(prof.getProfessionalField()));
		return prof;
	}

	/**
	 * 专业领域列表
	 * 
	 * @return 结果对象集合
	 */
	@Override
	public List<Proficient> findProficientList() throws Exception {
		return proficientDao.findProfessionalFile();
	}

	/**
	 * 分割字符串
	 * 
	 * @param str
	 * @return String[]
	 */
	public String[] spliteUse(String str) {
		if (str != null) {
			return str.split(",");
		} else {
			return null;
		}
	}
}
