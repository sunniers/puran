package com.shdatabank.puruan.dao;

import java.util.List;

import com.shdatabank.puruan.model.Dictionarydata;
import com.shdatabank.puruan.model.Fancing;
import com.shdatabank.puruan.model.FancingClassifier;

/**
 * 融资信息dao层
 */
public interface FancingDao {
	/**
	 * 融资信息查询
	 */
	public List<Fancing> findAllFancingBy(Fancing fancing);
	/**
	 * 查询所有融资分类
	 * @return 融资分类对象集合
	 */
	public List<Dictionarydata> findAllFacningClass();
	/**
	 * 查询所有融资方式
	 * @return
	 */
	public List<Dictionarydata> findAllFacningWay();
	/**
	 * 插入融资信息
	 * @param fancing
	 * @return
	 */
	public int insertFancing(Fancing fancing);
	/**
	 * 更新融资信息
	 * @param fancing
	 * @return
	 */
	public int updateFancing(Fancing fancing);
	/**
	 * 批量插入融资分类
	 * @param fancingClassifier
	 * @return
	 */
	public int insertFancingClassifier(List<FancingClassifier> fancingClassifiers);
	/**
	 * 删除某个融资的所有分类
	 * @param fancingId
	 * @return
	 */
	public int deleteFancingClassifier(Long fancingId);
	/**
	 * 根据融资id查询某个融资实体的详细信息
	 * @param fancingId
	 * @return
	 */
	public Fancing selectFancingDetail(Long fancingId);
	/**
	 * 草稿箱列表查询
	 * @param fancing
	 * @return
	 */
	public List<Fancing> selectAllFancingDrafts(Fancing fancing);
	/**
	 * 融资假删除
	 * @param fancingId
	 * @return
	 */
	public int updateFancingActive(Long fancingId);
	/**
	 * 融资状态修改
	 * @param fancing
	 * @return
	 */
	public int updateFancingStatus(Fancing fancing);
	/**
	 * 需求大厅中的融资详情
	 * @param fancingId
	 * @return
	 */
	public Fancing selectFancingById(Long fancingId);

}
