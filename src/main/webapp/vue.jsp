<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<html>
  <head>
    <title>vue test</title>
    <script src="${base}/assets/vue/vue.min.js" type="text/javascript"></script>
    <script src="${base}/assets/vue/vue-resource.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${base}/assets/bootstrap/css/bootstrap-table.css" />
  </head>
  <body>
    <table data-toggle="table">
      <thead>
        <tr>
          <th>Item ID</th>
          <th>Item Name</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>2</td>
        </tr>
      </tbody>
    </table>
    <div id="app">
      <h1>{{ message }}</h1>
    </div>
    <script type="text/javascript">
    new Vue({
      el: '#app',
      data: {
        message: 'hello world, vue.js'
      }
    })
    </script>
  </body>
</html>
