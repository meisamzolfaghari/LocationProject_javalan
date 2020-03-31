<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/28/2020
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Location</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/secured/location" method="post">
    <table>
        <tr>
            <td>City</td>
            <td>Postal Code</td>
            <td>State Province</td>
            <td>Street Address</td>
        </tr>
        <tr>
            <td><input name="city"></td>
            <td><input name="postalCode"></td>
            <td><input name="stateProvince"></td>
            <td><input name="streetAddress"></td>
        </tr>
    </table>
    <input type="hidden" value="add" name="action"/>
    <input type="submit" value="Add Location"/>
</form>

<%--persian Date--%>
<jsp:useBean id="timebean" class="ir.javaland.projects.location.bean.TimeBean" />
<jsp:setProperty name="timebean" property="locale" value="fa_IR"/>
Today is: <jsp:getProperty name="timebean" property="todayDate"/>

<jsp:include page="footer.jsp">
    <jsp:param name="param1" value="Meisam Company"/>
</jsp:include>
</body>
</html>
