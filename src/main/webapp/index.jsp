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
    <link href="${contextPath}/resources/css/index.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="resources/templates/navbar/navbar.jsp" %>
<div class="home-banner">
    <div class="left-banner">
        <ul>
            <li><img src="${contextPath}/resources/img/report.png">
            <span>Generates progress reports</span></li>
            <li><img src="${contextPath}/resources/img/test-case.png">
            <span>Keeps track of the progress through testing scenarios</span></li>
            <li><img src="${contextPath}/resources/img/spec.png">
            <span>Combines test specs into test coverage scenarios</span></li>
            <li><img src="${contextPath}/resources/img/manage.png">
            <span>Manage requirements, features and use-cases</span></li>
        </ul>
    </div>
    <div class="right-banner">
        <img src="${contextPath}/resources/img/error404.png">
    </div>
</div>
<div class="footer">
    <ul class="social">
        <li><a href=""></li>
        <li><a href=""></li>
        <li><a href=""></li>
        <li><a href=""></li>
        <li><a href=""></li>
    </ul>
</div>
</body>
</html>