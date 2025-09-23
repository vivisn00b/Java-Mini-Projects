package smartlibrary;

import java.time.*;
import smartlibrary.model.*;

// Test class
public class Main {
    public static void main(String[] args) {
        StudentUser student = new StudentUser("S001", "Alice", "alice@mail.com", "9999999999", "Student Hostel", "Active", "pass123", 5);
        FacultyUser faculty = new FacultyUser("F001", "Dr. Bob", "bob@univ.edu", "8888888888", "Faculty Quarters", "Active", "secret");
        GuestUser guest = new GuestUser("G001", "Charlie", "charlie@gmail.com", "7777777777", "Guest House", "Active", "guestpass1234");

        // Create some loans
        Loan loan1 = new Loan("B101", "BOOK001", student.getId(), LocalDate.now().minusDays(10), LocalDate.now().minusDays(5)); // overdue by 5 days
        Loan loan2 = new Loan("B102", "BOOK002", faculty.getId(), LocalDate.now().minusDays(15), LocalDate.now().minusDays(10)); // overdue by 10 days
        Loan loan3 = new Loan("B103", "BOOK003", guest.getId(), LocalDate.now().minusDays(8), LocalDate.now().minusDays(3)); // overdue by 3 days

        // Borrow books
        student.borrowBook(loan1);
        faculty.borrowBook(loan2);
        guest.borrowBook(loan3);

        // Show details
        System.out.println("\n--- USER DETAILS ---");
        student.showUserDetails();
        faculty.showUserDetails();
        guest.showUserDetails();

        // Calculate fines
        System.out.println("\n--- FINE CALCULATION ---");
        System.out.println(student.getName() + " fine: " + student.calculateTotalFine());
        System.out.println(faculty.getName() + " fine: " + faculty.calculateTotalFine());
        System.out.println(guest.getName() + " fine: " + guest.calculateTotalFine());

        // Paying fines
        System.out.println("\n--- PAYING FINES ---");
        student.payFine(5.0);
        faculty.payFine(3.0);
        guest.payFine(10.0);

        // Return books
        System.out.println("\n--- RETURNING BOOKS ---");
        student.returnBook("B101");
        faculty.returnBook("B102");
        guest.returnBook("B103");
    }
}