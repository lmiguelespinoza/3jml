package com.sunat.consultaestado.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunat.consultaestado.service.EstadoService;

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
		pDat="123";
		pEst=estadoService.consultaRuc(pDat);		
		System.out.println(pDat+' '+pEst);
		pDat="12345678901";
		pEst=estadoService.consultaRuc(pDat);		
		System.out.println(pDat+' '+pEst);
		pDat="UNICO";
		pEst=estadoService.consultaRazonSocial(pDat);		
		System.out.println(pDat+' '+pEst);
		pDat="UPC";
		pEst=estadoService.consultaRazonSocial(pDat);		
		System.out.println(pDat+' '+pEst);		
		System.out.println("..");	
		System.out.println("fin test");	
		
    }
	
	
}
