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
            $(document).on('click','.reviewFin',function(){
                $('.rightContentField').load('financingInfoManageReview.html');
            });
        }
    }
    app.init();
})