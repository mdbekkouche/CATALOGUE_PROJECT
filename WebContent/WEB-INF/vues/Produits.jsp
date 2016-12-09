
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalogue des produits</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript">
	function confirmation(id) {
		var conf = confirm("Etes vous sûr de vouloir supprimer ?");
		if (conf == true) {
			document.location = "controleur.php?action=supprimer&id="+id;
		}
	}
</script>
</head>
<body>

	<div>
		${ exception }
		<form action="controleur.php" method="post">
			<table>
			    <tr>
					<td>ID:</td>
					<td>${ produit.idProduit }<input type="hidden" name="idProduit" value="${produit.idProduit}"></td>
				</tr>
				<tr>
					<td>Designation:</td>
					<td><input type="text" name="designation" value="${produit.designation}"></td>
				</tr>
				<tr>
					<td>Prix:</td>
					<td><input type="text" name="prix" value="${produit.prix}"></td>
				</tr>
				<tr>
					<td>Quantité:</td>
					<td><input type="text" name="quantite" value="${produit.quantite}"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<c:if test="${ produit == null }">
							<input type="submit" name="action" value="Save">	
						</c:if>
						<c:if test="${ produit != null }">
							<input type="submit" name="action" value="Update">
						</c:if>
					</td>
				</tr>
			</table>
		</form>
		
	</div>

	<div>
		<table class="cMonTableau1">

			<tr>
				<th>ID</th>
				<th>DES</th>
				<th>PRIX</th>
				<th>QUANTITE</th>
			</tr>
			<c:forEach items="${ produits }" var="p">
				<tr>
					<td>${ p.idProduit }</td>
					<td>${ p.designation }</td>
					<td>${ p.prix }</td>
					<td>${ p.quantite }</td>
					<td><a href="javascript:confirmation('${ p.idProduit }')">Supprimer</a></td>
					<td><a href="controleur.php?action=editer&id=${ p.idProduit }">Editer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>