package LibraryManagementSystem;

public abstract class Book {
    private int bookId;
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    Book(){
        this.bookId=0;
        this.title="";
        this.author="";
        this.price=0.0;
        this.isAvailable=false;
    }

    Book(int bookId, String title, String author, double price, boolean isAvailable){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.price=price;
        this.isAvailable=isAvailable;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void displayDetails(){
        System.out.println("Book id is: "+bookId);
        System.out.println("Book title is: "+title);
        System.out.println("Book author is: "+author);
        System.out.println("Book price is: "+price+"rs");
        System.out.println("Is book available: "+isAvailable);
    }

    public abstract int calculateLateFee();
}
