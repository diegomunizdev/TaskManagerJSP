<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="StyleSheet" type="text/css" href="CSS/style.css" media="screen" >
<title>List of all tasks</title>
</head>
<body>
<table  width="100%" class="container">
	<thead >
	    <tr>
	        <th>ID da Tarefa</th>
	        <th>Nome</th>
	        <th>Descrição</th>
	        <th>Status</th>
	        <th>Atribuido</th>
	        <th>Data de conclusão</th>
	        <th>Data da criação</th>
	        <th>Data da atualização</th>
	        <th colspan="2">Ações</th>
	    </tr>
	</thead>
	<tbody>
		<c:forEach items="${tasks}" var="task">
			<jsp:useBean id="td" class="java.util.Date" />
			<c:if test="${task.data_conclusao.after(td)}"></c:if>
			
			
							<p>
				    <jsp:useBean id="today" class="java.util.Date" />
				    <b><c:out value="${today}"/></b>
				</p>
				<fmt:setLocale value="pt_BR" />
				<fmt:parseDate var="testdate" value="${task.data_conclusao}" pattern="yyyy-MM-dd" />
				<c:if test="${today.time gt testdate.time}">
				    <p><b><span class="wrap">Test date is less than now.</span></b></p>
				</c:if>
			
		    <c:choose>
		        <c:when test="${task.id mod 2 == 0}">
		            <tr class="par">
			            <td><c:out value="${task.id}" /></td>
			            <td><c:out value="${task.name}" /></td>
			            <td><c:out value="${task.description}" /></td>
			            <td><c:out value="${task.status_tarefa}" /></td>
			            <td><c:out value="${task.atribuido}" /></td>
			            <td><c:out value="${task.data_conclusao}" /></td>
			            <td><c:out value="${task.dateCreated}" /></td>
			            <td><c:out value="${task.dateUpdated}" /></td>
			            <td><a href="TaskController.do?action=edit&id=<c:out value="${task.id}"/>" class="btn-editar">Editar</a></td>
			            <td><a href="TaskController.do?action=delete&id=<c:out value="${task.id}"/>" class="btn-remover">Remover</a></td>
			        </tr>
		        </c:when>
		        <c:otherwise>
		           <tr class="impar">
			            <td><c:out value="${task.id}" /></td>
			            <td><c:out value="${task.name}" /></td>
			            <td><c:out value="${task.description}" /></td>
			            <td><c:out value="${task.status_tarefa}" /></td>
			            <td><c:out value="${task.atribuido}" /></td>
			            <td><c:out value="${task.data_conclusao}" /></td>
			            <td><c:out value="${task.dateCreated}" /></td>
			            <td><c:out value="${task.dateUpdated}" /></td>
			            <td><a href="TaskController.do?action=edit&id=<c:out value="${task.id}"/>" class="btn-editar">Editar</a></td>
			            <td><a href="TaskController.do?action=delete&id=<c:out value="${task.id}"/>" class="btn-remover">Remover</a></td>
			        </tr>
		        </c:otherwise>
		    </c:choose>
	    </c:forEach>
	</tbody>
</table>
</br>
<p class="container">
    <a href="TaskController.do?action=create" class="btn">Criar tarefa</a>
</p>
</body>
</html>