/*
 *	createTime:2016/11/18
 * 	author	  :Tangj
 * 	
 * 
 */
$(function(){
	var page=1,
		pageSize=10,
		total=0;
	
	var app={
			
			init:function(){
				this.initData();
			},
			initData:function(){
				if(sessionStorage.getItem('type')=='700001'){
					T.post('/s/requirementManage/selectProjectEnroll',
							{'page':page,'pageSize':pageSize,'projectRequirementId':sessionStorage.getItem('id')},function(res){
							console.log(res);
							if(res.retCode=='10000'){
								var obj=res.retObject.list;
									total=res.retObject.total;
									app.appendData(obj);
									app.look();
									app.page();
							}
					});
				}else{
					T.post('/s/requirementManage/selectTalentEnroll',
					{'page':page,'pageSize':pageSize,'talentRequirementId':sessionStorage.getItem('id')},function(res){
						console.log(res);
						if(res.retCode=='10000'){
							var obj=res.retObject.list;
								total=res.retObject.total;
								app.appendData(obj);
						}
					});
				}
				
			},
			appendData:function(obj){
					$.each(obj,function(i,ele){
						ele.focus=[];
						ele.blur=[];
					for(var k=0;k<Math.round(ele.stars);k++){
						ele.focus.push('resources/images/front/starFocus.png');
					}
					for(var j=0;j<5-Math.round(ele.stars);j++){
						ele.blur.push('resources/images/front/starBlur.png');
					}
				});
					$('.demandStatusCover table tbody').empty();
					$('#status_cover_tmplate').tmpl(obj).appendTo('.demandStatusCover table tbody');
			},
			look:function(){//查看&&选择供方
				 $('.look a').tooltip({
					    animation: false, 
					    type: 'attention',
					    placement:'bottom'
					  })
					  
					  $('.choiceSupply').tooltip({
						  	animation: false,
						  	 placement:'bottom',
						    type: 'confirm',
						    okHide: function(){
						    	var that=this,
						    		input=$(this).siblings('.sui-tooltip').find('input'),
						    		passDay=input.val(),
						    		id=sessionStorage.getItem('id'),
						    		userId=$(this).attr('data-id'),
						    		type=sessionStorage.getItem('type');
						    		if(!/^[1-9]\d*$/.test(passDay)){
						    			$(input).css('border-color','red');
						    		}else{
						    			if(type=='700001'){
						    				T.post('/s/requirementManage/insertProjectRequirementUndertake',
						    						{'projectRequirementId':id,'passDay':passDay,'userId':userId},function(res){
						    					console.log(res);
						    					if(res.retCode=='10000'){
						    						app.initData();
						    						that.tooltip('hide');
						    					}
						    				});
						    			}else if(type=='700002'){
						    				T.post('/s/requirementManage/insertTalentTransaction',
						    						{'talentRequirementId':id,'passDay':passDay,'userId':userId},function(res){
						    					console.log(res);
						    					if(res.retCode=='10000'){
						    						app.initData();
						    						that.tooltip('hide');
						    					}
						    				});
						    			}
						    		}
						    		
						    	
						    	
						    }
					  	})
			
			},
			page:function(){
				$('.demandStatusCover #paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :pageSize,
					onchange : function(newPage) {
						page=newPage;
						if(sessionStorage.getItem('type')=='700001'){
							T.post('/s/requirementManage/selectProjectEnroll',
									{'page':page,'pageSize':pageSize,'projectRequirementId':sessionStorage.getItem('id')},function(res){
									console.log(res);
									if(res.retCode=='10000'){
										var obj=res.retObject.list;
											total=res.retObject.total;
											app.appendData(obj);
											app.look();
									}
							});
						}else{
							T.post('/s/requirementManage/selectTalentEnroll',
							{'page':page,'pageSize':pageSize,'talentRequirementId':sessionStorage.getItem('id')},function(res){
								console.log(res);
								if(res.retCode=='10000'){
										var obj=res.retObject.list;
											total=res.retObject.total;
											app.appendData(obj);
											app.look();
								}
							});
						}
					}
				});
			}
	}
	app.init();
})