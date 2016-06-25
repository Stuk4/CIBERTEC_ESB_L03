import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;


public class MyAction extends AbstractActionLifecycle{
	
	
	private ConfigTree configTree;
	
	private String find;
	private String replaceBy;
	
	/**
	 * 
	 * @param configTree config tree 
	 */
	public MyAction(ConfigTree configTree){
		String value;
		this.configTree = configTree;
		value = configTree.getAttribute("find");
		find = value ==  null ? "" :value; 
		
		value = configTree.getAttribute("replaceBy");
		replaceBy = value == null ? "":value;		
	}
	
	public void printLine() {		
		System.out.println("=====================");
	}
	
	public Message exec(Message message) {
		printLine();
		String msg = (String) message.getBody().get();
		msg = msg.replace(find, replaceBy);		
		System.out.println("Body:{" +msg+ "}");
		message.getBody().add(msg);
		System.out.println(msg);
		printLine();
		return message;
	}

}
