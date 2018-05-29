<%@ include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/productsall.css">

<!--  <link rel="stylesheet" href="../resources/css/products.css"> -->
<title>Insert title here</title>
</head>
<body>

	<c:url var="firstUrl" value="/product/productsall?page=0&size=10" />
	<!---------------------------------------------->
	<c:url var="lastUrl"
		value="/product/productsall?page=${ brandList.totalPages }" />

	<c:url var="nextUrl"
		value="/product/productsall?page=${ currentIndex + 1 }" />
	<c:url var="prevUrl"
		value="/product/productsall?page=${ currentIndex - 1 }" />


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
					<c:url var="pageUrl" value="/product/productsall?page=${ i }" />

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
			<c:forEach items="${ brandListByPage }" var="brand">

				<c:forEach items="${ brand.products }" var="product">
					<div class="col-md-3 col-sm-6">
						<span class="thumbnail"> 
						<a href="/product/prodId/${product.id}" target="_blank"> <img
								src="${ product.imageUrl }" width="180" height="200"
								alt="${product.nameGoods }">
						</a>
							<h4>${ brand.markName }</h4>
							<p>${ product.nameGoods }</p>
							<hr class="line">
							<div class="row">
								<div class="col-md-6 col-sm-6">
									<p class="price" align="center">$${ product.price }</p>
								</div>
								
								<sec:authorize access="isAuthenticated()">
																
								<div class="col-md-6 col-sm-6">
									<a href="/order/add-order/${product.id}" target="_blank">
										<button class="btn btn-info right" type="submit">BUY
											ITEM</button>
									</a>
								</div>
								</sec:authorize>
								

							</div>

						</span>
					</div>
				</c:forEach>
			</c:forEach>

		</div>  
			
				
	</div>
	<br>
 
<%--  	<sec:authentication property="principal.username" var="username"/>  
	<a href="/order/all-order" target="_blank">My Orders</a>
	<a href="/"><b>Back</b></a>
 --%>
	<br>
</body>
</html>