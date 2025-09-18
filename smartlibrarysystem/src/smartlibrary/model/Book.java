package smartlibrary.model;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private final String isbn;
    private boolean isAvailable;
    private int copiesAvailable;
    private final String genre;
    private final String publisher;
    private final int yearPublished;
    private String status; // e.g., Available, Issued, Reserved
    @SuppressWarnings("FieldMayBeFinal")
    private String location; // e.g., Shelf number or section
    private String borrowerId; // ID of the user who has borrowed the book
    private String dueDate; // Due date for returns
    private String reservationList; // List of user IDs who have reserved the book
    private String bookCondition; // e.g., New, Good, Fair, Poor
    private String language; // Language of the book

    public Book(String id, String title, String author, String isbn, boolean isAvailable, int copiesAvailable, String genre, String publisher, int yearPublished, String status, String location, String borrowerId, String dueDate, String reservationList, String bookCondition, String language) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
        this.copiesAvailable = copiesAvailable;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.status = status;
        this.location = location;
        this.borrowerId = borrowerId;
        this.dueDate = dueDate;
        this.reservationList = reservationList;
        this.bookCondition = bookCondition;
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getStatus() {
        return status;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getBorrowerId() {
        return borrowerId;
    }
    
    public String getDueDate() {
        return dueDate;
    }
    
    public String getReservationList() {
        return reservationList;
    }
    
    public String getBookCondition() {
        return bookCondition;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void setAvailable(boolean available) {
        isAvailable = available;

        if (available) {
            setStatus("Available");
        } else {
            setStatus("Unavailable"); //Issued
        }
    }
    
    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;

        if (copiesAvailable <= 0) {
            setAvailable(false);
        } else {
            setAvailable(true);
        }
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }
    
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    public void setReservationList(String reservationList) {
        this.reservationList = reservationList;
    }
    
    public void setBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }
    
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", isAvailable=" + isAvailable +
                ", copiesAvailable=" + copiesAvailable +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearPublished=" + yearPublished +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", borrowerId='" + borrowerId + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", reservationList='" + reservationList + '\'' +
                ", bookCondition='" + bookCondition + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
