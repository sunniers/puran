package com.shdatabank.puruan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.model.ReturnObject;
import com.shdatabank.puruan.model.VirtualAboratory;
import com.shdatabank.puruan.service.VirtualAboratoryService;
import com.shdatabank.puruan.util.RetObjectBuilder;
import com.shdatabank.puruan.util.SystemConstant;

/**
 * 虚拟实验室controller层
 * @author swc
 */
@Controller
@RequestMapping(value="/virtual")
public class VirtualAboratoryController {
	/**
	 * 虚拟实验室service层
	 */
	@Autowired
	private VirtualAboratoryService virtualAboratoryService;
	/**
	 * 查询虚拟实验室
	 * @param virtualAboratory
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/aboratory",method=RequestMethod.POST)
    @ResponseBody
	public ReturnObject selectVirtualAboratory(@RequestBody VirtualAboratory virtualAboratory ) throws Exception{
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
				virtualAboratoryService.selectVirtualAboratory(virtualAboratory));
	}
	
	/**
	 * 查询未来七天使用情况
	 * @param virtualAboratory
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/counts",method=RequestMethod.POST)
    @ResponseBody
	public ReturnObject selectVirtualCount(@RequestBody VirtualAboratory virtualAboratory ) throws Exception{
		return RetObjectBuilder.generateRetObject(SystemConstant.SUCCESS,"",
				virtualAboratoryService.selectVirtualCount(virtualAboratory));
	}
}
