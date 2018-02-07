<%@ include file="/resources/templates/common/common.jsp" %>
<div class="newproject">
    <div class='project-form'>
        <form  action="<spring:url value='/project'/>" method="post">
        <h2 class="projects-title">New project</h2>
        	<input type="hidden" name="_method" value="put"/>
        	    <div class="form-group">
        	    	<label for="name">${name_text}</label>
        	    	<input class="form-control" placeholder="Name" name="name" id="name" type="text"/>
        	    </div>
        	<button type="submit" class="project-save">Submit</button>
        </form>
    </div>
</div>
