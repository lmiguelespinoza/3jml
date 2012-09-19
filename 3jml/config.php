<?php
$config = Config::singleton();

$config->set('controllersFolder', 'controllers/');
$config->set('modelsFolder', 'models/');
$config->set('viewsFolder', 'views/');

$config->set('dbhost', 'localhost');
$config->set('dbname', 'db');
$config->set('dbuser', 'root');
$config->set('dbpass', '');

/*urls*/
$config->set('url_login', 'index.php?controlador=login');

//redirect error
$config->set('url_redirect_error', 'index.php');


?>