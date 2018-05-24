<%@ include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="../resources/css/products.css">  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
<table class="table table-bordered">

    <thead >
      <tr>
        <th>Order Id</th>
        <th>Creat time</th>
        <th>Pack</th>
        <th>Payment</th>
        <th>Shipping</th>
        <th>Address</th>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>User ID</th>
        <th>User Email</th>
        <th></th>
       
        
        
       
        
        
      </tr>
    </thead>
    
    <tbody>
    	<c:forEach items="${ orderList }" var="order">
		<tr>
			<th>${ order.id }</th>
			<th>${ order.createdAt }</th>
			<th>${ order.packing }</th>
			<th>${ order.payment }</th>
			<th>${ order.shipping }</th>
			<th>${ order.address }</th>
			<th>${ order.product.id }</th>
			<th>${ order.product.nameGoods }</th>
			<th>${ order.user.id }</th>
			<th>${ order.user.email }</th>
			<th><a href="/order/orderId/${order.id}">Order Details</a></th>
			
	
		  
		
		
		</tr>  
		</c:forEach>  
    </tbody>
    
    
</table>

<a href="/dashboard"><b>Back</b></a>
</body>
</html>