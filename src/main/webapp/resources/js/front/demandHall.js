/*
 *	createTime:2016/11/10
 * 	author	  :Luyi
 * 	
 * 
 */
$(function(){
	var start=1,
		size=3,
		total=0;
	
	var feeDic={//金额字典表
			'100301':{'minFee':null,'maxFee':1000},
			'100302':{'minFee':1000,'maxFee':5000},
			'100303':{'minFee':5000,'maxFee':10000},
			'100304':{'minFee':10000,'maxFee':50000},
			'100305':{'minFee':50000,'maxFee':null}
		}
	
	var goPage={
			"100201":'../resources/html/front/recruitmentDetails.html',
			"100202":'../resources/html/front/demandDetail.html',
			"100203":'../resources/html/front/financingDetail.html'
		}
	
	
	var postData={//传回后台的参数
			name:'',
			dictionarydatas:[],
			projType2:[],
			minFee:'',
			maxFee:'',
			page:start,
			pageSize:size,
			orderBys:'',
			ascs:'',
	}
	
	var app={
			init:function(){
				this.initSearchCondition();
				this.initData();
				this.slide();
				this.orderBy();
				this.searchByName();
			},
	
			initSearchCondition:function(){//初始化搜索条件
				T.get('/s/getRequirement/selectDictionary','',function(res){
//					console.log(res);
					if (res.retCode=="10000") {
						var upList=res.retObject;
						$('#upConditions').children().remove();
						$('#search_condition_template').tmpl(upList).appendTo('#upConditions');
						app.clickCondition();
					}
				});
			},
			
			initData:function(){//初始化数据
				T.post('/s/getRequirement/selectRequirement',postData,function(res){
					console.log(res);
					if(res.retCode=="10000"){
						var obj=res.retObject.list;
							total=res.retObject.total;
						for(var i=0;i<obj.length;i++){
							if((obj[i].projCloseDate-new Date())>0){
								obj[i].projCloseDate=T.dateDiff(obj[i].projCloseDate);
							}else{
								obj[i].projCloseDate="0天0小时0分0秒";
							}
							
							obj[i].createDatetime=T.dateFormat(new Date(obj[i].createDatetime),'yyyy-MM-dd hh:mm:ss.S');
							obj[i].projServiceFee=T.fmtNumber(obj[i].projServiceFee,'#,###.##');
						}
						$('.searchInfo').empty();
						$('#demand_hall_template').tmpl(obj).appendTo($('.searchInfo'));
						app.page();
						app.demandDetail();
					}
				});
			},
			updateData:function(){//刷新分页的数据
				postData.page=start;
				T.post('/s/getRequirement/selectRequirement',postData,function(res){
					if(res.retCode=="10000"){
						var obj=res.retObject.list;
						for(var i=0;i<obj.length;i++){
							if((obj[i].projCloseDate-new Date())>0){
								obj[i].projCloseDate=T.dateDiff(obj[i].projCloseDate);
							}else{
								obj[i].projCloseDate="0天0小时0分0秒";
							}
							obj[i].createDatetime=T.dateFormat(new Date(obj[i].createDatetime),'yyyy-MM-dd hh:mm:ss.S');
							obj[i].projServiceFee=T.fmtNumber(obj[i].projServiceFee,'#,###.##');
						}
						console.log(obj);
						$('.searchInfo').empty();
						$('#demand_hall_template').tmpl(obj).appendTo($('.searchInfo'));
						app.demandDetail();
					}
				});
			},
			page:function(){
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :size,
					onchange : function(newPage) {
						start=newPage;
						app.updateData();
					}
				});
			},
			slide:function(){//显示隐藏筛选框
				var flag = "show";
				$(".collapseBtn").bind("click", function(){
					$(".conditions").slideToggle("fast",function(){
						flag == "show"?flag="hide":flag="show";
						if(flag=="show"){
							$(".collapseBtn span").html("隐藏筛选");
							$(".collapseBtn img").attr("src","resources/images/front/slide.png");
						}else{
							$(".collapseBtn span").html("显示筛选");
							$(".collapseBtn img").attr("src","resources/images/front/show.png");
							}
						});
					});
			},
			clickCondition:function(){//设置点击变色效果
				$(".conditions .span7:eq(0) span,.conditions .span7:eq(1) span").bind("click",function(){
					$(this).toggleClass("active");
					app.getDicData();
				})
				
				$(".conditions .span7:eq(2) span").bind("click",function(){
					$(this).toggleClass("active");
					$(this).siblings().removeClass('active');
					app.getDicData();
				})
			},
			getDicData:function(){
				app.getConData();
				
				//点击条件初始化排序
				$('.rank img').removeClass('focus').removeClass('blur').addClass('blur');
				$('.rank').find('.up').attr('src','resources/images/front/triangleUp.png');
				$('.rank').find('.down').attr('src','resources/images/front/triangleDown.png');
				console.log(postData);
				app.initData();
			},
			
			orderBy:function(){//点击切换上下按钮
				$(".rank").bind("click", function(){
					var domCurr=$(this);
					app.switchEffect(domCurr);
					app.getConData();
					postData.orderBys=domCurr.attr('data-id');//获取排序字段
					if(domCurr.find('img.focus').hasClass('up')){//获取排序方式
						postData.ascs='asc';
					}else{
						postData.ascs='desc';
					}
					console.log(postData);
					app.initData();
					});
			},
			switchEffect:function(dom){
				if(dom.find('.up').is('.focus')){
					$('.rank img').removeClass('focus').removeClass('blur').addClass('blur');
					dom.find('.down').removeClass('blur').addClass('focus');
					$('.rank').find('.up').attr('src','resources/images/front/triangleUp.png');
					$('.rank').find('.down').attr('src','resources/images/front/triangleDown.png');
					dom.find('.up').attr('src','resources/images/front/triangleUp.png');
					dom.find('.down').attr('src','resources/images/front/triangleDownFocus.png');
				}else{
					$('.rank img').removeClass('focus').removeClass('blur').addClass('blur');
					$('.rank').find('.up').attr('src','resources/images/front/triangleUp.png');
					$('.rank').find('.down').attr('src','resources/images/front/triangleDown.png');
					dom.find('.up').removeClass('focus').removeClass('blur').addClass('focus');
					dom.find('.up').attr('src','resources/images/front/triangleUpFocus.png');
					dom.find('.down').attr('src','resources/images/front/triangleDown.png');
				}
			},
			getConData:function(){
				postData.dictionarydatas=[];
				postData.projType2=[];
				postData.minFee='';
				postData.maxFee='';
			
				$(".demandClass span.active").each(function(index,dom){
					postData.dictionarydatas.push($(this).attr('data-id'));
				})
				$(".demandType span.active").each(function(index,dom){
					postData.projType2.push($(this).attr('data-id'));
				})
				$(".demandFee span.active").each(function(index,dom){
					postData.minFee=feeDic[$(this).attr('data-id')]['minFee'];
					postData.maxFee=feeDic[$(this).attr('data-id')]['maxFee'];
				})
				postData.orderBys='';
				postData.ascs='';
				postData.name=$('#search').val();
			},
			
			
			searchByName:function(){
				$('.cSearch img').bind("click",function(){
					//点击条件初始化排序
					$('.rank img').removeClass('focus').removeClass('blur').addClass('blur');
					$('.rank').find('.up').attr('src','resources/images/front/triangleUp.png');
					$('.rank').find('.down').attr('src','resources/images/front/triangleDown.png');
					postData.name=$('#search').val();
					console.log(postData);
					app.initData();
				})
			},
			
			demandDetail:function(){//需求大厅详情
				$('.demandHall .ml .mUp').bind('click',function(){
					statue = $(this).parent().attr('data-status');
					demandId = $(this).parent().attr('data-id');
					sessionStorage.setItem("id", demandId);
					T.load('.rightContentField',goPage[statue]);
				})
			}
	}
	
	app.init();
})