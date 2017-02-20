/*
 *	createTime:2016/11/23
 * 	author	  :LUYI
 * 	
 */
$(function(){

	var app = {
		init : function(){
			this.tab();
			this.initResourceDescription();//初始化资源描述
		},
		
		tab:function(){//切换资源详情和评价
			$('.backResourceDetail .contents .evaluation').hide();
			$('.backResourceDetail .header div').unbind().bind('click', function(){
				if ($(this).attr('class') == "evaluation") {
					$(this).addClass('active');
					$('.header .detail').removeClass('active');
					$('.contents .detail').hide();
					$('.contents .evaluation').show();
					app.initEvaluationData();//初始化资源评论
				} else {
					$(this).addClass('active');
					$('.header .evaluation').removeClass('active');
					$('.contents .detail').show();
					$('.contents .evaluation').hide();
				}
			});
		},
		
		initResourceDescription:function(){//初始化资源描述
			T.post("/s/resource_audit/findReq",
					{"resourceId":sessionStorage.getItem('id')},function(res){
						console.log(res);
						if(res.retCode="10000"){
							var obj=res.retObject;
							$('.backResourceDetail .selRes').text(obj.resourceDescription);//资源描述
							if(obj.showAddress!="null"){
								$('.detail .showAddress').html(//初始化资源演示地址
										"<div class='Add_style'><p>资源演示地址：<a href='"	
										+obj.showAddress+"' target= _blank>"
										+obj.showAddress
										+"</a></p></div>"
										);
								}
							}
						});
			},
		
		initEvaluationData:function(){//初始化资源评论
			T.post('/s/evaluate/selectCreativeResourceEvaluates',
					{"creativeResourceId":sessionStorage.getItem('id'),"page":1,"pageSize":5},function(res){
						console.log(res);
						if(res.retCode=="10000"){
							var o=res.retObject.list;
							$.each(o,function(index,ele){
								ele.evaluateTime=T.dateFormat(new Date(ele.evaluateTime),'MM-dd');
								ele.appendTime=T.dateFormat(new Date(ele.appendTime),'MM-dd');
								});
							$('.backResourceDetail .contents .evaluation').empty();
							$('#resource_detail_tmplate').tmpl(o).appendTo('.backResourceDetail .contents .evaluation');
							}
						});
			}
		}
	app.init();
})
