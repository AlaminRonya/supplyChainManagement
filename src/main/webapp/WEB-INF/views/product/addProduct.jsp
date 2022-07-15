<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/15/2022
  Time: 1:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
<div class="container">

    <div class="container-fluid">

        <div class="container">
            <div class="col-sm-6">
                <h3 style="margin-top: 10px">Add Product</h3>
                <p>Please fill out this to form</p>
                <%--@elvariable id="productDto" type="com.example.supplychainmanagement.dto.request.ProductDto"--%>
                <form:form action="${pageContext.request.contextPath}/api/page/v1/inventory/products/addProduct" method="POST" modelAttribute="productDto" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name">Product Name</label>
                        <form:input type="text" name="name" id="name" path="name"  placeholder="Your Name" class="form-control form-control-lg"/>
                        <form:errors path="name" cssClass="text-danger" />
                    </div>

                    <div class="form-group">
                        <label for="description">Product Description</label>
                        <form:input type="text" class="form-control form-control-lg" path="description"  placeholder="Description" name="description" id="description"/>
                        <form:errors path="description" cssClass="text-danger" />
                    </div>

                    <div class="form-group">
                        <label for="SKU">Product SKU</label>
                        <form:input type="text" name="SKU" id="SKU" path="SKU"  placeholder="SKU" class="form-control form-control-lg"/>
                        <form:errors path="SKU" cssClass="text-danger" />
                    </div>

                    <div class="form-group">
                        <label for="price">Price</label>
                        <form:input type="number" cssClass="form-control" id="price" placeholder="Price" path="price"/>
                        <form:errors path="price" cssClass="text-danger"/>
                    </div>

                    <div class="form-group">
                        <label for="quantity">Quantity number</label>
                        <form:input type="number" cssClass="form-control" id="quantity" placeholder="Quantity number" path="quantity"/>
                        <form:errors path="quantity" cssClass="text-danger"/>
                    </div>

                    <div class="form-group">
                        <label for="categoryName">Category Name:</label>
                        <form:select cssClass="dropdown" id="categoryName" path="categoryName">
                            <form:option selected="true" value="Select Category" disabled="true"/>
                            <form:options items="${allCategoryName}"/>
                        </form:select>
                        <form:errors path="categoryName" cssClass="text-danger" />
                    </div>

                    <div class="form-group">
                        <label for="discountName">Discount Name:</label>
                        <form:select cssClass="dropdown" id="discountName" path="discountName">
                            <form:option selected="true" value="Select Discount" disabled="true"/>
                            <form:options items="${allDiscountName}"/>
                        </form:select>
                        <form:errors path="discountName" cssClass="text-danger" />
                    </div>

                    <div class="form-group">
                        <label>Product Image</label>
                        <input type="file" name="productImage" accept="image/*"/>
                    </div>

                    <button type="submit" class="btn btn-primary">Create</button>
                </form:form>
            </div>
        </div>
    </div>
</div>



</body>
</html>
