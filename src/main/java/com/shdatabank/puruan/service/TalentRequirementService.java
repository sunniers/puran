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
import com.shdatabank.puruan.model.TalentRequirement;

/**
 * @author guoqiankun
 *
 */
public interface TalentRequirementService {
	/**
	 * 查询项目需求
	 * @return projectRequirement
	 */
	public PageInfo<TalentRequirement> selectTaTechnology(TalentRequirement talentRequirement) throws Exception;
	/**
	 * 根据创意人才id来修改创意人才
	 * @param talentRequirement
	 * @return
	 * @throws Exception
	 */
	public boolean updateTaTechnology(TalentRequirement talentRequirement) throws Exception;
	/**
	 *  根据创意人才id假删除一条创意人才
	 * @param talentRequirementId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTaTechnology(TalentRequirement talentRequirement) throws Exception;
	/**
	 * 查询出所有技术类型包含子类型
	 * @return
	 * @throws Exception
	 */
	public List<Dictionary> selectAllTechnologyType() throws Exception;
	/**
	 * 查询出所有工作形式
	 * @return
	 * @throws Exception
	 */
	public List<Dictionary> selectAllWorkModeType() throws Exception;
	/**
	 * 在点击修改操作是先通过ID查询创意人才是否存在
	 * @return talentRequirementId
	 */
	public TalentRequirement selectTaRequirementId(TalentRequirement talentRequirement) throws Exception;
}
