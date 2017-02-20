/**
 * RequirementCommitService.java
 * Created at 2016-11-3
 * Created by guoqiankun
 * Copyright (C) 2016 SHANGHAI DATABANK, All rights reserved.
 */
package com.shdatabank.puruan.service;



import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.ProjectRequirement;
import com.shdatabank.puruan.model.ProjectRequirementClass;
import com.shdatabank.puruan.model.SysMessage;

/**
 * @author guoqiankun
 *
 */
public interface RequirementCommitService {
	
	/**
	 * 查询项目需求
	 * @return projectRequirement
	 */
	public PageInfo<ProjectRequirement> selectPrRequirement(ProjectRequirement projectRequirement) throws Exception;
	/**
	 * 插入项目需求
	 * @param projectRequirement
	 * @return
	 * @throws Exception
	 */
	public boolean insertPrRequirement(ProjectRequirement projectRequirement) throws Exception;
	/**
	 * 在点击修改操作是先通过ID查询需求是否存在
	 * @return projectRequirement
	 */
	public ProjectRequirement selectPrRequirementId(ProjectRequirement projectRequirement)throws Exception;
	/**
	 * 修改项目需求
	 * @param projectRequirement
	 * @return
	 */
//	public boolean updatePrRequirement(ProjectRequirement projectRequirement) throws Exception;
	/**
	 * 根据项目需求id假删除创意需求
	 * @param projectRequirement
	 * @return
	 */
	public boolean deletePrRequirement(ProjectRequirement projectRequirement) throws Exception;
	/**
	 * 查询出所有需求类型包含子类型
	 * @param projectRequirement
	 * @return
	 */
	public List<Dictionary> selectAllRequirementType() throws Exception;
	/**
	 * 查看消息信息
	 * @param sysMessage
	 * @return
	 */
	public PageInfo<SysMessage> selectMessage(SysMessage sysMessage) throws Exception;
	/**
	 * 插入需求的分类
	 * @param projectRequirementClasses （创意资源小类id【Dictionarydata.dataId】、
	 * 	创意资源id【CreativeResource.creativeResourceId】、创意资源大类id【Dictionary.dictId】）
	 * @return 是否插入成功
	 */
	public boolean insertRequirementType(List<ProjectRequirementClass> projectRequirementClasses) throws Exception;
	/**
	 * 根据需求id删除资源类型
	 * @param projectRequirementClasses 创意资源id
	 * @return
	 */
//	public boolean deleteRequirementType(Long projRequireId)throws Exception;
}
