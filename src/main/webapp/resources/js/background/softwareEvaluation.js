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
            $(document).on('click','.reviewSof',function(){
                $('.rightContentField').load('softwareEvaluationReview.html');
            });
        }
    }
    app.init();
})