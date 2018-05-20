<%@ include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/products.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-bordered">

    <thead>
      <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Role</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>City</th>
        <th>Phone num</th>
        <th>Date register</th>
        <th></th>
        
        
      </tr>
    </thead>
    
    <tbody>
    	<c:forEach items="${ usersList }" var="user">
		<tr>
			<th>${ user.id }</th>
			<th>${ user.email }</th>
			<th>${ user.role }</th>
			<th>${ user.userProfile.firstName }</th>
			<th>${ user.userProfile.lastName }</th>
			<th>${ user.userProfile.age }</th>
			<th>${ user.userProfile.city }</th>
			<th>${ user.userProfile.phoneNumber }</th>
			<th>${ user.createdAdd }</th>
			<th><a href="/user/delete/${ user.id}">Delete</a></th>
		</tr>  
		</c:forEach>  
    </tbody>
    
    
</table>

<a href="/dashboard"><b>Back</b></a>
</body>
</html>