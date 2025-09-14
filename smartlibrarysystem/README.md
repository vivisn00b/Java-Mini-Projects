## 🛠️ Step-by-Step Build Order  

### Phase 1 – OOP Core  

Create classes: **Book, User (abstract), Member, Librarian, Loan**.  

Add attributes:  
- Book: `id`, `title`, `author`, `year`, `available`  
- User: `id`, `name` (abstract base class)  
- Member: `borrowedBooks` list  
- Librarian: special permissions (add/remove books, add users)  

Methods:  
- Member.borrow(Book b)  
- Member.returnBook(Book b)  
- Librarian.addBook(Book b)  
- Librarian.removeBook(Book b)  
- Librarian.addUser(User u)  

Test with a main method: create books, members, librarian; simulate borrowing and admin operations.  

👉 Practice: Encapsulation, inheritance (User → Member/Librarian), polymorphism (`getRole()`, `displayDetails()`).  

---

### Phase 2 – Exception Handling  

Add custom exceptions:  
- `BookNotAvailableException` → if a user tries to borrow an unavailable book.  
- `UserLimitExceededException` → if a member exceeds the borrowing limit.  

Wrap borrowing code with `try-catch`.  
Use `finally` for logging actions.  

👉 Practice: try, catch, finally, custom exceptions.  

---

### Phase 3 – Strings & Builders  

Add search feature: find books by title/author (case-insensitive).  
Use **StringBuilder** to construct search results.  
Override `toString()` for pretty output in Book, User, Loan.  

👉 Practice: String operations, StringBuilder, overriding toString.  

---

### Phase 4 – Sorting & Arrays  

Keep books in a `List<Book>`.  

Add methods to:  
- Sort books by title, author, or year (with Comparator).  
- Implement a custom bubble sort for practice.  

👉 Practice: Arrays.sort, Collections.sort, custom sorting.  

---

### Phase 5 – Generics  

Create a generic `Repository<T>` that can store `Book` or `User`.  

Implement methods like:  
- `add(T item)`  
- `remove(T item)`  
- `findById(int id)`  

Also write a generic method `printArray(T[] array)`.  

👉 Practice: Generics in classes and methods.  

---

### Phase 6 – Lambdas & Streams  

Use Streams to:  
- Filter all available books.  
- Find books published after 2010.  
- Group books by genre.  
- Count the books borrowed by each user.  

👉 Practice: filter, map, reduce, Collectors.groupingBy.  

---

### Phase 7 – Multithreading  

- Add a background auto-save thread: every 60s, write the library state to a file.  
- Simulate multiple users borrowing books at the same time.  
- Use `synchronized` or `AtomicInteger` to avoid race conditions.  
- Use `ExecutorService` to handle multiple concurrent requests.  

👉 Practice: Threads, synchronization, executors, race conditions.  

---

### Phase 8 – Polish & Extend  

- Use **StringBuffer** for thread-safe logging.  
- Create reports (like “Top 5 most borrowed books”) using a `ReportGenerator`.  
- Role-based menus: Member sees borrow/return/search; Librarian sees add/remove/report.  

👉 Practice: Thread-safe operations, reporting, role-based access.  

---

## 📂 File Structure

```plaintext
smartlibrarysystem/
│── src/
│   └── smartlibrary/
│       ├── model/
│       │   ├── Book.java
│       │   ├── User.java
│       │   ├── Member.java
│       │   └── Librarian.java
│       │
│       ├── exceptions/
│       │   ├── BookNotAvailableException.java
│       │   └── UserLimitExceededException.java
│       │
│       ├── service/
│       │   └── LibraryService.java
│       │
│       ├── util/
│       │   └── ReportGenerator.java
│       │
│       └── Main.java
└── README.md
```