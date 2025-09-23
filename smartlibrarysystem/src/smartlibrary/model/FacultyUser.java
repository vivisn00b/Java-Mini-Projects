package smartlibrary.model;

public class FacultyUser extends User {
    private final String userType = "Faculty";

    public FacultyUser(String id, String name, String email, String phoneNumber, String address, String membershipStatus, String password) {
        super(id, name, email, phoneNumber, address, membershipStatus, password, 10);
    }

    @Override
    public double calculateFine(Loan loan) {
        // Fine rule for faculties: ₹1 per day overdue
        if(loan.isOverdue()) {
            double fine = loan.getOverdueDays() * 1.0;
            addFine(fine);
            return fine;
        }
        return 0.0;
    }

    @Override
    public double payFine(double amount) {
        if(amount > finesDue) {
            System.out.println("OVERPAID! Returning extra: " + (amount - finesDue));
            finesDue = 0.0;
        } else {
            finesDue -= amount;
        }
        return finesDue;
    }

    @Override
    public void showUserDetails() {
        System.out.println("====== Faculty User Details ======");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Membership Status: " + membershipStatus);
        System.out.println("Max Books Allowed: " + maxBooksAllowed);
        System.out.println("Borrowed Books: " + borrowedBooks.size());
        System.out.println("Current Fines: " + finesDue);
    }

    public String getUserType() {
        return userType;
    }
}