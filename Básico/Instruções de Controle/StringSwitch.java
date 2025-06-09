package java7;

public class StringSwitch {

	public static void main(String [] args)
	{

		boolean help = false;
		boolean log = false;
		boolean verbose = false;
		
		for (String argument : args) {
			
			switch(argument.toLowerCase()) {
				case "-h":
				case "-help": help = true; 
							  break;
				case "-log": log = true;
							 break;
				case "-v":
				case "-verbose": verbose = true;
								 break;
				default: System.out.println("Illegal command line argument");
			}
			
		}
		
		System.out.println("Application Settings");
		System.out.println("Verbose: " + verbose);
		System.out.println("Logging: " + log);
		System.out.println("Help: " + help);
		
	}
	
}