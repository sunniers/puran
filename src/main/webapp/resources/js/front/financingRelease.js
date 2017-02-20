/*
 *	createTime:2016/11/21
 * 	author	  :LUYI
 * 
 */
$(function() {
	var app = {
			init:function(){
				this.tabHeader();// 融资发布、草稿箱切换
				this.draftUpdate();
			},

			tabHeader:function(){// 融资发布、草稿箱切换
				$('.financingRelease .content2').hide();
				$('.financingRelease .header div').bind('click', function() {
					/*通用切换方法
					$('.contents .content').hide();
					$(this).addClass('active');
					$('.'+$(this).attr('data-id')).show();*/
					if ($(this).attr('class') == "drafts") {
						$(this).addClass('active');
						$('.refer').removeClass('active');
						$('.content1').hide();
						$('.content2').show();
					} else {
						$('.content1 input').val("");
						$('.content1 textarea').val("");
						$(this).addClass('active');
						$('.drafts').removeClass('active');
						$('.content1').show();
						$('.content2').hide();
					}
				});
			},

			draftUpdate:function(){// 初始化草稿箱修改页面
				$('.financingRelease .content2 .edit').bind('click',function(){
							$('#draftDetail').modal('show');
					});
				},
				
			saveFinancing:function(){//融资发布保存
				$('.financingRelease .buttonType .save').bind('click',function(){
					
				});
			},
			
			submitFinancing:function(){//融资发布保存
				$('.financingRelease .buttonType .save').bind('click',function(){
					
				});
			}
			
	}
	app.init();
})