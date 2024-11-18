import java.util.List;

public class Seller extends User {
    // Constructor
    public Seller(String userID, String name, String email, String password) {
        super(userID, name, email, password, "Seller");
    }

    // Methods
    public void listBook(Book book) {
        // Implementation for listing a book
    }

    public void setBookPrice(String bookID, double price) {
        // Implementation for setting a book price
    }

    public List<Book> viewListedBooks() {
        // Implementation for viewing listed books
        return null;
    }

    public boolean removeBookListing(String bookID) {
        // Implementation for removing a book listing
        return false;
    }

    public List<Transaction> viewSalesHistory() {
        // Implementation for viewing sales history
        return null;
    }

    public void updateBookCondition(String bookID, String condition) {
        // Implementation for updating a book's condition
    }
}
