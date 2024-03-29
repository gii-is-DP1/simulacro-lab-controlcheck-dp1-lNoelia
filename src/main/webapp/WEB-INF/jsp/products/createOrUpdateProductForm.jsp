<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="Product">
    <jsp:body>
        <h2> Product </h2>
        <form:form modelAttribute="product" class="form-horizontal">
            <div class="form-group has-feedback">
                <petclinic:inputField label="Name" name="name"/>
                <petclinic:inputField label="Price" name="price"/>
                <div class="control-group">
                    <petclinic:selectField name="producttype" label="Product Type " names="${productTypes}" size="3"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="id" value="${product.id}"/>
                    <button class="btn btn-default" type="submit">Add Product</button>
                </div>
            </div>
        </form:form>
    </jsp:body>
</petclinic:layout>
