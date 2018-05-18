<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript">
	pages.mallTest = {
		onCreate : function() {
			var me = this;
			me.msel = $("#selectMenu", me.ui);
			me.paramValue = $("#paramValue", me.ui);
			me.btn = $("#submit", me.ui);

			me.paramValue.val("请选择菜单");
			me.msel.on('change', function() {
				me.onChange(this);
			});
			me.btn.on('click', function() {
				me.onSubmit();
			});
		},
		onChange : function(obj) {
			var me = this;
			if (obj.value == "") {
				me.paramValue.val("请选择菜单");
			}else if (obj.value == "/newsOrders") {
				me.paramValue
							.val("userId(用户id):4\ncourierId:4\npageNo:1\nlongitude:1\nlatitude:1");
			}else if (obj.value == "/deliverGoodsInfo") {
				me.paramValue
							 .val("deliverId:18");
			}else if (obj.value == "/updateUserInfo") {
				me.paramValue
							.val("userId:1\nheadImgUrl:1\nnickName:1\nbirthDay:1990-01-01\nsex:1\nlocatTion:1\nsigh:");
			}else if (obj.value == "/getUserHome") {
				me.paramValue
							.val("userId:1");
			}else if (obj.value == "/getNotOverdueEnvelope") {
				me.paramValue
				            .val("");
			}else if (obj.value == "/getOverdueEnvelope") {
				me.paramValue
							.val("pageNo:1\npageSize1:1");
			} else if (obj.value == "/getGoodsPosition") {
				me.paramValue.val("courierId:4");
			} else if (obj.value == "/checkEnvelope") {
				me.paramValue.val("redId:31");
			} else if (obj.value == "/determineCourier") {
				me.paramValue.val("userId:4\ndeliverId:30\ncourierId:4");
			} else if(obj.value == "/getNvClass"){
				me.paramValue.
							val("");
			} else if(obj.value == "/delConsigneeManagement"){
				me.paramValue.
							val("consigneeId:1");
			} else if(obj.value == "/insConsigneeManagement"){
				me.paramValue.
							val("userId:1\nconsigneeAddress:大连\nconsigneeName:测试\nconsigneePhone:10086");
			} else if(obj.value == "/getDeliverManagement"){
				me.paramValue.
							val("userId : 1");
			} else if(obj.value == "/delDeliverManagement"){
				me.paramValue.
							val("senderId : 1");
			} else if(obj.value == "/insDeliverManagement"){
				me.paramValue.
							val("userId:4\ndeliverAddress:大连\ndeliverName:测试\ndeliverPhone:10086");
			} else if(obj.value == "/getIntegralDetail"){
				me.paramValue.
							val("userId:4\npageNo:1");
			} else if(obj.value == "/selectCourier"){
				me.paramValue.
							val("deliverId:31\npageNo:1");
			} else if(obj.value == "/consigneeDetail"){
				me.paramValue.val("parcelId:1");
			} else if(obj.value == "/consumptionStatistics"){
				me.paramValue.
							val("userId:4\npageNo:1");
			} else if(obj.value == "/getHomeUserInfo"){
				me.paramValue.
							val("userId:1");
			}
			
		},
		onSubmit : function() {
			var me = this;
			
			$.mobile.loading("show"); //读取进度展示
			
			var requestParam='';

			if ($("#selectMenu", me.ui).val() == "") {
				$("#resultValue", me.ui).val('请选择菜单');
				$.mobile.loading("hide"); //读取进度展示
				return;
			}else if ($("#selectMenu", me.ui).val() == "/newsOrders") {
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
					userId : arrTemp[0].split(":")[1],
					courierId : arrTemp[1].split(":")[1],
					pageNo:arrTemp[2].split(":")[1],
					longitude : arrTemp[3].split(":")[1],
					latitude : arrTemp[4].split(":")[1]
				};
			}else if ($("#selectMenu", me.ui).val() == "/deliverGoodsInfo") {
				var arrTemp = $("#paramValue", me.ui).val();
				requestParam = {
					deliverId : arrTemp.split(":")[1]
				};
			}else if ($("#selectMenu", me.ui).val() == "/updateUserInfo") {
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
						userId : arrTemp[0].split(":")[1],
						headImgUrl : arrTemp[1].split(":")[1],
						nickName : arrTemp[2].split(":")[1],
						birthDay : arrTemp[3].split(":")[1],
						sex : arrTemp[4].split(":")[1],
						locatTion : arrTemp[5].split(":")[1],
						sigh : arrTemp[6].split(":")[1]
				};
			} else if ($("#selectMenu", me.ui).val() == "/getUserHome") {
				var arrTemp = $("#paramValue", me.ui).val();
				requestParam = {
					userId : arrTemp.split(":")[1]
				};
			} else if ($("#selectMenu", me.ui).val() == "/updateParcelInfo") {
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
					parcelId:arrTemp[0].split(":")[1],
					evaluationScores:arrTemp[1].split(":")[1]
				};
			} else if ($("#selectMenu", me.ui).val() == "/getOverdueEnvelope") {
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
						pageNo : arrTemp[0].split(":")[1],
						pageSize1 : arrTemp[1].split(":")[1],
				};
			} else if ($("#selectMenu", me.ui).val() == "/getHomeUserInfo") {
				var arrTemp = $("#paramValue", me.ui).val();
				requestParam = {
						userId : arrTemp.split(":")[1]
				};
			} else if ($("#selectMenu", me.ui).val() == "/getGoodsPosition") {
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
					courierId : arrTemp[0].split(":")[1]
				};
			} else if ($("#selectMenu", me.ui).val() == "/checkEnvelope") {
				var arrTemp = $("#paramValue", me.ui).val();
				requestParam = {
						redId : arrTemp.split(":")[1],
				};
			}else if($("#selectMenu", me.ui).val() == "/determineCourier"){
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
					userId : arrTemp[0].split(":")[1],
					deliverId : arrTemp[1].split(":")[1],
					courierId : arrTemp[2].split(":")[1]
				};
			}else if($("#selectMenu", me.ui).val() == "/getNvClass"){
				var arrTemp = $("#paramValue", me.ui).val();
				requestParam = {
				};
			}else if($("#selectMenu", me.ui).val() == "/delConsigneeManagement"){
				var arrTemp = $("#paramValue", me.ui).val();
				requestParam = {
					consigneeId : arrTemp.split(":")[1]
				};
			}else if($("#selectMenu", me.ui).val() == "/insConsigneeManagement"){
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
					userId : arrTemp[0].split(":")[1],
					consigneeAddress : arrTemp[1].split(":")[1],
					consigneeName : arrTemp[2].split(":")[1],
					consigneePhone : arrTemp[3].split(":")[1]
				};
			}else if($("#selectMenu", me.ui).val() == "/getDeliverManagement"){
				var arrTemp = $("#paramValue", me.ui).val();
				requestParam = {
					userId : arrTemp.split(":")[1]
				};
			}else if($("#selectMenu", me.ui).val() == "/delDeliverManagement"){
				var arrTemp = $("#paramValue", me.ui).val();
				requestParam = {
					senderId : arrTemp.split(":")[1]
				};
			}else if($("#selectMenu", me.ui).val() == "/insDeliverManagement"){
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
					userId : arrTemp[0].split(":")[1],
					deliverAddress : arrTemp[1].split(":")[1],
					deliverName : arrTemp[2].split(":")[1],
					deliverPhone : arrTemp[3].split(":")[1]
					
				};
			}else if($("#selectMenu", me.ui).val() == "/getIntegralDetail"){
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
					userId : arrTemp[0].split(":")[1],
					pageNo : arrTemp[1].split(":")[1]
				};
			}else if($("#selectMenu", me.ui).val() == "/selectCourier"){
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
					deliverId : arrTemp[0].split(":")[1],
					pageNo:arrTemp[1].split(":")[1]
				};
			}else if($("#selectMenu", me.ui).val() == "/consigneeDetail"){
				var arrTemp = $("#paramValue", me.ui).val();
				requestParam = {
					parcelId : arrTemp.split(":")[1]
				};
			}else if($("#selectMenu", me.ui).val() == "/consumptionStatistics"){
				var arrTemp = $("#paramValue", me.ui).val();
				arrTemp = arrTemp.split("\n");
				requestParam = {
					userId : arrTemp[0].split(":")[1],
					pageNo : arrTemp[1].split(":")[1]
				};
			}
			var html='';
			 $.ajax({ //ajax请求
					type : "POST",
					dataType : "json",
					url : x.basePath + $("#selectMenu", me.ui).val(),
					data : requestParam
				}).done(function(d) {//回调
					var me=this;
					$.mobile.loading("hide"); 
					//附近新订单
					if($("#selectMenu", me.ui).val()=="/newsOrders"){
						if(d.code == 999){
							html='系统错误';
						}else{
							for(var i=0;i<d.data.length;i++){
								html+=d.data[i].deliverId+'\n';
								html+=d.data[i].orderNo+'\n';
								html+=d.data[i].deliverTime+'\n';
								for(var j=0;j<d.data[i].parcelInfosBeans.length;j++){
									html+=d.data[i].parcelInfosBeans[j].parceType+'\n';
									html+=d.data[i].parcelInfosBeans[j].weight+'\n';
								}
							}
						}
						$("#resultValue",me.ui).val(html);
					//货物信息
					}else if($("#selectMenu", me.ui).val()=="/deliverGoodsInfo"){
						if(d.code == 999){
							html='系统错误';
						}else{
							html+=d.data.deliverGoodsInfoBean.deliverId+'\n';
							html+=d.data.deliverGoodsInfoBean.deliverTime+'\n';
							html+=d.data.deliverGoodsInfoBean.endTime+'\n';
							html+=d.data.deliverGoodsInfoBean.deliverName+'\n';
							html+=d.data.deliverGoodsInfoBean.deliverPhone+'\n';
							html+=d.data.deliverGoodsInfoBean.deliverAddress+'\n';
							html+=d.data.deliverGoodsInfoBean.courierName+'\n';
							html+=d.data.deliverGoodsInfoBean.courierCompany+'\n';
							html+=d.data.deliverGoodsInfoBean.courierCost+'\n';
							html+=d.data.deliverGoodsInfoBean.evaluationScores+'\n';
							for(var j=0;j<d.data.goodInfoBean.length;j++){
								html+=d.data.goodInfoBean[j].weight+'\n';
								html+=d.data.goodInfoBean[j].parceType+'\n';
								html+=d.data.goodInfoBean[j].sketch+'\n';
								html+=d.data.goodInfoBean[j].goodsImg+'\n';
								html+=d.data.goodInfoBean[j].parcelState+'\n';
								html+=d.data.goodInfoBean[j].consigneeName+'\n';
								html+=d.data.goodInfoBean[j].consigneePhone+'\n';
								html+=d.data.goodInfoBean[j].consigneeAddress+'\n';
							}
						}	
						$("#resultValue",me.ui).val(html);
					//抢单(点击抢单按钮)
					}else if($("#selectMenu", me.ui).val()=="/grabOrder"){
						if(d.code == 999){
							html='系统错误';
						}else{
							html='操作成功';
						}
						$("#resultValue",me.ui).val(html);
					//等待收货列表
					}else if($("#selectMenu", me.ui).val()=="/getUserHome"){
						var html = d.success + "\n" + d.message + "\n";
						if (d.data != null) {
								html += d.data.userId + "\n";
								html += d.data.headImgUrl + "\n";
								html += d.data.nickName + "\n";
								html += d.data.integral + "\n";
								html += d.data.messageFlg + "\n";
						} else {
							html += "没有数据";
						}
						$("#resultValue", me.ui).val(html);
					}else if($("#selectMenu", me.ui).val()=="/getNotOverdueEnvelope"){
						var html = d.success + "\n" + d.message + "\n";
						if(d.data != null){
							for(var i = 0;i<d.data.length;i++){
								html += d.data[i].redId + "\n";
								html += d.data[i].startTm + "\n";
								html += d.data[i].endTm + "\n";
							}
						}else{
							html += "没有数据";
						}
						
						$("#resultValue", me.ui).val(html);
					}else if($("#selectMenu", me.ui).val()=="/getOverdueEnvelope"){
						var html = d.success + "\n" + d.message + "\n";
						if(d.data != null){
							for(var i = 0;i<d.data.length;i++){
								html += d.data[i].redId + "\n";
								html += d.data[i].startTm + "\n";
								html += d.data[i].endTm + "\n";
							}
						}else{
							html += "没有数据";
						}
						$("#resultValue", me.ui).val(html);
// 						if(d.code == 999){
// 							html='系统错误';
// 						}else{
// 							for(var j=0;j<d.data.listBeans.length;j++){
// 								html+=d.data.listBeans[j].parcelId+'\n';
// 								html+=d.data.listBeans[j].deliverName+'\n';
// 								html+=d.data.listBeans[j].deliverPhone+'\n';
// 								html+=d.data.listBeans[j].deliverTime+'\n';
// 								html+=d.data.listBeans[j].parceType+'\n';
// 								html+=d.data.listBeans[j].parcelState+'\n';
// 								html+=d.data.listBeans[j].positionId+'\n';
// 							}
// 						}
// 						html+=d.data.count+'\n';
// 						$("#resultValue",me.ui).val(html);
					//确认收货
					}else if($("#selectMenu", me.ui).val()=="/updateParcelInfo"){
						if(d.code == 999){
							html='系统错误';
						}else if (d.code == 904){
							html='无效操作';
						}else{
							html='操作成功';
						}
						$("#resultValue",me.ui).val(html);
					//已送达
					}else if($("#selectMenu", me.ui).val()=="/haveDelivery"){
						if(d.code == 999){
							html='系统错误';
						}else if (d.code == 904){
							html='无效操作';
						}else{
							html='操作成功';
						}
						$("#resultValue",me.ui).val(html);
					//个人信息查询
					}else if($("#selectMenu", me.ui).val()=="/getHomeUserInfo"){
						var html = d.success + "\n" + d.message + "\n";
						if(d.data != null){
								html+=d.data.userId+'\n';
								html+=d.data.headImgUrl+'\n';
								html+=d.data.nickName+'\n';
								html+=d.data.birthDay+'\n';
								html+=d.data.sex+'\n';
								html+=d.data.locatTion+'\n';
								html+=d.data.sigh+'\n';
						}else {
							html += "没有数据";
						}
						$("#resultValue",me.ui).val(html);
					//用户送件列表
					}else if($("#selectMenu", me.ui).val()=="/getGoodsPosition"){
						if(d.code == 999){
							html='系统错误';
						}else{
							html +=d.data.longitude+'\n';
							html +=d.data.latitude+'\n';
						}
						$("#resultValue",me.ui).val(html);
					//发货消息详细
					}else if($("#selectMenu", me.ui).val()=="/checkEnvelope"){
						var html = d.success;
						$("#resultValue",me.ui).val(html);
					//指派快递员
					}else if($("#selectMenu", me.ui).val()=="/determineCourier"){
						if(d.code == 999){
							html='系统错误';
						}else{
							html='操作成功';
						}
						$("#resultValue",me.ui).val(html);
					//收件人管理(列表)
					
					} else if ($("#selectMenu", me.ui).val() == "/getNvClass") {
						var html = d.success + "\n" + d.message + "\n";
						if (d.data != null) {
							for ( var i = 0; i < d.data.length; i++) {
								html += d.data[i].nvcId + "\n";
								html += d.data[i].nvcName + "\n";
							}
						} else {
							html += "没有数据";
						}
						$("#resultValue", me.ui).val(html);
					//删除收件人
					}else if($("#selectMenu", me.ui).val()=="/delConsigneeManagement"){
						if(d.code == 999){
							html='系统错误';
						}else{
							html='操作成功';
						}
						$("#resultValue",me.ui).val(html);
					//增加收件人
					}else if($("#selectMenu", me.ui).val()=="/insConsigneeManagement"){
						if(d.code == 999){
							html='系统错误';
						}else{
							html='操作成功';
						}
						$("#resultValue",me.ui).val(html);
					//发货人管理(列表)
					}else if($("#selectMenu", me.ui).val()=="/getDeliverManagement"){
						if(d.code == 999){
							html='系统错误';
						}else{
							for(var i=0;i<d.data.length;i++){
								html+=d.data[i].senderId+'\n';
								html+=d.data[i].deliverName+'\n';
								html+=d.data[i].deliverPhone+'\n';
								html+=d.data[i].deliverAddress+'\n';
							}
						}
						$("#resultValue",me.ui).val(html);
					//删除发货人
					}else if($("#selectMenu", me.ui).val()=="/delDeliverManagement"){
						if(d.code == 999){
							html='系统错误';
						}else{
							html='操作成功';
						}
						$("#resultValue",me.ui).val(html);
					//增加发货人
					}else if($("#selectMenu", me.ui).val()=="/insDeliverManagement"){
						if(d.code == 999){
							html='系统错误';
						}else{
							html='操作成功';
						}
						$("#resultValue",me.ui).val(html);
					//积分明细
					}else if($("#selectMenu", me.ui).val()=="/getIntegralDetail"){
						if(d.code == 999){
							html='系统错误';
						}else{
							for(var i=0;i<d.data.length;i++){
								html+=d.data[i].codeName+'\n';
								html+=d.data[i].integral+'\n';
								html+=d.data[i].time+'\n';
							}
						}
						$("#resultValue",me.ui).val(html);
					//选择快递员
					}else if($("#selectMenu", me.ui).val()=="/selectCourier"){
						if(d.code == 999){
							html='系统错误';
						}else{
							for(var i=0;i<d.data.length;i++){
								html+='***************************************\n';
								html+="快递员Id:"+d.data[i].courierId+'\n';
								html+="快递员姓名:"+d.data[i].courierName+'\n';
								html+="快递员所属公司:"+d.data[i].company+'\n';
								html+="快递费用:"+d.data[i].offer+'\n';
								html+="评价分数:"+d.data[i].evaluationScores+'\n';
								html+="头像:"+d.data[i].headImage+'\n';
							}
						}
						$("#resultValue",me.ui).val(html);
					//收件详细
					}else if($("#selectMenu", me.ui).val()=="/consigneeDetail"){
						if(d.code == 999){
							html='系统错误';
						}else{
							html+=d.data.weight+'\n';
							html+=d.data.parceType+'\n';
							html+=d.data.sketch+'\n';
							html+=d.data.goodsImg+'\n';
							html+=d.data.consigneeName+'\n';
							html+=d.data.consigneePhone+'\n';
							html+=d.data.consigneeAddress+'\n';
							html+=d.data.evaluationScores+'\n';
							html+=d.data.deliverName+'\n';
							html+=d.data.deliverPhone+'\n';
							html+=d.data.deliverAddress+'\n';
							html+=d.data.deliverTime+'\n';
							html+=d.data.endTime+'\n';
							html+=d.data.courierName+'\n';
							html+=d.data.courierPhone+'\n';
							html+=d.data.courierCompany+'\n';
						}
						$("#resultValue",me.ui).val(html);
					//消费统计
					}else if($("#selectMenu", me.ui).val()=="/consumptionStatistics"){
						if(d.code == 999){
							html='系统错误';
						}else{
							for(var i=0;i<d.data.length;i++){
								html+=d.data[i].money+'\n';
								html+=d.data[i].operationType+'\n';
								html+=d.data[i].insertTime+'\n';
							}
						}
						$("#resultValue",me.ui).val(html);
					};
				});
			}
		};
</script>

<div data-role="page" id="mallTest">
	<div>
		<select name="selectMenu" id="selectMenu">
			<option value="" selected>请选择</option>
			<option value="/newsOrders">19.附近新订单</option>
			<option value="/deliverGoodsInfo">20. 货物信息</option>
			<option value="/updateUserInfo">21.个人信息修改</option>
			<option value="/getUserHome">22.我的首页</option>
			<option value="/getNotOverdueEnvelope">23.可抢红包查询</option>
			<option value="/getOverdueEnvelope">24.过期红包查询</option>
			<option value="/getHomeUserInfo">25.个人信息查询</option>
			<option value="/checkEnvelope">26.验证红包是否可抢</option>
			<option value="/determineCourier">27.指派快递员</option>
			<option value="/getNvClass">28.新闻视频分类</option>
			<option value="/delConsigneeManagement">29.删除收件人</option>
			<option value="/insConsigneeManagement">30.增加收件人</option>
			<option value="/getDeliverManagement">31.发货人管理(列表)</option>
			<option value="/delDeliverManagement">32.删除发货人</option>
			<option value="/insDeliverManagement">33.增加发货人</option>
			<option value="/getIntegralDetail">34.积分明细</option>
			<option value="/selectCourier">35.选择快递员</option>
			<option value="/consigneeDetail">36.收件详细</option>
			<option value="/consumptionStatistics">38.消费统计</option>
			<option value="/getGoodsPosition">37.追件</option>
		</select>
	</div>
	<div>
		<textarea rows="10" cols="15" name="paramValue" id="paramValue"></textarea>
		<input type="button" value="提交" id="submit">
	</div>
	<div>
		<textarea rows="10" cols="15" name="resultValue" id="resultValue"></textarea>
	</div>
</div>
