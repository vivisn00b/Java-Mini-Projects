package smartlibrary.model;

public class GuestUser extends User {
    private final String userType = "Faculty";

    public GuestUser(String id, String name, String email, String phoneNumber, String address, String membershipStatus, String password) {
        super(id, name, email, phoneNumber, address, membershipStatus, password, 3);
    }

    @Override
    public double calculateFine(Loan loan) {
        // Fine rule for guest users: ₹8 per day overdue
        if (loan.isOverdue()){
            double fine = loan.getOverdueDays() * 8.0;
            addFine(fine);
            return fine;
        }
        return 0.0;
    }

    @Override
    public double payFine(double amount) {
        if (amount > finesDue) {
            System.out.println("Overpaid. Returning extra: " + (amount - finesDue));
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
        System.out.println("Membership Status: " + membershipStatus);
        System.out.println("Fines Due: ₹" + finesDue);
        System.out.println("Max Books Allowed: " + maxBooksAllowed);
        System.out.println("Borrowed Books: " + borrowedBooks.size());
    }

    public String getUserType () {
        return userType;
    }
}
