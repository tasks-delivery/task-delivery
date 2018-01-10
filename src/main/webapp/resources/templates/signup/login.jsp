<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Task-delivery</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/reset.css" rel="stylesheet">
    <link href="${contextPath}/resources/templates/signup/signup.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<%@ include file="/resources/templates/navbar/navbar.jsp" %>
<div class="login">
   <form method="POST" action="${contextPath}/login" class="form-signin">
      <h2 class="form-heading">Login</h2>
      <div class="form-group ${error != null ? 'has-error' : ''}">
          <span>${message}</span>
          <input name="username" type="text" class="form-control" placeholder="Username"
                 autofocus="true"/>
          <input name="password" type="password" class="form-control" placeholder="Password"/>
          <span>${error}</span>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
          <h4 class="link-reg"><a href="${contextPath}/registration">Create an account</a></h4>
      </div>
   </form>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</html>
