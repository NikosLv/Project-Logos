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
       
        <th>Address</th>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>User ID</th>
        <th>User Email</th>
        <th>Order Details</th>
        <th>Email</th>
       
        
        
       
        
        
      </tr>
    </thead>
    
    <tbody>
    	<c:forEach items="${ orderList }" var="order">
		<tr>
			<th>${ order.id }</th>
			
			<th>${ order.address }</th>
			<th>${ order.product.id }</th>
			<th>${ order.product.nameGoods }</th>
			<th>${ order.user.id }</th>
			<th>${ order.user.email }</th>
			<th><a href="/order/orderDet/${order.id}">Details</a></th>
			<th><a href="/order/email">Send Email</a></th>
		
		
			
		  
		
		
		</tr>  
		</c:forEach>  
    </tbody>
    
    
</table>

<a href="/admin/dashboard"><b>Back</b></a>
</body>
</html>