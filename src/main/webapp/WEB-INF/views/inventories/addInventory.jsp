<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/13/2022
  Time: 2:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Inventory</title>
        <jsp:include page="../include/css.jsp"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-9">
                    <%--@elvariable id="productInventoryDto" type="com.example.supplychainmanagement.dto.ProductInventoryDto"--%>
                    <form:form action="${pageContext.request.contextPath}/api/page/v1/inventory/product/inventories/addInventory" method="post" modelAttribute="productInventoryDto" >
                        <div class="form-group">
                            <label for="quantity">Quantity number</label>
                            <form:input type="number" cssClass="form-control" id="quantity" placeholder="Quantity number" path="quantity"/>
                            <form:errors path="quantity" cssClass="text-danger"/>
                        </div>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </form:form>
                </div>
            </div>
        </div>

    </body>
</html>
