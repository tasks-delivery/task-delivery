<%@ include file="/resources/templates/common/common.jsp" %>
<div>
	<div class="panel-body">
		<form action="<spring:url value='/project'/>" method="post">
			<input type="hidden" name="_method" value="put"/>
			<div class="form-group">
				<label for="name">${name_text}</label>
				<input class="form-control" placeholder="Name" name="name" id="name" type="text"/>
			</div>
			<button type="submit" class="btn btn-default"></button>
		</form>
	</div>
</div>


