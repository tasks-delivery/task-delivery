<%@ include file="/resources/templates/common/common.jsp" %>
<<<<<<< HEAD
<link href="${contextPath}/resources/templates/dashboard/dashboard.css" rel="stylesheet">
<div class="board">
    <div class='dashboard'>
        <button class="project" type="submit">Create project</button>
        <table class="project-list">
            <thead></thead>
                <tbody>
                    <tr>
                        <td>first project</td>
                        <td>second project</td>
                        <td>third project</td>
                    </tr>
                    <tr>
                        <td>first project</td>
                        <td>second project</td>
                        <td>third project</td>
                    </tr>
                    <tr>
                        <td>first project</td>
                        <td>second project</td>
                        <td>third project</td>
                    </tr>
                </tbody>
        </table>
    </div>
=======
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
>>>>>>> 6e455b12c35d8a29ddf7e94511b0bdf8d05170c5
</div>