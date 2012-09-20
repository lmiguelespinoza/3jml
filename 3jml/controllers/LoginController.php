<?php
class LoginController extends ControllerBase
{
	public function index() {
		$this->view->show("login.php", @$data);
		
		if($_POST) {
			$user = $_POST['username'];
			$pwd  = $_POST['password'];
			if($user == 'user' and $pwd == '123456') {
				//define('ACCESO', 1);
				header('location: index.php?controlador=index&accion=index');	
			}
		}
	}

}
?>