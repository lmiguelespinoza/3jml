<!DOCTYPE html>
<html>
<head>
<title>Form to create a new resource</title>
</head>
<body>
<form action="rs/pedido-service/new" method="POST">
	<label for="cpedido">RUC   </label> <input name="pCliRUC"    /> <br />
	<label for="cpedido">Fecha </label> <input name="pPedFecReg" /> <br />
    <label for="cpedido">Total </label> <input name="pPedTotal"  /> <br />    
	<label for="dpedido">Producto</label> <input name="pProCodigo"   /> <br />
	<label for="dpedido">Cantidad</label> <input name="pPedCantidad" /> <br />
    <label for="dpedido">Precio  </label> <input name="pProPrecio"   /> <br />
    <label for="dpedido">Parcial </label> <input name="pPedParcial"  /> <br />    
	<input type="submit" value="Submit" />
</form>

</body>
</html>