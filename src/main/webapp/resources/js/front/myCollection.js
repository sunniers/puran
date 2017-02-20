/*
 *	createTime:2016/10/20
 * 	author	  :tangj
 * 	edit	  :
 * 
 */
$(function(){
	var start=1,
		size=10,
		total=0;
	var obj={
			'collDemand':{"page":1,"pageSize":10,"houseResourceName":""},//需求
			'collTalent':{"page":1,"pageSize":10,"houseResourceName":""},//人才
			'collRes':{"page":1,"pageSize":10,"houseResourceName":""}//资源
			};
	var objUrl={
			'collDemand':'/s/favorite/selectRequirementFavorite',//需求
			'collTalent':'/s/favorite/selectTalentFavorite',//人才
			'collRes':'/s/favorite/selectResourceFavorite'//资源
	}
	var _obj='collDemand';//当前活动页
	
	var goPage={
			"700002":'../resources/html/front/recruitmentDetails.html',//招募详情
			"700001":'../resources/html/front/demandDetail.html',//需求详情
			"700003":'../resources/html/front/financingDetail.html'//融资详情
		}
	var app={
			
			init:function(){
				this.initData();
				this.tab();
				this.saerch();
			},
			initData:function(){
				T.post(objUrl[_obj],obj[_obj],function(res){
					if(res.retCode=='10000'){
						var o=res.retObject.list;
							total=o.total;
							app.insertData(o);
							app.page();
					}
				});
			},
			fmtDemandData:function(o){//格式化需求数据
				$.each(o,function(index,ele){
					ele.price=T.fmtNumber(ele.price,' #,###.##');
					if(ele.status=='400102'){
						ele.status='报名中';
					}else if(ele.status=='400103'){
						ele.status='已结束';
					}
				})
			},
			fmtTalentData:function(o){//格式化需求数据
				$.each(o,function(index,ele){
					ele.price=T.fmtNumber(ele.price,' #,###.##');
				})
			},
			fmtResData:function(o){//格式化需求数据
				$.each(o,function(index,ele){
					ele.resourcePrice=T.fmtNumber(ele.resourcePrice,' #,###.##');
				})
			},
			refreshData:function(){
				T.post(objUrl[_obj],obj[_obj],function(res){
					console.log(res);
					if(res.retCode=='10000'){
						var o=res.retObject.list;
							app.insertData(o);
					}
				});
			},
			insertData:function(o){
				if(_obj=='collDemand'){
					app.fmtDemandData(o);//格式化需求数据
					$('.collContent .collDemand').empty();
					$('#coll_collDemand_template').tmpl(o).appendTo('.collContent .collDemand');
				}else if(_obj=='collTalent'){
					app.fmtTalentData(o);//格式化需求数据
					$('.collContent .collTalent').empty();
					$('#coll_collTalent_template').tmpl(o).appendTo('.collContent .collTalent');
				}else if(_obj=='collRes'){
					app.fmtResData(o);//格式化需求数据
					$('.collContent .collRes').empty();
					$('#coll_collRes_template').tmpl(o).appendTo('.collContent .collRes');
				}
				app.demandDetail();
				app.talentDetail();
				app.resDetail();
			},
			page:function(){
				$('#paginator').smartpaginator({
					totalrecords :total,
					recordsperpage :size,
					onchange : function(newPage) {
						start=newPage;
						obj[_obj].page=start;
						obj[_obj].houseResourceName=$('.myCollection .search .searchInput').val();
						app.refreshData();
					}
				});
			},
			tab:function(){//切换
				$('.myCollection .head .item').bind('click',function(){
					var id=$(this).attr('data-id');
						_obj=id;//切换活动页
					$('.myCollection .search .searchInput').val('');
					obj[_obj].houseResourceName=$('.myCollection .search .searchInput').val();
					$('.collContent>div').hide();
					$('.collContent .'+id).show();
					$('.myCollection .head .item').removeClass('active');
					$(this).addClass('active');
					app.initData();
				});
			},
			saerch:function(){//条件搜索
				$('.search button').bind('click',function(){
					obj[_obj].houseResourceName=$('.myCollection .search .searchInput').val();
					console.log($('.search .searchInput').val());
					app.initData();
				});
			},
			demandDetail:function(){
				$('.myCollection .collDemand .detail').bind('click',function(){
					var id=$(this).attr('data-id'),
						status=$(this).attr('data-status');
						console.log(status);
						sessionStorage.setItem('id',id);
						$('.rightContentField').load(goPage[status]);
						
				});
			},
			talentDetail:function(){
				$('.myCollection .collTalent .detail').bind('click',function(){
					var id=$(this).attr('data-id');
						sessionStorage.setItem('id',id);
						$('.rightContentField').load('../resources/html/front/talentDetails.html');
						
				});
			},
			resDetail:function(){
				$('.myCollection .collRes .m').bind('click',function(){
					var id=$(this).attr('data-id');
						sessionStorage.setItem('id',id);
						$('.rightContentField').load('../resources/html/front/myBuyResourcesSee.html');
						
				});
			}
	}
	app.init();
})