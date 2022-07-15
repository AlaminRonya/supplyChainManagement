<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/15/2022
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Product</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
<jsp:include page="../include/navbar.jsp"/>

<div class="container">
    <a style="margin: 20px 0" href="${pageContext.request.contextPath}/api/page/v1/inventory/products/addProduct" class="btn btn-primary">Add Product</a>


    <div class="container" style="margin-top: 30px">
        <div class="row">
            <div class="col-sm-3">
                <h4>Categories</h4>
<%--                <ul class="list-group">--%>
<%--                    <a th:href="@{/shop}"><li class="list-group-item">All Products</li></a>--%>
<%--                    <a href="" th:each="category, iStat : ${categories}"--%>
<%--                       th:href="@{/shop/category/{id}(id=${category.id})}"><li--%>
<%--                            class="list-group-item" th:text="${category.name}"></li></a>--%>

<%--                </ul>--%>
            </div>
            <div class="col-sm-9">
                <c:forEach var="responseProductDto" items="${responseProductsDto}">
                    <div class="card" style="margin-top: 20px">
                        <div class="row no-gutters">
                            <div class="col-sm-5 d-flex justify-content-center">

                                <img src="<c:url value="/api/page/v1/image-manual-response/${responseProductDto.getPhotosAttachmentList().get(0).getId()}"/>" alt="img" class="" height="150px" width="150px" />

                            </div>
                            <div class="col-sm-7 d-flex justify-content-center">
                                <div class="card-body">
                                    <h5 class="card-title">Product ID: ${responseProductDto.id}</h5>
                                    <h4>Product Name: <span>${responseProductDto.name}</span></h4>
                                    <p>Product Description: <span>${responseProductDto.description}</span></p>
                                    <p>Product SKU: <span>${responseProductDto.SKU}</span></p>
                                    <p>TK: <span>${responseProductDto.price}</span></p>
                                    <p>Product Create Date: <span>${responseProductDto.createdAt}</span></p>
                                    <p>Product Modified Date: <span>${responseProductDto.modifiedAt}</span></p>
                                    <p>Product Deleted Date: <span>${responseProductDto.deletedAt}</span></p>
                                    <a href="${pageContext.request.contextPath}/api/page/v1/inventory/categories/delete/${responseCategoryDto.id}" class="btn btn-danger">Delete</a>
                                    <a href="${pageContext.request.contextPath}/api/page/v1/inventory/categories/update/${responseCategoryDto.id}" class="btn btn-warning">Update</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>


</body>
<jsp:include page="../include/footerJS.jsp"/>
</html>
