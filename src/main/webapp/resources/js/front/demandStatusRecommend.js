/*
 *	createTime:2016/11/21
 * 	author	  :Tangj
 * 	
 * 
 */
$(function(){
	
	var app={
			
			init:function(){
				this.tab();
				this.company();
				this.chooseDay();
			},
			tab:function(){
				$('.demandStatusRecommend .tabs>div').bind('click',function(){
					$('.demandStatusRecommend .tabs>div').removeClass('active');
					$('.demandStatusRecommend .company').hide();
					$('.demandStatusRecommend .person').hide();
					$(this).addClass('active');
					$('.'+$(this).attr('data-id')).show();
					if($(this).attr('data-id')=="company"){
						app.company();
					}else{
						app.person();
					}
				});
			},
			company:function(){
				T.post('/s/requirementManage/selectCompany',
						{"projId":sessionStorage.getItem('id'),
						"type":sessionStorage.getItem('type')},function(res){
							console.log(res);
							if(res.retCode=='10000'){
								var o=res.retObject;
								$.each(o,function(i,ele){
										ele.focus=[];
										ele.blur=[];
									for(var k=0;k<Math.round(ele.stars);k++){
										ele.focus.push('resources/images/front/starFocus.png');
									}
									for(var j=0;j<5-Math.round(ele.stars);j++){
										ele.blur.push('resources/images/front/starBlur.png');
									}
								});
								$('.demandStatusRecommend .company tbody').empty();
								$('#status_recommendCompany_tmplate').tmpl(o).appendTo('.demandStatusRecommend .company tbody');
								app.choose();
							}
				});
			},
			person:function(){
				T.post('/s/requirementManage/selectUser',
						{"projId":sessionStorage.getItem('id'),
						"type":sessionStorage.getItem('type')},function(res){
							console.log(res);
							if(res.retCode=='10000'){
								var o=res.retObject;
								$.each(o,function(i,ele){
										ele.focus=[];
										ele.blur=[];
									for(var k=0;k<Math.round(ele.stars);k++){
										ele.focus.push('resources/images/front/starFocus.png');
									}
									for(var j=0;j<5-Math.round(ele.stars);j++){
										ele.blur.push('resources/images/front/starBlur.png');
									}
								});
								$('.demandStatusRecommend .person tbody').empty();
								$('#status_recommendPerson_tmplate').tmpl(o).appendTo('.demandStatusRecommend .person tbody');
								app.choose();
							}
				});
			},
			choose:function(){
				$('.demandStatusRecommend .company  .choice').unbind().bind('click',function(){
						$('#recommendChoose .makeSure').attr('data-id',$(this).attr('data-id'));
						if(sessionStorage.getItem('type')=='700001'){
							$('#recommendChoose .makeSure').attr('data-url','/s/requirementManage/insertProjectRequirementUndertake');
						}else{
							$('#recommendChoose .makeSure').attr('data-url','/s/requirementManage/insertTalentTransaction');
						}
						
						$('#recommendChoose').modal('show');
				});
				$('.demandStatusRecommend .person .choice').unbind().bind('click',function(){
					$('#recommendChoose .makeSure').attr('data-id',$(this).attr('data-id'));
					if(sessionStorage.getItem('type')=='700001'){
						$('#recommendChoose .makeSure').attr('data-url','/s/requirementManage/insertProjectRequirementUndertake');
					}else{
						$('#recommendChoose .makeSure').attr('data-url','/s/requirementManage/insertTalentTransaction');
					}
					$('#recommendChoose').modal('show');
				});
			},
			chooseDay:function(){
				$('#recommendChoose').on('okHide', function () {
					var userId 				 =	$('#recommendChoose .makeSure').attr('data-id'),
						projectRequirementId = sessionStorage.getItem('id'),
						url					 = 	$('#recommendChoose .makeSure').attr('data-url'),
						passDay				 =  $('#recommendChoose #passDay').val();
						if(T.isEmpty(passDay)){
							$('#recommendChoose .sui-msg').show();
							return false;
						}if(!/^[1-9]\d*$/.test(passDay)){
							
							$('#recommendChoose .sui-msg').show();
							return false;
						}else{
							$('#recommendChoose .sui-msg').hide();
							T.post(url,	{'projectRequirementId':projectRequirementId,'passDay':passDay,'userId':userId},
									function(res){
										console.log(res);
									if(res.retCode=='10000'){
										app.company();
										app.person();
										return true;
									}
							});
						}
						
					})
				
			}
	}
	
	app.init();
})