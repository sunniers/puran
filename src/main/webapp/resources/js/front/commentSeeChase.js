/*
 *	createTime:2016/11/16
 * 	author	  :Chenxl
 * 	edit	  :
 * 
 */
$(function(){
	var app={
			
			init:function(){
				this.getBaseInfo();
				this.reply();//回复
				//this.tabClick();
			},
			getBaseInfo:function(){
				T.post("/s/evaluate/selectCreativeResourceEvaluate",
						{"transactionId":sessionStorage.getItem('resourceTransactionId')},
						function(res){
							if(res.retCode="10000"){
								var _obj=res.retObject;
								_obj.transactionDatetime=T.dateFormat(new Date(_obj.transactionDatetime),"yyyy-MM-dd hh:mm:ss");
								评论时间
								_obj.evaluateTime=T.dateFormat(new Date(_obj.evaluateTime),"MM-dd");
								$('.img').html("<img src="+_obj.resourceImage+" />");//图片								
								$('.comName').text(_obj.resourceName);//资源名称
								$('.comMoney').text("￥"+_obj.transactionPrice+"元");//资源数量
								$('.Datetime').text("成交时间："+_obj.transactionDatetime);//成交时间
								$('.selPl').text(_obj.countEvalute);//商品满意度
								$('.evaluateValue').text(_obj.evaluateValue);//评论内容
								$('.evaluateTime').text(_obj.evaluateTime);//评论时间
								$('.starFocus').css("width",_obj.evaluateStar*20+"px")//星星个数
								$('.starFocus>span').text(_obj.evaluateStar+"分");//分数
							}
				});
			},
			reply:function(){
				
				$(document).on('click','.comHuifu',function(){
					if($('.reply').val()==''){
						$.alert('评论不能为空');
					}else{
					T.post('/s/evaluate/updateExplain',
							{"evaluateId":sessionStorage.getItem('resourceTransactionId'),
							"explain":$('.reply').val()},
							
					function(res){
								console.log(res);
						if(res.retCode=='10000'){
							$('.rightContentField').load('resources/html/front/sellResources.html');
						}else{
							$.alert('评论失败');
						}
					});
					}
				})
			},
	}
	app.init();
})

