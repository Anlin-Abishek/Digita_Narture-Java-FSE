import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionPool {

    private List<String> availableConnections;

    private DatabaseConnectionPool() {
        System.out.println("Initializing Database Connection Pool...");
        availableConnections = new ArrayList<>();
        availableConnections.add("Connection_1");
        availableConnections.add("Connection_2");
        availableConnections.add("Connection_3");
    }

    private static class Holder {
        private static final DatabaseConnectionPool INSTANCE = new DatabaseConnectionPool();
    }

    public static DatabaseConnectionPool getInstance() {
        return Holder.INSTANCE;
    }
    
     public String getConnection() {
        if (availableConnections.isEmpty()) {
            return "No connections available!";
        }
        return availableConnections.remove(0);
    }

    public void releaseConnection(String connection) {
        availableConnections.add(connection);
        System.out.println(connection + " released back to the pool.");
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("--- Requesting Pool Instance 1 ---");
        DatabaseConnectionPool pool1 = DatabaseConnectionPool.getInstance();
        
        String myConn = pool1.getConnection();
        System.out.println("Borrowed: " + myConn);

        System.out.println("\n--- Requesting Pool Instance 2 ---");
        DatabaseConnectionPool pool2 = DatabaseConnectionPool.getInstance();
        
        if (pool1 == pool2) {
            System.out.println("SUCCESS: Both variables point to the identical instance.");
        } else {
            System.out.println("FAILURE: Different instances exist.");
        }

        pool2.releaseConnection(myConn);
    }
}
