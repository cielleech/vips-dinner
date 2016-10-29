<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<html>
  <head>
    <title>vue test</title>
    <link rel="stylesheet" type="text/css" href="${base}/assets/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${base}/assets/bootstrap/css/bootstrap-table.css" />
    <link rel="stylesheet" type="text/css" href="${base}/assets/bootstrap/css/bootstrap-editable.css" />
    <script src="${base}/assets/vue/vue.min.js" type="text/javascript"></script>
    <script src="${base}/assets/vue/vue-resource.min.js" type="text/javascript"></script>
    <script src="${base}/assets/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${base}/assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${base}/assets/bootstrap/js/bootstrap-table.js" type="text/javascript"></script>
    <script src="${base}/assets/bootstrap/js/bootstrap-editable.js" type="text/javascript"></script>
    <script src="${base}/assets/bootstrap/js/bootstrap-table-editable.js" type="text/javascript"></script>
    <script src="${base}/assets/bootstrap/js/bootstrap-table-zh-CN.js" type="text/javascript"></script>
  </head>
  <body>
    <table id="table"
           data-toggle="table"
           data-height="460"
           data-pagination="true"
           data-url="${base}/assets/data.json">
    </table>
    <div id="app">
      <h1>{{ message }}</h1>
    </div>
    <script type="text/javascript">
     $('#table').bootstrapTable({
      search: true,
      columns:[
        { field: 'id', title: 'ID', align: 'center'},
        { field: 'name', title: 'Name', sortable: true, editable: true, align: 'center'},
        { field: 'price', title: 'Price', sortable: true, align: 'center'}
      ]
    });

    new Vue({
      el: '#app',
      data: {
        message: 'hello world, vue.js'
      }
    })
    </script>
  </body>
</html>
