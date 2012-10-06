<!DOCTYPE html>
<html>
<head>
<title>Form to create a new resource</title>
</head>
<body>
<form action="rs/producto-service/new" method="POST">
	<label for="producto">Descripción  </label> <input name="pNombre" /> <br />
	<label for="producto">Unidad venta </label> <input name="pUnivta" /> <br />
	<label for="producto">Precio       </label> <input name="pPrecio" /> <br />
    <label for="producto">Stock        </label> <input name="pStock" /> <br />
	<input type="submit" value="Submit" />
</form>

</body>
</html>