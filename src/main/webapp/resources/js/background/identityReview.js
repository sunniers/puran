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
				this.tableSwitch();//table切换
			},
			review:function(){
				$(document).on('click','.reviewId',function(){
					$('.rightContentField').load('identityReviewReview.html');
				});
			},
			//table切换
			tableSwitch:function(){
				$(".identityReview .identitySearchTitle .t").bind('click',function(){
					var clickObj=$(this).attr('data-attr');
						_obj=clickObj;
					/*切换效果*/
					$(".identityReview .identitySearchTitle .t").removeClass('active');
					$(this).addClass("active");
					$(".identityReviewData .sui-table").hide();
					$('.identityReviewData .'+clickObj+'').show();
					app.initData();
				});
			},
	}
	app.init();
})