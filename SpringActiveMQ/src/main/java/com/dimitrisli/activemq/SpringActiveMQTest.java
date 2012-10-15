package com.dimitrisli.activemq;

import java.util.Collection;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import pe.j3ml.app.excepcion.DAOExcepcion;
import pe.j3ml.app.model.TPedido;
import pe.j3ml.app.negocio.PedidoNegocio;

public class SpringActiveMQTest {

	public static void main(String[] args) throws JMSException, DAOExcepcion {

		System.out.println("Iniciando...");
		
		PedidoNegocio pedido = new PedidoNegocio();
		
		
		Collection<TPedido> tpedido = pedido.listar();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/jms/jms-context.xml");

		JmsTemplate template = (JmsTemplate) context.getBean("jmsTemplate");
		ActiveMQDestination destination = (ActiveMQDestination) context.getBean("destination");

		
		String message;
		for (TPedido reg : tpedido) {
			message = "<RazonSocial=" + reg.getCliRazonSocial() +">";
			message+= "<Direccion=" + reg.getCliDistrito() + ">";
			message+= "<CodigoPedido=" + reg.getPedCodigo() + ">";
			// sending a message
			template.convertAndSend(destination, message);
		}
/*
		template.convertAndSend(destination, "Hi");

		// receiving a message
		Object msg = template.receive(destination);
		if (msg instanceof TextMessage) {
			try {
				System.out.println(((TextMessage) msg).getText());
			} catch (JMSException e) {
				System.out.println(e);
			}
		}
*/
	}
}