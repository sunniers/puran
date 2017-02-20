package com.shdatabank.puruan.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shdatabank.puruan.model.Proficient;

/**
 * 专家库管理dao 层
 * 1.新增专家  的专业领域
 * 2.删除专家
 * 3.修改专家信息
 * 4.删除专家专业领域
 * 5.查询专家列表
 * 6.根据ID查询专家
 * 7.专业领域列表
 */
public interface ProficientDao {
	
	/**
	 * 新增专家  的专业领域
	 * @param params 
	 * @param Proficient： 专家信息
	 * @return 新增记录数
	 */
	public boolean proficientProfessionalField(Map<String, Object> params) throws Exception;
	/**
	 * 删除专家
	 * @param Proficient： 角色对象
	 * @return 删除记录数
	 */
	public boolean deleteProficient(@Param(value = "userId") Long userId);
	
	/**
	 * 修改专家信息
	 * @param Proficient： 专家
	 * @return 更新记录数
	 */	
	public int updateProficienUser(Proficient proficient);
	
	/**
	 * 删除专家专业领域
	 */	
	public boolean  deleteProficientFile(@Param(value = "userId") Long userId);
	
	/**
	 * 查询专家列表
	 * @param Proficient： 角色对象
	 * @return 结果对象集合
	 */
	public List<Proficient> selectAllProficient(Proficient proficient);
	
	/**
	 * 根据ID查询专家
	 * @param Proficient： 角色对象
	 * @return 后台角色对象
	 */
	public Proficient selectProficientById(@Param(value = "userId") Long userId);
	
	/**
	 * 专业领域列表
	 * @return 结果对象集合
	 */
	public List<Proficient> findProfessionalFile();
	
}
