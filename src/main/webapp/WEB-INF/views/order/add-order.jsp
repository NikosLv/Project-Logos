<%@ include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form:form cssClass="form-horizontal" action="/order/add-order"
		modelAttribute="orderModel" method="POST">
		

	
		<fieldset>
		<legend>Make order</legend>
		
		
		<div class="form-group">
		  <label class="col-md-4 control-label" for="selectbasic">Type of payment</label>
		  	<div class="col-md-5">
		    <form:select path="payment" cssClass="form-control">
				<form:options items="${ paymentList }"/>		    
		    </form:select>
		  	</div>
		 </div>
		 
		<div class="form-group">
		  <label class="col-md-4 control-label" for="selectbasic">Type of shipping</label>
		  	<div class="col-md-5">
		    <form:select path="shipping" cssClass="form-control">
				<form:options items="${ shippingList }"/>		    
		    </form:select>
		  	</div>
		 </div>
		 
		 <div class="form-group">
		  <label class="col-md-4 control-label" for="selectbasic">Type of packing</label>
		  	<div class="col-md-5">
		    <form:select path="packing" cssClass="form-control">
				<form:options items="${ packingList }"/>		    
		    </form:select>
		  	</div>
		 </div>
		 
		 <div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Shipping address</label>
			<div class="col-md-5">
				<form:textarea path="address" cssClass="form-control input-md" placeholder="Address" />
			</div>
		</div>
		 
		 
		 <form:input path="product"	value="${productModel.id }" type="hidden"/>
		  
		 
		  
		 <div class="form-group">
			<label class="col-md-6 control-label"></label>
			<div class="col-md-4">
			<sec:authentication property="principal.username" var="username"/>
			
			
				<button type="submit" class="btn btn-warning">Make order!</button>
			
			
							     		
			</div>
		</div>
		
		</fieldset>
	</form:form>

	<a href="/product/productsall"><b>Back</b></a><br>
</body>
</html>