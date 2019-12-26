<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">


<script src="bootstrap/js/jquery-3.4.1.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>

<script type="text/javascript">
	function confimeSupp(id){
		var conf = confirm("Do you want to delete this product ?");
		if(conf==true){
			document.location="supprimer.php?id="+id;
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<div class="row">
		<div class="col-md-10">
		    <div class="card my-3">
			  <h3>Recherche des produits:</h3>
			  <div class="card-body">
			   
				<form action="chercher.php" method="get">
				    <div class="form-group">
						<label>Mot clé:</label>
						<input type="text" class="form-control" name="mc" value="${model.motCle }">
					</div>
					 <div class="form-group">
						<button type="submit" class="btn btn-primary">Charger</button>
					</div>
				</form>
			  </div>
			</div>
			
		<h3>Liste des produis</h3>
		<table class="table table-striped">
			<tr>
				<th>ID</th><th>Designation</th><th>Prix</th><th>Quantité</th><th colspan="2">Actions</th>
			</tr>
			<c:forEach items="${model.prods }" var="p">
				<tr>
				<td><a href="edit.php?id=${p.id }">${p.id }</a></td>
				<td><a href="edit.php?id=${p.id }">${p.nom }</a></td>
				<td>${p.prix }</td>
				<td>${p.quantite }</td>
				<td><a class="btn btn-danger" href="javascript:confimeSupp('${p.id }')">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		</div>
	</div>
	
	
</body>
</html>