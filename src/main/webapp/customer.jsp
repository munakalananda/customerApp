<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<html>
<head>
</head>
<body>
<h1 align="center">Customer Details</h1>
<table align="center" border="2">
<tr bgcolor="#33ccff">
    <th>Customer Name</th>
    <th>Customer Id</th>
    <th>Customer Address</th>
</tr>
<logic:iterate name="CustomerObject" id="customerList">
<tr>
    <td align="center"><bean:write name="customerList"  property="customerName"/></td>
    <td align="center"><bean:write name="customerList"  property="customerId"/></td>
    <td align="center"><bean:write name="customerList"  property="customerAddress"/></td>
</tr>
</logic:iterate>
</table>
</body>
</html>
