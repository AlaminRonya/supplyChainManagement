<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/10/2022
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
    <div class="container-fluid">

        <div class="container">
            <div class="col-sm-6">
                <h3 style="margin-top: 10px">App Inventory Manager</h3>
                <p>Please fill out this to add category</p>
                <%--@elvariable id="productCategoryDto" type="com.example.supplychainmanagement.dto.request.ProductCategoryDto"--%>
                <form:form action="${pageContext.request.contextPath}/api/page/v1/inventory/categories/addCategory" method="POST" modelAttribute="productCategoryDto" >
                    <div class="form-group">
                        <label for="name">Name</label>
                        <form:input type="text" name="name" id="name" path="name"  placeholder="Category Name" class="form-control form-control-lg"/>
                        <form:errors path="name" cssClass="text-danger"/>
                    </div>
                    <div class="form-group">
                        <label for="desc">Description</label>
                        <form:input type="text" name="desc" id="desc" path="desc"  placeholder="Category description" class="form-control form-control-lg"/>
                        <form:errors path="desc" cssClass="text-danger"/>

                    </div>

                    <button type="submit" class="btn btn-primary">Create</button>
                </form:form>
            </div>
        </div>
    </div>

</body>
</html>
