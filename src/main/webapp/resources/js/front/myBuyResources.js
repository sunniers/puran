/*
 *	createTime:2016/11/11
 * 	author	  :Chenxl
 * 	edit	  :
 * 
 */
$(function(){
	var total=0,
		start=1,
		size=4;//分页默认参数
	var url='/s/ceativeResourceTransaction/selectAllCeativeResourceTransactionGm';
	var obj={
			'S_total':{"page": start,"pageSize":size},//全部
			'obligation':{"transactionStatus": 400501,"page": start,"pageSize":size},//待付款
			'shppind':{"transactionStatus": 400503,"page": start,"pageSize":size},//待确认
			'confirm':{"transactionStatus": 400504,"page": start,"pageSize":size},//待评价
			'finish':{"transactionStatus": 400506,"page": start,"pageSize":size},//已关闭

		}
	
	var _obj='S_total';//中间变量
	var app={
			init:function(){
				this.initData();
				this.tabClick();
				this.cancel();//取消交易
				this.S_total();//全部
				this.goodsReceipt();//确认收货
				this.confirm();//待评价
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
					/*切换效果*/
					$(".investment_title>div").removeClass('on');
					$(this).attr('class','on');
					$(".investment_con .investment_con_list").hide();
					$('.investment_con .'+clickObj+'').show();
					
					app.updateData();
				});
			},
			S_total:function(){//全部-查看
				$(document).off('click','.investment_title>div .details').on('click','.investment_con_list .details',function(){
					var id=$(this).attr('data-id');
					sessionStorage.setItem('id',id);
					$('.rightContentField').load('resources/html/front/purchaseDetails.html');
				});
			},
			goodsReceipt:function(){//全部-确认收货
				$(document).off('click','.investment_title>div .goodsReceipt').on('click','.investment_con_list .goodsReceipt',function(){
					var resourceTransactionId=$(this).attr('data-id');
					T.post('/s/ceativeResourceTransaction/updateCeativeResourceTransaction',{'resourceTransactionId':resourceTransactionId,'transactionStatus':400504},function(res){
						if(res.retCode=="10000"){app.initData();}
					});
				});
			},
			confirm:function(){//全部-评论
				$(document).off('click','.investment_title>div .confirm').on('click','.investment_con_list .confirm',function(){
					var resourceTransactionId=$(this).attr('data-id');
					sessionStorage.setItem('resourceTransactionId',resourceTransactionId);
					$('.rightContentField').load('resources/html/front/commentSee.html');
				});
			},
			cancel:function(){//全部-确认收货
				$(document).off('click','.investment_title>div .cancel').on('click','.investment_con_list .cancel',function(){
					var resourceTransactionId=$(this).attr('data-id');
					T.post('/s/ceativeResourceTransaction/updateCeativeResourceTransaction',{'resourceTransactionId':resourceTransactionId,'transactionStatus':400506},function(res){
						if(res.retCode=="10000"){app.initData();}
					});
				});
			},
			
			
			

	}
	app.init();
});