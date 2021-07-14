<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>스프링</title>
<!-- jsp:include 해당 jsp코드를 여기에 그대로 넣어주는 역할(다른 jsp파일 가져옴) -->
<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
<style type="text/css">

	.body{
		min-height: calc(100vh - 240px);
	}
	
	

</style>
</head>
<body>
    <tiles:insertAttribute name="nav"/>
   
    <div class = "body">       
    <tiles:insertAttribute name="body" />
    </div>
    <tiles:insertAttribute name="footer" />
</body>
</html>