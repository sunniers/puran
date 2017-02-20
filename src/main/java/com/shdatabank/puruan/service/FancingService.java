package com.shdatabank.puruan.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.Fancing;
import com.shdatabank.puruan.model.FancingAndClassifierList;
import com.shdatabank.puruan.model.FancingResponse;

/**
 * 融资信息service层
 */
public interface FancingService {

	/**
	 * 融资信息 
	 */
	public PageInfo<Fancing> findAllFancingBy(Fancing fancing)  throws Exception;
	/**
	 * 融资信息列表
	 */
	public List<Fancing> findAllFancing(Fancing fancing)  throws Exception;
	/**
	 * 插入融资信息
	 * @param fancing
	 * @return
	 */
	public boolean insertFancing(FancingAndClassifierList fancingAndClassifierList)  throws Exception;
	/**
	 * 更新融资信息
	 * @param fancing
	 * @return
	 */
	public boolean updateFancing(FancingAndClassifierList fancingAndClassifierList)  throws Exception;
	/**
	 * 查询融资分类与融资方式集合
	 * @return
	 * @throws Exception
	 */
	public FancingResponse selectFancingResponse() throws Exception;
	/**
	 * 根据融资id查询某个融资实体的详细信息
	 * @param fancingId
	 * @return
	 */
	public Fancing selectFancingDetail(Long fancingId) throws Exception;
	/**
	 * 草稿箱列表查询
	 * @param fancing
	 * @return
	 */
	public PageInfo<Fancing> selectAllFancingDrafts(Fancing fancing) throws Exception ;
	/**
	 * 融资假删除
	 * @param fancingId
	 * @return
	 */
	public boolean updateFancingActive(Long fancingId) throws Exception ;
	/**
	 * 融资状态修改
	 * @param fancing
	 * @return
	 */
	public boolean updateFancingStatus(Fancing fancing) throws Exception ;
	/**
	 * 需求大厅中的融资详情
	 * @param fancingId
	 * @return
	 */
	public Fancing selectFancingById(Long fancingId) throws Exception ;
	
}
