package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibraryServiceImpl implements LibraryService{
    List<Book> books=new ArrayList<>();
    List<Member> members=new ArrayList<>();
    List<BorrowBook> borrowedBooks=new ArrayList<>();

    public void createBook(int bookId, String title, String author, double price, boolean isAvailable, int numberOfPages, String publisher,int fileSize, String fileType, String bookType){
        Book b=getBookById(bookId);
        if(b!=null){
            System.out.println("Book with given id is already exist");
            return ;
        }

        if(bookType.equalsIgnoreCase("ebook")){
            b=new Ebook(bookId, title, author, price, isAvailable, fileSize, fileType);
        }
        else if(bookType.equalsIgnoreCase("printedbook")){
            b=new PrintedBook(bookId, title, author, price, isAvailable, numberOfPages, publisher);
        }else{
            System.out.println("Book type does not exist");
            return ;
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
                break;
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
            PrintedBook newPrintedBook=(PrintedBook) newBook;

            oldPrintedBook.setAuthor(newPrintedBook.getAuthor());
            oldPrintedBook.setAvailable(newPrintedBook.isAvailable());
            oldPrintedBook.setNumberOfPages(newPrintedBook.getNumberOfPages());
            oldPrintedBook.setPrice(newPrintedBook.getPrice());
            oldPrintedBook.setPublisher(newPrintedBook.getPublisher());
            oldPrintedBook.setTitle(newPrintedBook.getTitle());
        }
        else if(book instanceof Ebook){
            Ebook oldEbook=(Ebook) book;
            Ebook newEbook=(Ebook) newBook;

            oldEbook.setAuthor(newEbook.getAuthor());
            oldEbook.setAvailable(newEbook.isAvailable());
            oldEbook.setFileSize(newEbook.getFileSize());
            oldEbook.setPrice(newEbook.getPrice());
            oldEbook.setFileType(newEbook.getFileType());
            oldEbook.setTitle(newEbook.getTitle());
        }
    }

    @Override
    public void deleteBook(int bookId) {
        Iterator<Book> it=books.iterator();

        while(it.hasNext()){
            Book b=it.next();
            if(b.getBookId()==bookId && b.isAvailable()){
                it.remove();
                System.out.println("Book with given id "+bookId+" is deleted successfully");
                return ;
            }
        }

        System.out.println("Book with given id "+bookId+" is not found or book is borrowed, can't delete it for now.");
    }

    public void createMember(int memberId, String name, String email, int phoneNumber){
        Member member=getMemberById(memberId);
        if(member!=null){
            System.out.println("Member with given id is already exist");
            return ;
        }

        member=new Member(memberId, name, email, phoneNumber);
        addMember(member);
    }

    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public Member getMemberById(int memberId) {
        Member member=null;
        for(Member m:members){
            if(m.getMemberId()==memberId){
                member=m;
                break;
            }
        }

        return member;
    }

    @Override
    public void borrowBook(int bookId, int memberId) {
        Book book=getBookById(bookId);
        Member member=getMemberById(memberId);

        if(book==null || member==null){
            System.out.println("Record not found. Book id: "+bookId+" Member id: "+memberId);
            return ;
        }

        if(book.isAvailable()){
            book.setAvailable(false);
            BorrowBook b=new BorrowBook(bookId, book, member);
            borrowedBooks.add(b);
            System.out.println("Book with given details is borrowed by member");
            return ;
        }

        System.out.println("Sorry! Book is not available currently");
    }

    @Override
    public void returnBook(int bookId, int memberId) {
        Book book=getBookById(bookId);
        Member member=getMemberById(memberId);

        if(book==null || member==null){
            System.out.println("Record not found. Book id: "+bookId+" Member id: "+memberId);
            return ;
        }

        if(book.isAvailable()){
            System.out.println("Book is not borrowed yet");
            return ;
        }

        Iterator<BorrowBook> it=borrowedBooks.iterator();

        while(it.hasNext()){
            BorrowBook b=it.next();
            if(b.getBook().getBookId()==bookId && b.getMember().getMemberId()==memberId){
                it.remove();
                book.setAvailable(true);
                System.out.println("Book is returned by member");
                return ;
            }
        }
    }

    @Override
    public List<Book> getBorrowedBooks(int memberId) {
        Member member=getMemberById(memberId);
        if(member==null){
            System.out.println("member with given id is not available");
            return null;
        }

        List<Book> ansBooks=new ArrayList<>();
        
        for(BorrowBook b:borrowedBooks){
            if(b.getMember().getMemberId()==memberId){
                ansBooks.add(b.getBook());
            }
        }

        return ansBooks;
    }

    @Override
    public int calculateLateFee(int bookId, int days) {
        Book b=getBookById(bookId);

        if(b==null){
            System.out.println("Book record not found");
            return 0;
        }

        return b.calculateLateFee()*days;
    }
}
