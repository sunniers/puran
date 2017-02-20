/*
 *	createTime:2016/10/20
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	var app={
			init:function(){ // 初始函数
				this.tab();
				this.getMenu();
				this.getUser();
				this.otherFeature();
				this.getDemandInfo();//初始化需求推荐
				this.resRecommendInfo();//初始化资源推荐
			},
			tab:function(){ // 搜索框条件切换
				$('.searchType span').unbind().bind('click',function(){
					$('.searchType span').removeAttr('class');
					$(this).attr('class','active');
				});
			},
			getMenu:function(){//首页菜单获取
				T.post('/s/showFrontIndex/selectSysResources',{'resourceType':'peception'},function(res){
					if(res.retCode=='10000'){
						var menuList=res.retObject;
						$('#leftMenu').children().remove();
						$('#index_menu_template').tmpl(menuList).appendTo('#leftMenu');
						app.menuToPage();
					}else{
						
					}
				});
			},
			getUser:function(){//切换前台登录状态
				T.post('/s/getSession/getUser','',function(res){
					if(res.retCode=='10000'){
						$('#userName').html(res.retObject.userName);
						$('.unlogin').css('display',' none');
						$('.logined').css('display',' block');
					}else {
						$('.unlogin').css('display',' block');
						$('.logined').css('display',' none');
					}
				})
			},
			getDemandInfo:function(){//初始化需求推荐
				T.get('/s/showFrontIndex/selectProjectRequirements','',function(res){
							if(res.retCode=="10000"){
								app.initFirstItem(res.retObject[0]);//初始化需求推荐第一个
								app.initOtherItem(res.retObject);//初始化需求推荐后面项目		
							}else{
								
							}
				});
			},
			resRecommendInfo:function(){//初始化创意资源
				T.get('/s/showFrontIndex/selectCreativeResources','',function(res){
					if(res.retCode=='10000'){
						console.log(res);
						$('#index_resdemand_template').tmpl(res).appendTo('.demandRecommend .bottomContent');
						app.resDetail();
					}
				});
			},
			initFirstItem:function(firObj){//需求推荐第一个
				var html='';
				html+='<div>'+firObj.projName+'</div>';
				html+='<div>¥'+T.fmtNumber(firObj.projServiceFee,'#,###.##')+'</div>';
				
			var countStr=firObj.userCount.toString(),
				len=countStr.length,
				num1=countStr.charAt(len-3)|"0",
				num2=countStr.charAt(len-2)|"0",
				num3=countStr.charAt(len-1)|"0";
				html+='<div>已报<span>'+num1+'</span><span>'+num2+'</span><span>'+num3+'</span>人次</div>';
				html+=' <div><span>报名中</span></div>';
				/*********时分秒计算**********/
				var date1=new Date().getTime();  //开始时间
				var date2=firObj.projCloseDate;    //结束时间
				var date3=date2-date1;  //时间差的毫秒数
				//计算出相差天数
				var days=Math.floor(date3/(24*3600*1000));
				//计算出小时数
				var leave1=date3%(24*3600*1000);    //计算天数后剩余的毫秒数
				var hours=Math.floor(leave1/(3600*1000));
				//计算相差分钟数
				var leave2=leave1%(3600*1000);        //计算小时数后剩余的毫秒数
				var minutes=Math.floor(leave2/(60*1000));
				//计算相差秒数
				var leave3=leave2%(60*1000);      //计算分钟数后剩余的毫秒数
				var seconds=Math.round(leave3/1000);
				html+=' <div><img src="resources/images/front/time.png" alt="">剩余'+days+'天'+hours+'小时'+minutes+'分'+seconds+'秒</div>';
				html+='<div><span>'+firObj.publishUser+'</span></div>';
				$('.demandRecommendContent .left').append(html);
				$('.demandRecommendContent .left').attr('data-id',firObj.projId);
				
				$('.demandRecommendContent .left').bind('click',function(){//需求推荐-详情跳转
					var id=$(this).attr('data-id');
						sessionStorage.setItem('id',id);
					T.load('.rightContentField','../resources/html/front/demandDetail.html');
				});
			},
			initOtherItem:function(obj){//需求推荐 其它项目
				var itemHtml='';
				for(var i=1;i<5;i++){
					var o=obj[i];
					itemHtml+='<div data-id="'+obj[i].projId+'" class="m">';
					itemHtml+='<div class="mTitle"><span>'+o.projName+'</span></div>';
					itemHtml+='<div class="label">';
					for(var j=0;j<o.projectRequirementClasss.length;j++){
						itemHtml+='<span>'+o.projectRequirementClasss[j].projRequireClassValues+'</span>';
					}
					itemHtml+='</div>';
					itemHtml+='<div class="status"><span>¥</span><span>'+T.fmtNumber(o.projServiceFee,'#,###.##')+'</span><span>报名中</span></div>';
					itemHtml+='<div class="count">';
					itemHtml+='<span><img src="resources/images/front/time.png" alt="时间">剩余</span>';
					/*********时分秒计算**********/
					var date1=new Date().getTime();  //开始时间
					var date2=o.projCloseDate;    //结束时间
					var date3=date2-date1;  //时间差的毫秒数
					//计算出相差天数
					var days=Math.floor(date3/(24*3600*1000));
					//计算出小时数
					var leave1=date3%(24*3600*1000);    //计算天数后剩余的毫秒数
					var hours=Math.floor(leave1/(3600*1000));
					//计算相差分钟数
					var leave2=leave1%(3600*1000);        //计算小时数后剩余的毫秒数
					var minutes=Math.floor(leave2/(60*1000));
					//计算相差秒数
					var leave3=leave2%(60*1000);      //计算分钟数后剩余的毫秒数
					var seconds=Math.round(leave3/1000);
					itemHtml+='<span>'+days+'天'+hours+'小时'+minutes+'分'+seconds+'秒</span>';
					itemHtml+='<span>'+o.userCount+'人</span>';
					itemHtml+='<span><img src="resources/images/front/heart.png" alt="">已报名：</span>';
					itemHtml+=' </div></div>';
					
				}
				$('.demandRecommendContent .right').append(itemHtml);

				$('.demandRecommendContent .right .m').bind('click',function(){//需求推荐-详情跳转
					var id=$(this).attr('data-id');
						sessionStorage.setItem('id',id);
					T.load('.rightContentField','../resources/html/front/demandDetail.html');
				});
			},
			
			resDetail:function(){//资源推荐-详情跳转
				$('.bottomContent .bottomCard').bind('click',function(){
					var resourceTransactionId=$(this).attr('data-id');
						sessionStorage.setItem('resourceTransactionId',resourceTransactionId);
						T.load('.rightContentField','../resources/html/front/purchaseDetails.html');
				});
			},
			
			
			
			menuToPage:function(){//左侧菜单跳转
				$('.leftMenuField .parentDirectory').bind('click',function(){
					var url=$(this).attr('data-url');
					T.load('.rightContentField','../resources/html/front/'+url+'');
				});
				$('.leftMenuField .childDirectory').bind('click',function(){
					var url=$(this).attr('data-url');
					T.load('.rightContentField','../resources/html/front/'+url+'')
				});
			},
			otherFeature:function(){//首页非菜单功能
				// 注册
				$('#register')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/register.html');	
				})
				// 登录
				$('#login')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/userLogin.html');
				})
				//退出登录
				$('#logout')
					.unbind().bind('click',function(){
						T.post('/s/getSession/outUser','',function(res){
							if(res.retCode=='10000'){
								T.load('.rightContentField','../resources/html/front/userLogin.html');
								$('.unlogin').css('display',' block');
								$('.logined').css('display',' none');
							}
						})
				})

				// 投诉举报
				$('.complaintsReport')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/userLogin.html');
					})
				//我的帐号
				$('.logined #myAccount')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/myAccount.html');
				})
					
				//我的圈子
				$('.logined #myCircle')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/myCircle.html');
				})
				//我的收藏
				$('.logined #myCollection')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/myCollection.html');
				})
				
				//帮助中心
				$('.helpCenter')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/helpCenter.html');
				})
				//我的成交
				$('.logined #myDeal')
					.unbind().bind('click',function(){
						$('.rightContentField').load('../resources/html/front/myDeal.html')
				})
				//我的购物车
				$('.logined #shoppingCart')
					.unbind().bind('click',function(){
						$('.rightContentField').load('../resources/html/front/shoppingCart.html')
				})
				//需求大厅
				$('.demandHall')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/demandHall.html');
				})
				//创意人才
				$('.creativeTalent')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/creativepeople.html');
				})
				//创意资源
				$('.creativeResources')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/creativeResource.html');
				})
				//需求推荐-更多
				$('.demandRecommend .title .more')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/demandHall.html');
				})
				//创意资源-更多
				$('.demandRecommend .title .moreRes')
					.unbind().bind('click',function(){
						T.load('.rightContentField','../resources/html/front/creativeResource.html');
				})
				//T.load('.rightContentField','../resources/html/front/businessDetails.html');
				//首页
				$('.menuNav .goIndex')
				.unbind().bind('click',function(){
					window.location.href="index.html";
				})
			}
	}
	app.init();


})