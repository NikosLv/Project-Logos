<%@ include file="/WEB-INF/taglib.jsp" %>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">

<table class="table table-bordered">
    <thead>
      <tr>
        <th>Id</th>
        <th>Brand</th>
        <th>Product</th>
        <th>Body Type</th>
        <th>Description</th>
        <th>Unit</th>
        <th>Availability</th>
        <th>Producer</th>
        <th>Photo</th>
        <th>Price</th>
        
      </tr>
    </thead>
    <tbody>
    	
    	<c:forEach items="${ brandList }" var="brand">
    	
    			<c:forEach items="${ brand.products }" var="product"> 
    				<tr>
    				<td>${ brand.id }
    				<td>${ brand.markName }</td>
    				<td>${ product.nameGoods }</td>
    				<td>${ product.bodyType }</td>
    				<td>${ product.description }</td>
    				<td>${ product.unit }</td>
    				<td>${ product.availability }</td>
    				<td>${ product.producer }</td>
    				<td>${ product.imageUrl }</td>
    				<td>${ product.price }</td>
    				
    				</tr>
    			</c:forEach>
    	</c:forEach>
    </tbody>
</table>