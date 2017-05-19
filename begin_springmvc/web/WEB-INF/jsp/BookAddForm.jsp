<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-5-18
  Time: 下午5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book Form</title>
</head>
<body>

<div id="global">
    <form:form commandName="book" action="book_save" method="post">
        <fieldset>
            <legend>Add a book</legend>
            <p>
            <label for="category">Category:</label>
            <form:select id="category" path="category.id" items="${categories}" itemLabel="name" itemValue="id"/>
            </p>
            <p>
                <label for="title">Title:</label>
                <form:input id="title" path="title" />
            </p>
            <p>
                <label for="author">Author:</label>
                <form:input id="author" path="author" />
            </p>
            <p>
                <label for="isbn">ISBN:</label>
                <form:input id="isbn" path="isbn" />
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4"/>
                <input id="submit" type="submit" tabindex="5" value="Add Book"/>
            </p>
        </fieldset>
    </form:form>
</div>

</body>
</html>
