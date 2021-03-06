<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,br.com.robson.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
</head>
<body>
	
	Usuario Logado: ${usuarioLogado.login}	
	<br>
	<c:import url="logout-parcial.jsp"></c:import>	
	<a href="/gerenciador/entrada?acao=FormNovaEmpresa">Nova Empresa</a>
	<br>
    <br>
    Lista de empresas:
    <ul>    
        <c:forEach items="${empresas}" var="empresa">

            <li>
                ${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> 
                <a href="/gerenciador/entrada?acao=MostrarEmpresa&id=${empresa.id} ">editar</a>
                <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id} ">remove</a>
            </li>
        </c:forEach>
    </ul>

</body>
</html>