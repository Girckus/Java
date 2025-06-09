public class NewSwitch {
	
	enum Event {PLAY, STOP};

	public static void main(String[] args) {
		demonstrateTraditionalSwitchStatement();
		demonstrateEnhancedSwitchStatement();
		demonstrateSwitchExpressionWithArrows();
		demonstrateBlockedStatementsWithSharedCases();
		demonstrateSwitchExpressionWithYield(Event.PLAY);
		demonstrateSwitchExpressionWithYieldNotCompile(Event.PLAY);
	}

	public static void demonstrateTraditionalSwitchStatement()  
	{  
	   System.out.println("Traditional Switch Statement:");  
	   final int integer = 3;  
	   String numericString;  
	   switch (integer)  
	   {  
		  case 1 :  
			 numericString = "one";  
			 break;  
		  case 2 :  
			 numericString = "two";  
			 break;  
		  case 3:  
			 numericString = "three";  
			 break;  
		  default:  
			 numericString = "N/A";  
	   }  
	   System.out.println("\t" + integer + " ==> " + numericString);  
	}
	
	public static void demonstrateEnhancedSwitchStatement()  
	{  
	   System.out.println("Enhanced Switch Statement:");  
	   final int integer = 2;  
	   String numericString;  
	   switch (integer)  
	   {  
		  case 1 -> numericString = "one";  
		  case 2 -> numericString = "two";  
		  case 3 -> numericString = "three";  
		  default -> numericString = "N/A";  
	   }  
	   System.out.println("\t" + integer + " ==> " + numericString);  
	}
	
	public static void demonstrateSwitchExpressionWithArrows()  
	{  
	   final int integer = 4;  
	   System.out.println("Switch Expression with Arrows:");  
	   final String numericString =  
		  switch (integer)  
		  {  
			 case 1 -> "uno";  
			 case 2 -> "dos";  
			 case 3 -> "tres";  
			 case 4 -> "quatro";  
			 default -> "N/A";  
		  };  
	   System.out.println("\t" + integer + " ==> " + numericString);  
	}
	
	public static void demonstrateLabelRulesWithSharedCases()  
	{  
	   final int integer = 7;  
	   System.out.println("Multiple Case Labels:");  
	   final String numericString =  
		  switch (integer)  
		  {  
			 case 0 -> "zero";  
			 case 1, 3, 5, 7, 9 -> "odd";  
			 case 2, 4, 6, 8, 10 -> "even";  
			 default -> "N/A";  
		  };  
	   System.out.println("\t" + integer + " ==> " + numericString);  
	}
	
	public static void demonstrateBlockedStatementsWithSharedCases()
	{  
	   final int integer = 6;  
	   System.out.println("Multiple Case Labels:");  
	   String numericString;  
	   switch (integer)  
	   {  
		  case 0:  
			 numericString = "zero";  
			 break;  
		  case 1, 3, 5, 7, 9:  
			 numericString = "odd";  
			 break;  
		  case 2, 4, 6, 8, 10:  
			 numericString = "even";  
			 break;  
		  default:  
			 numericString = "N/A";  
	   };  
	   System.out.println("\t" + integer + " ==> " + numericString);  
	}

	public static void demonstrateSwitchExpressionWithYield(Event event)  
	{  
		System.out.println("Switch Expression with Yield:");  
		var log = switch (event) {
			case PLAY -> "User has triggered the play button";
			case STOP -> "User needs a break";
			default -> {
				String message = event.toString();
				LocalDateTime now = LocalDateTime.now();
				yield "Unknown event " + message + " logged on " + now;
			}
		};
		System.out.println("\t" + log);  
	}
	
	public static void demonstrateSwitchExpressionWithYieldNotCompile(Event event)  
	{  
		System.out.println("Switch Expression with Yield:");  
		var log = switch (event) {
			case PLAY -> "User has triggered the play button";
			//case STOP -> "User needs a break";
			default -> {
				String message = event.toString();
				LocalDateTime now = LocalDateTime.now();
				yield "Unknown event " + message + " logged on " + now;
			}
		};
		System.out.println("\t" + log);  
	}

}