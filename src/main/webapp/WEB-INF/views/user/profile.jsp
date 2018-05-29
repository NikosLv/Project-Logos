<%@ include file="/WEB-INF/taglib.jsp"%>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/footer.css">
<legend>User Profile</legend>

<div class="container" id="home">
<table class="table table-bordered">
    <thead>
      <tr>
        <th>Id</th>
        <th>email</th>
        <th>password</th>
        <th>role</th>
        <th>first name</th>
        <th>last name</th>
        <th>age</th>
        <th>city</th>
        <th>Phone Number</th>
     
        
      </tr>
    </thead>
    <tbody>

    	
    				<tr>
    				<td>${ userProfile.id }
    				<td>${ userProfile.email }</td>
    				<td>${ userProfile.password }</td>
    				<td>${ userProfile.role.role }</td>
    				<td>${ userProfile.userProfile.firstName }</td>
    				<td>${ userProfile.userProfile.lastName }</td>
    				<td>${ userProfile.userProfile.age }</td>
    				<td>${ userProfile.userProfile.city }</td>
    				<td>${ userProfile.userProfile.phoneNumber }</td>
    				   				
    				</tr>
    	
    </tbody>
</table>

<a href="/user/edit"><h4 align="right">Edit Profile</h4></a><br><br>
<a href="/admin/dashboard"><b>Back</b></a>
</div>
