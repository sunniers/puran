/*
 *	createTime:2016/11/8
 * 	author	  :Chenxl
 * 	edit	  :
 * 
 */
$(function(){
	
	var app={
			init:function(){
				this.review();
			},
			review:function(){
				$(document).on('click','.reviewRep',function(){
					$('.rightContentField').load('reportProcessingReview.html');
				});
			}
	}
	app.init();
})