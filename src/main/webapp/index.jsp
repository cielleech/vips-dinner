<%--
Created by IntelliJ IDEA.
User: cielleech
Date: 16/9/14
Time: 下午4:47
To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<html>
  <head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <script type="text/javascript" src="${base}/assets/vue/vue.min.js"></script>
    <script type="text/javascript" src="${base}/assets/vue/vue-resource.min.js"></script>
    <script type="text/javascript"
            src="${base}/assets/jquery/jquery-1.9.1.min.js"></script>
    <script type="text/javascript"
            src="${base}/assets/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css"
                           href="${base}/assets/bootstrap/css/bootstrap.min.css" />
  </head>
  <body>
    <button class="btn-default">默认按钮</button>
    <button class="btn-primary">原始按钮</button>
    <button class="btn-success">成功按钮</button>
    <button class="btn-info">信息按钮</button>
    <button class="btn-warning">警告按钮</button>
    <button class="btn-danger">危险按钮</button>
    <button class="btn-link">链接按钮</button>
    <div class="row">
      <div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8</div>
    </div>
    <button class="btn btn-warning" >test</button>
    <!--     <div class="container"> -->
      <div class="row">
        <div class="col-lg-4" style="background:red;">col-md-8</div>
        <div class="col-lg-4 col-md-offset-4" style="background:green;">col-md-4</div>
      </div>
      <!--     </div> -->
    <div class="container">
      <ul>
        <li>1</li>
        <li>2</li>
        <li>3</li>
      </ul>
    </div>
    <table class="table">
      <tr>
        <td>1</td>
        <td>2</td>
      </tr>
    </table>
    <form class="form-inline" role="form">
      <div class="form-group">
        <label class="sr-only" for="exampleInputEmail2">Email
          address</label> <input type="email" class="form-control"
                                              id="exampleInputEmail2" placeholder="Enter email">
      </div>
      <div class="form-group">
        <div class="input-group">
          <div class="input-group-addon">@</div>
          <input class="form-control" type="email"
                                      placeholder="Enter email">
        </div>
      </div>
      <div class="form-group">
        <label class="sr-only" for="exampleInputPassword2">Password</label>
        <input type="password" class="form-control"
                               id="exampleInputPassword2" placeholder="Password">
      </div>
      <div class="checkbox">
        <label> <input type="checkbox"> Remember me
        </label>
      </div>
      <button type="submit" class="btn btn-default">Sign in</button>
    </form>

    <div class="dropdown">
      <button class="btn btn-default dropdown-toggle" type="button"
                                                      id="dropdownMenu1" data-toggle="dropdown">
        Dropdown <span class="caret"></span>
      </button>
      <ul class="dropdown-menu" role="menu"
                                aria-labelledby="dropdownMenu1">
        <li role="presentation" class="dropdown-header">Dropdown
          header</li>
        <li role="presentation"><a role="menuitem"
                                   tabindex="-1" href="#">Action</a></li>
        <li role="presentation"><a role="menuitem"
                                   tabindex="-1" href="#">Another action</a></li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" class="disabled"><a
                                role="menuitem" tabindex="-1" href="#">Something
                                else here</a></li>
        <li role="presentation"><a role="menuitem"
                                   tabindex="-1" href="#">Separated link</a></li>
      </ul>
    </div>

    <div class="btn-group">
      <button class="btn btn-default">CSS</button>
      <button class="btn btn-default">CSS</button>
      <button class="btn btn-default">css</button>
    </div>

    <button type="button" class="btn btn-default">
      <span class="glyphicon glyphicon-star"></span> Star
    </button>

    <div id="app">{{ message }}</div>
    <script type="text/javascript">
    var Calc = function() {
    };
    Calc.prototype.add = function(a, b) {
      return a + b;
    };
    var cal = new Calc();
    new Vue({
      el : '#app',
      data : {
        message : 'Hello world vue.js'
      }
    })
    </script>
  </body>
</html>
