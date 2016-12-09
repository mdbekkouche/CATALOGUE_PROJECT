
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalogue des produits</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
 <div>
 <table class="cMonTableau1">
 
 	<tr>
 		<th>ID</th><th>DES</th><th>PRIX</th><th>QUANTITE</th>
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