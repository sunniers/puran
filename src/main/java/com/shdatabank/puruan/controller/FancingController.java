package com.shdatabank.puruan.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.shdatabank.puruan.model.Fancing;
import com.shdatabank.puruan.model.FancingAndClassifierList;
import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.FancingService;
import com.shdatabank.puruan.service.impl.FancingExport;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 融资信息Controller层
 * 1、融资信息查询
 * 2、融资信息导出列表
 * 3、打开融资发布页面 去初始化融资类型和融资方式
 * 4、融资保存与发布
 * 5、融资修改前的信息查询
 * 6、融资修改保存与发布
 * 7、草稿箱列表查询
 * 8、融资假删除
 * 9、融资状态修改
 * 10、需求大厅中的融资详情
 */
@Controller
@RequestMapping(value = "/fancing")
public class FancingController {

	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private FancingService fancingService;

	/**
	 * 融资信息查询
	 */
	@ResponseBody
	@RequestMapping(value = "/findBy", method = RequestMethod.POST)
	public ReturnObject findAllFancingBy(@RequestBody Fancing fancing) throws Exception {
		PageInfo<Fancing> fancings = fancingService.findAllFancingBy(fancing);
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", fancings);
	}

	/**
	 * 融资信息导出列表
	 */
	@RequestMapping(value = "/excelDownload", method = RequestMethod.GET)
	public String exportExcel(String projectName, String publishName,  HttpServletResponse response)
			throws Exception {
		try {
			String fileName = new String(("融资信息列表").getBytes("gb2312"), "iso8859-1") + ".xlsx";
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.setCharacterEncoding("utf-8");
			String[] titles = { "项目名称", "发布方", "融资金额","发布时间"};

			Fancing fancing = new Fancing();
			fancing.setProjectName(projectName);
			fancing.setPublishName(publishName);

			List<Fancing> investCompanys = fancingService.findAllFancing(fancing);
			ServletOutputStream outputStream = response.getOutputStream();
			FancingExport.ExportExcel(titles, investCompanys, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 打开融资发布页面
	 * 去初始化融资类型和融资方式
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/OpenFancingIndex", method = RequestMethod.POST)
	public ReturnObject OpenFancingIndex() throws Exception {
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", fancingService.selectFancingResponse());
	}
	/**
	 * 融资发布
	 * @param fancing
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/insertFancing", method = RequestMethod.POST)
	public ReturnObject insertFancing(@RequestBody FancingAndClassifierList fancingAndClassifierList) throws Exception {
		//检查用户是否登录
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		if(fancingService.insertFancing(fancingAndClassifierList)){
			//保存成功
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}else{
			//保存失败
			return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
		}
	}
	/**
	 * 融资修改前的信息查询
	 * @param fancing
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/selectFancingDetail", method = RequestMethod.POST)
	public ReturnObject selectFancingDetail(@RequestBody Fancing fancing) throws Exception {
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", fancingService.selectFancingDetail(fancing.getFancingId()));
	}
	/**
	 * 融资修改
	 * @param fancing
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/updateFancing", method = RequestMethod.POST)
	public ReturnObject updateFancing(@RequestBody FancingAndClassifierList fancingAndClassifierList) throws Exception {
		if(fancingService.updateFancing(fancingAndClassifierList)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}
		return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
	}
	/**
	 * 草稿箱列表查询
	 * @param fancing
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAllFancingDrafts", method = RequestMethod.POST)
	public ReturnObject selectAllFancingDrafts(@RequestBody Fancing fancing) throws Exception {
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		if(null == user){
			return RetObjectBuilder.generateRetObject(SystemConstant.SESSION_ERROR,SystemConstant.SESSION_ERROR_MSG);
		}
		PageInfo<Fancing> FancingDraftsList = fancingService.selectAllFancingDrafts(fancing);
        return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",FancingDraftsList);
	}
	/**
	 * 融资假删除
	 * @param fancing
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/updateFancingActive", method = RequestMethod.POST)
	public ReturnObject updateFancingActive(@RequestBody Fancing fancing) throws Exception {
		if(fancingService.updateFancingActive(fancing.getFancingId())){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}
		return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
	}
	/**
	 * 融资状态修改
	 * @param fancing
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/updateFancingStatus", method = RequestMethod.POST)
	public ReturnObject updateFancingStatus(@RequestBody Fancing fancing) throws Exception {
		if(fancingService.updateFancingStatus(fancing)){
			return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS);
		}
		return RetObjectBuilder.generateRetObject(SystemConstant.SAVE_ERROR,SystemConstant.SAVE_ERROR_MSG);
	}
	/**
	 * 需求大厅中的融资详情
	 * @param fancing
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/selectFancingById", method = RequestMethod.POST)
	public ReturnObject selectFancingById(@RequestBody Fancing fancing) throws Exception {
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS, "", fancingService.selectFancingById(fancing.getFancingId()));
	}
}
