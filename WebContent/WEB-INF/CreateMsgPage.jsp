<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Msg Page</title>
</head>
<body>
<form action="msgMerge.do" method="post">
<table>
<tr>
<td>Enter the content of the Message</td>
<td>:</td>
<td><input type="text" name="txtMsg"/></td>
</tr>
<tr>
<td>Upload the image if any</td>
<td>:</td>
<td><input type="file" name="imgMsg"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="btnCreateMsg" value="Create Message"/></td>
<td></td>
</tr>
</table>
</form>
</body>
</html>