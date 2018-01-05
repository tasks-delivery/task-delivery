<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="contain-to-grid fixed">
	<nav class="top-bar" data-topbar="">
		<div class="top-bar-section">
		<ul class="left">
		<li>
           	<a href="/" class="collapse-only">
           		<img src="${contextPath}/resources/img/bomb.png">
           		<span>Task-delivery</span>
           	</a>
           </li></ul>
			<ul class="center">
				<li><a href="/docs">Docs</a></li>
				<li><a href="/support">Support</a></li>
				<li><a href="/blog">Blog</a></li>
				<li><a href="about">About</a></li>
			</ul>
			<ul class="right">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <h5 class="btnLogout">Welcome ${pageContext.request.userPrincipal.name}</h5><h5> |</h5>
                    <a  onclick="document.forms['logoutForm'].submit()">Logout</a>
                </c:if>
            </ul>
		</div>
	</nav>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
