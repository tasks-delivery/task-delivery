<%@ include file="/resources/templates/common/common.jsp" %>
<div class="board">
    <div class='dashboard'>
        <button class="add-project" type="button" onclick="location.href = '/project'">Create project</button>
        <table border="1" cellspacing="0" cellpadding="8" class="project-list">
            <tr><th>Name</th><th>Start date</th></tr>
            <c:forEach items="${project}" var="project">
                <tr><td>${project.name}</td><td>01.02.1993
                 <button class="project-del-btn">Delete</button>
                 <button class="project-edit-btn">Edit</button>
                </td></tr>
            </c:forEach>
        </table>
</div>