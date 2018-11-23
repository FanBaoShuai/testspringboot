<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function jingpai(pricessss){
		var max = parseFloat($("#max").next().children("li:eq(1)").html());
		var aa = parseFloat($("#sale").val());
		if(!max){
			max = pricessss;
		}
		if(max>aa){
			$("#ppp").html("不能低于最高竞拍价");
			return false;
		}else{
			$("#ppp").html("");
			return true;
		}
	}
	$(function(){
		var max = parseFloat($("#max").next().children("li:eq(1)").html());
		if(!max){
			max = $("ul:eq(4)").children("li:eq(1)").html();
		}
		$("#sale").val(max);
	});
</script>
</head>

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
  <div class="items sg-font lf">
      <ul class="rows">
        <li>名称：</li>
        <li class="borderno">${auction.auction_name}</li>
      </ul>
      <ul class="rows">
        <li>描述：</li>
        <li class="borderno">${auction.auction_desc }</li>
      </ul>
      <ul class="rows">
        <li>开始时间：</li>
        <li class="borderno">${auction.auction_start_time }</li>
      </ul>
      <ul class="rows">
        <li>结束时间：</li>
        <li class="borderno">${auction.auction_end_time }</li>
      </ul>
      <ul class="rows border-no">
        <li>起拍价：</li>
        <li class="borderno">${auction.auction_start_price }</li>
      </ul>
  </div>
  <div class="rg borders"><img src="images/ad20.jpg" width="270" height="185" alt="" /></div>
  <div class="cl"></div>
  <div class="top10 salebd">
  	<form action="${pageContext.request.contextPath}/recordAdd.do" method="post">
       <p>
       <input type="hidden" name="auction_id" value="${auction.auction_id}"/>
       <label for="sale">出价：</label>
       <input type="text"  class="inputwd" id="sale" value="4000" name="auction_price" onblur="jingpai(${auction.auction_start_price})"/>
       <input name="" type="submit" value="竞 拍" class="spbg buttombg f14  sale-buttom" />
       </p>
       <p class="f14 red" id="ppp"></p>
    </form>
  </div>
  <div class="top10">
    <a href="#"><input name="" type="submit" value="刷 新" class="spbg buttombg f14" /></a>
    <a href="${pageContext.request.contextPath}/pmspgly.jsp"><input name="" type="submit" value="返回列表" class="spbg buttombg f14" /></a>
  </div>
  <div class="offer">
    <h3>出价记录</h3>
    <div class="items sg-font">
      <ul class="rows even strong" id="max">
        <li>竞拍时间</li>
        <li>竞拍价格</li>
        <li class="borderno">竞拍人</li>
      </ul>
    <c:forEach items="${recordList }" var="fb">
      <ul class="rows">
        <li>${fb.auction_time }</li>
        <li>${fb.auction_price }</li>
        <li class="borderno">${fb.user.user_name }</li>
      </ul>
    </c:forEach>
  </div>
  </div>
<!-- main end-->
</div>
</body>
</html>
