package jfs.backend.execption;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String msg) {
		
		super(msg);
	//	System.out.println(msg);
		
	}
	
	public ResourceNotFoundException(String msg, Throwable cause) {
		
		super(msg,cause);
	}
	
}
