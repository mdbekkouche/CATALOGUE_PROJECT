
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalogue des produits</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<div>
	
		<form action="controleur.php" method="post">
			<table>
				<tr>
					<td>Designation:</td>
					<td><input type="text" name="designation"></td>
				</tr>
				<tr>
					<td>Prix:</td>
					<td><input type="text" name="prix"></td>
				</tr>
				<tr>
					<td>Quantité:</td>
					<td><input type="text" name="quantite"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="action" value="save"></td>
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
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>