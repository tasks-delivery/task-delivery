<%@ include file="/resources/templates/common/common.jsp" %>
<link href="${contextPath}/resources/templates/dashboard/dashboard.css" rel="stylesheet">
<div class="board">
    <div class='dashboard'>
        <button class="add-project" type="button" onclick="location.href = '/projects'">Create project</button>
        <table class="project-list">
            <thead></thead>
                <tbody>
                    <tr>
                        <td>first project</td>
                        <td>second project</td>
                        <td>third project</td>
                    <tr>
                        <td>first project</td>
                        <td>second project</td>
                        <td>third project</td>
                    </tr>
                    <tr>
                        <td>first project</td>
                        <td>${name}</td>
                        <%=request.getParameter("pname")%>
                        <td>third project</td>
                    </tr>
                </tbody>
        </table>
    </div>
</div>