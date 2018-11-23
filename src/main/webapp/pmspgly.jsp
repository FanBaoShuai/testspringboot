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
	function updates(id){
		if(confirm("你真的确认要修改吗？请确认")){
			window.location="${pageContext.request.contextPath}/selectOne.do?id="+id;
		}
	};
	function supping(id){
		if(confirm("你真的确认要竞拍吗？请确认")){
			window.location="${pageContext.request.contextPath}/selectOne1.do?id="+id;
		}
	};
	function deletes(id){
		if(confirm("你真的确认要删除吗？请确认")){
			window.location="${pageContext.request.contextPath}/delete.do?id="+id;
		}
	};
	function adds(){
		if(confirm("你真的确认要发布吗？请确认")){
			window.location="${pageContext.request.contextPath}/add.jsp";
		}
	}
</script>
</head>

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
  <div class="forms">
  <form action="${pageContext.request.contextPath}/selectAll.do" method="post">
    <label for="name">名称</label>
    <input name="auction_name" value="" type="text" class="nwinput" id="name"/>
    <label for="names">描述</label>
    <input name="auction_desc" value="" type="text" id="names" class="nwinput"/>
    <label for="time">开始时间</label>
    <input name="auction_start_time" value="" type="text" id="time" class="nwinput"/>
    <label for="end-time">结束时间</label>
    <input name="auction_end_time" value="" type="text" id="end-time" class="nwinput" />
    <label for="price">起拍价</label>
    <input name="auction_start_price" value="" type="text" id="price" class="nwinput" />
    <input name="" type="submit"  value="查询" class="spbg buttombg f14  sale-buttom" onclick="selectAlls()"/>
    <input type="button"  value="发布" class="spbg buttombg f14  sale-buttom buttomb" onclick="adds()"/>
 </form>
  </div>
  <div class="items">
      <ul class="rows even strong">
        <li>名称</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>
    <c:forEach items="${listAuction}" var="f"> 
      <ul class="rows">
        <li><a href="国书" title="">${f.auction_name}</a></li>
        <li class="list-wd">${f.auction_desc }</li>
        <li>${f.auction_start_time }</li>
        <li>${f.auction_end_time }</li>
        <li>${f.auction_start_price }</li>
        <li class="borderno red">
        <c:if test="${user.user_is_admin==0 }">
          	<a href="javascript:void(0)" onclick="supping(${f.auction_id});">竞拍</a>
        </c:if>
        <c:if test="${user.user_is_admin==1 }">
		   	<a href="javascript:void(0)" title="修改" onclick="updates(${f.auction_id});">修改</a>|
          	<a href="javascript:void(0)" title="删除" onclick="deletes(${f.auction_id});">删除</a>
        </c:if>
        </li>
      </ul>
   </c:forEach> 
     
      <div class="page">
        <a href="#" title="">首页</a>
        <a href="#" title="">上一页</a>
        <span class="red">前5页</span>
        <a href="#" title="">1</a> 
        <a href="#" title="">2</a> 
        <a href="#" title="">3</a> 
        <a href="#" title="">4</a>
        <a href="#" title="">5</a> 
        <a href="#" title="">下一页</a>
        <a href="#" title="">尾页</a> 
      </div>
  </div>
</div>
</body>
</html>