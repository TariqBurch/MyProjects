package communication;

import java.io.Serializable;

public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean success;
	private String errorMessage;
	private Object data;
	
	
	
	Response(){
		
		success=true;
		errorMessage="";
		data=null;
		
	}
	
	public Response(boolean success) {
		this.success = success;
		errorMessage = "";
		data = null;
	}

	public Response(Object data) {
		success = true;
		errorMessage = "";
		this.data = data;
	}

	public Response(boolean success, String errorMessage, Object data) {

		this.success = success;
		this.errorMessage = errorMessage;
		this.data = data;
	}
	
	public boolean isSuccess() {
		return success;
	}

	
	
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	
	@Override
	public String toString() {
		return "Response [success=" + success + ", errorMessage=" + errorMessage + ", data=" + data + "]";
	}
	
	
	

}
