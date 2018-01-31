<%@ include file="/resources/templates/common/common.jsp" %>
<link href="${contextPath}/resources/templates/project/project.css" rel="stylesheet">
<div class="project">
    <form:form method="POST" modelAttribute="projectForm" class="projectForm">
        <h2>Create new project</h2>
        <spring:bind path="projectName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="projectName" id="projectname" value="" placeholder="Name"></form:input>
            </div>
        </spring:bind>
        <button class="apply-project"  onclick="goMail()" type="button">Submit</button>
    </form:form>
</div>

<div>
        <%
        String name = request.getParameter("name");
        if (name == null || name.length() == 0) {
            %>
            Hello, world !
            <%            } else {
            %>
            Hello, world ! I'm <%= name%>
            <%
        }
            %>
</div>
