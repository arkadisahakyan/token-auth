<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Authentication</title>
	</head>
	<body>
		<form method=POST action=/token-auth/auth>
			Your token here: <input type=TEXT name=token>
			<input type=SUBMIT value=Submit>
		</form>
	</body>
</html>