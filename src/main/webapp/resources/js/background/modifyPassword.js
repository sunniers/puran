/*
 *	createTime:2016/10/27
 * 	author	  :caichao
 *
 *
 */
$(function(){
    var  app = {
        init: function() {
            this.save();
        },
        save:function(){
        	$(document).on('click','#save',function(){
        		app.checkData();
        	})
        },
        checkData:function(){
        	var obj = {
        			'password':$('#password').val(),
        			'newPassword':$('#newPassword').val(),
        			'sureNewPassword':$('#sureNewPassword').val()
        	}
        	if(T.isEmpty(obj.password)){
        		$('.msg-con').html("请输入原密码");
				$('.msg-error').css('opacity','1');
				return false;
        	}
        	if(T.isEmpty(obj.newPassword)){
        		$('.msg-con').html("请输入新密码");
				$('.msg-error').css('opacity','1');
				return false;
        	}
        	if (!/(?!^\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{6,50}/g.test(obj['newPassword'])) {
				$('.userNamePrompt .msg-con').html('密码必须是6-50位数字和字母的组合');
				$('.userNamePrompt').css('opacity','1');
		        return false;
		    }
        	if(T.isEmpty(obj.sureNewPassword)){
        		$('.msg-con').html("请输入确认新密码");
				$('.msg-error').css('opacity','1');
				return false;
        	} 
        	if (obj['newPassword']!=obj['sureNewPassword']) {
				$('.userNamePrompt .msg-con').html('两次密码必须一致');
				$('.userNamePrompt').css('opacity','1');
		        return false;
		    }
        	else{
        		$('.msg-error').css('opacity','0');
        		var data = {
        				'userPwd':$('#password').val(),
            			'newBackUserPwd':$('#newPassword').val(),
            			'userName':'545642313'
        		}
        		T.post('/s/modifyPwd/updateBackUserNewPwd',data,function(res){
        			console.log(data.newBackUserPwd);
        			console.log(data.userName);
        			console.log(res);
        			if(res.retCode=='10000'){
        				location.href="../../../login.html";
        			}else{
        				$('.userNamePrompt .msg-con').html('原密码输入错误');
        				$('.userNamePrompt').css('opacity','1');
        		        return false;
        			}
        		})
        	}
        }
    }
    app.init();
})