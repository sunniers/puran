/*
 *	createTime:2016/11/22
 * 	author	  :LUYI
 * 	edit	  :
 * 
 */
$(function(){
	var start=1,
		size=8,
		total=0;
	
	var postData={//传回后台的参数
			page:start,
			pageSize:size,
			name:'',
			startTime:'',
			endTime:''
		}
	
	var goHtml={
			"700001":'backDemandDetail.html',  //需求
			"700002":'backTalentDetail.html',  //人才
			"700005":'backResourceDetail.html'   //资源
		}
	
	var app = {
			init : function(){
				this.initData();//初始化数据
				this.searchByConditions();//根据条件查询
			},
		
			review : function(){//供需信息详情
				$('#supplyDemandtableData .reviewSup').unbind().bind('click', function(){
					signId = $(this).parent().attr('data-status');
					id = $(this).parent().attr('data-id');
					console.log(id);
					sessionStorage.setItem("id", id);
					T.load('.rightContentField',goHtml[signId]);
				});
			},
		
			initData:function(){//初始化数据
				T.post('/s/deal/findBy',postData,function(res){
					console.log(res);
					console.log(postData);
					if (res.retCode=='10000') {
						total=res.retObject.total;
						var infoList=res.retObject.list;
						for(var i=0;i<infoList.length;i++){
							infoList[i].time=T.dateFormat(new Date(infoList[i].time),"yyyy-MM-dd");
	        			}
						$('#supplyDemandtableData tbody').empty();
						$('#supply_demandinfo_template').tmpl(infoList).appendTo('#supplyDemandtableData');
						app.review();
					}else{
						
					}
				})
			},
			
			searchByConditions:function(){//根据条件查询
				$('#search').unbind().bind('click',function(){
					postData.name=$('#name').val();
					postData.startTime = $('#startTime').val();
					postData.endTime = $('#endTime').val();
					app.initData();
				});
			
			}
		}
	app.init();
})