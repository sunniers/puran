package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CreateResourceAndClassifier;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.CreativeResourceClassifier;
import com.shdatabank.puruan.model.CreativeResourceFront;
import com.shdatabank.puruan.model.Dictionary;

/**
 * 创意资源发布Service接口
 * 1、创意资源的添加
 * 2、创意资源单条查询
 */
public interface CreativeResourceService {

	/**
	 * 创意资源的保存和发布
	 * @param creativeResource
	 * @return
	 */
	public boolean insertCreativeResource(CreateResourceAndClassifier createResourceAndClassifier)throws Exception;		
	
	/**
	 * 创意资源的修改并重新发布
	 * @param createResourceAndClassifier 资源状态、资源id、资源类型集合
	 * @return 资源实体
	 * @throws Exception
	 */
	public boolean updateCreativeResource(CreateResourceAndClassifier createResourceAndClassifier)throws Exception;
	/**
	 * 创意资源下架
	 * @param creativeResource
	 * @return
	 * @throws Exception
	 */
	public boolean updateCreativeResourceOffShelf(CreativeResource creativeResource)throws Exception;
	/**
	 * 资源上架
	 * @param creativeResource
	 * @return
	 * @throws Exception
	 */
	public boolean updateCreativeResourceOnShelf(CreativeResource creativeResource)throws Exception;
	/**
	 * 创意资源假删除
	 * @param creativeResource
	 * @return
	 * @throws Exception
	 */
	public boolean updateCreativeResourceFalseDel(CreativeResource creativeResource)throws Exception;
	/**
	 * 根据资源id查询创意资源信息
	 * @param creativeResourceId 创意资源id
	 * @return 创意资源对象
	 */
	public CreativeResource selectCreativeResource(Long creativeResourceId)throws Exception;
	/**
	 * 查询出所有创意资源类型包含子类型
	 * @return 所有创意资源类型集合
	 */
	public List<Dictionary> selectAllCreativeResourceType()throws Exception;
	/**
	 * 给将发布的创意资源分类
	 * @param creativeResourceClassifier （创意资源小类id【Dictionarydata.dataId】、
	 * 	创意资源id【CreativeResource.creativeResourceId】、创意资源大类id【Dictionary.dictId】）
	 * @return 是否插入成功
	 */
	public boolean insertCreativeResourceClassifier(List<CreativeResourceClassifier> creativeResourceClassifierList)throws Exception;

	/**
	 * 资源仓库中创意资源根据类型的条件查询
	 * @param resourceType 创意资源类型id
	 * @return 创意资源集合
	 */
	public PageInfo<CreativeResource> selectAllCreativeResource(CreativeResource creativeResource)throws Exception;
	/**
	 * 查询已删除状态的资源集合
	 * @param creativeResource 资源状态
	 * @return
	 */
	public PageInfo<CreativeResource> selectAllCreativeResourceActive(CreativeResource creativeResource)throws Exception;
	/**
	 * 资源仓库默认页面
	 * @param CreativeResource
	 * @return
	 * @throws Exception
	 */
	public PageInfo<CreativeResource> selectAllCreativeResourceDefault(CreativeResource creativeResource)throws Exception;
	/**
	 * 根据资源分类id查询当前资源类型集合
	 * @return 资源分类对象
	 * @param classifierId 资源分类id
	 */
	public List<CreativeResourceClassifier> selectAllCreativeResourceClassifier(Long creativeResourceId)throws Exception;
	/**
	 * 根据资源id删除资源类型
	 * @param creativeResourceClassifier 创意资源id
	 * @return
	 */
	public boolean deleteCreativeResourceClassifier(Long creativeResourceId)throws Exception;
	/**
	 * 首页已出售的创意资源分页条件查询
	 * @param CreativeResource 创意资源类型集合，创意资源名称
	 * @return
	 */
	public PageInfo<CreativeResourceFront> selectAllCreativeResourceFront(CreativeResourceFront creativeResourceFront)throws Exception;
	/**
	 * 首页正在出售的创意资源详情
	 * @param creativeResourceId
	 * @return
	 */
	public CreativeResourceFront selectCreativeResourceFront(Long creativeResourceId)throws Exception;

}
