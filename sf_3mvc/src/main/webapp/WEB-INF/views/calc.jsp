<%@ page contentType="text/html; charset=utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<title>${title}</title>
</head>
<body>
<h1>${title}</h1>
<form action="${root}/calc" method="post">
	<input type="text" name="n1" size="3" value="20">
	<select name="oper">
		<option>+</option>
		<option>-</option>
		<option>*</option>
		<option>/</option>
	</select>
	<input type="text" name="n2" size="3" value="10">
	<input type="submit" value="계산">
</form>
</body>
</html>
