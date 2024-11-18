public class Book {
    // Attributes
    private String bookID;
    private String title;
    private String author;
    private String category;
    private String condition;
    private double price;

    // Constructor
    public Book(String bookID, String title, String author, String category, String condition, double price) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.condition = condition;
        this.price = price;
    }

    // Getters and Setters
    public String getBookID() { return bookID; }
    public void setBookID(String bookID) { this.bookID = bookID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Methods
    public String getDetails() {
        // Implementation for getting book details
        return "";
    }

    public void updateCondition(String condition) {
        // Implementation for updating the book's condition
    }

    public void updatePrice(double newPrice) {
        // Implementation for updating the book's price
    }
}
