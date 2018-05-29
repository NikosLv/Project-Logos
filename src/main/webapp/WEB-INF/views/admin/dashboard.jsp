<%@ include file="/WEB-INF/taglib.jsp"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<legend align="center">Control panel</legend><br>


<div class="container">
    <div class="row">
        <div class="col-md-4">
            
            <div id="sidebar" class="well sidebar-nav">
                <h5><i class="glyphicon glyphicon-home"></i>
                    <small><b>MANAGEMENT</b></small>
                </h5>
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="/">Home</a></li>
                    <li><a href="/product/add-brand">Add Brand</a></li>
                    <li><a href="/product/add-product">Add Product</a></li>
                     <li><a href="/product/products-by-page">List Products</a></li>
                      <li><a href="/order/all-order">List Orders</a></li>
                </ul>
                <h5><i class="glyphicon glyphicon-user"></i>
                    <small><b>USERS</b></small>
                </h5>
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="/user/users">List</a></li>
                    <li><a href="/user/profile">My Profile</a></li>
                    <li><a href="/user/edit">Edit My Profile</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-8">
            <!-- Content Here -->
        </div>
    </div>
</div>