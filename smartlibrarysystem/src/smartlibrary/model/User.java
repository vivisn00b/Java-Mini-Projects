package smartlibrary.model;

import java.util.ArrayList;
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
    protected int booksCurrentlyBorrowed; // Number of books currently borrowed
    protected List<String> borrowedBooks = new ArrayList<>(); // List of borrowed book IDs
    protected List<String> reservedBooks = new ArrayList<>(); // List of reserved book IDs


    public abstract double payFine();
    public abstract void showUserDetails();

    public User(String id, String name, String email, String phoneNumber, String address, String membershipStatus, String password, double finesDue, int maxBooksAllowed, int booksCurrentlyBorrowed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.membershipStatus = membershipStatus;
        this.password = password;
        this.finesDue = finesDue;
        this.maxBooksAllowed = maxBooksAllowed;
        this.booksCurrentlyBorrowed = booksCurrentlyBorrowed;
    }

    public boolean borrowBook(String bookId) {
        if (booksCurrentlyBorrowed < maxBooksAllowed) {
            borrowedBooks.add(bookId);
            booksCurrentlyBorrowed++;
            System.out.println("Book " + bookId + " successfully borrowed by user " + id);
            return true;
        }
        System.out.println("User " + id + " has reached the maximum limit of borrowed books.");
        return false;
    }

    public boolean returnBook(String bookId) {
        if(borrowedBooks.remove(bookId)) {
            booksCurrentlyBorrowed--;
            System.out.println("Book " + bookId + " successfully returned by user " + id);
            return true;
        }
        System.out.println("Book " + bookId + " not found in borrowed list of user " + id);
        return false;
    }

    public void reserveBook(String bookId) {
        reservedBooks.add(bookId);
        System.out.println("Book " + bookId + " reserved by user " + id);
    }

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