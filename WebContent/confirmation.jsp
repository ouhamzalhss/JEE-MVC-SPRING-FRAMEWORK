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


	<div class="container mt-5">
	       <div class="alert alert-info" role="alert">

				 <h3>Confirmation</h3>	
			
				  <div class="form-group">
			   		 <label for="identifiant">Identifiant: ${produit.id }</label>
			  	  </div>
			  	  
			  	   <div class="form-group">
			   		 <label for="designation">Désignation:${produit.nom }</label>
			  	  </div>
			  	  
			  	   <div class="form-group">
			   		 <label for="prix">Prix:${produit.prix }</label>
			  	  </div>
			  	  
			  	   <div class="form-group">
			   		 <label for="qte">Quantité:${produit.quantite }</label>
			  	  </div>
					

		    </div>
	 </div>
</body>
</html>