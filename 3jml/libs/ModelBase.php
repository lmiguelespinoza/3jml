<?php
abstract class ModelBase 
{
	protected $db;

	public function __construct()
	{
		$this->db = new Conexion(); 		
	}
	
	public function cerrarConexion()
	{
		$this->db->cerrarConexion();
	}
}
?>