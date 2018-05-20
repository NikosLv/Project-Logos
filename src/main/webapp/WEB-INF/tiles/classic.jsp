<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">

<c:choose>
	<c:when test="${title == null}">
		<tiles:putAttribute name="title" value="Detal Auto" />
	</c:when>
	<c:otherwise>
		<tiles:putAttribute name="title" value="${title}" />
	</c:otherwise>
</c:choose>

<title>
	<tiles:getAsString name="title"></tiles:getAsString>
</title>



</head>

<body>

	<tiles:insertAttribute name="header" />
		<div class="container">
			
			<tiles:insertAttribute name="body" />		
		</div>
	<tiles:insertAttribute name="footer"/>
</body>
</html>