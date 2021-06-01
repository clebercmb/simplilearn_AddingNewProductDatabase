<%--
  Created by IntelliJ IDEA.
  User: cleber
  Date: 5/28/21
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <br/><br/><br/>

    <h2>Dashboard Product</h2>
    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Action</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="prod" items="${products}">
            <tr>
                <td><c:out value="${prod.productID}"/></td>
                <td><c:out value="${prod.name}"/></td>
                <td><c:out value="${prod.category}"/></td>
                <td><c:out value="${prod.price}"/></td>

                <td>
                    <a href="<%=request.getContextPath()%>/deleteProduct?id=<c:out value="${prod.productID}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>



</body>
</html>
