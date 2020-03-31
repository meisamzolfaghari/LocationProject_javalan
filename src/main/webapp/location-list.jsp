<%@ page import="ir.javaland.projects.location.model.Location" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Location List</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/secured/location?action=add">Add Location</a>
<table border=10px>
    <tr>
        <td>Country Name</td>
        <td>Province</td>
        <td>City</td>
        <td>Postal Code</td>
        <td>Address</td>
        <td>Delete</td>
        <td>Edit</td>
    </tr>
    <%
        List<Location> locationList =
                (List<Location>) request.getAttribute("LocationList");
        for (Location location : locationList) {
    %>
    <tr>
        <td><%=location.getCountry().getCountryName()%>
        </td>
        <td><%=location.getStateProvince()%>
        </td>
        <td><%=location.getCity()%>
        </td>
        <td><%=location.getPostalCode()%>
        </td>
        <td><%=location.getStreetAddress()%>
        </td>
        <td><a href="${pageContext.request.contextPath}/secured/location?action=delete&loc_id=<%=location.getId().toString()%>">Delete</a></td>
        <td><a href="${pageContext.request.contextPath}/secured/location?action=edit&loc_id=<%=location.getId().toString()%>">Edit</a></td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
