<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>
        JSP Time
    </title>
</head>
<body>
<div style="text-align: center; font-size: x-large">
    <p>It's been <%=System.currentTimeMillis()%> milliseconds...
        <br/>
        Since January 1st 1970.</p>
    <hr/>
    <p>
        In Fact it's
        <%
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEEEEEE");
            String today = sdf.format(now);
            out.println(today);
        %>.
    </p>
</div>
</body>
</html>
