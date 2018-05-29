<%@ include file="/WEB-INF/taglib.jsp"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/prodId.css">
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ title }</title>
</head>
<body>



	<h2>Product details</h2>
	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">

						<div class="preview-pic tab-content">
							<div class="tab-pane active" id="pic-1">
								<img src="${ productModel.imageUrl }" />
							</div>
						</div>

						<div class="panel panel-default text-center">
							<h3>
								<div class="panel-title">
									<span class="glyphicon glyphicon-comment"></span> Description
								</div>
							</h3>
							<hr>
							<h4>${ productModel.description }<br>
							</h4>
						</div>

					</div>
					<div class="details col-md-6">
						<div class="panel panel-default text-center">
							<h3>
								<div class="panel-title">
									<span class="glyphicon glyphicon-list-alt"></span> Name
								</div>
							</h3>
							<hr>
							<h4>${ productModel.nameGoods }</h4>
						</div>
						<div class="panel panel-default text-center">
							<div class="rating">
								<h3>
									<div class="panel-title">
										<span class="glyphicon glyphicon-info-sign"></span> Brand
									</div>
								</h3>
								<hr>
								<h4>${ productModel.brand.markName }<br>
								</h4>
							</div>
						</div>

						<div class="panel panel-default text-center">
							<div class="rating">
								<h3>
									<div class="panel-title">
										<span class="glyphicon glyphicon-info-sign"></span> Producer
									</div>
								</h3>
								<hr>
								<h4>${ productModel.producer }<br>
								</h4>
							</div>
						</div>

						<div class="panel panel-default text-center">
							<div class="rating">
								<h3>
									<div class="panel-title">
										<span class="glyphicon glyphicon-info-sign"></span> Unit
									</div>
								</h3>
								<hr>
								<h4>${ productModel.unit }<br>
								</h4>
							</div>
						</div>

						<div class="panel panel-default text-center">
							<div class="rating">
								<h3>
									<div class="panel-title">
										<span class="glyphicon glyphicon-info-sign"></span>
										Availability
									</div>
								</h3>
								<hr>
								<h4>${ productModel.availability }<br>
								</h4>
							</div>
						</div>

						<div class="panel panel-default text-center">
							<div class="rating">
								<h3>
									<div class="panel-title">
										<span class="glyphicon glyphicon-info-sign"></span> Body
									</div>
								</h3>
								<hr>
								<h4>${ productModel.bodyType }<br>
								</h4>
							</div>

						</div>



						<div class="panel panel-default text-center">
							<h3>
								<div class="panel-title">
									<span class="glyphicon glyphicon-credit-card"></span> Price
								</div>
							</h3>
							<hr>
							<h2>
								<font color="purple">${ productModel.price }$<br>
							</h2>
							</font>
						</div>


						<div class="text-center">

							<sec:authorize access="hasRole('USER')">
								<div class="text-center">

									<a href="/product/productsall" target="_blank">
										<button class="btn btn-info right" type="submit">Back
											to BUY</button>
									</a>


								</div>
							</sec:authorize>



						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>





</body>
</html>