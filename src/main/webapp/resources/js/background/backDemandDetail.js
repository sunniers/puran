/*
 *	createTime:2016/11/23
 * 	author	  :LUYI
 * 	
 */
$(function(){
	var data={
			'projId':sessionStorage.getItem('id')
	}
	var number = {
			'401101':1,
			'401102':2,
			'401103':3,
			'401104':4,
			'401105':5
	}
	sessionStorage.clear();
	var app = {
			init:function(){
				this.initData();
			},
			initData:function(){
				T.post('/s/detailedInformation/selectProjectRequirementDetails2',data,function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var obj = res.retObject;
						stepNum = obj.statusName;//取得进度码
						app.step();
						//插入时间
						obj.auditDatetime=T.dateFormat(new Date(obj.auditDatetime),"yyyy-MM-dd");
						obj.finishDate=T.dateFormat(new Date(obj.finishDate),"yyyy-MM-dd");
						obj.projColseDate=T.dateFormat(new Date(obj.projColseDate),"yyyy-MM-dd");
						if(obj.undertakeDatetime!=null){
							obj.undertakeDatetime=T.dateFormat(new Date(obj.undertakeDatetime),"yyyy-MM-dd");
						}else{
							obj.undertakeDatetime = "时间待定";
						}
				        $('.times').children().remove();
				        $('#demandDetail_times_tmplate').tmpl(obj).appendTo('.times');
						//插入简介
						$('.introduction').children().remove();
				        $('#demandDetail_introduction_tmplate').tmpl(obj).appendTo('.introduction');
				        //插入描述
				        $('.needDetailsInfo').html(obj.projRequireDescriptionContent);
				        //插入附件
				        $('.enclosure').children().remove();
				        $('#demandDetail_enclosure_tmplate').tmpl(obj).appendTo('.enclosure');
				        //插入评论数量
				        $('#commentNum').html(obj.projectEvaluates.length);
				        //插入评论
				        for(var i=0;i<obj.projectEvaluates.length;i++){
	        				obj.projectEvaluates[i].evaluateTime=T.dateFormat(new Date(obj.projectEvaluates[i].evaluateTime),"yyyy-MM-dd hh:mm:ss");
	        			}
				        $('.commentArea').children().remove();
				        $('#demandDetail_commentArea_tmplate').tmpl(obj.projectEvaluates).appendTo('.commentArea');
					}
				})
			},
			
			//初始化进度条
			step:function(){
				$('.sui-steps-round .wrap .round').css({"background-color": "white","color":"#0995e0","border": "4px white solid"});
				$('.sui-steps-round .wrap .bar').css({"background-color": "white","color":"#0995e0"});
				for(var i=1;i<number[stepNum]+1;i++){
					$('.sui-steps-round .step'+i+' .round').css({"background-color": "#0995e0","color":"white","border": "4px #0995e0 solid"});
				}
				for(var i=1;i<number[stepNum];i++){
					$('.sui-steps-round .step'+i+' .bar').css({"background-color": "#0995e0","color":"white"});
				}
			}
	}
	app.init();
})
