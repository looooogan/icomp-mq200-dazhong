<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String basePath = request.getContextPath();
	String basePathWeb = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>测试页面</title>
<meta name="viewport" content="width=device-width" />
<link rel="stylesheet"
	href="<%=basePath%>/resource/jquery.mobile-1.4.0/jquery.mobile-1.4.0.css" />
<script src="<%=basePath%>/resource/js/jquery-1.11.1.min.js"></script>
<script
	src="<%=basePath%>/resource/jquery.mobile-1.4.0/jquery.mobile-1.4.0.js"></script>
<script src="<%=basePath%>/resource/js/xUtil.js"></script>
<script src="<%=basePath%>/resource/js/global.js"></script>
<script src="<%=basePath%>/resource/js/mobiscroll.custom-2.5.0.min.js"></script>
<script src="<%=basePath%>/resource/js/highstock.js"
	type="text/javascript"></script>
<script src="<%=basePath%>/resource/js/previewImg.js"></script>
<link href="<%=basePath%>/resource/css/mobiscroll.custom-2.5.0.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/resource/css/styles.css" rel="stylesheet"
	type="text/css" />

<script>
	// 所有对话框按钮应该关闭父对话框
	$(document).on("mobileinit", function() {
		$.mobile.defaultPageTransition = "slide";
	});
</script>

<script type="text/javascript">
	pages.index = {
		onCreate : function() {
			var me = this;
			$("#supplement",me.ui).on('click',function(){
				$.mobile.pageContainer.pagecontainer("change", "#supplement");
			});
			$("#mallId",me.ui).on('click',function(){
				$.mobile.pageContainer.pagecontainer("change", "#mallTest");
			});
			$("#customerId",me.ui).on('click',function(){
				$.mobile.pageContainer.pagecontainer("change", "#test");
			});
			$("#commondId",me.ui).on('click',function(){
				$.mobile.pageContainer.pagecontainer("change", "#commonId");
			});
		}
	};
</script>
</head>
<body>

	<div data-role="page" id="index">
		<!--data-role="page"调用js  -->
		<br>
		<input type="button" value="1接口--18接口" id="customerId">
		<br>
		<input type="button" value="19接口--38接口" id="mallId">
		<br>
		<input type="button" value="39接口--45接口" id="supplement">
		<br>
	</div>
	<%@include file="mallTest.jsp"%>
</body>
</html>
