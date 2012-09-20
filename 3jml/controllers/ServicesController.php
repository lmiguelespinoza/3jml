<?php
class ServicesController extends ControllerBase
{
	public function index() {
		header('Location: index.php');
	}
	
	public function validaRucClienteSoap() {
		@$ruc = $_GET['ruc'];
		if(!is_null($ruc)) {
			$estadoSunat    = $this->consulta_ruc_sunat_soap($ruc);			
			$estadoInfocorp = $this->consulta_ruc_infocorp_soap($ruc);
			if($estadoSunat == 'Activo' and $estadoInfocorp == 'Activo') {
				$class  = 'success'; $estado = 'Activo';
			} else {
				$class = 'important'; $estado = 'Inactivo';	
			}
			$result = array('clase' => $class, 'estado' => $estado);
		} else {
			$result = array('clase' => 'info', 'Servicio web no disponible');
		}
		echo json_encode($result);
	}
	
	public function validaRucSunat() {
		@$ruc = $_GET['ruc'];
		if(!is_null($ruc)) {
			$estado = $this->consulta_ruc_sunat_soap($ruc);
			($estado == 'Activo') ? $class = 'success' : $class = 'important';
			$result = array('clase' => $class, 'estado' => $estado);			
		} else {
			$result = array('clase' => 'info', 'Servicio web no disponible');
		}
		echo json_encode($result);
	}
	
	public function validaRucInfocorp() {
		@$ruc = $_GET['ruc'];
		if(!is_null($ruc)) {
			$estado = $this->consulta_ruc_infocorp_soap($ruc);
			($estado == 'Activo') ? $class = 'success' : $class = 'important';
			$result = array('clase' => $class, 'estado' => $estado);			
		} else {
			$result = array('clase' => 'info', 'Servicio web no disponible');
		}
		echo json_encode($result);
	}
	
	private function consulta_ruc_sunat_soap($ruc) {
		$client = new SoapClient('http://localhost:8081/consultasunat/EstadoService?wsdl', array('trace' => 1));
		$result = $client->consultaRuc(array('nRuc' => $ruc));
		return (string) $result->estado;
	}
	
	private function consulta_ruc_infocorp_soap($ruc) {
		$client = new SoapClient('http://localhost:8081/consultainfocorp/EstadoService?wsdl', array('trace' => 1));
		$result = $client->consultaRuc(array('nRuc' => $ruc));
		return (string) $result->estado;
	}

}
?>