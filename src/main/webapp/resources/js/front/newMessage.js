/*
 *	createTime:2016/11/9
 * 	author	  :caichao
 * 	
 * 
 */
$(function(){
	var total=0,
	start=1,
	size=6;//分页默认参数
	var obj = {
			'registrationNews':{"page":start,"pageSize":size,"receiveMessageType":600001},//报名消息
			'collectionNews':{"page":start,"pageSize":size,"receiveMessageType":600002}//关注消息
	}
	_obj = 'registrationNews';//中间变量
	var app = {
			init:function(){
				this.initdata();
				this.tabClick();
			},
			initdata:function(){//初始化
				obj[_obj].page=1;
				T.post('/s/requirement/selectMessage',obj[_obj],function(res){
					console.log(res);
					if(res.retCode=='10000'){
						total=res.retObject.total;//初始化总页数
						$('.'+_obj+'').children().remove();
						$('#demand_'+_obj+'_tmplate').tmpl(res.retObject.list).appendTo($('.'+_obj+''));
						$('.'+_obj+'').show();
						app.lookAtProject();//查看项目
						app.lookAtName();//查看个人
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
						app.updataData();
					}
				});
			},
			updataData:function(){
				T.post('/s/requirement/selectMessage',obj[_obj],function(res){
					console.log(res);
					if(res.retCode=='10000'){
						$('.'+_obj+'').children().remove();
						$('#demand_'+_obj+'_tmplate').tmpl(res.retObject.list).appendTo($('.'+_obj+''));
						$('.'+_obj+'').show();
						app.lookAtProject();//查看项目
						app.lookAtName();//查看个人
					}
				})
			
			},
			tabClick:function(){
				$(".header>.headers").bind('click',function(){
					var clickObj=$(this).attr('data-attr');
						_obj=clickObj;
						
					/*切换效果*/
					$(".header>.headers").removeClass('on');
					$(this).addClass("on");
					$(".newMessage .newMessage_ct").hide();
					$('.newMessage .'+clickObj+'').show();
					app.initdata();
				});
			},
			lookAtName:function(){//查看个人
				$('.box .title').unbind().bind('click',function(){
					var sysMessageId=$(this).parent().parent().attr('data-id');
					console.log(sysMessageId);
					sessionStorage.setItem('sysMessageId',sysMessageId);
					$('.rightContentField').load('resources/html/front/personalDetails.html');
				})
			},
			lookAtProject:function(){//查看项目
				$('.box .projectName').unbind().bind('click',function(){
					var sysMessageId=$(this).parent().parent().attr('data-id');
					console.log(sysMessageId);
					sessionStorage.setItem('id',sysMessageId);
					$('.rightContentField').load('resources/html/front/demandDetail.html');
				})
			}
	}
	app.init();
})
