<%@ include file="/WEB-INF/taglib.jsp"%>
<style>
.error {
	color: red;
}
</style>
<link rel="stylesheet" href="../resources/css/register.css">


<form:form action="/register" method="POST"
	modelAttribute="registerModel" cssClass="form-horizontal">
	<%-- <form:errors path="*" cssClass="error" /> --%>
	<fieldset>
		<h1 align="center">Register new buyer</h1>


		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput"><h5>Email</h5></label>
			<div class="col-md-5">
				<form:input path="email" cssClass="form-control input-md"
					placeholder="Email" />
					<form:errors path="email" cssClass="error" />

			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput"><h5>Password:</h5></label>
			<div class="col-md-5">
				<form:password path="password" cssClass="form-control input-md"
					placeholder="Enter password" />
					<form:errors path="password" cssClass="error" />
			</div>

		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput"><h5>Confirm
					password:</h5></label>
			<div class="col-md-5">
				<form:password path="passwordConfirmation"
					cssClass="form-control input-md" placeholder="Enter password again" />
					<form:errors path="passwordConfirmation" cssClass="error" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-6 control-label"></label>
			<div class="col-md-4">
				<button type="submit" class="btn btn-warning">Register</button>
			</div>
		</div>

	</fieldset>

</form:form>
