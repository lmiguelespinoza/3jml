//FUNCIONES DE LA APPWEB
function getEstadoCliente(input, div){
    var ruc = $(input).val();
	if(ruc != '') {
		$.ajax({
			type: 'GET',
			url: 'index.php?controlador=services&accion=validaRucClienteSoap&ruc=' + ruc,
			dataType: 'json',
			success:function(response){
				$(div).removeClass('hidden');
				$(div).html('<span class="label label-'+ response.clase +'">' + response.estado + '</span>');
				if(response.estado == 'Activo') {
					activarCampos();
				}
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

function clearDivResult() {
	$('#resultEstadoCliente').html('');	
}
