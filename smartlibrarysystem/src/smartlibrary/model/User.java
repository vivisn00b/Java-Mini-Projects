package smartlibrary.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class User {
    protected String id;
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected String address;
    protected String membershipStatus; // Active, Inactive, Suspended
    protected String password; // For authentication
    protected double finesDue; // Total fines due
    protected int maxBooksAllowed; // Maximum books allowed to borrow
    protected List<Loan> borrowedBooks = new ArrayList<>();
    protected List<String> reservedBooks = new ArrayList<>();

    // Abstract methods → subclasses must implement
    public abstract double calculateFine(Loan loan);
    public abstract double payFine(double amount);
    public abstract void showUserDetails();

    public User(String id, String name, String email, String phoneNumber, String address,
                String membershipStatus, String password, int maxBooksAllowed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.membershipStatus = membershipStatus;
        this.password = password;
        this.maxBooksAllowed = maxBooksAllowed;
        this.finesDue = 0.0;
    }

    public boolean borrowBook(Loan loan) {
        if (borrowedBooks.size() < maxBooksAllowed) {
            borrowedBooks.add(loan);
            System.out.println("Book " + loan.getBookId() + " successfully borrowed by user " + id);
            return true;
        }
        System.out.println("User " + id + " has reached the maximum limit of borrowed books.");
        return false;
    }

    public boolean returnBook(String bookId) {
        Iterator<Loan> iterator = borrowedBooks.iterator();
        while (iterator.hasNext()) {
            Loan loan = iterator.next();
            if (loan.getBookId().equals(bookId)) {
                iterator.remove();
                System.out.println("Book " + bookId + " returned by user " + id);
                return true;
            }
        }
        System.out.println("Book " + bookId + " not found in borrowed list of user " + id);
        return false;
    }

    public void reserveBook(String bookId) {
        reservedBooks.add(bookId);
        System.out.println("Book " + bookId + " reserved by user " + id);
    }

    public void addFine(double amount) {
        finesDue += amount;
    }

    public double calculateTotalFine() {
        double total = 0.0;
        for (Loan loan : borrowedBooks) {
            total += calculateFine(loan); // subclass-specific fine rules
        }
        return total;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getFinesDue() { return finesDue; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", membershipStatus='" + membershipStatus + '\'' +
                ", finesDue=" + finesDue +
                '}';
    }
}
