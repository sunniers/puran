/*
 *	createTime:2016/11/1
 * 	author	  :caichao
 * 	
 * 
 */
$(function(){
	var app = new Object();
	app = {
			init:function(){
				this.submit();
				this.upload();
			},
			upload:function(){
				$('.upLoadImg1').unbind().bind('click',function(){
				    $(this).fileupload({  
				        autoUpload: true,//是否自动上传  
				        url: '/s/upload/file',//上传地址  
				        done: function (e, data) {//设置文件上传完毕事件的回调函数 
				        	$(this).siblings('.replace').html('<img class="resourceIcon1" style="width:auto;height:50px;margin-top:0;" src="../resources/images/front/warning.png">');
				            console.log('文件上传成功-----name:'+data.result);
				        }
				    }) 
				});
				$('.upLoadImg2').unbind().bind('click',function(){
				    $(this).fileupload({  
				        autoUpload: true,//是否自动上传  
				        url: '/s/upload/file',//上传地址  
				        done: function (e, data) {//设置文件上传完毕事件的回调函数  
				        	$(this).siblings('.replace').html('<img class="resourceIcon2" style="width:auto;height:50px;margin-top:0;" src="../resources/images/front/rightAngleBrackets.png">');
				            console.log('文件上传成功-----name:'+data.result);
				        }
				    }) 
				});	
				$('.upLoadImg3').unbind().bind('click',function(){
				    $(this).fileupload({  
				        autoUpload: true,//是否自动上传  
				        url: '/s/upload/file',//上传地址  
				        done: function (e, data) {//设置文件上传完毕事件的回调函数  
				        	$(this).siblings('.replace').html('<img class="resourceIcon3" style="width:auto;height:50px;margin-top:0;" src="../resources/images/front/warning.png">');
				            console.log('文件上传成功-----name:'+data.result);
				        }
				    }) 
				});	
			},
			submit:function(){
				$('.userContent .promptWords').hide();
				$('#subBtn').unbind().bind('click',function(){
					var data = {
							'resourceIcon1' : $('.resourceIcon1').attr('src'),
							'resourceIcon2' : $('.resourceIcon2').attr('src'),
							'resourceIcon3' : $('.resourceIcon3').attr('src'),
							'companyName' : $('.enterpriseName input').val(),
							'companyType' : $('.legalPerson input').val(),
							'companyPhone' : $('.organization input').val(),
							'companyCredits':[{'creditFrontPath':'cai1'},{'creditBackPath':'cai2'},{'creditFrontPath':'cai3'}]
					}
					$('.userContent .promptWords').hide();
					if(T.isEmpty(data.companyName)){
						$('.enterpriseName .promptWords').show();
						$('.enterpriseName .msg-con').html("企业名称不能为空");
						return false;
					}
					if(T.isEmpty(data.companyType)){
						$('.legalPerson .promptWords').show();
						$('.legalPerson .msg-con').html("法人名称不能为空");
						return false;
					}
					if(T.isEmpty(data.companyPhone)){
						$('.organization .promptWords').show();
						$('.organization .msg-con').html("机构代码不能为空");
						return false;
					}
					if(T.isEmpty(data.resourceIcon1)){
						$('.upload .promptWords').show();
						$('.upload .msg-con').html("请上传图1");
						return false;
					}
					if(T.isEmpty(data.resourceIcon2)){
						$('.upload .promptWords').show();
						$('.upload .msg-con').html("请上传图2");
						return false;
					}
					if(T.isEmpty(data.resourceIcon3)){
						$('.upload .promptWords').show();
						$('.upload .msg-con').html("请上传图3");
						return false;
					}
					else{
						T.post('/s/identityAuthentication/company',data,function(res){
							console.log(res);
							if(res.retCode=='10000'){
								$.alert({
								      body: '您已提交成功',
								      height: 100
								    });
								$('.rightContentField').load('../resources/html/front/myAccount.html');
							}else{
								$.alert({
								      body: res.retMessage,
								      height: 100
								    });
							}
							
						})
					}
					
				})
			}
	}
	app.init();
})
