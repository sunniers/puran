package com.shdatabank.puruan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.CreateResourceAndClassifier;
import com.shdatabank.puruan.model.CreativeResource;
import com.shdatabank.puruan.model.CreativeResourceClassifier;
import com.shdatabank.puruan.model.CreativeResourceFront;
import com.shdatabank.puruan.model.Dictionary;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.CreativeResourceService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;
/**
 * 创意资源controller
 * 1、创意资源保存为草稿	0/创意资源的提交1
 * 2、创意资源修改并重新发布/草稿的保存与提交
 * 3、查询单条创意资源
 * 4、所有创意资源类型的查询
 * 5、查询所有创意资源分类集合
 * 6、分页条件查询创意资源集合
 * 7、分页条件查询已删除的创意资源集合
 * 8、资源仓库默认库存界面
 * 9、资源下架
 * 10、资源上架
 * 11、资源假删除
 * 12、创意资源销售界面分页条件查询
 * 13、根据id查询该资源所属分类集合
 */
@Controller
@RequestMapping(value="/creativeResource")
public class CreativeResourceController {
	
	@Autowired
	private CreativeResourceService creativeResourceService;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	/**
	 * 创意资源信息的保存和提交
	 * @param createResourceAndClassifier 创意资源对象与资源分类对象集合
	 * @return 无
	 * @throws Exception
	 */	
	@RequestMapping(value="/insertCreativeResource",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject insertCreativeResource(@RequestBody CreateResourceAndClassifier createResourceAndClassifier) throws Exception{		
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		boolean success = creativeResourceService.insertCreativeResource(createResourceAndClassifier);
		if(success){
			//保存成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			//保存失败
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 创意资源修改并重新发布：草稿状态、未通过审核状态、已删除状态
	 * @param 创意资源对象与资源分类对象集合
	 * @return 是否提交成功
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCreativeResource",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateCreativeResource(@RequestBody CreateResourceAndClassifier createResourceAndClassifier)throws Exception{
		if(creativeResourceService.updateCreativeResource(createResourceAndClassifier)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}
		return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
	}
	
	/**
	 * 查询单条创意资源信息
	 * @param creativeResourceId 创意资源id
	 * @return 创意资源信息
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCreativeResource",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectCreativeResource(@RequestBody CreativeResource creativeResource)throws Exception{		
		//查询资源详细信息同时去资源类型表里把相应资源的类型集合查询出来
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",creativeResourceService.selectCreativeResource(creativeResource.getCreativeResourceId()));
	}
	/**
	 * 查询所有创意资源分类集合
	 * @return 创意资源分类List(创意资源类型List)
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCreativeResourceType",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectCreativeResourceClassifier()throws Exception{
		List<Dictionary> dictionaryList = creativeResourceService.selectAllCreativeResourceType();
		if(null == dictionaryList){
			return RetObjectBuilder.generateRetObject(SystemConstant.SEARCH_ERROR,SystemConstant.SEARCH_ERROR_MSG);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",dictionaryList);
		}
	}
	/**
	 * 分页条件查询创意资源集合
	 * @param creativeResource 创意资源类型id,当前登录的用户id
	 * @return 创意资源对象集合
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllCreativeResource",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllCreativeResource(@RequestBody CreativeResource creativeResource)throws Exception{				
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		PageInfo<CreativeResource> creativeResourceList = creativeResourceService.selectAllCreativeResource(creativeResource);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",creativeResourceList);
	}
	/**
	 * 分页条件查询创意资源集合(已删除的资源)
	 * @param creativeResource 创意资源类型id,当前登录的用户id
	 * @return 已删除创意资源对象集合
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllCreativeResourceActive",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllCreativeResourceActive(@RequestBody CreativeResource creativeResource)throws Exception {
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		PageInfo<CreativeResource> creativeResourceList = creativeResourceService.selectAllCreativeResourceActive(creativeResource);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",creativeResourceList);
	}
	/**
	 * 资源仓库默认页面
	 * @param creativeResource
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllCreativeResourceDefault",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllCreativeResourceDefault(@RequestBody CreativeResource creativeResource)throws Exception{		
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		PageInfo<CreativeResource> creativeResourceList = creativeResourceService.selectAllCreativeResourceDefault(creativeResource);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",creativeResourceList);
	}
	/**
	 * 资源下架
	 * @param creativeResource 资源id
	 * @return 无返回值
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCreativeResourceOffShelf",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateCreativeResourceOffShelf(@RequestBody CreativeResource creativeResource)throws Exception{
		if(creativeResourceService.updateCreativeResourceOffShelf(creativeResource)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
		
	}
	/**
	 * 资源上架
	 * @param creativeResource 资源id
	 * @return 无返回值
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCreativeResourceOnShelf",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateCreativeResourceOnShelf(@RequestBody CreativeResource creativeResource)throws Exception{
		//如果资源为下架状态才允许资源上架，否者不允许执行资源上架操作
		if(creativeResourceService.updateCreativeResourceOnShelf(creativeResource)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}				
	}
	/**
	 * 创意资源假删除
	 * @param creativeResource 创意资源id 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCreativeResourceFalseDel",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateCreativeResourceFalseDel(@RequestBody CreativeResource creativeResource)throws Exception{
		if(creativeResourceService.updateCreativeResourceFalseDel(creativeResource)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
		}
	}
	/**
	 * 测试创意资源添加类型能否成功
	 * @param creativeResourceClassifierList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertTest",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject updateCreativeResourceFalseDel(@RequestBody List<CreativeResourceClassifier> creativeResourceClassifierList)throws Exception{
		boolean retMsg = creativeResourceService.insertCreativeResourceClassifier(creativeResourceClassifierList);
		if(retMsg){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
		}
	}
	/**
	 * 测试创意资源类型批量更新能否成功
	 * @param creativeResourceClassifierList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteCreativeResourceClassifier",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject deleteCreativeResourceClassifier(@RequestBody CreativeResourceClassifier creativeResourceClassifier)throws Exception{
		boolean retMsg = creativeResourceService.deleteCreativeResourceClassifier(creativeResourceClassifier.getCreativeResourceId());
		if(retMsg){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			return RetObjectBuilder.generateRetObject(SystemConstant.DELETE_ERROR,SystemConstant.DELETE_ERROR_MSG);
		}
	}
	/**
	 * 首页分页条件查询正在出售的创意资源对象集合（默认按照星级评价从高到低排序）
	 * @param creativeResourceFront 创意资源类型集合，创意资源名称
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllCreativeResourceFront",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllCreativeResourceFront(@RequestBody CreativeResourceFront creativeResourceFront)throws Exception{		
		PageInfo<CreativeResourceFront> creativeResourceFrontList = creativeResourceService.selectAllCreativeResourceFront(creativeResourceFront);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",creativeResourceFrontList);
	}
	/**
	 * 根据资源id查询该资源所属类型集合
	 * @param creativeResourceClassifier
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectAllCreativeResourceClassifier",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectAllCreativeResourceClassifier(@RequestBody CreativeResourceClassifier creativeResourceClassifier)throws Exception{
		List<CreativeResourceClassifier> creativeResourceClassifierList = creativeResourceService.selectAllCreativeResourceClassifier(creativeResourceClassifier.getCreativeResourceId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",creativeResourceClassifierList);
	}
	/**
	 * 首页单条创意资源详细信息展示
	 * @param creativeResourceFront
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectCreativeResourceFront",method=RequestMethod.POST)
	@ResponseBody
	public ReturnObject selectCreativeResourceFront(@RequestBody CreativeResourceFront creativeResourceFront)throws Exception{
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		CreativeResourceFront creativeResourceFronts = creativeResourceService.selectCreativeResourceFront(creativeResourceFront.getCreativeResourceId());
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",creativeResourceFronts);
	}
}
