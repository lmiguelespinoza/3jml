<?php
class IndexModel extends ModelBase
{
	public function listadoTotal()
	{		
		$consulta = $this->db->consulta("SELECT * FROM usuario"); 
		$this->db->cerrarConexion();
		return $consulta;
	}
		
}
?>