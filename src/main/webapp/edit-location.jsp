<%@ page import="ir.javaland.projects.location.model.Location" %>
<%@ page import="com.sun.xml.bind.v2.schemagen.xmlschema.LocalAttribute" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/27/2020
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Location</title>
</head>
<body>
<form action="/HrProject_war/secured/location" method="post">
    <table>
        <jsp:useBean id="location" class="ir.javaland.projects.location.model.Location" scope="request"/>
        <tr>
            <td>City</td>
            <td>Postal Code</td>
            <td>State Province</td>
            <td>Street Address</td>
            <td>Country Name</td>
        </tr>
        <tr>
            <td><input name="city" value="<jsp:getProperty name="location" property="city"/>"></td>
            <td><input name="postalCode" value="<jsp:getProperty name="location" property="postalCode"/>"></td>
            <td><input name="stateProvince" value="<jsp:getProperty name="location" property="stateProvince"/>"></td>
            <td><input name="streetAddress" value="<jsp:getProperty name="location" property="streetAddress"/>"></td>
            <td><%=location.getCountry().getCountryName()%>
            </td>
        </tr>
    </table>
    <input type="hidden" value="<jsp:getProperty name="location" property="id"/>" name="locationId"/>
    <input type="hidden" value="edit" name="action"/>
    <input type="submit" value="Update Location"/>
</form>

<%--US Date--%>
<jsp:useBean id="timebean" class="ir.javaland.projects.location.bean.TimeBean" />
<%--Today is: <jsp:getProperty name="timebean" property="todayDate"/>--%>

<%--persian Date--%>
<jsp:setProperty name="timebean" property="locale" value="fa_IR"/>
Today is: <jsp:getProperty name="timebean" property="todayDate"/>

<%--this will read from an attribute of request named = "locale"--%>
<%--<jsp:setProperty name="timebean" property="locale" param="locale"/>--%>
<%--Today is: <jsp:getProperty name="timebean" property="todayDate"/>--%>

<jsp:include page="footer.jsp">
    <jsp:param name="param1" value="Meisam Company"/>
</jsp:include>
</body>
</html>
