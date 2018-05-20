<%@ include file="/WEB-INF/taglib.jsp" %>

<style>
	.error {
		color: red;
	}
</style>


	<form:form 
		cssClass="form-horizontal" 
		action="/product/add-product" 
		modelAttribute="productModel" 
		method="POST"
		enctype="multipart/form-data">
	<fieldset>
		<legend>Add New Product</legend>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Product name:</label>
			<div class="col-md-5">
				<form:input path="nameGoods" cssClass="form-control input-md" placeholder="Product name" />
			</div>
		</div>
		
		<!-- Type of body select -->
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="selectbasic">Select body</label>
		  	<div class="col-md-5">
		    <form:select path="bodyType" cssClass="form-control">
				<form:options items="${ bodyTypeList }"/>		    
		    </form:select>
		  	</div>
		 </div>
		  
		  <div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Description:</label>
			<div class="col-md-5">
				<form:textarea path="description" cssClass="form-control input-md" placeholder="Description" />
			</div>
		</div>
		
		<!-- Unit select -->
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="selectbasic">Select unit</label>
		  <div class="col-md-5">
		    <form:select path="unit" cssClass="form-control">
				<form:options items="${ unitList }"/>		    
		    </form:select>
		  </div>
		 </div>
		 
		 <!-- Availability select -->
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="selectbasic">Availability</label>
		  <div class="col-md-5">
		    <form:select path="availability" cssClass="form-control">
				<form:options items="${ availabilityList }"/>		    
		    </form:select>
		  </div>
		 </div>
		 
		 <!-- Select producer -->
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="selectbasic">Select Producer</label>
		  <div class="col-md-5">
		    <form:select path="producer" cssClass="form-control">
				<form:options items="${ producerList }"/>		    
		    </form:select>
		  </div>
		 </div>
		 
		 <!-- PRICE -->
		 <div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Price:</label>
			<div class="col-md-5">
				<form:input path="price" cssClass="form-control input-md" placeholder="Price" />
			</div>
		</div>
		 						 
		  <!-- Select auto brand -->
		  
		 <div class="form-group">
		  <label class="col-md-4 control-label" for="selectbasic">Select brand</label>
		  <div class="col-md-5">
		    <form:select path="brand" cssClass="form-control">
				<form:options items="${ brandList }" itemLabel="markName"/>		    
		    </form:select>
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textinput">Add image</label>
			<div class="col-md-5">
				<input type="file" name="productImage"> 
			</div>
		</div>
				
				
	    <!-- Button -->
	    
		<div class="form-group">
			<label class="col-md-6 control-label"></label>
			<div class="col-md-4">
				<button type="submit" class="btn btn-warning">Add Product</button>
			</div>
		</div>
				
	</fieldset>
	</form:form>
	<a href="/dashboard"><b>Back</b></a><br>
	



