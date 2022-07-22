<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/16/2022
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update Product</title>
        <jsp:include page="../include/css.jsp"/>
    </head>
    <body>


        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6">
                    <%--@elvariable id="productDto" type="com.example.supplychainmanagement.dto.request.ProductDto"--%>
                    <form:form action="${pageContext.request.contextPath}/api/page/v1/inventory/products/update/${responseProductDto.id}" method="post" modelAttribute="productDto" enctype="multipart/form-data">


                        <div class="form-group">
                            <label for="name">Product Name</label>
                            <form:input type="text" name="name" id="name" path="name" value="${responseProductDto.name}" placeholder="Your Name" class="form-control form-control-lg"/>
                            <form:errors path="name" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="description">Product Description</label>
                            <form:input type="text" class="form-control form-control-lg" path="description" value="${responseProductDto.description}" placeholder="Description" name="description" id="description"/>
                            <form:errors path="description" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="SKU">Product SKU</label>
                            <form:input type="text" name="SKU" id="SKU" path="SKU" value="${responseProductDto.SKU}" placeholder="SKU" class="form-control form-control-lg"/>
                            <form:errors path="SKU" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="price">Price</label>
                            <form:input type="number" cssClass="form-control" id="price" value="${responseProductDto.price}" placeholder="Price" path="price"/>
                            <form:errors path="price" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="quantity">Quantity add number</label>
                            <form:input type="number" cssClass="form-control" value="${responseProductDto.productInventory.quantity}" id="quantity" placeholder="Quantity number" path="quantity"/>
                            <form:errors path="quantity" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="categoryName">Category Name:</label>
                            <form:input type="text" cssClass="form-control" value="${responseProductDto.category.name}" id="categoryName" path="categoryName" disabled="false"/>
                            <form:errors path="categoryName" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="discountName">Discount Name:</label>
                            <form:select cssClass="dropdown" id="discountName" path="discountName">
                                <form:option selected="true" value="${responseProductDto.discount.name}" />
                                <form:options items="${allDiscountName}"/>
                            </form:select>
                            <form:errors path="discountName" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <label>Product Image</label>
                            <img src="<c:url value="/api/page/v1/image-manual-response/${responseProductDto.photosAttachmentList.get(0).id}"/>" alt="img" width="150" height="150"/>

                            <input type="file"  name="productImage" accept="image/*"/>
                        </div>

                        <button type="submit" class="btn btn-primary">Create</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    </body>
</html>
