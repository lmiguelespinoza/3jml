<?php
abstract class ControllerBase {
    
    protected $view;
	protected $config;
    
    function __construct()
    {
        $this->view = new View();
		$this->config = Config::singleton();
    }

}
?>