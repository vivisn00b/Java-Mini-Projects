package smartlibrary.model;

public class StudentUser extends User {
    private final String userType = "Student";

    public StudentUser(String id, String name, String email, String phoneNumber, String address, String membershipStatus, String password, int maxBooksAllowed) {
        super(id, name, email, phoneNumber, address, membershipStatus, password, maxBooksAllowed);
    }

    @Override
    public double calculateFine(Loan loan) {
        // Fine rule for students: ₹4 per day overdue
        long overdueDays = loan.getOverdueDays();
        return overdueDays > 0 ? overdueDays * 4.0 : 0.0;
    }

    @Override
    public double payFine(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid fine payment amount.");
            return finesDue;
        }

        if (amount > finesDue) {
            System.out.println("💰 Student " + name + " overpaid. Returning change of " + (amount - finesDue));
            finesDue = 0.0;
        } else {
            finesDue -= amount;
        }

        return finesDue;
    }

    @Override
    public void showUserDetails() {
        System.out.println("====== Student User Details ======");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Membership: " + membershipStatus);
        System.out.println("Fines Due: " + finesDue);
        System.out.println("Max Books Allowed: " + maxBooksAllowed);
        System.out.println("Borrowed Books: " + borrowedBooks.size());
    }

    public String getUserType() {
        return userType;
    }
}
