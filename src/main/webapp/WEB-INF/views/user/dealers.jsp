<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/22/2022
  Time: 11:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Dealer's</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
<jsp:include page="../include/navbar.jsp"/>
<div class="container">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">SN</th>
            <th scope="col">Username</th>
            <th scope="col">TIN Number</th>
            <th scope="col">Active</th>
            <th scope="col">Request</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach varStatus="iStat" var="dealer" items="${dealers}">
                <tr>
                    <td>${iStat.index + 1}</td>
                    <td>${dealer.user.email}</td>
                    <td>${dealer.tradeLicenseNumber}</td>
                    <td>${dealer.active}</td>

                    <td><a href="${pageContext.request.contextPath}/page/v1/dealer/active/${dealer.id}"  class="btn btn-warning">Active</a></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
