<%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ title }</title>
</head>
<body>
Order details:<br>


							id:			${ orderModel.id }<br>
							Payment:	${ orderModel.payment }<br>
							Shipping:	${ orderModel.shipping }<br>
							Packing:	${ orderModel.packing }<br>
							Address:	${ orderModel.address }<br>
							
								
								
</body>
</html>