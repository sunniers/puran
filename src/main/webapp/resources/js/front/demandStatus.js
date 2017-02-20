/*
 *	createTime:2016/11/18
 * 	author	  :Tangj
 * 	
 * 
 */
$(function(){
	var tabIndex='all';//处于选中状态的标签页-默认为全部
	var status={	//状态码
			all:'',//全部	
			examine:'400101',//审核中
			release:'400102',//已发布
			deal:'400103',//已成交
			releaseFail:'400104'//发布失败
	}
	var objActive={	//请求参数
			page:1,
			total:0,
			pageSize:10,
			orderBy:'',//排序字段create_datetime/enroll/proj_flow_status
			asc:'',	   //排序方式asc/desc
			search:'',	//搜索条件
			requirementStatus:''
		}

	var postUrl={	//列表数据接口对象

			all:'/s/requirementManage/selectRequirementManage',//全部	
			examine:'/s/requirementManage/selectRequirementManage',//审核中
			release:'/s/requirementManage/selectRequirementManage',//已发布
			deal:'/s/requirementManage/selectRransactionEnd',//已成交
			releaseFail:'/s/requirementManage/selectRequirementManage'//发布失败
			
		}
	
	var viewUrl={//页面查看操作跳转
			'400101':{'700001':'resources/html/front/demandStatusView.html',
						'700002':'resources/html/front/recruitmentDetails.html'},//审核中-查看
			'400102':{'700001':'resources/html/front/demandDetail.html',
				  		'700002':'resources/html/front/recruitmentDetails.html'},//已发布
			'400103':{'700001':'resources/html/front/demandDetail.html',
		  				'700002':'resources/html/front/recruitmentDetails.html'},//已成交
			'400104':{'700001':'resources/html/front/demandStatusView.html',
						'700002':'resources/html/front/recruitmentDetails.html'}//发布失败
		}
	
	var otherUrl={	//其他操作的URL
			'trustShip':'resources/html/front/demandStatusTrustShip.html',//酬金托管
			'edit':'resources/html/front/demandStatusEdit.html',//修改
			'recommend':'resources/html/front/demandStatusRecommend.html',//推荐
			'cover':'resources/html/front/demandStatusCover.html'//自荐
		}
	
	
	var app={
			
			init:function(){
				this.tabSwitch();
				this.rank();
				this.initData();
				this.search();
			},
			
			/*页面切换控制器*/
			tabSwitch:function(){
				
				$('.demandStatus ul li').bind('click',function(){
					var that=$(this);
					
						tabIndex=that.attr('data-id');//改变处于选中状态的标签页
						
						app.initPostData();//初始化入参
						app.initClass();//初始化排序
						app.initSearchInput();//初始化搜索框
						app.switchAffect(that);//效果处理
						
						app.initData();//初始化各个页面数据
				});
				
			},
			initPostData:function(){
				
					objActive.page=1;
					objActive.requirementStatus=status[tabIndex];
					objActive.page=1;
					objActive.total=0;
					objActive.pageSize=10;
					objActive.orderBy='';
					objActive.asc='';
					objActive.search='';
					
			},
			/*
			 * 初始化排序样式
			 */
			initClass:function(){
					$('.demandStatus .boxheader .rank').find('img').removeClass('focus');
					$('.demandStatus .boxheader .rank').find('.up').attr('src','resources/images/front/triangleUp.png');
					$('.demandStatus .boxheader .rank').find('.down').attr('src','resources/images/front/triangleDown.png');
			},
			/*
			 * 初始化搜索框
			 */
			initSearchInput:function(){
				$('.demandStatus .boxheader .searchInput input').val('');	
			},
			/*
			 * tab标签切换效果处理、对应内容展示、排序及搜索框初始化
			 */
			switchAffect:function(that){
				
				//tab标签效果
				$('.demandStatus ul li').removeClass();
				that.addClass('on');
				
				//页面显示切换
				$('.demandStatus .box').hide();
				$('.'+tabIndex).show();
				
			},
			/*
			 * 排序
			 */
			rank:function(){
		
				/*
				 * 排序切换
				 */
				$('.demandStatus .boxheader .rank').bind('click',function(){
					if($(this).find('img').is('.focus')){
						if($(this).find('.focus').is('.up')){//降序
							
							app.initClass();
							$(this).find('.down').addClass('focus')
								.attr('src','resources/images/front/triangleDownFocus.png');
							app.rankData($(this).attr('data-id'),'desc');//降序
							
						}else{//升序
							
							app.initClass();
							$(this).find('.up').addClass('focus')
								.attr('src','resources/images/front/triangleUpFocus.png');
							app.rankData($(this).attr('data-id'),'asc');//升序
						}
					}else{//默认升序
						
							app.initClass();
							$(this).find('.up').addClass('focus')
								.attr('src','resources/images/front/triangleUpFocus.png');
							app.rankData($(this).attr('data-id'),'asc');//升序
					}
					app.updateData();
				});
			},
			/*
			 * 排序数据组织
			 */
			rankData:function(order,asc){
					
					objActive.orderBy=order||objActive.orderBy;
					objActive.asc=asc||objActive.asc;
					objActive.search=$('.demandStatus .searchInput input').val();
					
			},
			/*
			 * 初始化页面数据
			 */
			initData:function(){
				T.post(postUrl[tabIndex],objActive,function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var o=res.retObject.list;
							objActive.total=res.retObject.total;
							app.dataList(o);
							app.page();
					}
				})
			},
			/*
			 *数据处理
			 */
			dataList:function(o){
				
				app.dateFormat(o);
				
				$('.'+tabIndex+' .boxConent').empty();
				$('#demandStatus_'+tabIndex+'_tmplate').tmpl(o).appendTo('.'+tabIndex+' .boxConent');
				app.handle();
			},
			/*
			 * 时间格式化处理
			 */
			dateFormat:function(o){
				$.each(o,function(i,e){
					e.createDatetime=T.dateFormat(new Date(e.createDatetime),'yyyy-MM-dd');
				});
			},
			/*
			 * 单独为分页器设定的数据刷新
			 */
			updateData:function(){
				T.post(postUrl[tabIndex],objActive,function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var o=res.retObject.list;
							app.dataList(o);	
					}
				})
			},
			/*
			 * 分页器
			 */
			page:function(){
				$('.demandStatus #paginator').smartpaginator({
					totalrecords :objActive.total,
					recordsperpage :objActive.pageSize,
					onchange : function(newPage) {
						app.initPostData();
						app.initClass();//初始化排序
						objActive.search=$('.demandStatus .searchInput input').val();
						objActive.page=newPage;
						app.updateData();
					}
				});
			},
			/*
			 * 模糊查询
			 */
			search:function(){
				
				$('.demandStatus .searchInput img').bind('click',function(){
					app.initPostData();
					objActive.search=$('.demandStatus .searchInput input').val();
					app.initData();
				});
				
				
			},
			
			/*
			 * 所有页面的操作事件绑定
			 */
			handle:function(){
				
				$('.demandStatus .box button').unbind().bind('click',function(){
					
					var status	=	$(this).attr('data-status'),
						code	=   $(this).attr('data-code'),
					 	id		=	$(this).attr('data-id'),
						type	=	$(this).attr('data-type');
						sessionStorage.setItem('id',id);
					if(type == 'view'){	//查看操作
						$('.rightContentField').load(viewUrl[status][code]);
					}
					
					
					else if(type == 'trustShip'){	//酬金托管
						$('.rightContentField').load(otherUrl[type]);
					}
					
					
					else if(type == 'evaluate'){	//评价
						$('#demandStatusEvaluate').modal('show');
						T.post('/s/requirementManage/selectProjectUserReleation',{"projectRequirementId":id},function(res){
							console.log(res);
							if(res.retCode=="10000"){
								$('#demandStatusEvaluate .userName').html(res.retObject.userName);
								$('#demandStatusEvaluate .projectDuty').html(res.retObject.projectDuty);
								$('#demandStatusEvaluate .userName').attr('data-userId',res.retObject.userId);
								$('#demandStatusEvaluate .userName').attr('data-projId',id);
							}
						});
					}
					
					
					else if(type == 'edit'){	//修改
						$('.rightContentField').load(otherUrl[type]);
					}
					
					
					else if(type == 'del'){	//删除
						T.post('/s/requirementManage/deleteRequirement',
								{'requirementType':code,'requirementId':id},function(res){
									console.log(res);
									if(res.retCode=='10000'){
										app.initData();
									}
								});
					}
					
				});
				
				$('.demandStatus .box .recommend').unbind().bind('click',function(){//推荐
					var status	=	$(this).attr('data-status'),
						code	=   $(this).attr('data-code'),
					 	id		=	$(this).attr('data-id'),
						type	=	$(this).attr('data-type');
						sessionStorage.setItem('id',id);
						sessionStorage.setItem('type',code);
						$('.rightContentField').load(otherUrl[type]);
				})
				
				$('.demandStatus .box .cover').unbind().bind('click',function(){//自荐
					var status	=	$(this).attr('data-status'),
						code	=   $(this).attr('data-code'),
					 	id		=	$(this).attr('data-id'),
						type	=	$(this).attr('data-type');
						sessionStorage.setItem('id',id);
						sessionStorage.setItem('type',code);
						$('.rightContentField').load(otherUrl[type]);
					
				})
				
				$('#demandStatusEvaluate .evaStar img').unbind().bind('click',function(){//评价-打分
					var i=parseInt($(this).attr('data-id'));
					$('#demandStatusEvaluate .evaStar img').removeClass('focus').attr('src','resources/images/front/starBlur.png');
						for(i;i>0;i--){
							$('#demandStatusEvaluate .evaStar [data-id="'+i+'"]').addClass('focus').attr('src','resources/images/front/starFocus.png');
						}
				});
				
				$('#demandStatusEvaluate .makeSure').unbind().bind('click',function(){//评价提交
					var userId=$('#demandStatusEvaluate .userName').attr('data-userId'),
						projId=$('#demandStatusEvaluate .userName').attr('data-projId'),
						starLength=$('#demandStatusEvaluate .evaStar').find('.focus').length;
					
					T.post('/s/evaluate/insertCreativeTalentEvaluate',
							{"projId":projId,"userId":userId,"evaluateStar":starLength},
							function(res){
								$('#demandStatusEvaluate').modal('hide');
								app.initData();
					});
				});
			}
	}
	
	app.init();
})