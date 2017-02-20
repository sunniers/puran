/*
 *	createTime:2016/11/7
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
				$(document).on('click','.reviewTal',function(){
					$('.rightContentField').load('talentsReviewReview.html');
				});
			}
	}
	app.init();
})