package pcka;

public class AccessModifiers {
	
	private String privateModifier = "private";
	String defaultModifier = "default";
	protected String protectedModifier = "protected";
	public String publicModifier = "public";
	
	public static void main(String[] args) {
		AccessModifiers accessModifiers = new AccessModifiers();
		
		System.out.println(accessModifiers.privateModifier);
		System.out.println(accessModifiers.defaultModifier);
		System.out.println(accessModifiers.protectedModifier);
		System.out.println(accessModifiers.publicModifier);
	}
	
}

