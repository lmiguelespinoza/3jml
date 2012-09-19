<?php  
class Conexion {
	  
	private $conexion;  
	private $total_consultas;
	 
	public function Conexion() {  
		$config = Config::singleton();
		if(!isset($this->conexion)) {  
			$this->conexion = (mysql_connect($config->get('dbhost'),$config->get('dbuser'),$config->get('dbpass'))) or die(mysql_error());  			
			mysql_select_db($config->get('dbname'),$this->conexion) or die(mysql_error()); 
			mysql_query("SET NAMES 'utf8'");
		}  
	}  
	
	public function consulta($consulta) {  
		$resultado = mysql_query($consulta,$this->conexion);
		if(!$resultado) {  
			echo 'MySQL Error: ' . mysql_error();  
			exit;  
		}  
		return $resultado;   
	}
	
    public function ejecutar($comando) {		  
		if(!mysql_query($comando,$this->conexion)) {  
			echo 'MySQL Error: ' . mysql_error();  
			exit;  
		}  
	}    
	
	public function cerrarConexion() {
		mysql_close($this->conexion);
	}

    public function num_rows($consulta) {   
    	return mysql_num_rows($consulta);  
    }  
    
    public function affected_rows() {   
    	return mysql_affected_rows();  
    } 
	
    public function fetch_assoc($consulta) {   
    	return mysql_fetch_assoc($consulta);  
    }	
	
	public function real_escape_string($consulta) {
		return mysql_real_escape_string($consulta);
	}
	
	public function error() {
		return mysql_error();
	}
}
?>