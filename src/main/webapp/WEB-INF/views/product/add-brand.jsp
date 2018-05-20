<%@ include file="/WEB-INF/taglib.jsp"%>
<style>
.error {
	color: red;
}
</style>

<form:form cssClass="form-horizontal" action="/product/add-brand"
	method="POST" modelAttribute="brandModel">

	<fieldset>
		<legend>Add Car Brand</legend>

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">
			Brand name:</label>
			<div class="col-md-5">
				<form:input path="markName" cssClass="form-control input-md"
					placeholder="Make name" />
				<form:errors path="markName" cssClass="error" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-6 control-label"></label>
			<div class="col-md-4">
				<button type="submit" class="btn btn-warning">Add Brand</button>
			</div>
		</div>

	</fieldset>
</form:form>
<br>

<a href="/dashboard"><b>Back</b></a>
<br>