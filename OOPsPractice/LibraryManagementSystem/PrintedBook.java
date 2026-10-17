package LibraryManagementSystem;

public class PrintedBook extends Book{
    private int numberOfPages;
    private String publisher;

    public PrintedBook(){
        this.numberOfPages=0;
        this.publisher="";
    }

    public PrintedBook(int bookId, String title, String author, double price, boolean isAvailable, int numberOfPages, String publisher) {
        super(bookId, title, author, price, isAvailable);
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override 
    public int calculateLateFee(int days){
        return 200;
    }

    @Override 
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Number of pages: "+numberOfPages);
        System.out.println("Publisher: "+publisher);
    }
}
