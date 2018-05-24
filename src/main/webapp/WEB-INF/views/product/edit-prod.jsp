<%@ include file="/WEB-INF/taglib.jsp"%>

<c:if test="${ error  != null}">
	<span style="color: red;">${ error}</span>

</c:if>

<form:form action="/product/edit-prod" method="post"
	modelAttribute="editProdModel" cssClass="form-horizontal">

	<!--    <input type="hidden" name="productId" value="${productModel.id}">  --> 



	<fieldset>
		<legend>Edit product</legend>

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Product
				name:</label>
			<div class="col-md-5">
				<form:input path="nameGoods" cssClass="form-control input-md"
					placeholder="Product name" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Select
				body</label>
			<div class="col-md-5">
				<form:select path="bodyType" cssClass="form-control">
					<form:options items="${ bodyTypeList }" />
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Description:</label>
			<div class="col-md-5">
				<form:input path="description" cssClass="form-control input-md"
					placeholder="Description" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Select
				unit</label>
			<div class="col-md-5">
				<form:select path="unit" cssClass="form-control">
					<form:options items="${ unitList }" />
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Availability</label>
			<div class="col-md-5">
				<form:select path="availability" cssClass="form-control">
					<form:options items="${ availabilityList }" />
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Select
				Producer</label>
			<div class="col-md-5">
				<form:select path="producer" cssClass="form-control">
					<form:options items="${ producerList }" />
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Price:</label>
			<div class="col-md-5">
				<form:input path="price" cssClass="form-control input-md"
					placeholder="Price" />
			</div>
		</div>


		<div class="form-group">
			<label class="col-md-6 control-label"></label>
			<div class="col-md-4">
				<button type="submit" class="btn btn-warning">Edit product</button>
			</div>
		</div>





	</fieldset>





</form:form>
<br>
<a href="/dashboard">Back</a>
<br>