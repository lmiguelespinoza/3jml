<?php
class ServicesController extends ControllerBase
{
	public function index() {
		header('Location: index.php');
	}
	
	public function validaRucSunat() {
		@$ruc = $_GET['ruc'];
		if(!is_null($ruc)) {
			$resultadoSunat = $this->consulta_ruc_sunat_soap($ruc);
			if($resultadoSunat->estado == 1) {
				$msj = '<button type=button" class="close" data-dismiss="alert">×</button>
			            &bull; El nro. de RUC ingresado se encuentra <strong>activo</strong> en la SUNAT.';
			} elseif($resultadoSunat->estado == 2) {
				$msj = '<button type=button" class="close" data-dismiss="alert">×</button>
			            &bull; El nro. de RUC ingresado se encuentra <strong>inactivo</strong> en la SUNAT.';
			} elseif($resultadoSunat->estado == 3) {
				$msj = '<button type=button" class="close" data-dismiss="alert">×</button>
			            &bull; El nro. de RUC ingresado <strong>no existe</strong> en la SUNAT.';
			}
			$infocorp = $this->validaRucInfocorp($ruc);			
			$resultado = array_merge((array) $resultadoSunat, array('msj' => $msj, 'infocorp' => $infocorp));
			echo json_encode($resultado);
		}
	}
		
	private function validaRucInfocorp($ruc) {
		$msj = "";
		if(!is_null($ruc)) {
			$estado = $this->consulta_ruc_infocorp_soap($ruc);
			if($estado == 1) {
				$msj = '<button type=button" class="close" data-dismiss="alert">×</button>
			            &bull; El nro. de RUC ingresado figura como <strong>deudor</strong> en INFOCORP.';
			}
		}
		return $msj;
	}
	
	private function consulta_ruc_sunat_soap($ruc) {
		$client = new SoapClient('http://localhost:8081/consultasunat/EstadoService?wsdl', array('trace' => 1));
		$result = $client->consultarRuc(array('nRuc' => $ruc));
		return $result->persona;
	}
	
	private function consulta_ruc_infocorp_soap($ruc) {
		$client = new SoapClient('http://localhost:8081/consultainfocorp/EstadoService?wsdl', array('trace' => 1));
		$result = $client->consultarDeudorRuc(array('nRuc' => $ruc));
		return (string) $result->estado;
	}

}
?>