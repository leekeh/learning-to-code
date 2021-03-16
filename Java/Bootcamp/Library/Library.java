import java.util.ArrayList;


public class Library {
    String address;
    ArrayList <Book> inventory;
    // Add the missing implementation to this class
    public Library(String location) {
        address = location;
        inventory = new ArrayList<Book>();
    }
    
    public void addBook (Book book) {
        inventory.add(book);
    }
    
    public void printAvailableBooks() {
        if (inventory.isEmpty()) {
            System.out.println("There are no books available.");
        }
        for (Book book : inventory) {
            if (!book.isBorrowed()) {
                System.out.println(book.getTitle());
            }
        }
    }
    
    public void borrowBook(String title) {
        if (findAndBorrow(title)) {
            System.out.println(title + " was succesfully checked out.");
        }
    }
    
    public boolean findAndBorrow(String title) {
        int lent = 0;
        if (inventory.isEmpty()) {
            System.out.println("There are no books available in this library.");
            return false;
        }
        for (Book book : inventory) {
            if (title.equals(book.getTitle())) {
                if (!book.isBorrowed()) {
                    book.registerBorrow();
                    return true;
                } else {
                    lent++;
                }
            }
        }
        if (lent==0) {
            System.out.println("Sorry, this book is not in our catalog.");
        } else {
            System.out.println("Sorry, all copies of this book have been lent out.");
        }
        return false;
    }
    
    public void returnBook(String title) {
        if (findAndReturn(title)) {
            System.out.println(title + " was succesfully returned.");
        }
    }
    
    public boolean findAndReturn(String title) {
        if (inventory.isEmpty()) {
            System.out.println("There are no books available in this library.");
            return false;
        }        
        int unlent = 0;
        for (Book book : inventory) {
            if (title.equals(book.getTitle())) {
                if (book.isBorrowed()) {
                    book.registerReturn();
                    return true;
                } else {
                    unlent++;
                }
            }
        }
        if (unlent==0) {
            System.out.println("Sorry, this book is not in our catalog.");
        } else {
            System.out.println("Sorry, this book was not lent out.");
        }
        return false;
    }
    
    public void printAddress() {
        System.out.println(address);
    }
    
    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }
    
    public static void main(String[] args) {
      //this is testing code
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours(); //not sure if this was the goal
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 
