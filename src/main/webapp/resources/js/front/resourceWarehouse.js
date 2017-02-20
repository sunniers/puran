/*
 *	createTime:2016/11/1
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	var total=0,
		start=1,
		size=4;//分页默认参数
	$('.borderInves').css('height',(size*100+145+'px'));//更具每页显示的条数动态改变页面高度
	var url='/s/creativeResource/selectAllCreativeResource';
	var obj={
			'notReviewed':{//未通过审核
							"url":'/s/creativeResource/selectAllCreativeResource',
							"resourceStatus": 401204,"page": start,"pageSize":size},
			'inventoryGoods':{
								"url":'/s/createResourceWarehouse/selectAllCreateResourceWarehouse',//库存
								"page": start,"pageSize":size},
			'reviewIng':{
						"url":'/s/creativeResource/selectAllCreativeResource',//审核中
						"resourceStatus": 401202,"page": start,"pageSize":size},
			'onSealing':{
						"url":'/s/creativeResource/selectAllCreativeResource',//正在出售
						"resourceStatus": 401203,"page": start,"pageSize":size},
			'soldOut':{
						"url":'/s/creativeResource/selectAllCreativeResource',//已下架
						"resourceStatus": 401205,"page": start,"pageSize":size},
			'deleted':{
						"url":'/s/creativeResource/selectAllCreativeResourceActive',//已删除
						"resourceStatus": 401206,"active":1,
						"page": start,"pageSize":size}
		}
	
	var _obj='inventoryGoods';//中间变量
	
	var stockId='';//资源仓库-添加
	var resourceNumber='';//资源仓库-添加
	var app={
			init:function(){
				this.initData();
				this.tabClick();
				this.onSealing_soldOut();
				/*初始化数据表格内功能*/
				this.onSealing_soldOut();
				this.reviewIng_lookAt();
				this.notReviewed_edit();
				this.notReviewed_del();
				this.soldOut_lookAt();
				this.soldOut_edit();
				this.soldOut_shelves();
				this.deleted_edit();
				this.deleted_del();
				this.inventoryGoods_lookAt();
/*				this.inventoryGoods_edit();*/
				this.inventoryGoods_del();
			},
			initData:function(){//初始化
				obj[_obj].page=1;
				T.post(obj[_obj].url,obj[_obj],function(res){
					console.log(res);
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
				T.post(obj[_obj].url,obj[_obj],function(res){
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
						T.post(obj[_obj].url,obj[_obj],function(res){
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
					
					app.updateData();
				});
			},
			onSealing_soldOut:function(){//出售中-下架
				$(document).off('click','.onSealing ._sold_out').on('click','.onSealing ._sold_out',function(){
					var creativeResourceId=$(this).attr('data-id');
					T.post("/s/creativeResource/updateCreativeResourceOffShelf",{"creativeResourceId":creativeResourceId},function(res){
						if(res.retCode="10000"){
							app.initData();
						}
					});
				});
			},
			reviewIng_lookAt:function(){//审核中-查看
				$(document).off('click','.reviewIng ._look_at').on('click','.reviewIng ._look_at',function(){
					var creativeResourceId=$(this).attr('data-id');
					sessionStorage.setItem('creativeResourceId',creativeResourceId);
					$('.rightContentField').load('resources/html/front/recourseWarehouseDetail.html');
				});
			},
			notReviewed_edit:function(){//审核未通过-修改
				$(document).off('click','.notReviewed .edit').on('click','.notReviewed .edit',function(){
					var creativeResourceId=$(this).attr('data-id');
					sessionStorage.setItem('creativeResourceId',creativeResourceId);
					$('.rightContentField').load('resources/html/front/recourseRelease.html')
				});
			},
			notReviewed_del:function(){//审核未通过-删除
				$(document).off('click','.notReviewed .del').on('click','.notReviewed .del',function(){
					var creativeResourceId=$(this).attr('data-id');
					T.post('/s/creativeResource/updateCreativeResourceFalseDel',{'creativeResourceId':creativeResourceId},function(res){
						if(res.retCode=="10000"){app.initData();}
					});
				});
			},
			soldOut_lookAt:function(){//已下架-查看
				$(document).off('click','.soldOut ._look_at').on('click','.soldOut ._look_at',function(){
					var creativeResourceId=$(this).attr('data-id');
					sessionStorage.setItem('creativeResourceId',creativeResourceId);
					$('.rightContentField').load('resources/html/front/recourseWarehouseDetail.html');
				});
			},
			soldOut_edit:function(){//已下架-修改
				$(document).off('click','.soldOut .edit').on('click','.soldOut .edit',function(){
					var creativeResourceId=$(this).attr('data-id');
					sessionStorage.setItem('creativeResourceId',creativeResourceId);
					$('.rightContentField').load('resources/html/front/recourseRelease.html')
				});
			},
			soldOut_shelves:function(){//已下架-上架
				$(document).off('click','.soldOut .shelves').on('click','.soldOut .shelves',function(){
					var creativeResourceId=$(this).attr('data-id');
					T.post("/s/creativeResource/updateCreativeResourceOnShelf",{"creativeResourceId":creativeResourceId},function(res){
						if(res.retCode="10000"){
							app.initData();
						}
					});
					
				});
			},
			deleted_edit:function(){//已删除-修改
				$(document).off('click','.deleted .edit').on('click','.deleted .edit',function(){
					var creativeResourceId=$(this).attr('data-id');
					sessionStorage.setItem('creativeResourceId',creativeResourceId);
					$('.rightContentField').load('resources/html/front/recourseRelease.html')
				});
			},
			deleted_del:function(){//已删除-删除
				$(document).off('click','.deleted .del').on('click','.deleted .del',function(){
					var creativeResourceId=$(this).attr('data-id');
					T.post('/s/creativeResource/updateCreativeResourceFalseDel',{'creativeResourceId':creativeResourceId},function(res){
						if(res.retCode=="10000"){app.initData();}
					});
				});
			},
			inventoryGoods_lookAt:function(){//库存-查看
				$(document).off('click','.inventoryGoods ._look_at').on('click','.inventoryGoods ._look_at',function(){
					var id=$(this).attr('data-id');
						sessionStorage.setItem('creativeResourceId',id);
					$('.rightContentField').load('resources/html/front/purchaseDetails.html');
				});
			}/*,
			inventoryGoods_edit:function(){//库存-修改
				$(document).off('click','.inventoryGoods .edit').on('click','.inventoryGoods .edit',function(){
					
					$(this).parents('tr').find('.inventoryGoodsNumber').prop('contenteditable',true).focus();
				});
				$(document).off('click','.inventoryGoods .inventoryGoodsNumber').on('blur','.inventoryGoods .inventoryGoodsNumber',function(){
					var stockId=$(this).attr('data-id'),
						stockCount=$(this).html();
					T.post('/s/createResourceWarehouse/updateCreateResourceWarehouseCount',
								{'stockId':stockId,'stockCount':stockCount},function(res){
						if(res.retCode=='10000'){
							$(this).prop('contenteditable',false);
						}
					});
				})
			}*/,
			inventoryGoods_del:function(){//库存-添加
				$(document).off('click','.inventoryGoods .add').on('click','.inventoryGoods .add',function(){
					stockId=$(this).attr('data-id');
					resourceNumber=$(this).attr('data-num');
					T.post('/s/createResourceWarehouse/selectAllProject','',function(res){
						if(res.retCode=="10000"){
							$('#addMyShopping .proName').empty();
							$('#resources_proName_tmplate').tmpl(res.retObject).appendTo('#addMyShopping .proName');
							var projectId=$('#addMyShopping .proName').val();
							T.post('/s/createResourceWarehouse/selectAllTask',{"projectId":projectId},function(res){
								if(res.retCode=="10000"){
									var obj=res.retObject,
										html='';
										html+='<option value="null"></option>';
										$.each(obj,function(i,o){
											html+='<option value="'+o.projTaskId+'">'+o.projTaskName+'</option>';
										});
										
									$('#addMyShopping .taskName').empty()
									$(html).appendTo('#addMyShopping .taskName');
									$('#addMyShopping .addNum').attr('placeholder','当前资源库存数量:'+resourceNumber);
									$('#addMyShopping').modal('show');
								}else{
									$.alert('查询任务失败')
								}
							});
						}else{
							$.alert('查询项目失败')
						}
					});
					
				});
				
				$('#addMyShopping .proName').change(function(){
					T.post('/s/createResourceWarehouse/selectAllTask',{"projectId":$(this).val()},function(res){
						if(res.retCode=="10000"){
							var obj=res.retObject,
							html='';
							html+='<option value="null"></option>';
							$.each(obj,function(i,o){
								html+='<option value="'+o.projTaskId+'">'+o.projTaskName+'</option>';
							});
							$('#addMyShopping .taskName').empty()
							$(html).appendTo('#addMyShopping .taskName');
						}else{
							//$.alert('查询任务失败')
						}
					});
				})
				
					$('#addMyShopping .makeSure').bind('click',function(){
					if(T.isEmpty($('#addMyShopping .addNum').val())){
						$('#addMyShopping .addNum').css('border-color','red');
						$('#addMyShopping .msg-con').html('请填写数量').show();
						return false;
					}
					if($('#addMyShopping .addNum').val()>parseInt(resourceNumber)){
						$('#addMyShopping .addNum').css('border-color','red');
						$('#addMyShopping .msg-con').html('数量超过库存').show();
						return false;
					}else{
						$('#addMyShopping .msg-error').hide();
						var obj={
								  "projectId":$('#addMyShopping .proName').val(),
								  "projectTaskId":$('#addMyShopping .taskName').val(),
								  "stockId":stockId,
								  "number":$('#addMyShopping .addNum').val()
								}
						T.post('/s/createResourceWarehouse/insertResourseProjectPurchaseTask',obj,function(res){
							if(res.retCode=="10000"){
								$('#addMyShopping').modal('hide');
								$.alert("添加成功");
							}
						});
					}
				});
				$('#addMyShopping .addNum').keyup(function(){
					if(T.isEmpty($(this).val())){
						$(this).css('border-color','red');
						$('#addMyShopping .msg-con').html('请填写数量');
						$('#addMyShopping .msg-error').show();
						return false;
					}
					if($(this).val()>parseInt(resourceNumber)){
						$(this).css('border-color','red');
						$('#addMyShopping .msg-con').html('数量超过库存');
						$('#addMyShopping .msg-error').show();
						return false;
					}else{
						$('#addMyShopping .msg-error').hide();
						$(this).css('border-color','#ccc9c9');
					}
				});
			}
	}
	app.init();
});