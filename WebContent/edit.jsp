<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">


<script src="bootstrap/js/jquery-3.4.1.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>

<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>


	<div class="container">
		<h3>Ajout des produis</h3>
<%-- 		<p class="error">${exception }</p> --%>
		<form method="post" action="UpdateProduit.php">
		
			  <div class="form-group">
		   		 <label for="identifiant">Identifiant: ${produit.id }</label>
		   		 <input type="hidden" name="id" class="form-control" id="identifiant" value="${produit.id }" placeholder="200000">
		  	  </div>
		  	  
		  	   <div class="form-group">
		   		 <label for="designation">Désignation</label>
		   		 <input type="text" name="designation" class="form-control" value="${produit.nom }" id="designation" placeholder="désignation">
		  	  </div>
		  	  
		  	   <div class="form-group">
		   		 <label for="prix">Prix</label>
		   		 <input type="text" name="prix" class="form-control" value="${produit.prix }" id="prix" placeholder="Prix">
		  	  </div>
		  	  
		  	   <div class="form-group">
		   		 <label for="qte">Quantité</label>
		   		 <input type="text" name="qte" class="form-control" value="${produit.quantite }" id="qte" placeholder="Quantité">
		  	  </div>
			
			    <input type="submit" class="btn btn-success" value="Update" name="action">
		
		
		</form>
		
		</div>
</body>
</html>