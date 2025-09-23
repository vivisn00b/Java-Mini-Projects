package smartlibrary.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
    @SuppressWarnings("FieldMayBeFinal")
    private String loanId;
    @SuppressWarnings("FieldMayBeFinal")
    private String bookId;
    @SuppressWarnings("FieldMayBeFinal")
    private String userId;
    @SuppressWarnings("FieldMayBeFinal")
    private LocalDate issueDate;
    @SuppressWarnings("FieldMayBeFinal")
    private LocalDate dueDate;
    private LocalDate returnDate;

    public Loan(String loanId, String bookId, String userId, LocalDate issueDate, LocalDate dueDate) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = null; // not yet returned
    }

    // Mark the book as returned
    public void markReturned(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    // Check if the book is overdue
    public boolean isOverdue() {
        if (returnDate == null) {
            return LocalDate.now().isAfter(dueDate);
        }
        return returnDate.isAfter(dueDate);
    }

    // Calculate how many days overdue
    public long getOverdueDays() {
        LocalDate compareDate = (returnDate == null) ? LocalDate.now() : returnDate;
        if (compareDate.isAfter(dueDate)) {
            return ChronoUnit.DAYS.between(dueDate, compareDate);
        }
        return 0;
    }

    // Getters
    public String getLoanId() { return loanId; }
    public String getBookId() { return bookId; }
    public String getUserId() { return userId; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", overdueDays=" + getOverdueDays() +
                '}';
    }
}
