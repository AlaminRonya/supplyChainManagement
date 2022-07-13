<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/13/2022
  Time: 2:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Inventory</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>

<jsp:include page="../include/navbar.jsp"/>


<div class="container">

    <a style="margin: 20px 0" href="${pageContext.request.contextPath}/api/page/v1/inventory/product/inventories/addInventory" class="btn btn-primary">Add Inventory</a>


    <div class="container-fluid">
        <div class="container" style="margin-top: 30px">
            <div class="row">
                <div class="col">
                    <c:forEach var="responseInventoryDto" items="${responseInventoriesDto}">
                        <div class="card" style="margin-top: 20px">
                            <div class="row no-gutters">
                                <div class="col-sm-7 d-flex justify-content-center">
                                    <div class="card-body">
                                        <h5 class="card-title">ID: ${responseInventoryDto.id}</h5>
                                        <h4>Quantity: <span>${responseInventoryDto.quantity}</span></h4>
                                        <h4>Create Date: <span>${responseInventoryDto.createdAt}</span></h4>
                                        <p>Modified Date: ${responseInventoryDto.modifiedAt}</p>
                                        <p>Deleted Date: ${responseInventoryDto.deletedAt}</p>
                                        <a href="${pageContext.request.contextPath}/api/page/v1/inventory/product/inventories/delete/${responseInventoryDto.id}" class="btn btn-danger">Delete</a>
                                        <a href="${pageContext.request.contextPath}/api/page/v1/inventory/product/inventories/update/${responseInventoryDto.id}" class="btn btn-warning">Update</a>
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


</body>
<jsp:include page="../include/footerJS.jsp"/>
</html>
