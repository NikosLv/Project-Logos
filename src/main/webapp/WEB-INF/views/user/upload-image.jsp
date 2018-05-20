<%@ include file="/WEB-INF/taglib.jsp" %>
<form:form action="/user/profile/image/uplaod" method="POST" enctype="multipart/form-data">

Chooser profile image:
<input type="file" name="profileImage"><br><br>
<input type="submit" value="Download">

</form:form>