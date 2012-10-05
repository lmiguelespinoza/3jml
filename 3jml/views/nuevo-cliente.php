<?php
  ob_start();
?>
<div class="row-fluid">
    <div class="span2">
		<div class="sidebar-nav">
            <ul class="well nav nav-list">
                <li class="nav-header">Menú Cliente</li>
                <li class="active"><a href="index.php?controlador=cliente&accion=nuevo"><i class="icon-edit"></i> Nuevo</a></li>
                <li><a href="#"><i class="icon-list"></i> Listar</a></li>
            </ul>
        </div>
    </div>
	<div class="span10">
        <form class="bs-docs-example form-horizontal" method="post" action="http://localhost:8081/bodega/rs/cliente-service/new">
            <legend>Registro de nuevo cliente</legend>
            <div id="alertMsg1" class="alert hidden"></div>
            <div id="alertMsg2" class="alert hidden"></div>
            <div class="control-group">
                <label class="control-label" for="txtRuc">RUC</label>
                <div class="controls">
                    <input id="txtRuc" name="ruc" placeholder="RUC" type="text" maxlength="11" tabindex="1" class="span3" autocomplete="off">          
                    <button class="btn btn-small disabled" type="button" id="btnValidarEstadoCliente" disabled="disabled" tabindex="2" style="margin-left:10px;"
                            data-loading-text="Cargando...">Verificar estado</button>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="txtRazonSocial">Raz&oacute;n Social</label>
                <div class="controls">
                    <input id="txtRazonSocial" name="razonSocial" placeholder="Raz&oacute;n Social" type="text" class="span5" tabindex="4" disabled="disabled">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="txtDireccion">Direcci&oacute;n</label>
                <div class="controls">
                    <input id="txtDireccion" name="direccion" placeholder="Direcci&oacute;n" type="text" class="span7" tabindex="5" disabled="disabled">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="cboDistrito">Distrito</label>
                <div class="controls">
                    <select id="cboDistrito" name="distrito" class="span3" tabindex="6" disabled="disabled">
                        <option></option>
                        <option>ATE</option>
                        <option>CALLAO</option>
                        <option>CHORRILLOS</option>
                        <option>LOS OLIVOS</option>
                        <option>LA VICTORIA</option>
                        <option>MIRAFLORES</option>
                        <option>SANTIAGO DE SURCO</option>                
                        <option>SURQUILLO</option>
                        
                    </select>
                </div>
            </div> 
            <div class="control-group">
                <label class="control-label" for="txtTelefono">Tel&eacute;fono</label>
                <div class="controls">
                    <input id="txtTelefono" name="telefono" placeholder="Tel&eacute;fono" type="text" class="span3" tabindex="7" disabled="disabled">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="txtCorreo">Correo</label>
                <div class="controls">
                    <input id="txtCorreo" name="correo" placeholder="Correo" type="text" class="span5" tabindex="8" disabled="disabled">
                </div>
            </div> 
            <div class="control-group">
                <label class="control-label" for="txtContacto">Contacto</label>
                <div class="controls">
                    <input id="txtContacto" name="contacto" placeholder="Contacto" type="text" class="span5" tabindex="9" disabled="disabled">
                </div>
            </div> 
            <br />
            <div class="form-actions">
            <button type="submit" id="btnGrabar" class="btn btn-primary" disabled="disabled" tabindex="10">Grabar</button>
            <button type="button" class="btn" onclick="history.back();">Cancelar</button>
            <input type="hidden" name="urlReturn" id="urlReturn" value="http://localhost/3jml/index.php?controlador=cliente" />
            </div>
        </form>
	</div>
</div>
<?php
  //Assign all Page Specific variables
  $content = ob_get_contents();
  ob_end_clean();
  ob_start();
?>

<script>
$('#txtRuc').numeric(false);

$('#txtRuc').keypress(function(e) {
	validarBotonKeypress('#txtRuc', '#btnValidarEstadoCliente', e);
});

$('#btnValidarEstadoCliente').click(function () {
	var btn = $(this);
	btn.button('loading');
	clearDivResult();
   	clearCampos();
    desactivarCampos();
	setTimeout(function () {		
		getEstadoCliente('#txtRuc');		
	}, 2000);
})
</script>

<?php
  $acciones = ob_get_contents();
  ob_end_clean();
  $pagetitle = "Inicio";
  //Apply the template
  include("masterpage.php");
?>