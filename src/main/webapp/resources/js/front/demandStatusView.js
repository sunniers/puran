/*
 *	createTime:2016/11/20
 * 	author	  :Tangj
 * 	
 * 
 */
$(function(){
	
	var app={
			init:function(){
				this.showData();
			},
			showData:function(){
				T.post('/s/requirement/selectPrRequirementId',
						{'projId':sessionStorage.getItem('id')},
						function(res){
							console.log(res);
							if(res.retCode="10000"){
								var obj=res.retObject;
									
								obj.projRequireDescriptionContent=obj.projRequireDescriptions[0].projRequireDescriptionContent;
								obj.projCloseDate	=	T.dateFormat(new Date(obj.projCloseDate),'yyyy-MM-dd');
								obj.projDevlierDate	=	T.dateFormat(new Date(obj.projDevlierDate),'yyyy-MM-dd');
								obj.projServiceFee	=	T.fmtNumber(obj.projServiceFee,'#,###.##');
								$('.demandStatusView').empty();
								$('#status_view_tmplate').tmpl(obj).appendTo('.demandStatusView');
								
								if(obj.providerType.indexOf('1')>-1){
									$('.demandStatusView .providerType [data-id="1"]').prop('checked',true)
								}if(obj.providerType.indexOf('2')>-1){
									$('.demandStatusView .providerType [data-id="2"]').prop('checked',true)
								}if(obj.authenticationRequirement.indexOf('1')>-1){
									$('.demandStatusView .authenticationRequirement [data-id="1"]').prop('checked',true)
								}if(obj.authenticationRequirement.indexOf('2')>-1){
									$('.demandStatusView .authenticationRequirement [data-id="2"]').prop('checked',true)
								}if(obj.authenticationRequirement.indexOf('3')>-1){
									$('.demandStatusView .authenticationRequirement [data-id="3"]').prop('checked',true)
								}if(obj.publishWay.indexOf('1')>-1){
									$('.demandStatusView .publishWay [data-id="1"]').prop('checked',true)
								}if(obj.publishWay.indexOf('2')>-1){
									$('.demandStatusView .publishWay [data-id="2"]').prop('checked',true)
								}if(obj.publishWay.indexOf('3')>-1){
									$('.demandStatusView .publishWay [data-id="3"]').prop('checked',true)
								}
							}
						});
			}
	}
	app.init();
})