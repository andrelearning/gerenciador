<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.List"%>
<%@page import="br.com.alura.gerenciador.model.Empresa"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">





<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Empresas</title>
</head>
<body>

	<c:if test="${not empty empresa}">
		Empresa ${ empresa } cadastrada com sucesso!
	 </c:if>

	Lista de empresas: <br/>
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
		
			<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
			<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remover</a>
			<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">alterar</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>