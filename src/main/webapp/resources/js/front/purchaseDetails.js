/*
 *	createTime:2016/11/14
 * 	author	  :Chenxl
 * 	purchaseDetail.html
 * 
 */
$(function(){
	
	
	var app={
			init:function(){
				this.getBaseInfo();
				this.tabClick();
				this.evaluation();//资源评价
			},
			getBaseInfo:function(){
				T.post("/s/creativeResource/selectCreativeResourceFront",
						{"creativeResourceId":sessionStorage.getItem('id')},
						function(res){
							if(res.retCode="10000"){
								var _obj=res.retObject;
								$('.pic').html("<img src="+_obj.resourceImage+" />");//图片								
								$('.selInfo>h2').text(_obj.resourceName);//资源名称
								$('.Stock').text(_obj.resourceNumber);//资源数量
								$('.selLeft>span').text(_obj.resourcePrice);//资源价格
								$('.selCj').text(_obj.countTransaction);//累计成交数量
								$('.selRes').text(_obj.resourceDescription);//资源描述
								if(_obj.showAddress!="null"){
									$('.showAddress').html(
											"<div class='Add_style'><p>资源演示地址：<a href='"	
											+_obj.showAddress+"' target= _blank>"
											+_obj.showAddress
											+"</a></p></div>"
											);//初始化资源演示地址

								}
								//判断是否可以继续购买
								//isMy==1购买的
								//isMy==2出售的
								if(_obj.isMy==1){
									$('.purchase').css("display","block");
								}
							}
				});
			},
			//商品评论详情
			evaluation:function(){
				$(document).off('click','#evaluation').on('click','#evaluation',function(){
					T.post('/s/evaluate/selectCreativeResourceEvaluates',{"creativeResourceId":sessionStorage.getItem('id'),"page":1,"pageSize":10},
					function(res){
						console.log(res);
						if(res.retCode=="10000"){
							var o=res.retObject.list;
								$.each(o,function(index,ele){
									ele.evaluateTime=T.dateFormat(new Date(ele.evaluateTime),'MM-dd');
									ele.appendTime=T.dateFormat(new Date(ele.appendTime),'MM-dd');
								});
								$('.resourceDetails .selReply').empty();
								$('#purchase_replay_tmplate').tmpl(o).appendTo('.resourceDetails .selReply');
						}
					});
				});
			},
			tabClick:function(){
				$(".investment_title>div").bind('click',function(){
					var clickObj=$(this).attr('data-attr');
						_obj=clickObj;
					/*切换效果*/
					$(".investment_title>div").removeClass('on');
					$(this).attr('class','on');
					$(".investment_con .investment_con_list").hide();
					$('.investment_con .'+clickObj+'').show();

				});
			}
	}
	app.init();
})