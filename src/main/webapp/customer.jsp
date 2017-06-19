<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
</head>
<body>
<h1>
<logic:iterate name="CustomerObject" id="customerList">
<p>Customer Details: <bean:write name="customerList"/></p>
</logic:iterate>
</h1>
</body>
</html>