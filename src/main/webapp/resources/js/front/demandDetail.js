/*
 *	createTime:2016/11/16
 * 	author	  :caichao
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
				this.comment();//发表评论
				this.upload()//附件上传
			},
			initData:function(){
				T.post('/s/detailedInformation/selectProjectRequirementDetails',data,function(res){
					if(res.retCode=='10000'){
						console.log(res);
						var obj = res.retObject;
						stepNum = obj.statusName;//取得进度码
						enrollNum = obj.isEnroll;//报名状态
						houseNum = obj.isHouse;//收藏状态
						isMy = obj.isMy;//是否为自己项目
						app.isMy();
						app.step();
						app.signUp();//报名
						app.collection();//收藏
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
						$('.introduces').children().remove();
				        $('#demandDetail_introduce_tmplate').tmpl(obj).appendTo('.introduces');
				        //插入描述
				        $('.describe').html(obj.projRequireDescriptionContent);
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
			comment:function(){
				$('#cmtBtn').unbind().bind('click',function(){
					var _data = {
							'projId':data.projId,
							'evaluateValue':$('#commentArea').val()
					}
					T.post('/s/evaluate/insertProjectEvaluate',_data,function(res){
						console.log(res);
						if(res.retCode=='10000'){
							console.log("发表成功");
						}
					})
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
			},
			//是否报名
			signUp:function(){
				if(enrollNum==1){
					$('#signUp').html("取消 报名");
					$('#signUp').unbind().bind('click',function(){
						T.post('/s/enroll/deleteProjectEnroll',{'projectRequirementId':data.projId},function(res){
							if(res.retCode=='10000'){
								enrollNum = 0;
								alert("已取消报名");
								app.signUp();
							}else{
								enrollNum = 1;
								alert("未取消报名");
								app.signUp();
							}
						})
					})
				}else{
					$('#signUp').html("报 名");
					$('#signUp').unbind().bind('click',function(){
						$('#demandDetail_signUpContent').modal('show');
						$('#demandDetail_signUpContent .msg-error').hide();	
						$('#modalSubmit').unbind().bind('click',function(){
							$('#demandDetail_signUpContent .msg-error').hide();
							var imform = {
									'projectRequirementId':data.projId,
									'name':$('#demandDetail_signUpContent .contacts').val(),
									'mobile':$('#demandDetail_signUpContent .contactNumber').val(),
									'email':$('#demandDetail_signUpContent .emailbox').val(),
									'enrollValue':$('#demandDetail_signUpContent .remarks').val(),
									'enrollFileName':$('#uploadSuccess').attr('data-name'),
									'enrollFilePath':$('#uploadSuccess').attr('src')
							}	
							if(T.isEmpty(imform.name)){
								$('.contactsPrompt').show();
								$('.contactsPrompt .msg-con').html("联系人不能为空");
								return false;
							}
							if(T.isEmpty(imform.mobile)){
								$('.contactNumberPrompt').show();
								$('.contactNumberPrompt .msg-con').html("联系电话不能为空");
								return false;
							}
							if(T.isEmpty(imform.email)){
								$('.emailboxPrompt').show();
								$('.naemailboxPromptme .msg-con').html("邮箱不能为空");
								return false;
							}
							else{
								T.post('/s/enroll/insertProjectEnroll',imform,function(res){
									if(res.retCode=='10000'){
										enrollNum = 1;
										alert("报名成功");
										app.signUp();
									}else{
										enrollNum = 0;
										alert("报名未成功");
										app.signUp();
									}
								})
							}
						})
					})
				}
			},
			//是否收藏
			collection:function(){
				if(houseNum==1){
					$('#collection').html("取消 收藏");
				}else{
					$('#collection').html("收藏");
				}
				$('#collection').unbind().bind('click',function(){
					var x = (houseNum+3)%2;
					houseNum = x;
					if(x==1){//收藏	
						T.post('/s/favorite/insertMyFavorite',{"houseType":700001,"houseResourceId":data.projId},function(res){
							if(res.retCode=='10000'){
								alert("收藏成功");
								app.collection();
							}
						})
					}else{
						T.post('/s/favorite/deleteUserHouse',{"houseType":700001,"houseResourceId":data.projId},function(res){
							if(res.retCode=='10000'){
								alert("已取消收藏");
								app.collection();
							}
						})
					}
				})
			},
			upload:function(){
				$('#demandDetail_signUpContent .upLoadImg').unbind().bind('click',function(){	
				    $(this).fileupload({  
				        autoUpload: true,//是否自动上传  
				        url: '/s/upload/file',//上传地址  
				        done: function (e, data) {//设置文件上传完毕事件的回调函数 
				        	var result=JSON.parse(data.result);
					        	imageName=result.name;
					        	path=result.path;
				        	$(this).siblings('.replace').html('<div id="uploadSuccess" src="'+path+'"  data-name="'+imageName+'" >上传成功</div>');
				            console.log('文件上传成功-----name:'+data.result);
				        }
				    }) 
				});
			},
			isMy:function(){
				console.log(isMy);
				if(isMy==1){
					$('#collection').hide();
					$('#signUp').hide();
				}else{
					$('#collection').show();
					$('#signUp').show();
				}
			}
			
	}
	app.init();
})
