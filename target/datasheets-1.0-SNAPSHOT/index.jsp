<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html lang="en">
<head>
    <style>
        body {
            background-color: black;
        }
    </style>
    <title>Electronic components</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="js/ajax.js"></script>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/alldatasheets"
                   user="root"  password="saidfadelreda"/>

<sql:query dataSource="${snapshot}" var="result">
    SELECT * FROM components;
</sql:query>



<div class="container-fluid-sm">
    <div class="jumbotron text-center mb-0">
        <h1 class="display-1">Electronic components</h1>
        <p>Easy and fast electronic documentations</p>
    </div>

    <div class="row text-white pt-3 pb-3" style="background-color: darkgray">
        <div class="col-md-4"></div>
   <!--     <div class="col-md-4">
            <label>Component:<input type="text" name="component" id="component" oninput="loadAjax()"/></label>
            <button class="btn btn-dark btn-outline-green">Search</button>
        </div>-->
        <div class="input-group col-md-4">
            <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
                   aria-describedby="search-addon" name="component" id="component" oninput="loadAjax()"/>
            <button type="button" class="btn btn-utline-primary btn-primary text-white" onclick="loadAjax()">search</button>
        </div>
    </div>
    <div>
        <table class="table table-hover table-inverse table-striped">
            <thead>
            <tr class="thead-dark">
                <th>Component id</th>
                <th>Reference</th>
                <th>Voltage</th>
                <th>Voltage unit</th>
                <th>Category</th>
                <th>Packaging</th>
                <th>Datasheet</th>
            </tr>
            </thead>
            <tbody id="data">
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
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
