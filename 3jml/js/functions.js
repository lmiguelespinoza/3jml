//FUNCIONES DE LA APPWEB
$(document).ready(function() {
	$('#alertMsg').fadeOut(8000);
});

function getEstadoCliente(input){
    var ruc = $(input).val();
	if(ruc != '') {
		$.ajax({
			type: 'GET',
			url: 'index.php?controlador=services&accion=validaRucSunat&ruc=' + ruc,
			dataType: 'json',
			success:function(response){
				if(response.estado == 1) {
					$('#alertMsg1').removeClass('hidden').addClass('alert-success');					
					$('#txtRazonSocial').val(response.razonSocial);
					$('#txtDireccion').val(response.direccion);
					$('#cboDistrito').val(response.distrito);	
					activarCampos();
				} else {
					$('#alertMsg1').removeClass('hidden').addClass('alert-error');
				}
				if(response.infocorp != '') $('#alertMsg2').removeClass('hidden').html(response.infocorp);
				$('#btnValidarEstadoCliente').html('Verificar estado');
				$('#alertMsg1').html(response.msj);
			}
		});
	}
    return false;
}

function validarBotonKeypress(obj, btn, e) {
	var size = $(obj).val().length;
	switch (e.keyCode) {
	  case 8:
		  activarDesactivarBoton(btn, 0);
		  clearDivResult();
		  clearCampos();
		  desactivarCampos();
		  break;
	  default:	  	
		if(size == 10 || size == 11) {
			activarDesactivarBoton(btn, 1);
		} else {
			activarDesactivarBoton(btn, 0);
		}
	}
}

function activarDesactivarBoton(btn, estado) {
	if(estado == 1) {
		$(btn).removeClass('disabled');
		$(btn).removeAttr('disabled');
	}
	if(estado == 0) {
		$(btn).addClass('disabled');
		$(btn).attr('disabled','disabled');
	}
}

function activarCampos() {
	$('#txtRazonSocial').removeAttr('disabled');
	$('#txtDireccion').removeAttr('disabled');
	$('#cboDistrito').removeAttr('disabled');
	$('#txtTelefono').removeAttr('disabled');
	$('#txtCorreo').removeAttr('disabled');
	$('#txtContacto').removeAttr('disabled');
	$('#btnGrabar').removeAttr('disabled');
}

function desactivarCampos() {
	$('#txtRazonSocial').attr('disabled','disabled');
	$('#txtDireccion').attr('disabled','disabled');
	$('#cboDistrito').attr('disabled','disabled');
	$('#txtTelefono').attr('disabled','disabled');
	$('#txtCorreo').attr('disabled','disabled');
	$('#txtContacto').attr('disabled','disabled');
	$('#btnGrabar').attr('disabled','disabled');
}

function clearCampos() {
	$('#txtRazonSocial').val('');
	$('#txtDireccion').val('');
	$('#cboDistrito').val('');
	$('#txtTelefono').val('');
	$('#txtCorreo').val('');
	$('#txtContacto').val('');
}

function clearDivResult() {
	$('#alertMsg1').html('');
	$('#alertMsg1').removeClass().addClass('alert hidden');
	$('#alertMsg2').html('');
	$('#alertMsg2').removeClass().addClass('alert hidden');
}
