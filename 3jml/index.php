<?php
session_start();
if(!empty($_SESSION['username'])) {
	define( '_ACCESO', 1 );
	//define( '_MAIL', 1 ); //activo=con mail //desactivado=sin mail
	if($_SESSION['sla']<=1) {
		define( '_PRIVILEGIO', 1 );	
	}
	if($_SESSION['privilegio']=="Admin")
		define( '_ADMIN', 1 );
}
ini_set('date.timezone', 'America/Lima');

require 'libs/FrontController.php';
FrontController::main();
?>