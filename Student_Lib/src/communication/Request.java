package communication;

import java.io.Serializable;

public class Request implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String action;
	private Object object;
	
	public Request() {
		
		this.action="";
		this.object=null;
		
	}
	
	public Request(String action) {
		
		this.action=action;
		object = null;
		
	}
	
	public Request(String action , Object object) {
		
		this.action=action;
		this.object=object;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "Request [action=" + action + ", object=" + object + "]";
	}
	
	
	
	
	
	

}
