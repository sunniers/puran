/*
 *	createTime:2016/11/14
 * 	author	  :Chenxl
 * 	edit	  :
 * 
 */
$(function(){
	
	
	var app={
			init:function(){
				this.getBaseInfo();
				this.tabClick();
			},
			getBaseInfo:function(){
				T.post("/s/creativeResource/selectCreativeResourceFront",
						{"creativeResourceId":sessionStorage.getItem('id')},
						function(res){
							console.log(res);
							if(res.retCode="10000"){
								var _obj=res.retObject;
								var url = _obj.showAddress;
								$('.pic').html("<img src="+_obj.resourceImage+" />");//图片								
								$('.selInfo>h2').text(_obj.resourceName);//资源名称
								$('.Stock').text(_obj.resourceNumber);//资源数量
								$('.selLeft>span').text(_obj.resourcePrice);//资源价格
								$('.selPl').text(_obj.countEvalute);//累计评论数量
								$('.selCj').text(_obj.countTransaction);//累计成交数量
								$('.selRes').text(_obj.resourceDescription);//资源描述
								if(url!="null"){
									$('.showAddress').html(
											"<div class='Add_style'><p>资源演示地址：<a href='"
											+_obj.showAddress
											+"' target= _blank>"
											+_obj.showAddress
											+"</a></p></div>"
											);//初始化资源演示地址
								}
							}
				});
			},
			tabClick:function(){
				$(".investment_title>div").bind('click',function(){
					var clickObj=$(this).attr('data-attr');
						_obj=clickObj;
						console.log(clickObj);
					/*切换效果*/
					$(".investment_title>div").removeClass('on');
					$(this).attr('class','on');
					$(".investment_con .investment_con_list").hide();
					$('.investment_con .'+clickObj+'').show();
					app.initData();//初始化数据
				});
			}
	}
	app.init();
})