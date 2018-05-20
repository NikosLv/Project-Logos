<%@ include file="/WEB-INF/taglib.jsp"%>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../resources/css/login.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>



<c:if test="${ param.fail }">
<p style="color:red;"> Failed to authorize</p>
</c:if>   
<!--<form:form action="/login" method="POST" cssClass="form-horizontal">

Email: <input type="text" name="email"><br>
Password: <input type = "password" name = "password"><br>
Remember Me: <input type="checkbox" name="rememberMe"> <br>
<input type="submit" class="btn btn-warning"  value="Log in">
	-->


<h2 style="color:white" >Login page</h2>
<legend align="center" ></legend>

<div class="col-md-4">
<div class="login-panel panel panel-default">
                    
                    <div class="panel-heading">
                        <h3 class="panel-title">Sign In</h3>
                    </div>
                    
                    <div class="panel-body" >
                            <fieldset>
                            	<form:form action="/login" method="POST">
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="text" >
                                </div>
                                
                                
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                
                                
                                <div class="checkbox">
                                    <label>
                                        <input name="rememberMe" type="checkbox">Remember Me
                                    </label>
                                </div>
                                
                                
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit" class="btn btn-warning"  value="Log in">
                              </form:form>  
                            </fieldset>
                        
                    </div>
                    
                </div>
</div>
</div>







			
	

 <!-- </form:form> -->   				
	