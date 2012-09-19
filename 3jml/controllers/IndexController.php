<?php
class IndexController extends ControllerBase
{
	public function index() {
		$this->view->show("home.php", @$data);
	}
	
	public function login() {
		$this->view->show("login.php", @$data);
	}

	public function soap() {
		echo "Leyendo un Servicio Web SOAP <br />";
		$client = new SoapClient('http://localhost:8081/apachecxf-jaxws-get-person/HolaMundo?wsdl', array('trace' => 1));

		$result = $client->decirHola(array('arg0'=>'Juanziiko'));
		//echo "Respuesta: " . $client->__getLastResponse() . "<br />";
		//var_dump($result);
		echo "Respuesta de la funcion 'decirHola()': <br />";
		echo $result->mensaje;
		
		$persona = $client->buscarPersona(array('legajo'=>30));
		//var_dump($persona);
		echo "Respuesta de la funcion 'buscarPersona()': <br />";
		foreach($persona as $row) {
			echo $row->legajo . " => " . $row->nombre . "<br />";	
		}
		
		$personas = $client->obtenerPersonas();
		//var_dump($personas);
		echo "Respuesta de la funcion 'obtenerPersonas()': <br />";
		foreach($personas as $persona) {
			foreach($persona as $row)
			echo $row->legajo . " => " . $row->nombre . "<br />";	
		}
	}
	
	public function nuevo() {
		$this->view->show("nuevo-cliente.php", @$data);
	}

}
?>