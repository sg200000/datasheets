<%--
  Created by IntelliJ IDEA.
  User: saidg
  Date: 1/9/2022
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/admin.css" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-md">
    <form method="get" action="AdminServlet">
        <div class="col-md-6"></div>
        <div class="col-md-6"></div>
        <div class="col-md-4">
            <label>Reference:
                <input type="text" name="reference"/>
            </label><br>
            <label>Category:
                <input type="text" name="category"/>
            </label><br>
            <label>Voltage:
                <input type="text" name="voltage"/>
            </label><br>
            <label>Voltage unit:
                <select name="voltage_unit">
                    <option value="V">V</option>
                    <option value="mV">mV</option>
                    <option value="uV">µV</option>
                </select>
            </label><br>
            <label>Packaging:
                <select name="packaging">
                    <option value="8-DIP">8-DIP</option>
                    <option value="32-DIP">32-DIP</option>
                    <option value="8-MSOP">8-MSOP</option>
                    <option value="10-MSOP">10-MSOP</option>
                    <option value="16-MSOP">16-MSOP</option>
                    <option value="8-SOIC">8-SOIC</option>
                    <option value="14-SOIC">14-SOIC</option>
                    <option value="16-SOIC">16-SOIC</option>
                    <option value="16-SOIC">16-SOIC</option>
                    <option value="SOT-23-6">SOT-23-6</option>
                    <option value="8-TDFN">8-TDFN</option>
                    <option value="8-TSSOP">8-TSSOP</option>
                    <option value="14-TSSOP">14-TSSOP</option>
                    <option value="20-TSSOP">20-TSSOP</option>
                    <option value="µSOP-8">µSOP-8</option>
                    <option value="48-CLCC">48-CLCC</option>
                    <option value="TQFP-44">TQFP-44</option>
                    <option value="LQFP">LQFP</option>
                    <option value="DO">DO</option>
                    <option value="TO">TO</option>
                </select>
            </label>
            <label>Datasheet:
                <input type="text" name="datasheet"/>
            </label><br>
            <input class="btn btn-primary" type="submit" name="submit" value="Add">
        </div>

    </form>
</div>
</body>
</html>
