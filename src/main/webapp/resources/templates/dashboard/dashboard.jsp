<%@ include file="/resources/templates/common/common.jsp" %>
<link href="${contextPath}/resources/templates/dashboard/dashboard.css" rel="stylesheet">
<div class="board">
    <div class='dashboard'>
        <button class="add-project" type="button" onclick="location.href = '/project'">Create project</button>
        <table class="project-list">
            <thead></thead>
                <tbody>
                    <c:forEach items="${project}" var="p">
                    <tr>
                        <td>${p.name}</td>
                    </tr>
                    </c:forEach>
                </tbody>
        </table>
</div>