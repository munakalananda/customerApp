<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
</head>
<body>
<h1>Get Customer Details !!

</h1>
<html:form action="/customer.do" >
Get Customers Info :<html:submit value="GetDetails"/>
<%-- <html:text name="CustomerForm" property="customerID"/> --%>

</html:form>

</body>
</html>