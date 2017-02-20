/*
 *	createTime:2016/10/20
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	
	
	var app={
			init:function(){
				this.getBaseInfo();
			},
			getBaseInfo:function(){
				T.post("/s/creativeResource/selectCreativeResource",
						{"creativeResourceId":sessionStorage.getItem('creativeResourceId')},
						function(res){
							console.log(res);
							if(res.retCode="10000"){
								var _obj=res.retObject;
								
								$('#upload .up').html("<img src="+_obj.resourceImage+"/>");//初始化图片
								$('.resourceType').val(_obj.dataValue);
								$('.resourceType').attr('data-id',_obj.resourceType);//初始化资源类型
								
								$('.resourceName').val(_obj.resourceName);//初始化资源名称
								$('.resourceNumber').val(_obj.resourceNumber);//初始化资源数量
								$('.resourcePrice').val(_obj.resourcePrice);//初始化资源价格
								$('.showAddress').val(_obj.showAddress);//初始化资源演示地址
								$('.resourceDescription').val(_obj.resourceDescription);//初始化资源描述
							}else{
								
							}
				});
			}
	}
	app.init();
})