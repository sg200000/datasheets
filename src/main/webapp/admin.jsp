<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="admin/css/admin.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="admin/js/ajaxAdmin.js"></script>
    <style>
        body {
            background-color: aqua;
        }
    </style>
</head>
<body >
<div class="global container-fluid-sm p-3 my-3 bg-aqua text-black">
    <div class="row">
        <div class="col-md-4">
            <h1 class="titles">Add new Component</h1>
            <table>
                <tr>
                    <td>Reference:</td>
                    <td><input type="text" name="reference" id="reference"/></td>
                </tr>
                <tr>
                    <td>Category:</td>
                    <td><input type="text" name="category" id="category"/></td>
                </tr>
                <tr>
                    <td>Voltage:</td>
                    <td><input type="text" name="voltage" id="voltage"/></td>
                </tr>
                <tr>
                    <td>Voltage unit:</td>
                    <td>
                        <select name="voltage_unit" id="voltage_unit">
                        <option value="V">V</option>
                        <option value="mV">mV</option>
                        <option value="uV">µV</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Packaging:</td>
                    <td>
                        <select name="packaging" id="packaging">
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
                    </td>
                </tr>
                <tr>
                    <td>Datasheet:</td>
                    <td><input type="text" name="datasheet" id="datasheet"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-primary" type="button" id="add" name="submit" value="Add" onclick="loadAjax('add')" /></td>
                </tr>
            </table>
        </div>
        <div class="col-md-4 titles">
            <h1 class="titles">Delete a component</h1>
            <table>
                <tr>
                    <td>id</td>
                    <td><input type="text" name="id" id="idRm"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-primary" type="button" name="submit" value="delete" onclick="loadAjax('remove')"></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
