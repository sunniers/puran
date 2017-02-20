/*
 *	createTime:2016/11/9
 * 	author	  :Tjun
 * 	
 * 
 */
$(function(){
	
	
	var app={
			
			init:function(){
				this.initData();
				this.payFor();
				this.cancel();
			},
			initData:function(){
				
				var ids=sessionStorage.getItem('ids').split(',');
				T.post('/s/card/selectAccount',{'ids':ids},function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var o=res.retObject.list;
							$.each(o,function(i,e){
								e.itemTotalPrice=Number(e.resourcePrice*e.shoppingNum)
								e.price=T.fmtNumber(e.itemTotalPrice,'#,###.##');
							});
							var totalNum=0,
								totalPrice=0;
							$.each(o,function(i,e){
								totalNum+=Number(e.shoppingNum);
								totalPrice+=e.itemTotalPrice;
							});
							totalPrice=totalPrice.toFixed(2)
							$('.shoppingCartCount .count .num').attr('data-num',totalNum)
							$('.shoppingCartCount .count .num').html('商品数量：'+T.fmtNumber(totalNum,'#,###.##')+'件');
							
							$('.shoppingCartCount .count .totalPrice').attr('data-num',totalPrice)
							$('.shoppingCartCount .count .totalPrice').html('应付金额：'+T.fmtNumber(totalPrice,'#,###.##')+'元');
							
							$('.shoppingCartCount .tableList tbody').empty();
							$('#shopping_cartCount_tmplate').tmpl(o).appendTo('.shoppingCartCount .tableList tbody');
					}
				});
			},
			cancel:function(){
				$('.shoppingCartCount .goPay  .cancel').unbind().bind('click',function(){
					$('.rightContentField').load('resources/html/front/shoppingCart.html');	
				});
			},
			payFor:function(){
				$('.shoppingCartCount .goPay  .pay').unbind().bind('click',function(){
					$('.rightContentField').load('resources/html/front/payFor.html');	
				});
			}
	}
	app.init();
})