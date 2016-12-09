
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalogue produits</title>
</head>
<body>
 <div>
 <table>
 
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