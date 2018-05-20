<%@ include file="/WEB-INF/taglib.jsp" %>
<c:if test="${ error  != null}">
	<span style="color:red;">${ error}</span>

</c:if>

<form:form action="/user/edit" method="post" modelAttribute="editModel" cssClass="form-horizontal" >


	<form:hidden path="email" />
	<form:hidden path="password" />
	
	<fieldset>
	    <legend>Edit personal data</legend>
	    
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">First name:</label>
			<div class="col-md-5">
				<form:input path="firstName" cssClass="form-control input-md" placeholder="First name" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Last name:</label>
			<div class="col-md-5">
				<form:input path="lastName" cssClass="form-control input-md" placeholder="Last name" />
			</div>
		</div>
			
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Age:</label>
			<div class="col-md-5">
				<form:input path="age" cssClass="form-control input-md" placeholder="Age" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">City:</label>
			<div class="col-md-5">
				<form:input path="city" cssClass="form-control input-md" placeholder="City" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Phone number:</label>
			<div class="col-md-5">
				<form:input path="phoneNumber" cssClass="form-control input-md" placeholder="Phone number" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-6 control-label"></label>
			<div class="col-md-4">
				<button type="submit" class="btn btn-warning" >Edit data</button>
			</div>
		</div>
		
		
		
		
		
	</fieldset>





</form:form><br>
<a href="/dashboard"><b>Back</b></a><br>