import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

// Placeholder classes for Book and Transaction
class Book {
    String bookID;
    String title;
    String description;
    double price;
    String category;
    String condition;
    Image image;

    public Book(String bookID, String title, String description, double price, String category, String condition, Image image) {
        this.bookID = bookID;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.condition = condition;
        this.image = image;
    }

    @Override
    public String toString() {
        return title + " - $" + price;
    }
}

class Transaction {
    String bookID;
    String transactionID;
    String date;

    public Transaction(String bookID, String transactionID, String date) {
        this.bookID = bookID;
        this.transactionID = transactionID;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionID + ", Book ID: " + bookID + ", Date: " + date;
    }
}

// Abstract User class
abstract class User {
    String userID;
    String name;
    String email;
    String password;
    String userType;

    public User(String userID, String name, String email, String password, String userType) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
}

// Buyer class with original structure
public class Buyer extends User {
    private boolean isLoggedIn = false;
    private List<Book> cart = new ArrayList<>();
    private List<Transaction> purchaseHistory = new ArrayList<>();

    public Buyer(String userID, String name, String email, String password) {
        super(userID, name, email, password, "Buyer");
    }

    public List<Book> browseBooks(String category) {
        // Example book listings with images for each category
        List<Book> books = new ArrayList<>();
        books.add(new Book("1", "Quantum Physics", "An introductory book on Quantum Physics.", 29.99, "Natural Science Books", "Used-Like New", new Image("path/to/image1.jpg")));
        books.add(new Book("2", "Java Programming", "Learn Java programming from basics to advanced.", 45.50, "Computer Books", "Used-Moderately Used", new Image("path/to/image2.jpg")));
        return books;
    }

    public void addToCart(Book book) {
        cart.add(book);
    }

    public List<Book> getCart() {
        return cart;
    }

    public boolean purchaseBook() {
        for (Book book : cart) {
            purchaseHistory.add(new Transaction(book.bookID, "TXN" + book.bookID, "2024-11-06"));
        }
        cart.clear();
        return true;
    }

    public List<Transaction> viewPurchaseHistory() {
        return purchaseHistory;
    }

    public boolean login(String email, String password) {
        isLoggedIn = this.email.equals(email) && this.password.equals(password);
        return isLoggedIn;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public static void main(String[] args) {
        Application.launch(BuyerApp.class, args);
    }
}

// JavaFX Application class for Buyer
class BuyerApp extends Application {
    private Buyer buyer = new Buyer("001", "John Doe", "buyer@example.com", "password");
    private ListView<HBox> bookListView = new ListView<>();
    private ListView<HBox> cartListView = new ListView<>();
    private Label loginStatusLabel = new Label("Status: Not logged in");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Buyer Bookstore");

        // Main layout
        BorderPane mainLayout = new BorderPane();
        Scene scene = new Scene(mainLayout, 600, 800);

        // Login Section
        VBox loginSection = new VBox(10);
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");
        Label loginMessage = new Label();

        loginButton.setOnAction(e -> {
            boolean success = buyer.login(emailField.getText(), passwordField.getText());
            if (success) {
                loginMessage.setText("Login successful!");
                loginStatusLabel.setText("Status: Logged in");
            } else {
                loginMessage.setText("Invalid login!");
            }
        });

        loginSection.getChildren().addAll(loginStatusLabel, emailField, passwordField, loginButton, loginMessage);

        // Browse Books Section with book images, title, description, and price
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("Natural Science Books", "Computer Books");
        categoryComboBox.setPromptText("Select Category");

        Button browseButton = new Button("Browse Books");
        browseButton.setOnAction(e -> {
            String selectedCategory = categoryComboBox.getValue();
            List<Book> books = buyer.browseBooks(selectedCategory);
            bookListView.getItems().clear();

            for (Book book : books) {
                HBox bookItem = new HBox(10);
                ImageView imageView = new ImageView(book.image);
                imageView.setFitHeight(100);
                imageView.setFitWidth(80);
                VBox bookDetails = new VBox();
                bookDetails.getChildren().addAll(new Label(book.title), new Label(book.description), new Label("Price: $" + book.price));
                Button addButton = new Button("Add to Cart");
                addButton.setOnAction(event -> {
                    buyer.addToCart(book);
                    addButton.setText("Added!");
                });
                bookItem.getChildren().addAll(imageView, bookDetails, addButton);
                bookListView.getItems().add(bookItem);
            }
        });

        VBox browseSection = new VBox(10, categoryComboBox, browseButton, bookListView);

        // Shopping Cart Section
        Button cartButton = new Button("🛒");
        cartButton.setOnAction(e -> openCartWindow());

        // Set up main layout
        mainLayout.setTop(loginSection);
        mainLayout.setCenter(browseSection);
        mainLayout.setRight(cartButton);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openCartWindow() {
        Stage cartStage = new Stage();
        cartStage.setTitle("Shopping Cart");

        VBox cartLayout = new VBox(10);
        cartLayout.setPadding(new Insets(10));

        for (Book book : buyer.getCart()) {
            HBox cartItem = new HBox(10);
            cartItem.getChildren().addAll(new Label(book.title), new Label("$" + book.price));
            Button removeButton = new Button("Remove");
            removeButton.setOnAction(e -> {
                buyer.getCart().remove(book);
                cartListView.getItems().remove(cartItem);
            });
            cartItem.getChildren().add(removeButton);
            cartListView.getItems().add(cartItem);
        }

        Button checkoutButton = new Button("Check Out");
        checkoutButton.setOnAction(e -> openCheckoutWindow());

        cartLayout.getChildren().addAll(new Label("Your Cart:"), cartListView, checkoutButton);
        Scene cartScene = new Scene(cartLayout, 300, 400);
        cartStage.setScene(cartScene);
        cartStage.show();
    }

    private void openCheckoutWindow() {
        Stage checkoutStage = new Stage();
        checkoutStage.setTitle("Checkout");

        VBox checkoutLayout = new VBox(10);
        checkoutLayout.setPadding(new Insets(10));

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        TextField cardField = new TextField();
        cardField.setPromptText("Card Number");
        TextField addressField = new TextField();
        addressField.setPromptText("Address");

        Button makePurchaseButton = new Button("Make Purchase");
        makePurchaseButton.setOnAction(e -> {
            buyer.purchaseBook();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Purchase completed! Thank you for your order.");
            alert.showAndWait();
            checkoutStage.close();
        });

        checkoutLayout.getChildren().addAll(
            new Label("Checkout"), emailField, cardField, addressField, makePurchaseButton
        );

        Scene checkoutScene = new Scene(checkoutLayout, 300, 300);
        checkoutStage.setScene(checkoutScene);
        checkoutStage.show();
    }
}
