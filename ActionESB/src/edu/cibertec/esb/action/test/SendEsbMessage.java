package edu.cibertec.esb.action.test;

import org.jboss.soa.esb.client.ServiceInvoker;
import org.jboss.soa.esb.message.Message;
import org.jboss.soa.esb.message.format.MessageFactory;

public class SendEsbMessage {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Message esbMessage;
		ServiceInvoker invoker;
		
		System.setProperty("javax.xml.registry.ConnectionFactoryClass",
				"org.apache.ws.scout.registry.ConnectionFactoryImpl");
		esbMessage = MessageFactory.getInstance().getMessage();
		esbMessage.getBody().add("Say Hello from Invoker");
		invoker = new ServiceInvoker("Chapter3Sample", "Chapter3Service");
		
		System.out.println("Invoker:" + invoker);
		invoker.deliverAsync(esbMessage);
	}
}
