package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.ProjRequireDescription;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementClass;
import com.shdatabank.puruan.model.SysMessage;

/**
 * 查询项目需求dao层接口
 */
public interface RequirementCommitDao {

	/**
	 * 查询项目需求
	 * @return projectRequirement
	 */
	public List<ProjectRequirement> selectPrRequirement(ProjectRequirement projectRequirement);
	/**
	 * 在点击修改操作是先通过ID查询需求是否存在
	 * @return projectRequirement
	 */
	public ProjectRequirement selectPrRequirementId(Long projId);
	/**
	 * 插入项目需求
	 * @param projectRequirement
	 * @return
	 */
	public int insertPrRequirement(ProjectRequirement projectRequirement);
	/**
	 * 修改项目需求
	 * @param projectRequirement
	 * @return
	 */
	public int updatePrRequirement(ProjectRequirement projectRequirement);
	/**
	 * 根据项目需求id假删除创意需求
	 * @param projectRequirement
	 * @return
	 */
	public int deletePrRequirement(Long projId);
	/**
	 * 查询出所有需求类型包含子类型
	 * @param projectRequirement
	 * @return   
	 */
	public List<Dictionary> selectAllRequirementType();
	/**
	 * 查看消息信息
	 * @param sysMessage
	 * @return
	 */
	public List<SysMessage> selectMessage(SysMessage sysMessage);
	/**
	 * 插入需求的分类
	 * @param projectRequirementClasses （创意资源小类id【Dictionarydata.dataId】
	 * @return 是否插入成功
	 */
	public int insertRequirementType(List<ProjectRequirementClass> projectRequirementClasses);
	/**
	 * 插入需求概述
	 * @param projRequireDescriptions （创意资源小类id【Dictionarydata.dataId】
	 * @return 是否插入成功
	 */
	public int insertRequirementDescription(List<ProjRequireDescription> projRequireDescriptions);
	/**
	 * 根据需求id删除该需求id的所有类型
	 * @param creativeResourceId
	 * @return
	 */
	public int deleteRequirementType(Long projRequireId);
	/**
	 * 根据需求id删除该需求id的所有描述
	 * @param creativeResourceId
	 * @return
	 */
	public int deleteRequirementDescription(Long projRequireId);
	
}
