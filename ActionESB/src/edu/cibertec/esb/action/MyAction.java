package edu.cibertec.esb.action;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

/**
 * AbstractActionLifecycle -> adaptador, sobreescribe los metodos (process)
 * 
 * @author Java-VS
 *
 */
public class MyAction extends AbstractActionLifecycle{
	
	private ConfigTree configTree;
	private String symbol;
	private int count;
	private static final String DEFAULT_SYMBOL = "&";
	private static final int DEFAULT_COUNT = 20;
	
	/**
	 * 
	 * @param configTree config tree 
	 */
	public MyAction(ConfigTree configTree){
		String value;
		this.configTree = configTree;
		value = configTree.getAttribute("symbol");
		symbol = value ==  null ? DEFAULT_SYMBOL :value; 
		
		value = configTree.getAttribute("count");
		count = value == null ? DEFAULT_COUNT:Integer.parseInt(value);		
	}
	
	public void printLine() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(symbol);			
		}
		System.out.println(sb);
	}
	
	public Message printMessage(Message message) {
		printLine();
		String msg = (String) message.getBody().get();
		message.getBody().remove("qwerty");
		System.out.println("Body:{" +msg+ "}");
		message.getBody().add("Modificado: "+msg);
		printLine();
		return message;
	}

}
