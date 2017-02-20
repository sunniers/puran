package com.shdatabank.puruan.dao;


import java.util.List;

import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.TalentRequirement;
import com.shdatabank.puruan.model.TalentRequirementClass;
import com.shdatabank.puruan.model.TalentTechnology;

/**
 * 查询人才需求dao层接口
 */
public interface TalentRequirementDao {
	/**
	 * 查询人才需求
	 * @return projectRequirement
	 */
	public List<TalentRequirement> selectTaTechnology(TalentRequirement talentRequirement);
	/**
	 * 在点击修改操作是先通过ID查询需求是否存在
	 * @return talentRequirementId
	 */
	public TalentRequirement selectTaTechnologyId(Long talentRequirementId);
	/**
	 * 插入人才需求
	 * @param talentRequirement
	 * @return
	 */
	public int insertTaRequirement(TalentRequirement talentRequirement);
	/**
	 * 插入创意人才技能
	 * @param talentTechnology
	 * @return
	 */
	public int insertTalentTechnology(List<TalentTechnology> talentTechnologys);
	/**
	 * 插入需求的分类
	 * @param projectRequirementClasses （创意资源小类id【Dictionarydata.dataId】
	 * @return 是否插入成功
	 */
	public int insertRequirementType(List<TalentRequirementClass> talentRequirementClasss);
	/**
	 *根据创意人才id删除创意技术类型 
	 * @param creativeTalentId
	 * @return
	 */
	public int deleteTalentTechnology(Long creativeTalentId);
	/**
	 * 根据创意人才id来修改创意人才
	 * @param talentRequirement
	 * @return
	 */
	public int updateTaTechnology(TalentRequirement talentRequirement);
	/**
	 * 根据创意人才id假删除一条创意人才
	 * @param talentRequirementId
	 * @return
	 */
	public int deleteTaTechnology(Long talentRequirementId);
	/**
	 * 根据需求id删除该人才需求分类id的所有类型
	 * @param talentRequirementId
	 * @return
	 */
	public int deleteRequirementType(Long talentRequirementId);
	/**
	 * 查询出所有技术类型包含子类型
	 * @return
	 */
	public List<Dictionary> selectAllTechnologyType();
	/**
	 * 查询出所有工作形式
	 * @return
	 */
	public List<Dictionary> selectAllWorkModeType();
	/**
	 * 在点击修改操作是先通过ID查询创意人才是否存在
	 * @return talentRequirementId
	 */
	public TalentRequirement selectTaRequirementId(Long talentRequirementId);
	
	
}
