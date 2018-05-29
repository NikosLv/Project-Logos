<%@ include file="/WEB-INF/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="../resources/css/products.css">  -->

<title>Products by page</title>
</head>
<body>

	<c:url var="firstUrl" value="/product/products-by-page?page=0" />
	<!---------------------------------------------->
	<c:url var="lastUrl"
		value="/product/products-by-page?page=${ brandList.totalPages }" />

	<c:url var="nextUrl"
		value="/product/products-by-page?page=${ currentIndex + 1 }" />
	<c:url var="prevUrl"
		value="/product/products-by-page?page=${ currentIndex - 1 }" />


	<div class="container">

		<div class="row">
			<ul class="pagination">
				<c:choose>
					<c:when test="${ currentIndex == 0 }">
						<li class="disabled"><a href="#">&lt;&lt;</a></li>
						<li class="disabled"><a href="#">&lt;</a></li>
						<li class="active"><a href="${ firstUrl }">1</a></li>
					</c:when>

					<c:otherwise>
						<li><a href="${ firstUrl }">&lt;&lt;</a></li>
						<li><a href="${ prevUrl }">&lt;</a></li>
					</c:otherwise>
				</c:choose>

				<c:forEach var="i" begin="${ beginIndex }" end="${ endIndex }">
					<c:url var="pageUrl" value="/product/products-by-page?page=${ i }" />

					<c:choose>
						<c:when test="${ i == currentIndex }">
							<li class="active"><a href="#">${ i + 1 }</a></li>
						</c:when>

						<c:otherwise>
							<li><a href="${ pageUrl }">${ i + 1 }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${ currentIndex+1 == brandList.totalPages }">
						<li class="disabled"><a href="#">&gt;</a></li>
						<li class="disabled"><a href="#">&gt;&gt;</a></li>
					</c:when>

					<c:otherwise>
						<li><a href="${ nextUrl }">&gt;</a></li>
						<li><a href="${ lastUrl }">&gt;&gt;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>

		<div class="row">
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
						<th>Price</th>
						<th>Date download</th>
						<th><span class="glyphicon glyphicon-exclamation-sign"></th>
        				<th><span class="glyphicon glyphicon-pencil"></span></th>
        				<th><span class="glyphicon glyphicon-erase"></span></th>
        				

					</tr>
				</thead>
				<tbody>

					<c:forEach items="${ brandListByPage }" var="brand">

						<c:forEach items="${ brand.products }" var="product">
							<tr>
								<td>${ product.id }
								<td>${ brand.markName }</td>
								<td>${ product.nameGoods }</td>
								<td>${ product.bodyType }</td>
								<td>${ product.description }</td>
								<td>${ product.unit }</td>
								<td>${ product.availability }</td>
								<td>${ product.producer }</td>
								<td>${ product.price }</td>
								<td>${ product.dateDownload }</td>
								<th><a href="/product/prodId/${product.id }">Detalis</a></th>
    							<th><a href="/product/edit-prod/${product.id }">Edit</a></th>
        						<th><a href="/product/delete/${product.id}" >Delete</a></th>
        						
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<a href="/admin/dashboard">Back</a>
	<br>
</body>
</html>