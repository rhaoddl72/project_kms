<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<title>
	
	
	<c:if test="${title ne null}">${title}</c:if>
	<c:if test="${title eq null}">스프링</c:if>

</title>
</head>
<body>
    <tiles:insertAttribute name="nav"/>
    <tiles:insertAttribute name="body" />                                                 
    <tiles:insertAttribute name="footer" />
</body>
</html>