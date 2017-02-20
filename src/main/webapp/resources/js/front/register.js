/*
 *	createTime:2016/10/25
 * 	author	  :caichao
 *
 *
 */
$(function(){
    var  app = {
        init: function() {
            	this.submit();
        },
        submit:function(){
        	$('.userContentRight .promptWords').hide();
        	$('#regBtn').unbind().bind('click',function(){
        		$('.userContentRight .promptWords').hide();
        		app.checkData();
        	})
        },
        checkData:function(){
        	var obj = {
        			'userName':$('.register #userName').val(),
        			'passWord':$('#passWord').val(),
        			'sureWord':$('#sureWord').val(),
        			'mailbox':$('#mailbox').val()
        	}
        	if(T.isEmpty(obj.userName)){
        		$('.userName .msg-con').html("请输入用户名");
				$('.userName .promptWords').show();
				return false;
        	}
			if (!/^((?=.*[0-9].*)(?=.*[A-Za-z].*))[_0-9A-Za-z]{6,50}$/g.test(obj['userName'])) {
				$('.userName .msg-con').html("用户名必须是6-50位数字和字母的组合");
				$('.userName .promptWords').show();
				return false;
			}
        	if(T.isEmpty(obj.passWord)){
        		$('.passWord .msg-con').html("请输入密码");
				$('.passWord .promptWords').show();
				return false;
        	}
			if (!/^((?=.*[0-9].*)(?=.*[A-Za-z].*))[_0-9A-Za-z]{6,50}$/g.test(obj['passWord'])) {
				$('.passWord .msg-con').html("密码必须是6-50位数字和字母的组合");
				$('.passWord .promptWords').show();
				return false;
			}
        	if(T.isEmpty(obj.sureWord)){
        		$('.sureWord .msg-con').html("请输入确认密码");
				$('.sureWord .promptWords').show();
				return false;
        	}
			if (obj['passWord']!=obj['sureWord']) {
				$('.sureWord .msg-con').html("密码必须一致");
				$('.sureWord .promptWords').show();
				return false;
			}
        	if(T.isEmpty(obj.mailbox)){
        		$('.mailbox .msg-con').html("请输入邮箱");
				$('.mailbox .promptWords').show();
				return false;
        	}
        	else{
        		
        		var data = {
        				'userName':$('.register #userName').val(),
            			'userPwd':$('#passWord').val(),
            			'userEmail':$('#mailbox').val()	
        		}
        		T.post('/s/login/register',data,function(res){
        			console.log(res);
        			if(res.retCode=='10000'){
        				sessionStorage.setItem("userName",data.userName);
        				sessionStorage.setItem("userPwd",data.userPwd);
        				sessionStorage.setItem("userEmail",data.userEmail);
        				$('.rightContentField').load('../resources/html/front/registerPrompting.html')
        			}else{
        				$.alert({
						      body: res.retMessage,
						      height: 100
						    });
        			}
        		})
        	}
        }
    }
    app.init();
})