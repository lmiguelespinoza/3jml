<!DOCTYPE html>
<html>

<head>
<title>Registro / Consulta  de  Pedido</title>
</head>

<body>

<form action="rs/pedido-service/newN" method="GET">
    <h2>Nro.Pedido</h2>	
	<input type="submit" value="Generar Nro. Pedido" />
</form>
<br />
<br />
<form action="rs/pedido-service/newC" method="POST">
    <h2>Cabecera</h2>
	<label for="cpedido">Pedido  </label> <input name="pPedCodigo"   /> <br />
	<label for="cpedido">Usuario </label> <input name="pUsuNombre"   /> <br />	
	<label for="cpedido">RUC     </label> <input name="pCliRUC"      /> <br />
	<label for="cpedido">Fecha   </label> <input name="pPedFecReg"   /> <br />
    <label for="cpedido">Total   </label> <input name="pPedTotal"    /> <br />    
	<input type="submit" value="Actualizar Cabecera" />
</form>
<br />
<br />
<form action="rs/pedido-service/newD" method="POST">
    <h2>Detalle</h2>
	<label for="dpedido">Pedido  </label> <input name="pPedCodigo"   /> <br />
	<label for="dpedido">Producto</label> <input name="pProCodigo"   /> <br />
	<label for="dpedido">Cantidad</label> <input name="pPedCantidad" /> <br />
    <label for="dpedido">Precio  </label> <input name="pProPrecio"   /> <br />
    <label for="dpedido">Parcial </label> <input name="pPedParcial"  /> <br />    
	<input type="submit" value="Actualizar Detalle" />
</form>
<br />
<br />
<h2>Consulta</h2>
<form action="rs/pedido-service/pedido/" method="GET">
	<label for="cpedido">Número de Pedido </label> <input name="pPedCodigo" /> <br />
	<input type="submit" value="Filtrar Pedido" />
</form>

<h2>Pedidos</h2>
<a href="rs/pedido-service/pedidos">Obtener pedidos</a>	

</body>

</html>