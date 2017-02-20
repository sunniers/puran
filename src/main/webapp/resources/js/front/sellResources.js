/*
 *	createTime:2016/11/8
 * 	author	  :Chenxl
 * 	edit	  :
 * 
 */
$(function(){
	var total=0,
		start=1,
		size=4;//分页默认参数
	var url='/s/ceativeResourceTransaction/selectAllCeativeResourceTransactionCs';
	var obj={
			'S_total':{"page": start,"pageSize":size},//全部
			'obligation':{"transactionStatus": 400501,"page": start,"pageSize":size},//代付款
			'dueOut':{"transactionStatus": 400502,"page": start,"pageSize":size},//待发货
			'shppind':{"transactionStatus": 400503,"page": start,"pageSize":size},//待确认
			'confirm':{"transactionStatus": 400504,"page": start,"pageSize":size},//待评价
			'evaluate':{"transactionStatus": 400505,"active":1,"page": start,"pageSize":size},//已完成
			'finish':{"transactionStatus": 400506,"active":1,"page": start,"pageSize":size}//已关闭
		}
	
	var _obj='S_total';//中间变量
	var app={
			init:function(){
				
				this.initData();
				this.tabClick();
				/*初始化数据表格内功能*/
				this.S_total();//全部
				this.deliverGoods();//发货
				this.confirm();//解释回复
			},
			initData:function(){//初始化
				obj[_obj].page=1;
				T.post(url,obj[_obj],function(res){
					
							if(res.retCode=="10000"){
								total=res.retObject.total;//初始化总页数
								$("."+_obj+" table tbody").remove();
								$('#resources_'+_obj+'_tmplate').tmpl(res.retObject.list).appendTo($("."+_obj+" table"));
								$('.'+_obj+'').show();
								app.page();
							}else{
								
							}
					});
			},
			updateData:function(){
				T.post(url,obj[_obj],function(res){
					console.log(res);
					if(res.retCode=="10000"){
						total=res.retObject.total;
						$("."+_obj+" table tbody").remove();
						$('#resources_'+_obj+'_tmplate').tmpl(res.retObject.list).appendTo($("."+_obj+" table"));
						app.page();
					}else{
						
					}
				});
			},
			page:function(){
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :size,
					onchange : function(newPage) {
						start=newPage;
						obj[_obj]["page"]=start;
						T.post(url,obj[_obj],function(res){
							if(res.retCode=="10000"){
								$("."+_obj+" table tbody").remove();
								$('#resources_'+_obj+'_tmplate').tmpl(res.retObject.list).appendTo($("."+_obj+" table"));
							}else{
								
							}
						});
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
					//app.updateData();
				});
			},
			S_total:function(){//全部-查看
				$(document).off('click','.investment_title>div ._look').on('click','.investment_con_list ._look',function(){
					var id=$(this).attr('data-id');
					sessionStorage.setItem('id',id);
					$('.rightContentField').load('resources/html/front/purchaseDetails.html');
				});
			},
			deliverGoods:function(){//发货
				$(document).off('click','.investment_title>div .deliverGoods').on('click','.investment_con_list .deliverGoods',function(){
					var resourceTransactionId=$(this).attr('data-id');
					T.post('/s/ceativeResourceTransaction/updateCeativeResourceTransaction',{'resourceTransactionId':resourceTransactionId,'transactionStatus':400503},function(res){
						if(res.retCode=="10000"){$.alert('已发货');}
						if(res.retCode=="10000"){app.initData();}
					});
				});
			},
			confirm:function(){//全部-解释回复
				$(document).off('click','.investment_title>div .confirm').on('click','.investment_con_list .confirm',function(){
					var resourceTransactionId=$(this).attr('data-id');
					sessionStorage.setItem('resourceTransactionId',resourceTransactionId);
					$('.rightContentField').load('resources/html/front/commentSeeChase.html');
				});
			},
			 

	}
	app.init();
});