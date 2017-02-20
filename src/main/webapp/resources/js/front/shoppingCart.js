/*
 *	createTime:2016/11/9
 * 	author	  :Tjun
 * 	
 * 
 */
$(function(){
	
	var page=1,
		pageSize=10,
		total=0;
	
	var app={
			
			init:function(){
				this.initData();
				this.payFor();
			},
			
			/*商品数量处理 
			*效果处理
			*/
			
			check:function(){//全选反选
				$('.catbox thead .check-all,.foot .check-all').unbind().bind('click',function(){
					if($(this).is(':checked')){
						$('.catbox thead .check-all').prop('checked',true);
						$('.foot .check-all').prop('checked',true);
						$('.catbox tbody .check-one').prop('checked',true);
					}else{
						$('.catbox thead .check-all').prop('checked',false);
						$('.foot .check-all').prop('checked',false);
						$('.catbox tbody .check-one').prop('checked',false);
					}
					app.countAllPrice();
				});
			},
			checkOneByOne:function(){//单个商品选择
				$('.catbox .check-one').unbind().bind('click',function(){
					app.countAllPrice();
				});
			},
			addAndSub:function(){//数量添加、减少、修改
				$('.catbox tr .add,.catbox tr .reduce').unbind().bind('click',function(){
					var o=$(this).parent().find('input'),
						inventory=parseInt(o.attr('data-inventory')),
						count=parseInt(o.val());
						if($(this).is('.add')){
							count+=1;
						}else{
							count-=1;
						}
						app.addSubAffect(o,count,inventory,$(this));
						app.itemCountPrice($(this));
						app.countAllPrice();
						app.addCartNum(count,$(this).parent().parent().attr('data-creativeResourceId'));
				});
				$('.catbox .count .count-input').unbind().bind('blur',function(){
					var inventory=parseInt($(this).attr('data-inventory')),
						count=parseInt($(this).val());
					$('.catbox tr .add,.catbox tr .reduce').css('color','black');
					if(/^[1-9]\d*$/.test($(this).val())){
						if(count>inventory){
							that.parent().find('.add').css('color','#f0f0f0');
							$(this).val(inventory);
						}else if(count<1){
							that.parent().find('.reduce').css('color','#f0f0f0');
							$(this).val('1');
						}
					}else{
						$(this).val('1');
						$('.catbox tr .reduce').css('color','#f0f0f0');
					}
					app.itemCountPrice($(this));
					app.countAllPrice();
					app.addCartNum(count,$(this).parent().parent().attr('data-creativeResourceId'));
				})
			},
			addSubAffect:function(o,count,inventory,that){//数量添加或者减少 按钮效果处理
				if(count<inventory&&count>1){
					that.parent().find('.add,.reduce').css('color','black');
				}else{
					that.css('color','#f0f0f0');
				}
				if(count>inventory||count<1){
					return false;
				}else{
					o.val(count);
				}
			},
			itemCountPrice:function(that){//单条商品价格统计
				var price	=	Number(that.parent().find('input').attr('data-price')),
					count	=	Number(that.parent().find('input').val()),
					total	=	price*count;
					that.parent().siblings('.subtotal').attr('data-num',total);
					that.parent().siblings('.subtotal').html(T.fmtNumber(total,'#,###.00'));
			},
			countAllPrice:function(){
				var totalPrice=0.00,
					total=0;
				$('.catbox .check-one').each(function(){
					if($(this).is(':checked')){
						totalPrice+=Number($(this).parent().siblings('.subtotal').attr('data-num'));
						total+=Number($(this).parent().siblings('.count').find('input').val());
					}
				});
				$('.catbox #priceTotal').attr('data-total',totalPrice);
				$('.catbox #priceTotal').html(T.fmtNumber(totalPrice,'#,###.00'));
				$('.catbox #selectedTotal').attr('data-totalNum',total);
				$('.catbox #selectedTotal').html(total);
				console.log(total);
			},
			
			
			
			/*
			 * 数据处理
			 */
			
			initData:function(){//初始化购物车数据
				T.post('/s/card/myShoppingCard',{'page':page,'pageSize':pageSize},function(res){
					console.log(res);
					if(res.retCode=="10000"){
						var o=res.retObject.list;
							total=res.retCode.total;
							$.each(o,function(i,e){
								e.totalFormatPrice=T.fmtNumber(Number(e.shoppingNum*e.resourcePrice),'#,###.00');
								e.totalPrice=Number(e.shoppingNum*e.resourcePrice);
								e.price=T.fmtNumber(e.resourcePrice,'#,###.00');
							});
						$('.catbox tbody').empty();
						$('#shopping_cart_tmplate').tmpl(o).appendTo('.catbox tbody');
						app.check();
						app.addAndSub();
						app.checkOneByOne();
						app.del();
						app.page();
						app.myCollect();
					}
				});
			},
			refreshData:function(){//刷新数据
				T.post('/s/card/myShoppingCard',{'page':page,'pageSize':pageSize},function(res){
					console.log(res);
					if(res.retCode=="10000"){
						var o=res.retObject.list;
							$.each(o,function(i,e){
								e.totalFormatPrice=T.fmtNumber(Number(e.shoppingNum*e.resourcePrice),'#,###.00');
								e.totalPrice=Number(e.shoppingNum*e.resourcePrice);
								e.price=T.fmtNumber(e.resourcePrice,'#,###.00');
							});
						$('.catbox tbody').empty();
						$('#shopping_cart_tmplate').tmpl(o).appendTo('.catbox tbody');
						app.check();
						app.addAndSub();
						app.checkOneByOne();
						app.del();
					}
				});
			},
			page:function(){//分页
				$('.catbox #paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :pageSize,
					onchange : function(newPage) {
						page=newPage;
						app.refreshData();
					}
				});
			},
			addCartNum:function(count,id){//购物车数量添加减少
				
				T.post('/s/card/updateShCard',{"goodsId":id,"goodsNumber":count},function(res){
					console.log(res);
				});
			},
			del:function(){//删除
				$('.catbox .delete').unbind().bind('click',function(){
					console.log($(this).parent().parent().attr('data-creativeResourceId'));
					var id=$(this).parent().parent().attr('data-creativeResourceId');
					T.post('/s/card/deleteShCard',{'shoppingCartId':id},function(res){
							console.log(res);
							if(res.retCode=='10000'){
								app.initData();
							}
					});
				});
			},
			myCollect:function(){//收藏
				$('.catbox .collect').unbind().bind('click',function(){
					console.log('ok');
					var id=$(this).parent().parent().attr('data-creativeResourceId'),
						resourceType=$(this).parent().parent().attr('data-resourceType');
					T.post('/s/favorite/insertMyFavorite',{'houseType':resourceType ,'houseResourceId':id},function(res){
							console.log(res);
							if(res.retCode=='10000'){
								app.initData();
							}
					});
				});
			},
			payFor:function(){//去支付
				$('.catbox .foot .payFor').unbind().bind('click',function(){
					if(Number($('.catbox #selectedTotal').attr('data-totalNum'))<=0){
						$.alert('请选择商品')
					}else{
						var ids=[];
							$('.catbox tbody input').each(function(i,e){
								if($(this).is(':checked')){
									var id=$(this).parent().parent().attr('data-creativeResourceId');
									ids.push(id);
								}
							});
							sessionStorage.setItem('ids',ids);
							$('.rightContentField').load('resources/html/front/shoppingCartCount.html');	
					}
				});
			}		
	}
	app.init();
})