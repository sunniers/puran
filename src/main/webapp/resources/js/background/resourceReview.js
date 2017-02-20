/*
 *	createTime:2016/11/7
 * 	author	  :Chenxl
 * 	edit	  :
 * 
 */
$(function(){
	var total=0,
		start=1,
		size=5,//默认分页参数
		searchVal=null;
	var obj={
			'resAudit':{//待审核
				"page":start,"pageSize":size,"sign":"未审核","resourceName":searchVal
			},
			'resChecked':{//已审核
				"page":start,"pageSize":size,"sign":"已审核","resourceName":searchVal
			}
	}
	var _obj='resAudit';//中间变量
	var app={
			init:function(){
				this.initData();
				//this.updataData();
				this.search();
				this.review();
				this.tableSwitch();
				
			},
			initData:function(){
				obj[_obj].page=1;//初始化
				obj[_obj].resourceName=searchVal;
				T.post('/s/resource_audit/find',obj[_obj],function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var o = res.retObject.list;
						$.each(o,function(index,ele){
							ele.publishDatetime=T.dateFormat(new Date(ele.publishDatetime),'MM-dd');
							ele.auditDatetime=T.dateFormat(new Date(ele.auditDatetime),'MM-dd');
						});
						$('.resourceReviewData table tbody').children().remove();
						$('#auditing_'+_obj+'_tmplate').tmpl(o).appendTo($('.'+_obj));
						$('.'+_obj).show();
						app.page();
					}
				})
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
			//搜索
			search:function(){
				$('#search').unbind().bind('click',function(){
					searchVal=$('#searchVal').val();
					app.initData();
				});
			},
			review:function(){//查看、审核
				$(document).on('click','.resAuditing',function(){
					var resourceId=$(this).attr('data-id');
					sessionStorage.setItem('resourceId',resourceId);
					$('.rightContentField').load('resourceReviewReview.html');
				});
			},
			//table切换
			tableSwitch:function(){
				$(".resourceReview .resourceSearchTitle .t").bind('click',function(){
					var clickObj=$(this).attr('data-attr');
						_obj=clickObj;
					/*切换效果*/
					$(".resourceReview .resourceSearchTitle .t").removeClass('active');
					$(this).addClass("active");
					$(".resourceReviewData .sui-table").hide();
					$('.resourceReviewData .'+clickObj+'').show();
					app.initData();
				});
			},
	}
	app.init();
})