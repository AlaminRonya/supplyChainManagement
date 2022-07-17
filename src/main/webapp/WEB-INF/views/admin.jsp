<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/27/2022
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <title>Title</title>
        <jsp:include page="include/css.jsp"/>
    </head>

    <body>
        <jsp:include page="include/navbar.jsp"/>
        <div class="jumbotron text-center">
            <h1 class="display-4">Welcome back, Admin</h1>
            <p>Easily manage your data from this admin <mark>Supply Chain Management</mark></p>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 pt-3" >
                    <div class="card" style="background-color:white;">
                        <div class="card-body">
                            <h4 class="card-title">Products</h4>
                            <p class="card-text">Manage all the products here.</p>
                            <a href="${pageContext.request.contextPath}/api/page/v1/inventory/products/allProducts"  class="card-link btn btn-primary">Manage</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 pt-3" >
                    <div class="card" style="background-color:white;">
                        <div class="card-body">
                            <h4 class="card-title">Categories</h4>
                            <p class="card-text">Manage the categories section here.</p>
                            <a href="${pageContext.request.contextPath}/api/page/v1/inventory/categories/insert/all/show" class="card-link btn btn-primary">Manage</a>

                        </div>
                    </div>
                </div>
                <div class="col-sm-3 pt-3" >
                    <div class="card" style="background-color:white;">
                        <div class="card-body">
                            <h4 class="card-title">Inventories</h4>
                            <p class="card-text">Manage all the inventories here.</p>
                            <a href="${pageContext.request.contextPath}/api/page/v1/inventory/product/inventories/all/show"  class="card-link btn btn-primary">Manage</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3 pt-3" >
                    <div class="card" style="background-color:white;">
                        <div class="card-body">
                            <h4 class="card-title">Discounts</h4>
                            <p class="card-text">Manage all the discounts here.</p>
                            <a href="${pageContext.request.contextPath}/api/page/v1/inventory/product/discounts/all"  class="card-link btn btn-primary">Manage</a>
                        </div>
                    </div>
                </div>

            </div>

        </div>


    </body>

    <jsp:include page="include/footerJS.jsp"/>
</html>
