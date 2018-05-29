<%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ title }</title>
</head>
<body>
<b>My Order details:</b><br><br>

<table class="table table-bordered">

<thead>
							<tr>
								<th>Order id</th>
								<th>date of buy</th>
								<th>payment</th>
								<th>shipping</th>
								
								<th>Address</th>
								<th>product name</th>
								
								<th><span class="glyphicon glyphicon-credit-card"></span></th>
							
								
							</tr>
	</thead>						
	<tbody>						
	<c:forEach items="${ orderByUser }" var="order">
		<tr>
			<th>${ order.id }</th>
			<th>${ order.createdAt }</th>
			<th>${ order.payment }</th>
			<th>${ order.shipping }</th>
			
			<th>${ order.address }</th>
			<th>${ order.product.nameGoods }</th>
			<th><a href="/order/pay">Pay</th>
					
		</tr>  
		</c:forEach>  
		</tbody>						
</table>
<a href="/product/productsall"><b>Pay other products</b></a>								
</body>
</html>