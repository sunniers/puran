/*
 *	createTime:2016/11/21 
 * 	author	  :Chenxl
 * 	edit	  :
 * 
 */
$(function(){
	var total=0,
		start=1,
		size=12,//分页默认参数
		searchVal=null
		
	var obj={
			'Audit':{//待审核
				"page":start,"pageSize":size,"projName":searchVal},
			'Checked':{//已审核
				"page":start,"pageSize":size,"projName":searchVal,
						"sign" :'已审核'}
		}
	
	var _obj='Audit';//中间变量
	var app={
			init:function(){
				this.initData();
				this.search();
				this.review();//审核
				this.tableSwitch();//table切换
				//this.updateData();
			},
			initData:function(){
				obj[_obj].page=1;//初始化
				obj[_obj].projName=searchVal;
				T.post('/s/req_audit/find',obj[_obj],function(res){
					console.log(res);
					if(res.retCode=='10000'){
						total=res.retObject.total;//初始化总页数
						var o=res.retObject.list;
						$.each(o,function(index,ele){
							ele.createDatetime=T.dateFormat(new Date(ele.createDatetime),'MM-dd');
							ele.auditDateTime=T.dateFormat(new Date(ele.auditDateTime),'MM-dd');
						});
						$('.needReviewData table tbody').children().remove();
						$('#auditing_'+_obj+'_tmplate').tmpl(o).appendTo($('.'+_obj));
						$('.'+_obj).show();
						app.page();
					}
				})
			},
			//更新数据
			updataData:function(){
				T.post('/s/req_audit/find',obj[_obj],function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var o = res.retObject.list;
						$.each(o,function(index,ele){
							ele.createDatetime=T.dateFormat(new Date(ele.createDatetime),'MM-dd');
							ele.auditDateTime=T.dateFormat(new Date(ele.auditDateTime),'MM-dd');
						});
						$('.needReviewData table tbody').children().remove();
						$('#auditing_'+_obj+'_tmplate').tmpl(o).appendTo($('.'+_obj));
						$('.'+_obj).show();
						
					}
				})
			
			},
			//搜索
			search:function(){
				$('#search').unbind().bind('click',function(){
					searchVal=$('#searchVal').val();
					app.initData();
				});
			},
			page:function(){
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :size,
					onchange : function(newPage) {
						start=newPage;
						obj[_obj]["page"]=start;
						app.initData();
					}
				});
			},
			review:function(){//审核、查看
				$(document).on('click','.review',function(){
					var requirementType=$(this).attr('data-type');
					var projId=$(this).attr('data-id');
					sessionStorage.setItem('projId',projId);
					sessionStorage.setItem('requirementType',requirementType);
					$('.rightContentField').load('needReviewReview.html');
				});
			},
			//table切换
			tableSwitch:function(){
				$(".needReview .needSearchTitle .t").bind('click',function(){
					var clickObj=$(this).attr('data-attr');
						_obj=clickObj;
					/*切换效果*/
					$(".needReview .needSearchTitle .t").removeClass('active');
					$(this).addClass("active");
					$(".needReviewData .sui-table").hide();
					$('.needReviewData .'+clickObj+'').show();
					app.initData();
				});
			},
			
		}
	app.init();
})