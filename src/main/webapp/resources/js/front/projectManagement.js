/*
 *	createTime:2016/11/23
 * 	author	  :caichao
 * 	 
 */
$(function(){
	var total=0,
		pageSize=10,
		page=1,
		orderBys='pr.proj_devlier_date',//
		ascs='',//asc desc
		name='';
	var data = {
			"entered":{'page':page,'pageSize':pageSize,'orderBys':'pr.proj_devlier_date','ascs':'','name':''},
			"noAccept":{'page':page,'pageSize':pageSize,'orderBys':'pr.proj_devlier_date','ascs':'','name':''},
			"conducting":{'page':page,'pageSize':pageSize,'orderBys':'pr.proj_devlier_date','ascs':'','name':''},
			"done":{'page':page,'pageSize':pageSize,'orderBys':'pr.proj_devlier_date','ascs':'','name':''}
	}
	var interfaces = {
			"entered":'/s/projectAdminstration/selectEnrollTrue',
			"noAccept":'/s/projectAdminstration/selectEnrollFalse',
			"conducting":'/s/projectAdminstration/selectRunningObj',
			"done":'/s/projectAdminstration/selectEndObj'
	}
	_tableClick="entered";
	var app = {
			init:function(){
				this.initData();
				this.tableClick();//内容切换
				this.orderBy();
				this.search();
			},
			initData:function(){//数据初始化
				ascs='';
				name='';
				data[_tableClick].ascs='';
				data[_tableClick].name='';
				data[_tableClick].page=1;
				//console.log(data[_tableClick].page);
				T.post(interfaces[_tableClick],data[_tableClick],function(res){
					if(res.retCode=='10000'){
						console.log(res);
						var obj = res.retObject;
							app.appendList(obj.list);
							app.bindClick();
							app.page();
					}
				})
			},
			refreshData:function(){//用于分页器刷新数据
				T.post(interfaces[_tableClick],data[_tableClick],function(res){
					if(res.retCode=='10000'){
						console.log(res);
						var obj = res.retObject;
						app.appendList(obj.list);
						app.bindClick();
					}
				})
			},
			
			page:function(){//分页器
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :pageSize,
					onchange : function(newPage) {
						page=newPage;
						data[_tableClick].page=newPage;
						app.refreshData();
					}
				});
			},
			
			
			appendList:function(_obj){//动态加载dom
				$.each(_obj,function(i,o){
					T.isEmpty(o.projCloseDate)?o.projCloseDate=null:o.projCloseDate=T.dateFormat(new Date(o.projCloseDate),'yyyy-MM-dd');
					T.isEmpty(o.projDevlierDate)?o.projDevlierDate=null:o.projDevlierDate=T.dateFormat(new Date(o.projDevlierDate),'yyyy-MM-dd');
					T.isEmpty(o.projectRealEndDate)?o.projectRealEndDate=null:o.projectRealEndDate=T.dateFormat(new Date(o.projectRealEndDate),'yyyy-MM-dd');
				});
				$('.'+_tableClick+' tbody').children().remove();
				$('#projectManagement_'+_tableClick+'_template').tmpl(_obj).appendTo($('.'+_tableClick+' tbody'));
			},
			
			
			tableClick:function(){//内容切换
				$('.investment_con .investment_con_list').hide();
				$('.investment_con .entered').show();
				$('.investment_title>div').unbind().bind('click',function(){
					var tableClick = $(this).attr('data-id');
					_tableClick = tableClick;
					
					$('.investment_title>div').removeClass('on');
					$(this).addClass('on');
					
					$('.investment_con .investment_con_list').hide();
					$('.investment_con .'+tableClick+'').show();
					$('.borderInves .conducting .doneTimeSort .up').attr('src','resources/images/front/triangleUp.png');
					$('.borderInves .conducting .doneTimeSort .down').attr('src','resources/images/front/triangleDown.png');
					app.initData();
				})
			},
			orderBy:function(){
				$('.borderInves .conducting .doneTimeSort')
							.bind('click',function(){
					if(!$(this).find('img').hasClass('focus')){
						$(this).find('.up').addClass('focus')
							.attr('src','resources/images/front/triangleUpFocus.png');
							data[_tableClick].ascs='asc';
							data[_tableClick].name=name;
					}else{
						if($('.focus').hasClass('up')){
							$(this).find('.up').removeClass('focus')
								.attr('src','resources/images/front/triangleUp.png');
							$(this).find('.down').addClass('focus')
							.attr('src','resources/images/front/triangleDownFocus.png');
							data[_tableClick].ascs='desc';
							data[_tableClick].name=name;
						}else{
							$(this).find('.down').removeClass('focus')
								.attr('src','resources/images/front/triangleDown.png');
							$(this).find('.up').addClass('focus')
								.attr('src','resources/images/front/triangleUpFocus.png');
							data[_tableClick].ascs='asc';
							data[_tableClick].name=name;
						}
					}
					app.refreshData();
				});
			},
			search:function(){
				$('.investment_title .sosoSub').bind('click',function(){
					name	=	$('.investment_title .soSo').val();
					data[_tableClick].name=name;
					app.refreshData();
				});
				
			},
			bindClick:function(){//用于绑定click事件--主要用于动态生成的数据
				/*
				 * 已报名-查看
				 * 未接纳-查看
				 * 已完成-查看
				 * */
				$('.investment_con .entered  .checked,.investment_con .noAccept	.checked,.investment_con .done	.checked')
					.unbind().bind('click',function(){
						app.checked($(this).attr('data-id'));
				});
				/*
				 * 已报名-取消报名
				 */
				$('.investment_con .entered  .cancelApply')
					.unbind().bind('click',function(){
						app.cancelApply($(this).attr('data-id'));
				});
				/*
				 * 进行中-团队
				 */
				$('.investment_con .conducting  .team')
					.unbind().bind('click',function(){
						app.team($(this).attr('data-id'));
				});
				/*
				 * 进行中-需求
				 */
				$('.investment_con .conducting  .demand')
					.unbind().bind('click',function(){
						app.demand($(this).attr('data-id'));
				});
				/*
				 * 进行中-分包
				 */
				$('.investment_con .conducting  .subcontract')
					.unbind().bind('click',function(){
						app.subcontract($(this).attr('data-id'));
				});
				/*
				 * 进行中-进度
				 */
				$('.investment_con .conducting  .progress')
					.unbind().bind('click',function(){
						app.progress($(this).attr('data-id'));
				});
				/*
				 * 进行中-变更
				 */
				$('.investment_con .conducting  .change')
					.unbind().bind('click',function(){
						app.change($(this).attr('data-id'));
				});
				/*
				 * 进行中-采购
				 */
				$('.investment_con .conducting  .purchase')
					.unbind().bind('click',function(){
						app.purchase($(this).attr('data-id'));
				});
				/*
				 * 已完成-评论
				 */
				$('.investment_con .done  .discuss')
					.unbind().bind('click',function(){
						app.purchase($(this).attr('data-id'));
				});
				
				
				
			},
			checked:function(id){
				sessionStorage.setItem('id',id);
				$('.rightContentField').load('resources/html/front/demandDetail.html');
				
			},
			cancelApply:function(id){
				$.alert({
					body: '是否取消报名？',
					okBtn : '确定',
					cancelBtn : '取消',
					okHidden:function(){
						T.post('/s/enroll/deleteProjectEnroll',
								{'projectRequirementId':id},function(res){
							console.log(res);
							if(res.retCode=='10000'){
								app.initData();
							}else{
								
							}
						});
					}
				})
				
			},
			team:function(id){
				T.post('/s/enroll/deleteProjectEnroll',{},function(res){
					
				});
			},
			demand:function(){
				
			},
			subcontract:function(){
				
			},
			progress:function(){
				
			},
			change:function(){
				
			},
			purchase:function(){
				
			},
			discuss:function(){
				
			}
	}
	app.init();
})
