import java.util.Date;

public class Transaction {
    // Attributes
    private String transactionID;
    private String bookID;
    private String buyerID;
    private String sellerID;
    private double transactionAmount;
    private Date transactionDate;

    // Constructor
    public Transaction(String transactionID, String bookID, String buyerID, String sellerID, double transactionAmount, Date transactionDate) {
        this.transactionID = transactionID;
        this.bookID = bookID;
        this.buyerID = buyerID;
        this.sellerID = sellerID;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    // Getters and Setters
    public String getTransactionID() { return transactionID; }
    public void setTransactionID(String transactionID) { this.transactionID = transactionID; }

    public String getBookID() { return bookID; }
    public void setBookID(String bookID) { this.bookID = bookID; }

    public String getBuyerID() { return buyerID; }
    public void setBuyerID(String buyerID) { this.buyerID = buyerID; }

    public String getSellerID() { return sellerID; }
    public void setSellerID(String sellerID) { this.sellerID = sellerID; }

    public double getTransactionAmount() { return transactionAmount; }
    public void setTransactionAmount(double transactionAmount) { this.transactionAmount = transactionAmount; }

    public Date getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Date transactionDate) { this.transactionDate = transactionDate; }

    // Methods
    public boolean processTransaction() {
        // Implementation for processing the transaction
        return false;
    }

    public String getTransactionDetails() {
        // Implementation for getting transaction details
        return "";
    }

    public boolean refundTransaction() {
        // Implementation for refunding the transaction
        return false;
    }
}
