<%--
  Created by IntelliJ IDEA.
  User: moretajoo
  Date: Feb 7, 2010
  Time: 12:26:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tag-test.tld" prefix="tt" %>

<html>
<head><title>Simple jsp page</title></head>
<body>Place your content here
<%
pageContext.forward("forward.do");
%>
</body>
</html>