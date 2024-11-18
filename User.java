public class User {
    // Attributes
    private String userID;
    private String name;
    private String email;
    private String password;
    private String role;
    private String status;
    private int failedAttempts;

    // Constructor
    public User(String userID, String name, String email, String password, String role) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = "Active";
        this.failedAttempts = 0;
    }

    // Getters and Setters
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getFailedAttempts() { return failedAttempts; }
    public void setFailedAttempts(int failedAttempts) { this.failedAttempts = failedAttempts; }

    // Methods
    public boolean register() {
        // Implementation for registration
        return false;
    }

    public boolean login() {
        // Implementation for login
        return false;
    }

    public void logout() {
        // Implementation for logout
    }
}
