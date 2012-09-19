<?php
  ob_start();
?>
	  <div class="hero-unit">
        <h1>Bienvenido,</h1>
		<h2>Sistema de Pre-venta para Bodegas</h2>
        <p>[descripcion]</p><br />
        <p><a href="index.php?controlador=login" class="btn btn-success btn-large">Iniciar sesi&oacute;n &raquo;</a></p>
      </div>
<?php
  //Assign all Page Specific variables
  $content = ob_get_contents();
  ob_end_clean();
  ob_start();
?>


<?php
  $acciones = ob_get_contents();
  ob_end_clean();
  $pagetitle = "Inicio";
  //Apply the template
  include("masterpage.php");
?>