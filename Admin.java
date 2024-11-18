import java.util.List;

public class Admin extends User {
    // Constructor
    public Admin(String userID, String name, String email, String password) {
        super(userID, name, email, password, "Admin");
    }

    // Methods
    public void manageUsers(String userID, String action) {
        // Implementation for managing users (e.g., lock/unlock account)
    }

    public List<Transaction> monitorTransactions() {
        // Implementation for monitoring transactions
        return null;
    }

    public Report generateReport(String startDate, String endDate) {
        // Implementation for generating a report
        return null;
    }

    public void configureSystem(String setting, Object value) {
        // Implementation for configuring the system
    }
}
