/*
 *	createTime:2016/11/18
 * 	author	  :Luyi
 * 	
 * 
 */
$(function() {
	var start=1,
		size=12,
		total=0;
	
	var postData = {//传到后台的参数"
				orderBys: '',
				ascs: '',
				page: start,
				pageSize: size,
				classifierValueArray: [],
				resourceName: '',
			}
	
	var app = {
			init:function(){
				this.initSearchConData();//初始化搜索条件
				this.initAllData();//初始化数据
				this.slide();//显示隐藏筛选框
				this.clickOrder();//点击切换上下按钮
				this.searchByResourceName();//根据name查询
			},
			
			initSearchConData:function(){//初始化搜索条件
				T.post('/s/creativeResource/selectCreativeResourceType','',function(res){
					console.log(res);
					if (res.retCode=="10000") {
						var searchData=res.retObject;
						$('#searchCon').children().remove();
						$('#search_con_template').tmpl(searchData).appendTo('#searchCon');
						app.clickResultUp();
					}
				})
			},
			
			initAllData:function(){//初始化数据
				T.post('/s/creativeResource/selectAllCreativeResourceFront',postData,function(res){
					console.log(res);
					if (res.retCode=="10000") {
						var obj=res.retObject.list;
						total=res.retObject.total;
						$('.creativeResource .resourceField').empty();
						$('#creative_resource_template').tmpl(obj).appendTo($('.resourceField'));
						app.page();
						app.createResDetail();
					}
				})
			},
			
			page:function(){//设置分页
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :size,
					onchange : function(newPage) {
						start=newPage;
						app.updatePageData();
					}
				});
			},
			
			updatePageData:function(){//刷新分页的数据
				postData.page=start;
				T.post('/s/creativeResource/selectAllCreativeResourceFront',postData,function(res){
					if(res.retCode=="10000"){
						var obj=res.retObject.list;
						total=res.retObject.total;
						$('.creativeResource .resourceField').empty();
						$('#creative_resource_template').tmpl(obj).appendTo($('.resourceField'));
						app.createResDetail();
					}
				});
			},
			
			slide:function(){//显示隐藏筛选框
				var flag = "show";
				$(".collapseBtn").unbind().bind("click", function(){
					$("#searchCon").slideToggle("fast",function(){
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
			
			clickResultUp:function(){//设置点击变色效果
				$("#searchCon .span7 span").unbind().bind("click",function(){
					$(this).toggleClass("active");
					app.initDicData();
				})
			},
			

			initDicData:function(){
				app.getConData();
				
				//点击条件初始化排序
				$('.order img').removeClass('focus').removeClass('blur').addClass('blur');
				$('.order').find('.up').attr('src','resources/images/front/triangleUp.png');
				$('.order').find('.down').attr('src','resources/images/front/triangleDown.png');
				console.log(postData);
				app.initAllData();
			},
			
			getConData:function(){//点击条件对应的值
				postData.classifierValueArray=[];
			
				$(".developType span.active").each(function(index,dom){
					postData.classifierValueArray.push($(this).attr('data-id'));
				})
				$(".testType span.active").each(function(index,dom){
					postData.classifierValueArray.push($(this).attr('data-id'));
				})
				$(".designType span.active").each(function(index,dom){
					postData.classifierValueArray.push($(this).attr('data-id'));
				})
				$(".worksType span.active").each(function(index,dom){
					postData.classifierValueArray.push($(this).attr('data-id'));
				})
				postData.orderBys='';
				postData.ascs='';
				postData.resourceName=$('#searchResource').val();
				console.log(postData);
			},
			
			clickOrder:function(){//点击切换上下按钮
				$(".order").unbind().bind("click", function(){
					var domCurr=$(this);
					app.clickResultDown(domCurr);
					postData.orderBys=domCurr.attr('data-id');//获取排序字段
					if(domCurr.find('img.focus').hasClass('up')){//获取排序方式
						postData.ascs='asc';
					}else{
						postData.ascs='desc';
					}
					console.log(postData);
					app.initAllData();
					});
			},
			
			clickResultDown:function(dom){//设置排序点击变色效果
				if(dom.find('.up').is('.focus')){
					$('.order img').removeClass('focus').removeClass('blur').addClass('blur');
					dom.find('.down').removeClass('blur').addClass('focus');
					$('.order').find('.up').attr('src','resources/images/front/triangleUp.png');
					$('.order').find('.down').attr('src','resources/images/front/triangleDown.png');
					dom.find('.up').attr('src','resources/images/front/triangleUp.png');
					dom.find('.down').attr('src','resources/images/front/triangleDownFocus.png');
				}else{
					$('.order img').removeClass('focus').removeClass('blur').addClass('blur');
					$('.order').find('.up').attr('src','resources/images/front/triangleUp.png');
					$('.order').find('.down').attr('src','resources/images/front/triangleDown.png');
					dom.find('.up').removeClass('focus').removeClass('blur').addClass('focus');
					dom.find('.up').attr('src','resources/images/front/triangleUpFocus.png');
					dom.find('.down').attr('src','resources/images/front/triangleDown.png');
				}
			},
			
			searchByResourceName:function(){//根据name查询
				$('.cSearch img').unbind().bind("click",function(){
					//点击条件初始化排序
					$('.order img').removeClass('focus').removeClass('blur').addClass('blur');
					$('.order').find('.up').attr('src','resources/images/front/triangleUp.png');
					$('.order').find('.down').attr('src','resources/images/front/triangleDown.png');
					postData.orderBys='';
					postData.ascs='';
					postData.resourceName=$('#searchResource').val();
					console.log(postData);
					app.initAllData();
				})
			},
			
			createResDetail:function(){//创意资源详情
				$('.creativeResource .mbox').unbind().bind('click',function(){
					creativeResourceId = $(this).attr('data-id');
					sessionStorage.setItem("id", creativeResourceId);
					T.load('.rightContentField','../resources/html/front/purchaseDetails.html');
				})
			}
	}
	app.init();
})