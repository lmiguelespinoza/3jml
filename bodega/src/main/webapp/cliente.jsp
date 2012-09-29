<!DOCTYPE html>
<html>
<head>
<title>Form to create a new resource</title>
</head>
<body>
<form action="rs/cliente-service/new" method="POST">
	
	<label for="dni">RUC</label> <input name="ruc" /> <br />
	<label for="nombres">Razon</label> <input name="razonSocial" /> <br />
    <label for="nombres">Direccion</label> <input name="direccion" /> <br />
	<label for="nombres">Distrito</label> <input name="distrito" /> <br /> 
    <label for="nombres">Telefono</label> <input name="telefono" /> <br />
    <label for="nombres">Correo</label> <input name="correo" /> <br />
    <label for="nombres">Contacto</label> <input name="contacto" /> <br />     
	
	<input type="submit" value="Submit" />
</form>

</body>
</html>