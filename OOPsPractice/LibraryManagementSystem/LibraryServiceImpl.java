package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService{
    List<Book> books=new ArrayList<>();

    public void createBook(int bookId, String title, String author, double price, boolean isAvailable, int numberOfPages, String publisher,int fileSize, String fileType, String bookType){
        Book b;
        if(bookType.equalsIgnoreCase("ebook")){
            b=new Ebook(bookId, title, author, price, isAvailable, fileSize, fileType);
        }
        else{
            b=new PrintedBook(bookId, title, author, price, isAvailable, numberOfPages, publisher);
        }

        addBook(b);
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book getBookById(int bookId) {
        Book book=null;
        for(Book b:books){
            if(b.getBookId()==bookId){
                book=b;
            }
        }

        return book;
    }

    @Override
    public void displayBook(int bookId) {
        Book book=getBookById(bookId);

        if(book==null){
            System.out.println("Book with given id "+bookId+" is not found");
            return ;
        }

        book.displayDetails();
    }

    @Override
    public void displayAllBooks() {
        for(Book book:books){
            book.displayDetails();
        }
    }

    @Override
    public void updateBook(int bookId, Book newBook) {
        Book book=getBookById(bookId);

        if(book==null){
            System.out.println("Book with given id "+bookId+" is not found");
            return ;
        }
        
        if(book instanceof PrintedBook){
            PrintedBook oldPrintedBook=(PrintedBook) book;
            PrintedBook newPrintedBook=(PrintedBook) book;

            oldPrintedBook.setAuthor(newPrintedBook.getAuthor());
            oldPrintedBook.setAvailable(newPrintedBook.isAvailable());
        }
        else if(book instanceof Ebook){

        }
    }

    @Override
    public void deleteBook(int bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBook'");
    }

    @Override
    public void addMember(Member member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMember'");
    }

    @Override
    public Member getMemberById(int memberId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMemberById'");
    }

    @Override
    public void borrowBook(int bookId, int memberId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrowBook'");
    }

    @Override
    public void returnBook(int bookId, int memberId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnBook'");
    }

    @Override
    public List<Book> getBorrowedBooks(int memberId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBorrowedBooks'");
    }

    @Override
    public int calculateLateFee(int bookId, int days) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateLateFee'");
    }
    
}
