<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html lang="en">
<head>
    <style>
        .no-padding {
            margin: 0 ! important;
            padding: 0 ! important;
        }
    </style>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="ajax.js"></script>
</head>
<body>

<div class="jumbotron text-center">
    <h1 class="display-1">Electronic components finder</h1>
    <p>Easy and fast electronic documentations</p>
</div>

<div class="container-fluid-sm p-3 my-3 bg-dark text-white">
    <div class="row no-padding">
        <div class="col-sm-4"></div>
        <div>
            <form method="get" action="">
                <label>Component:
                    <input type="text" name="component" id="component" onchange="loadAjax()" /></label>
                <button>Search</button>
            </form>
        </div>
    </div>
</div>

<sql:setDataSource var="snapshot"
                   url="jdbc:mysql://localhost:3306/alldatasheets"
                   user="root"  password="said2000"/>

<sql:query dataSource="${snapshot}" var="result">
    SELECT * FROM components;
</sql:query>

<table class="table table-hover table-inverse table-striped">
    <tr class="thead-dark">
        <th>Component id</th>
        <th>Reference</th>
        <th>Voltage</th>
        <th>Voltage unit</th>
        <th>Category</th>
        <th>Packaging</th>
        <th>Datasheet</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.reference}"/></td>
            <td><c:out value="${row.voltage}"/></td>
            <td><c:out value="${row.voltage_unit}"/></td>
            <td><c:out value="${row.category}"/></td>
            <td><c:out value="${row.packaging}"/></td>
            <td><a href="${row.datasheet}" >Dowload</a></td>
        </tr>
    </c:forEach>
</table>
<p id="print"></p>
</body>
</html>
