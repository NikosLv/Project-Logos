<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ title }</title>
</head>
<body>
This Order Details:


<table class="table table-bordered">

<thead>
							<tr>
								<th>Order id</th>
								<th>date of buy</th>
								<th>payment</th>
								<th>shipping</th>
								<th>packing</th>
								
								<th>Id product</th>
								<th>product name</th>
								<th>user email</th>
							
								
							</tr>
	</thead>						
	<tbody>		
							<tr>
								<th>${ orderModel.id }</th>
								<th>${ orderModel.createdAt }</th>
								<th>${ orderModel.payment }</th>
								<th>${ orderModel.shipping }</th>
								<th>${ orderModel.packing }</th>
								
								<th>${ order.product.id }</th>
								<th>${ orderModel.product.nameGoods }</th>
								<th>${ orderModel.user.email }</th>
								
							
							</tr>				
	
		</tbody>						
</table>	
<a href="/order/all-order"><b>Back</b></a>
</body>
</html>