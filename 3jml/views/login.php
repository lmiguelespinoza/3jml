<?php
  ob_start();
?>
    <fieldset style="border:solid 1px #000; width:200px; padding-right:150px; padding-top:30px; padding-bottom:10px; margin:0 auto;">
    <form class="form-horizontal" method="post">
    <div class="control-group">
    <label class="control-label" for="inputEmail">Usuario</label>
    <div class="controls">
    <input type="text" id="username" name="username" placeholder="Usuario">
    </div>
    </div>
    <div class="control-group">
    <label class="control-label" for="inputPassword">Contrase&ntilde;a</label>
    <div class="controls">
    <input type="password" id="password" name="password" placeholder="Contrase&ntilde;a">
    </div>
    </div>
    <div class="control-group">
    <div class="controls">
    <label class="checkbox">
    <input type="checkbox"> Recordar mis datos
    </label>
    <button type="submit" class="btn">Iniciar sesi&oacute;n</button>
    </div>
    </div>
    </form>
    </fieldset>
<?php
  //Assign all Page Specific variables
  $content = ob_get_contents();
  ob_end_clean();
  ob_start();
?>


<?php
  $acciones = ob_get_contents();
  ob_end_clean();
  $pagetitle = "Login";
  //Apply the template
  include("masterpage.php");
?>