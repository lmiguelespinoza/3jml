<?php
class ClienteController extends ControllerBase
{
	public function index() {
		$this->nuevo();
	}
	
	public function nuevo() {
		$this->view->show("nuevo-cliente.php", @$data);
	}

}
?>