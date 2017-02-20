/*
 *	createTime:2016/11/21
 * 	author	  :caichao
 * 	
 * 
 */
$(function(){
	var projTaskId = sessionStorage.getItem('projTaskId');
	var data = {
			"page":1,
			"pageSize":7,
			"projTaskId":projTaskId
	}
	var app = {
			init:function(){
				this.initData();
				this.addPurchase();//添加
				this.purchase();//采购
			},
			initData:function(){
				T.post('/s/task/selectPurchase',data,function(res){
					if(res.retCode=='10000'){
						console.log(res);
						var obj = res.retObject;
						for(var i=0;i<obj.list.length;i++){
							obj.list[i].index=i+1;
						}
						$('table tbody').children().remove();
						$('#taskPurchase_table_tmplate').tmpl(obj.list).appendTo('table tbody');
						app.lookAt();//查看
						app.moveTo();//移到库存
						$('#paginator').smartpaginator({
							totalrecords : obj.total,
							recordsperpage : data.pageSize,
							onchange : function(newPage) { // 修改起始页码 更新数据
									var currData = data;
									currData.page = newPage;
									T.post('/s/task/selectPurchase', currData, function(res) {
										console.log(res);
										var _obj = res.retObject;
										for(var i=0;i<_obj.list.length;i++){
											_obj.list[i].index=i+1+(newPage-1)*data.pageSize;
										}
										$('table tbody').children().remove();
										$('#taskPurchase_table_tmplate').tmpl(_obj.list).appendTo('table tbody');
								        app.lookAt();//查看
								        app.moveTo();//移到库存
									});
								}
							});
					}
				})
			},
			addPurchase:function(){
				$('.header .addPurchase').unbind().bind('click',function(){
					$('.rightContentField').load('../resources/html/front/resourceWarehouse.html')
				})
			},
			purchase:function(){
				$('.header .purchase').unbind().bind('click',function(){
					$('.rightContentField').load('../resources/html/front/myBuyResources.html')
				})
			},
			lookAt:function(){
				$('table tbody .lookAt').unbind().bind('click',function(){
					var projectPurchaseId = $(this).parent().attr('data-id');
					console.log(projectPurchaseId);
					sessionStorage.setItem('id',projectPurchaseId);
					$('.rightContentField').load('../resources/html/front/purchaseDetails.html')
				})
			},
			moveTo:function(){
				$('table tbody .moveTo').unbind().bind('click',function(){
					var projectPurchaseId = $(this).parent().attr('data-id');
					var purchaseCount = $(this).attr('data-count');
					var moveData = {
							"purchaseCount":purchaseCount,
							"projectPurchaseId":projectPurchaseId
					}
					T.post('/s/task/updatePurchase',moveData,function(res){
						if(res.retCode=='10000'){
							console.log(res);
							$.alert({
							      body: '成功移到库存！',
							      height: 100
							    });
						}
					})
				})
			}
	}
	app.init();
})
