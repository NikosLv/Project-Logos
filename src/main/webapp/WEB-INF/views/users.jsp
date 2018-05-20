<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/css/style.css" rel="stylesheet">
</head>
<body>

	<div id="app">
		

	</div>

	<script src="../resources/js/vue.min.js"></script>
	<script src="../resources/js/axios.min.js"></script>
	
	<script type="text/javascript">
		
	var vm = new Vue({
		el: '#app',
		data: {
			rootUrl: 'http://localhost:8080/api',
			users: []
		},
		methods: {
			getUsers() {
				var self = this;
				axios.get(this.rootUrl + '/users')
					.then(function (resp) {
						self.users = resp.data;
					}).catch(function(err) {
						console.log(err);
					})
			},
			deleteUser: function(user) {
				axios.get(this.rootUrl + '/delete/' + user.id)
					.then(function(resp) {
						console.log(resp.data);
						alert("User with ID: " + user.id + " succesfully deleted");
						location.reload();
					})
					.catch(function(err) {
						console.log(err);
					});
			}
		},
		mounted() {
			this.getUsers();
		}
	});
	</script>
</body>
</html>