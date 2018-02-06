<%@ include file="/resources/templates/common/common.jsp" %>
<link href="${contextPath}/resources/templates/dashboard/dashboard.css" rel="stylesheet">
<div class="board">
    <div class='dashboard'>
        <button class="add-project" type="button" onclick="location.href = '/project'">Create project</button>
        <table class="project-list">
            <thead></thead>
                <tbody>
                    <tr>
                        <td>first project</td>
                        <td>second project</td>
                        <td><%= request.getAttribute("pname")  %></td>
                    <tr>
                        <td>second project</td>
                        <td><c:out value="${pname}"/></td>
                    </tr>
                    <tr>

                        <td>first project</td>
                        <td>${pname}</td>
                                  <td>${project}</td>
                        <%=request.getParameter("pname")%>
                        <td>third project</td>
                    </tr>
                </tbody>
        </table>
             <div class="secondtest">
                       <%=request.getParameter("pname")%>
             </div>

    <div>
   <h5 class="welcome-user">Welcome ${request.project.projectForm}</h5>
    </div>
            <div>
     <div>
     </div>

            </div>
    </div>

</div>