/*
 *	createTime:2016/10/31
 * 	author	  :caichao
 * 	edit	  :Tangj  11/16
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
				$('.upLoadImg2').unbind().bind('click',function(){
				    $(this).fileupload({  
				        autoUpload: true,//是否自动上传  
				        url: '/s/upload/file',//上传地址  
				        done: function (e, data) {//设置文件上传完毕事件的回调函数 
				        	var result=JSON.parse(data.result);
					        	imageName=result.name;
					        	path=result.path;
				        	$(this).siblings('.replace').html('<img data-name="'+imageName+'" class="resourceIcon2" style="width:auto;height:50px;margin-top:0;" src="'+path+'">');
				            console.log('文件上传成功-----name:'+data.result);
				        }
				    }) 
				});
				$('.upLoadImg1').unbind().bind('click',function(){
				    $(this).fileupload({  
				        autoUpload: true,//是否自动上传  
				        url: '/s/upload/file',//上传地址  
				        done: function (e, data) {//设置文件上传完毕事件的回调函数 
				        	var result=JSON.parse(data.result);
					        	imageName=result.name;
					        	path=result.path;
				        	$(this).siblings('.replace').html('<img data-name="'+imageName+'" class="resourceIcon1" style="width:auto;height:50px;margin-top:0;" src="'+path+'">');
				            console.log('文件上传成功-----name:'+data.result);
				        }
				    }) 
				});	
			},
			submit:function(){
				$('.userContent .promptWords').hide();
				$('#subBtn').unbind().bind('click',function(){
					var data = {
							'resourceIcon1' : $('.resourceIcon1').attr('data-name'),
							'resourceIcon2' : $('.resourceIcon2').attr('data-name'),
							'userRealName' : $('.name input').val(),
							'creditNumber' : $('.idNumber input').val(),
							'creditFrontPath':'sdafsafdsad',
							'creditBackPath':'cai'
					}
					$('.userContent .promptWords').hide();
					if(T.isEmpty(data.userRealName)){
						$('.name .promptWords').show();
						$('.name .msg-con').html("姓名不能为空");
						return false;
					}
					if(data.userRealName.length > 50){
						$('.name .promptWords').show();
						$('.name .msg-con').html("不能超过50字");
						return false;
					}
					if(T.isEmpty(data.creditNumber)){
						$('.idNumber .promptWords').show();
						$('.idNumber .msg-con').html("证件号不能为空");
						return false;
					}
					if(T.isValidIDCardNo(data.creditNumber)!="true"){
						$('.idNumber .promptWords').show();
						$('.idNumber .msg-con').html("证件格式不正确");
						return false;
					}
					if(T.isEmpty(data.resourceIcon2)){
						$('.upload .promptWords').show();
						$('.upload .msg-con').html("请上传正面照");
						return false;
					}
					if(T.isEmpty(data.resourceIcon1)){
						$('.upload .promptWords').show();
						$('.upload .msg-con').html("请上传反面照");
						return false;
					}
					else{
						T.post('/s/identityAuthentication/user',data,function(res){
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
