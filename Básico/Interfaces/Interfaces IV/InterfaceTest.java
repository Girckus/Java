interface DBLogging{
    String MONGO_DB_NAME = "ABC_Mongo_Datastore";
    String NEO4J_DB_NAME = "ABC_Neo4J_Datastore";
    String CASSANDRA_DB_NAME = "ABC_Cassandra_Datastore";
	
	enum Level {WARN_LEVEL, ERROR_LEVEL, FATAL_LEVEL};

    // abstract method example
    void logInfo(String message);

    // default method example
    default void logWarn(String message){
    	print(messsage, Level.WARN_LEVEL);
    }
    
	default void logError(String message){
		print(messsage, Level.ERROR_LEVEL);
    }
    
	default void logFatal(String message){
		print(messsage, Level.FATAL_LEVEL);
    }
    
	// static method example
    static boolean isNull(String str) {
    	System.out.println("Interface Null Check");
    	return str == null ? true : "".equals(str) ? true : false;
    }
	
	// private method example
	private void print(String message, Level level) {
		System.out.println(message);
        System.out.println("Step 1: Connect to DataStore");
        switch(level) {
			case WARN_LEVEL -> System.out.println("Step 2: Log Warn Message");
			case ERROR_LEVEL -> System.out.println("Step 2: Log Error Message");
			case FATAL_LEVEL -> System.out.println("Step 2: Log fatal Message");
		}
        System.out.println("Step 3: Close the DataStore connection");
	}
}

public class InterfaceTest implements DBLogging {

	@Override
	public void logInfo(String message) {
		if(DBLogging.isNull(message)) {
			logError("Null");
		}
		else {
			logWarn(message);
			logFatal(message);
		}
		
	}

	public static void main(String args[]) {
		InterfaceTest it = new InterfaceTest();
		
		it.logInfo(null);
		it.logInfo(DBLogging.CASSANDRA_DB_NAME);
	}
	
}
