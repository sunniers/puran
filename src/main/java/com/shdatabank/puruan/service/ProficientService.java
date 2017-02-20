package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.Proficient;

/**
 * 专家库service层
 */
public interface ProficientService {
	
	/**
	 * 新增专家
	 * @param Proficient： 专家信息
	 * @return 新增记录数
	 */
	public boolean registerProficien(Proficient proficient) throws Exception ;
	
	/**
	 * 删除专家用户
	 * @param Proficient： 角色对象
	 * @return 删除记录数
	 */
	public boolean deleteProficien(Proficient proficient) throws Exception ;
	/**
	 * 修改专家信息
	 * @param Proficient： 专家
	 * @return 更新记录数
	 */	
	public boolean updateProficien(Proficient proficient) throws Exception ;
	
	/**
	 * 查询专家
	 * @param Proficient： 角色对象
	 * @return 结果对象集合
	 */
	public PageInfo<Proficient> selectProficients(Proficient proficient) throws Exception ;
	
	/**
	 * 根据ID查询专家
	 * @param Proficient： 角色对象
	 * @return 后台角色对象
	 */
	public Proficient selectProficientById(Proficient proficient) throws Exception ;
	
	/**
	 * 专业领域列表
	 * @return 结果对象集合
	 */
	public List<Proficient> findProficientList() throws Exception;

}
