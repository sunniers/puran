/*
 *	createTime:2016/11/14
 * 	author	  :caichao
 * 	
 */
$(function(){
	var data = {
			total:0,
			page : 1,
			pageSize :5
	}
	var app = {
			init:function(){
				this.initData();
				this.searchDeal();//查询
				this.initType();//初始化类型
			},
			initData:function(){	
				T.post('/s/deal/selectMyBargain',data,function(res){
					if(res.retCode=='10000'){
						console.log(res);
	        			obj = res.retObject;
	        			for(var i=0;i<obj.list.length;i++){
	        				obj.list[i].time=T.dateFormat(new Date(obj.list[i].time),"yyyy-MM-dd");
	        			}
	        			$('.tableContent .tableContents').children().remove();
	        			$('#myDeal_table_tmplate').tmpl(obj.list).appendTo('.tableContents');
	        			app.lookAt();
	        			app.page();
					}
				})
			},
			page:function(){
				$('#paginator').smartpaginator({
						totalrecords : obj.total,
						recordsperpage : data.pageSize,
						onchange : function(newPage) { // 修改起始页码 更新数据
								var currData = data;
								currData.page = newPage;
								T.post('/s/deal/selectMyBargain', currData, function(res) {
									console.log(res);
									var _obj = res.retObject;
									for(var i=0;i<_obj.list.length;i++){
					        			_obj.list[i].time=T.dateFormat(new Date(_obj.list[i].time),"yyyy-MM-dd");
					        		}
									$('.tableContents').children().remove();
							        $('#myDeal_table_tmplate').tmpl(_obj.list).appendTo('.tableContents');
							        app.lookAt();
								});
							}
						});
					},
			searchDeal:function(){	
				$('#dealBtn').unbind().bind('click',function(){
					var _data = {
							total:0,
							page : 1,
							pageSize :5,
							sign:$('#lookType option:selected').attr('data-id'),
							startTime:$('#startTime').val(),
							endTime:$('#endTime').val(),
							name:$('#dealName').val()
					}
					T.post('/s/deal/selectMyCommunity',_data,function(res){
						if(res.retCode=='10000'){
							console.log(res);
		        			obj = res.retObject;
		        			for(var i=0;i<obj.list.length;i++){
		        				obj.list[i].time=T.dateFormat(new Date(obj.list[i].time),"yyyy-MM-dd");
		        			}
		        			$('.tableContent .tableContents').children().remove();
		        			$('#myDeal_table_tmplate').tmpl(obj.list).appendTo('.tableContents');
		        			app.lookAt();
		        			//分页
		    				$('#paginator').smartpaginator({
		    						totalrecords : obj.total,
		    						recordsperpage : _data.pageSize,
		    						onchange : function(newPage) { // 修改起始页码 更新数据
		    								var currData = _data;
		    								currData.page = newPage;
		    								T.post('/s/deal/selectMyCommunity', currData, function(res) {
		    									console.log(res);
		    									var _obj = res.retObject;
		    									for(var i=0;i<_obj.list.length;i++){
		    					        			_obj.list[i].time=T.dateFormat(new Date(_obj.list[i].time),"yyyy-MM-dd");
		    					        		}
		    									$('.tableContents').children().remove();
		    							        $('#myDeal_table_tmplate').tmpl(_obj.list).appendTo('.tableContents');
		    							        app.lookAt();
		    								});
		    							}
		    						});				
						}
							})
						})
					},
					initType:function(){
						T.post('/s/deal/selectAllRequirementType','',function(res){
							console.log(res);
							if(res.retCode=='10000'){
								var html='<option value="">请选择</option>';
		                		for(var i=0;i<res.retObject[0].dictionarydatas.length;i++){
		                			html+='<option data-id="'+res.retObject[0].dictionarydatas[i].dataId+'">'+res.retObject[0].dictionarydatas[i].dataValue+'</option>';
		                		}
		                		$('#lookType').append(html);
							}
						})
					},
					lookAt:function(){
						var states = {
								'800001':'resources/html/front/demandDetail.html',
								'800002':'resources/html/front/recruitmentDetails.html',
								'800003':'resources/html/front/talentDetails.html',
								'800004':'resources/html/front/SaleDetails.html',
								'800005':'resources/html/front/purchaseDetails.html'
						}
						$('.tableContents button').unbind().bind('click',function(){
							var myDealId=$(this).attr('data-id');
							sessionStorage.setItem('id',myDealId);
							var myDealSign=$(this).attr('data-sign');
							$('.rightContentField').load(states[myDealSign]);
						})
					}
	}
	app.init();
})
