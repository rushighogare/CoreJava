package LibraryManagementSystem;

import java.util.List;

public interface LibraryService {
    public void addBook(Book book);

    public Book getBookById(int bookId);

    public void displayBook(int bookId);

    public void displayAllBooks();

    public void updateBook(int bookId, Book book);

    public void deleteBook(int bookId);

    public void addMember(Member member);

    public Member getMemberById(int memberId);

    public void borrowBook(int bookId, int memberId);

    public void returnBook(int bookId, int memberId);

    public List<Book> getBorrowedBooks(int memberId);

    public int calculateLateFee(int bookId, int days);
}
