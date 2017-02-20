package com.shdatabank.puruan.dao;

import java.util.List;
import java.util.Map;

import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.CreativeResourceClassifier;
import com.shdatabank.puruan.model.CreativeResourceFront;
import com.shdatabank.puruan.model.Dictionary;

/**
 * 创意资源发布Dao接口
 * 1、创意资源插入
 * 2、创意资源单条查询
 */
public interface CreativeResourceDao {

	/**
	 * 创意资源的添加
	 * @param creativeResource 创意资源对象
	 * @return 创意资源对象
	 */
	public int insertCreativeResource(CreativeResource creativeResource);
	
	/**
	 * 更新创意资源状态
	 * @param creativeResource 创意资源当前创意资源id
	 * @return  创意资源对象
	 */
	public int updateCreativeResource(CreativeResource creativeResource);
	/**
	 * 资源修改并重新发布
	 * @param creativeResource
	 * @return
	 */
	public int updateCreativeResourceActive(CreativeResource creativeResource);
	/**
	 * 资源修改保存为草稿
	 * @param creativeResource
	 * @return
	 */
	public int updateCreativeResourceSave(CreativeResource creativeResource);

	/**
	 * 根据资源id查询创意资源信息
	 * @param creativeResourceId 创意资源id
	 * @return 创意资源对象
	 */
	public CreativeResource selectCreativeResource(Long creativeResourceId);

	/**
	 * 查询出所有创意资源类型包含子类型
	 * @return 所有创意资源类型集合
	 */	
	public List<Dictionary> selectAllCreativeResourceType();
	/**
	 * 给将发布的创意资源分类
	 * @param creativeResourceClassifier （创意资源小类id【Dictionarydata.dataId】
	 * @return 是否插入成功
	 */
	public int insertCreativeResourceClassifier(List<CreativeResourceClassifier> creativeResourceClassifierList);
	
	/**
	 * 资源仓库中创意资源根据类型的条件查询
	 * @param userId 用户id
	 * @param resourceStatus 创意资源类型
	 * @param active 删除状态
	 * @return 创意资源集合
	 */
	public List<CreativeResource> selectAllCreativeResource(CreativeResource creativeResource);
	
	/**
	 * 查询已删除状态的资源集合
	 * @param creativeResource 资源状态
	 * @return
	 */
	public List<CreativeResource> selectAllCreativeResourceActive(CreativeResource creativeResource);
	
	/**
	 * 资源仓库默认页面
	 * @param userId 用户id
	 * @return 创意资源所有状态集合
	 */
	public List<CreativeResource> selectAllCreativeResourceDefault(CreativeResource creativeResource);
	
	/**
	 * 根据资源分类id查询当前资源类型集合
	 * @param classifierId 资源分类id
	 * @return 资源分类对象
	 */
	public List<CreativeResourceClassifier> selectAllCreativeResourceClassifier(Long creativeResourceId);
	/**
	 * 根据资源id删除资源类型
	 * @param creativeResourceClassifier 资源id
	 * @return
	 */
	public int deleteCreativeResourceClassifier(Long creativeResourceId);
	/**
	 * 首页已出售的创意资源分页条件查询
	 * @param CreativeResource 创意资源类型，创意资源名称
	 * @return
	 */
	public List<CreativeResourceFront> selectAllCreativeResourceFront(Map<String, Object> param);
	
	/**
	 * 首页正在出售的创意资源详情
	 * @param creativeResourceId
	 * @return
	 */
	public CreativeResourceFront selectCreativeResourceFront(Long creativeResourceId);
}
