package ref;


public class MethodReferenceTeste {
	
	interface Sayable{  
	    void say();  
	}
	
	interface Messageable{  
	    Message getMessage(String msg);  
	}
	
	public static class Message{  
	    Message(String msg){  
	        System.out.print(msg);  
	    }  
	} 

	public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }
	
	public void saySomething2(){  
        System.out.println("Hello, this is non-static method.");  
    }  
	
	private void makeItSay() {
		 // Referring non-static method using this
        Sayable sayable4 = this::saySomething2; 
        
        // Calling interface method  
        sayable4.say();
	}
	
    public static void main(String[] args) {  
        // Referring static method  
        Sayable sayable = MethodReferenceTeste::saySomething;  
        
        // Calling interface method  
        sayable.say();
        
        
        
        MethodReferenceTeste methodReference = new MethodReferenceTeste();

        // Referring non-static method using reference  
        Sayable sayable2 = methodReference::saySomething2;  
        
        // Calling interface method  
        sayable2.say();  
        
        // Referring non-static method using anonymous object  
        Sayable sayable3 = new MethodReferenceTeste()::saySomething2; // You can use anonymous object also  
        
        // Calling interface method  
        sayable3.say();
        
        // Using this
        methodReference.makeItSay();
        
        // Constructor
        Messageable hello = MethodReferenceTeste.Message::new;  
        hello.getMessage("Hello");
    }
	
}