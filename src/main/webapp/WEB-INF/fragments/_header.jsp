<%@ include file="/WEB-INF/taglib.jsp"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
   
   
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Detal auto</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    
    <!-- left menu -->
    
      <ul class="nav navbar-nav">
        <li class="active"><a href="/">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="/contact">Contact</a></li>
        <li><a href="/payment-shipping">Payment and Shipping</a></li>
     
      </ul>
      
      <!-- search menu ---------------------------------->
      
        <form class="navbar-form navbar-left" action="/product/productsall/search" method="get">
	<div class="form-group">
	<input type="text" class="form-control" name="search" placeholder="Find spare parts">
	</div>
	<input type="submit" value="Search" class="btn btn-default">
	</form>
      
      
      <!-- right menu -------------------------------------->
      
 	<ul class="nav navbar-nav navbar-right" style="width: 400px;">
			
		
		    
		     		

	<sec:authorize access="!isAuthenticated()">
		<li><a href="/login">Login</a></li>
		<li class="divider"></li>
		<li><a href="/register">Register</a></li> 
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
	
		<sec:authentication property="principal.username" var="username"/>
	     <li><a href="/user/profile">${username}</a></li>
		
		<sec:authorize access="hasRole('ADMIN')">
			<li><a href="/dashboard">Dashboard</a></li>
		</sec:authorize>
		
		<sec:authorize access="hasAnyRole('USER')">
			<li><a href="/product/productsall">Products</a></li>
		</sec:authorize>
		
		
		<c:url var="logoutUrl" value="/logout" />
		
		<form:form action="${logoutUrl}" method="POST" cssStyle="padding-top: 7px;">
			<li><input type="submit" value="Log Out" class="btn btn-danger"></li>
		</form:form>
		
	</sec:authorize>
			
			
			
			
			
			
			
			
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>