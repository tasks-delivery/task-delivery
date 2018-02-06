<%@ include file="/resources/templates/common/common.jsp" %>
<link href="${contextPath}/resources/templates/project/project.css" rel="stylesheet">
<div class="project">
 <form:form method="POST" modelAttribute="projectForm" class="form-signin">
        <h2 class="form-signin-heading">Create new project</h2>
        <spring:bind path="projectName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="projectName" class="form-control" placeholder="Name"
                            autofocus="true"></form:input>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            </div>
        </spring:bind>
    </form:form>

    <div>
   <h5 class="welcome-user">Welcome ${response.project.projectName}</h5>
    </div>
</div>