<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- taglib de spring security --%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'ajout d'un cours</title>
</head>
<body>
	<%-- inclusion dynamique du fragment entete.jsp --%>
	<jsp:include page="/WEB-INF/fragments/entete.jsp" />

	<div align="center">
		<h2>Ajout d'un cours</h2>
	</div>

	<div align="center">
		
		<form:form modelAttribute="coursAddCommand" method="POST" action="${pageContext.request.contextPath}/coursAdd-meth">
		
		<form:errors path="*" cssClass="error_validation" element="div" />
		
			<table>
				<tr>
					<td> <form:label path="libelle">Libell� : </form:label> </td>
					<td> <form:input path="libelle"/> </td>
					<td> <form:errors path="libelle"/> </td>
				</tr>
				
				<tr>
					<td> <form:label path="matiere">Mati�re : </form:label> </td>
					<td> <form:input path="matiere"/> </td> <!-- chercher pour avoir la liste des matiere -->
					<td> <form:errors path="matiere"/> </td>
				</tr>
				
				<tr>
					<td> <form:label path="date">Date : </form:label> </td>
					<td> <form:input path="date"/> </td>
					<td> <form:errors path="date"/> </td>
				</tr>
				
				<tr>
					<td> <form:label path="duree">Dur�e : </form:label> </td>
					<td> <form:input path="duree"/> </td>
					<td> <form:errors path="duree"/> </td>
				</tr>
				
				<tr>
					<td> <form:label path="description">Description : </form:label> </td>
					<td> <form:input path="description"/> </td>
					<td> <form:errors path="description"/> </td>
				</tr>
				
				<tr>
					<td> <form:label path="promotion">Promotion : </form:label> </td>
					<td> <form:input path="promotion"/> </td> <!-- chercher pour avoir la liste des matiere -->
					<td> <form:errors path="promotion"/> </td>
				</tr>
				
<%-- 				<form:input type="hidden" path="etudiantCours" value="<%= %>" /><!-- recuperer les �tudiants de la promotion ?? ou dans le validator de cours??  --> --%>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="Ajouter">
					</td>
				</tr>
								
			</table>
		</form:form>
	</div>
	
	<%-- inclusion dynamique du fragment piedDePage.jsp --%>
	<jsp:include page="/WEB-INF/fragments/piedDePage.jsp" />

</body>
</html>