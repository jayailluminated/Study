<%@ taglib uri="/WEB-INF/tag-test.tld" prefix="myTag" %>

<%@ page import="java.util.*" %>

<%
	String[] movies = {"a", "b", "c"};
	pageContext.setAttribute("movieCollection", movies);
%>


<html>
<head>
	<title>
	</title>
</head>
<body>
<table>
	<myTag:simple movieList="${movieCollection}">
		<tr>
			<td>${movie}</td>
		</tr>
	</myTag:simple>
</table>
<em>Copyright &copy; 2010 Testhub</em>
</body>
</html>
