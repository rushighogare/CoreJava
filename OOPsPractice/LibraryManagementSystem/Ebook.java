package LibraryManagementSystem;

public class Ebook extends Book{
    private int fileSize;
    private String fileType;

    public Ebook() {
        this.fileSize = 0;
        this.fileType = "";
    }

    public Ebook(int bookId, String title, String author, double price, boolean isAvailable, int fileSize, String fileType) {
        super(bookId, title, author, price, isAvailable);
        this.fileSize = fileSize;
        this.fileType = fileType;
    }

    public int getFileSize() {
        return fileSize;
    }
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override 
    public int calculateLateFee(){
        return 0;
    }

    @Override 
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Size of file is: "+fileSize);
        System.out.println("Provided type of file is: "+fileType);
    }
}
