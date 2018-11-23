<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript">
	
	function changeImage(){
													/* 让浏览器监控到地址会有变化 */
		$("#kaptchaImage").prop("src","Kaptcha.do?t="+new Date().getTime());
	}
</script>
</head>

<body>
<div class="wrap">
<!-- main begin-->
 <div class="main">
   <div class="sidebar">
     <p><img src="images/img1.jpg" width="443" height="314" alt="" /></p>
   </div>
   <div class="sidebarg">
     <form action="${pageContext.request.contextPath}/login.do" method="post" target='_blank'>
    <div class="login">
      <dl>
        <dt class="blues">用户登陆</dt>													<!-- 常用邮箱 -->
        <dd><label for="name">用户名：</label><input type="text" class="inputh" value="" id="name" name="user_name"/></dd>
        <dd><label for="password">密 码：</label><input type="text" class="inputh" value="" id="password" name="user_password"/></dd>
        <dd>																			<!-- 密码 -->
           <label class="lf" for="passwords">验证码：</label>
           <input type="text" class="inputh inputs lf" value="验证码" id="passwords" name="kaptcha"/>
           	<!-- 为了第一次访问的时候就让验证码自动生成出并不是一个固定的死值所以让图片的路径改为定义的产生验证码的Controller,让页面加载完成后应可以生成一个可用的验证码 -->
          	<!-- 如果不这样写在访问的时候如果不点击更换验证码获得到一个可用的验证码的话就会因为获取不到验证码而报错 -->
           <span class="wordp lf"><img src="${pageContext.request.contextPath}/Kaptcha.do" width="96" height="27" alt="" id="kaptchaImage"/></span>
           <span class="blues lf"><a href="javascript:void(0)" title="" onclick="changeImage()">看不清</a></span>
        </dd>
        <dd>
           <input name=""  type="checkbox" id="rem_u"  />
           <span for="rem_u">下次自动登录</span>
        </dd>
        <dd class="buttom">
           <input name="" type="submit" value="登 录" class="spbg buttombg f14 lf" />
          <!--  <input name="" type="submit" value="注 册" class="spbg buttombg f14 lf" /> -->
          <a href="${pageContext.request.contextPath}/register.jsp" class="spbg buttombg f14 lf">注册</a>
           <span class="blues  lf"><a href="" title="">忘记密码?</a></span>
           <div class="cl"></div>
        </dd>
       
      </dl>
    </div>
    </form>
   </div>
  <div class="cl"></div>
 </div>
<!-- main end-->
 
<!-- footer begin-->
</div>
 <!--footer end-->
 
</div>
</body>
</html>
