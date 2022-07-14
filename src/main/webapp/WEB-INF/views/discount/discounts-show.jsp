<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/14/2022
  Time: 2:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Discount</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
<jsp:include page="../include/navbar.jsp"/>

<div class="container">

    <a style="margin: 20px 0" href="${pageContext.request.contextPath}/api/page/v1/inventory/product/discounts/addDiscount" class="btn btn-primary">Add Inventory</a>


    <div class="container-fluid">
        <div class="container" style="margin-top: 30px">
            <div class="row">
                <div class="col">

                    <c:forEach var="discountDto" items="${discountsDto}">
                        <div class="card" style="margin-top: 20px">
                            <div class="row no-gutters">
                                <div class="col-sm-7 d-flex justify-content-center">
                                    <div class="card-body">
                                        <h5 class="card-title">ID: ${discountDto.id}</h5>
                                        <h4>Name: <span>${discountDto.name}</span></h4>
                                        <h2>Description: <span>${discountDto.description}</span></h2>
                                        <h2>Discount Percent: <span>${discountDto.discountPercent}%</span></h2>
                                        <h2>Active: <span>${discountDto.active}</span></h2>
                                        <p>Create Date: <span>${discountDto.createdAt}</span></p>
                                        <p>Modified Date: ${discountDto.modifiedAt}</p>
                                        <p>Deleted Date: ${discountDto.deletedAt}</p>
                                        <a href="${pageContext.request.contextPath}/api/page/v1/inventory/product/discounts/delete/${discountDto.id}" class="btn btn-danger">Delete</a>
                                        <a href="${pageContext.request.contextPath}/api/page/v1/inventory/product/discounts/update/${discountDto.id}" class="btn btn-warning">Update</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../include/footerJS.jsp"/>
</body>
</html>
