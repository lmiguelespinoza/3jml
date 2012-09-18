package com.inforcorp.consultaestado.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infocorp.consultaestado.service.EstadoService;

public class EstadoServiceTest {

	
	private EstadoService estadoService = null;
	
	public EstadoServiceTest()
	{
		ApplicationContext context = 
				 new ClassPathXmlApplicationContext("/applicationContext.xml");
		this.estadoService = (EstadoService) context.getBean("estadoServiceClient");
	}

	@Test
	public void testconsultaRuc()
    {
		System.out.println("inicio test");	
		System.out.println(".");	
		String pDat="";
		String pEst="";
		String cTip="";
		cTip="RUC: ";
		pDat="123";
		pEst=estadoService.consultaRuc(pDat);		
		System.out.println(cTip+' '+pDat+' '+pEst);
		pDat="12345678901";
		pEst=estadoService.consultaRuc(pDat);		
		System.out.println(cTip+' '+pDat+' '+pEst);

		cTip="DNI: ";
		pDat="1234";
		pEst=estadoService.consultaDNI(pDat);		
		System.out.println(cTip+' '+pDat+' '+pEst);
		
		pDat="12345678901";
		pEst=estadoService.consultaDNI(pDat);		
		System.out.println(cTip+' '+pDat+' '+pEst);
		
		cTip="Razon Social: ";
		pDat="UNICO";
		pEst=estadoService.consultaRazonSocial(pDat);		
		System.out.println(cTip+' '+pDat+' '+pEst);
		pDat="UPC";
		pEst=estadoService.consultaRazonSocial(pDat);		
		System.out.println(cTip+' '+pDat+' '+pEst);

		cTip="Nombre: ";
		pDat="UNICO";
		pEst=estadoService.consultaNombrePersona(pDat);		
		System.out.println(cTip+' '+pDat+' '+pEst);
		pDat="UPC";
		pEst=estadoService.consultaNombrePersona(pDat);		
		System.out.println(cTip+' '+pDat+' '+pEst);
		
		
		estadoService.insertarCliente("1", "2", "3", "4", "5", "6", "7");
		
		
		
		System.out.println("..");	
		System.out.println("fin test");	
		
    }
	
	
}
