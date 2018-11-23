<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	function submits(){
		if(names()&&prices()&&starts()&&ends()){
			return true;
		}else{
			return false;
		}
	};

	function names(){
		var acnname = document.getElementById("acnname").value;
		var acndname = document.getElementById("acndname");
		if(acnname.trim().length==0){
			acndname.innerHTML="名字不能为空";
			return false;
		}else{
			acndname.innerHTML="格式正确";
			return true;
		}
	};
	function prices(){
		var acnprices= /^\d+$/;
		var acnpricess = /^\d+.\d+$/;
		var acnprice = document.getElementById("acnprice").value;
		var acndprice = document.getElementById("acndprice");
		if(acnprices.test(acnprice)||acnpricess.test(acnprice)){
			acndprice.innerHTML="格式正确";
			return true;
		}else{
			acndprice.innerHTML="必须为数字";
			return false;
		}
	};
	function upsetsss(){
		var acnupsets = /^\d+$/;
		var acnupsetss = /^\d+.\d+$/;
		var acnupset = document.getElementById("acnupset").value;
		var acndupset = document.getElementById("acndupset");
		if(!acnupsets.test(acnupset)||acnupsetss.test(acnupset)){
			acndupset.innerHTML="必须为数字";
			return false;
		}else{
			acndupset.innerHTML="格式正确";
			return true;
		}
	};
	function starts(){
		var startss = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/;
		var acnstart = document.getElementById("acnstart").value;
		var acndstart = document.getElementById("acndstart");
		if(startss.test(acnstart)){
			acndstart.innerHTML="格式正确";
			return true;
		}else{
			acndstart.innerHTML="格式：2010-05-05 12:30:00";
			return false;
		}
	};
	function ends(){
		var endss = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/;
		var acnend = document.getElementById("acnend").value;
		var acndend = document.getElementById("acndend");
		if(endss.test(acnend)){
			acndend.innerHTML="格式正确";
			return true;
		}else{
			acndend.innerHTML="格式：2010-05-05 12:30:00";
			return false;
		}
	};
</script>
</head>

<body>
<div class="wrap">
  <!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
        <form action="${pageContext.request.contextPath}/update.do" method="post" enctype="multipart/form-data" onsubmit="return submits()">
        <input type="hidden" name="auction_id" value="${auction.auction_id}">
          <dl>
            <dd >
              <label>名称：</label>
              <input type="text" class="inputh lf" value="${auction.auction_name}" name="auction_name" id="acnname" onblur="names()"/>
              <div class="xzkbg spbg lf" id="acndname"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input type="text" class="inputh lf" value="${auction.auction_start_price }" name="auction_start_price" id="acnprice" onblur="prices()"/>
              <div class="lf red laba"  id="acndprice"></div>
            </dd>
            <dd>
              <label>底价：</label>
              <input type="text" class="inputh lf" value="${auction.auction_upset }" name="auction_upset" id="acnupset" onblur="upsetsss()"/>
              <div class="lf red laba" id="acndupset"></div>
            </dd>
            <dd>
              <label>开始时间：</label>
              <input type="text" class="inputh lf" value="<fmt:formatDate value="${auction.auction_start_time }" pattern="yyyy-MM-dd HH:mm:ss"/>" name="auction_start_time" id="acnstart" onblur="starts()"/>
              <div class="lf red laba" id="acndstart"></div>
            </dd>
            <dd>
              <label>结束时间：</label>
              <input type="text" class="inputh lf" value="<fmt:formatDate value="${auction.auction_end_time}" pattern="yyyy-MM-dd HH:mm:ss"/>"  name="auction_end_time" id="acnend" onblur="ends()"/>
              <div class="lf red laba" id="acndend"></div>
            </dd>
            <dd class="dds">
              <label>描述：</label>
              <textarea name="auction_desc" cols="" rows="" class="textarea">${auction.auction_desc}</textarea>
            </dd>
            <dd>
              <label>修改图片：</label>
              <div class="lf salebd"><a href="#"><img src="${pageContext.request.contextPath}/images/${auction.auction_pic }" width="100" height="100" /></a></div>
               <input name="touxiang" type="file" class="marg10" />
               <input type="hidden" name="auction_pic" value="${auction.auction_pic }">
            </dd>
            <dd class="hegas">
                <input name="" type="submit" value="保 存" class="spbg buttombg buttombgs f14 lf buttomb"/>
                <input name="" type="submit" value="取 消" class="spbg buttombg buttombgs f14 lf buttomb" />
            </dd>
          </dl>
            </form>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 
</div>
</body>
</html>
