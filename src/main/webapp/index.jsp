<%--
  Created by IntelliJ IDEA.
  User: cielleech
  Date: 16/9/14
  Time: 下午4:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
  <script src="${base}/assets/vue/vue.min.js"></script>
</head>
<body>
  <div id="app">
    {{ message }}
  </div>
  <script type="text/javascript">
    new Vue({
      el: '#app',
      data: {
        message: 'Hello world vue.js'
      }
    })
  </script>
</body>
</html>
