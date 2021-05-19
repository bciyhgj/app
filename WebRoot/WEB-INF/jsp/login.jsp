<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>开发者平台入口</title>
    
    <link type="text/css" href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link type="text/css" href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link type="text/css" href="${pageContext.request.contextPath }/statics/css/nprogress.css" rel="stylesheet">
    <link href="https://colorlib.com/polygon/gentelella/css/animate.min
    <!-- Animate.css -->.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link type="text/css" href="${pageContext.request.contextPath }/statics/css/custom.min.css" rel="stylesheet">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="${pageContext.request.contextPath }/doLogin" method="POST">
              <h1>APP开发者平台</h1>
              <div>${eeror }</div>
              <div>
                <input type="text" name="devCode" class="form-control" placeholder="请输入用户名" required="" />
              </div>
              <div>
                <input type="password" name="devPassword" class="form-control" placeholder="请输入密码" required="" />
              </div>
              <div>
                <!--<a class="btn btn-default submit" href="index.html">登录</a>
                <a class="reset_pass" href="#">Lost your password?</a>-->
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">New to site?
                  <!--<a href="#signup" class="to_register"> Create Account </a>-->
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                  <p>©2016 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                </div>
              </div>
            </form>
          </section>
        </div>
       </div>
      </div>
  </body>
</html>
