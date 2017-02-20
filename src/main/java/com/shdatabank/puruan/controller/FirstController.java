package com.shdatabank.puruan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shdatabank.puruan.service.FirstService;

/************************************************* 
Copyright (C), 1988-1999, SHDataBank Tech. Co., Ltd. 
File name: FirstController     // 文件名FirstController
Author: 周宇    
Date:2016-9-22 //及完成日期
Description:demo服务   // 用于详细说明此程序文件完成的主要功能，
Others:         // 其它内容的说明
History:        // 修改历史记录列表，每条修改记录应包括修改日期、修改
                // 者及修改内容简述
1. Date: 2016-9-23
Author: 周宇
Modification:修改 了某个方法
2. Date：2016-9-25
Author:李四
Modification:加了一个字段
*************************************************/ 
@RequestMapping(value="/fc")
@Controller
public class FirstController {
	@Autowired
	private FirstService service;
	/************************************************* 
	  Function: method      // 函数名称
	  Description:提供demo服务方法    // 函数功能、性能等的描述	  
	  Input:无参数       // 输入参数说明，包括每个参数的作        // 用、取值说明及参数间关系。
	  Return:返回测试         // 函数返回值的说明
	  Others:无         // 其它说明
	*************************************************/ 
	@RequestMapping(value="/method/{kkk}",method=RequestMethod.GET)
	@ResponseBody
   public void firstMethod()
   {
	   service.firstBiz();
   }
}
