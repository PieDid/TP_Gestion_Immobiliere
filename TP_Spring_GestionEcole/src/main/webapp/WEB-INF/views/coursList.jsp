<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de liste des cours</title>
</head>
<body>

	<!-- r�cup�r�e grace � la m�thode generateCoursList du controlleur CoursController-->
	<h2>Liste des cours</h2>

	<table>
		<tr>
			<th>Identifiant</th>
			<th>Mati�re</th>
			<th>Libell�</th>
			<th>Dur�e</th>
			<th>Description</th>
			<th>Promotion</th>

		</tr>
		<c:forEach items="${attribut_listeCours}" var="cours">

			<tr>
				<td>${cours.idCours}</td>
				<td>${cours.matiere}</td>
				<td>${cours.libelle}</td>
				<td>${cours.date}</td>
				<td>${cours.duree}</td>
				<td>${cours.description}</td>
				<td>${cours.promotion}</td>
				<!-- Cette m�thode peut etre dans personne controller. 
				
					Elle s'appelle etudiantByIdCours, prend en argument 
					un int idCours qui corresponds � l'id du cours, et renvoie la liste des �tudiants qui sont associ� a ce cours. 
					
					L'affichage de la liste se ferait dans etudiantList.jsp, ou qqch comme ca. 
					
					La requete SQL ressemblerait � :
					
					SELECT * FROM etudiant e 
						 INNER JOIN etudiantcours ec
						 ON e.id_etudiant = ec.etudiant_id
						 WHERE ec.cours_id = :pIdCours
							 
					avec pIdCours qui correspond � l'id du cours en question.
				 -->

				<td colspan="2"><a
					href="etudiantByIdCours?coursId=${cours.idCours}">Liste des
						�tudiants du cours (redirection)</a></td>

				<!-- appelle vers la m�thode afficherFormulaireUpdateCours du CoursController, 
					redirigant vers le formulaire pour udpater le cours -->
				<td colspan="2"><a href="coursUpdate?coursId=${cours.idCours}">Modifier</a>
				</td>

				<!-- appelle vers la m�thode supprimerCours du CoursController -->
				<td colspan="2"><a href="coursDelete?courId=${cours.idCours}">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
		<!-- appelle vers la m�thode afficherFormulaireAddCours du CoursController, 
					redirigant vers le formulaire pour ajouter le cours le cours -->
		<tr>
			<td colspan="10"><a href="coursAdd">Ajouter</a></td>
		</tr>
	</table>
	<hr />


</body>
</html>