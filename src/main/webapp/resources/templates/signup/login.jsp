<link href="${contextPath}/resources/templates/signup/signup.css" rel="stylesheet">
<%@ include file="/resources/templates/common/common.jsp" %>
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