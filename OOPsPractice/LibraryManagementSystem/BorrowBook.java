package LibraryManagementSystem;

public class BorrowBook {
    private int borrowId;
    private Book book;
    private Member member;

    public BorrowBook(){
        this.borrowId=0;
        this.book=null;
        this.member=null;
    }

    public BorrowBook(int borrowId, Book book, Member member){
        this.borrowId=borrowId;
        this.book=book;
        this.member=member;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void displayBorrowRecord(){
        System.out.println("Borrowed book: "+getBook().getTitle());
        System.out.println("Borrowed by: "+getMember().getName());
    }
}
