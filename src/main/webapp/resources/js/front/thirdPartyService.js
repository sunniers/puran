/*
 *	createTime:2016/11/16
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	var obj={
			'conceptEvaluation':'conceptEvaluation.html',//软件创意设计评估
			'softwareEvaluation':'softwareEvaluation.html',//软件测评
			'projectSupervision':'projectSupervision.html',//软件项目监理
			'copyrightAgent':'copyrightAgent.html',//软件著作权代理
			'patentAgent':'patentAgent.html',//专利代理
			'computerJudicialAuthentication':'computerJudicialAuthentication.html',//计算机司法鉴定
			'intellectualPropertyQuery':'intellectualPropertyQuery.html',//知识产权查新
			}
	var app={
			init:function(){
				this.goTopage();
			},
			goTopage:function(){
				$('.serviceItem').bind('click',function(){
					var item=$(this).attr('data-id');
					$('.rightContentField').load('../resources/html/front/'+obj[item]);
				});
			}
	}
	app.init();
});