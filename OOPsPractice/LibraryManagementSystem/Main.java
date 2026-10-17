
package LibraryManagementSystem;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryServiceImpl service = new LibraryServiceImpl();

        int choice;

        do {
            System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Add Member");
            System.out.println("7. Search Member by ID");
            System.out.println("8. Borrow Book");
            System.out.println("9. Return Book");
            System.out.println("10. View Borrowed Books");
            System.out.println("11. Calculate Late Fee");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Book Type (PrintedBook/Ebook): ");
                    String bookType = sc.nextLine();

                    int numberOfPages = 0;
                    String publisher = "";
                    int fileSize = 0;
                    String fileType = "";

                    if (bookType.equalsIgnoreCase("printedbook")) {
                        System.out.print("Enter Number of Pages: ");
                        numberOfPages = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Publisher: ");
                        publisher = sc.nextLine();

                    } else if (bookType.equalsIgnoreCase("ebook")) {
                        System.out.print("Enter File Size: ");
                        fileSize = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter File Type: ");
                        fileType = sc.nextLine();

                    } else {
                        System.out.println("Invalid book type.");
                        break;
                    }

                    service.createBook(
                            bookId, title, author, price,
                            true, numberOfPages, publisher,
                            fileSize, fileType, bookType
                    );

                    break;
                }

                case 2:
                    service.displayAllBooks();
                    break;

                case 3: {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    service.displayBook(bookId);
                    break;
                }

                case 4: {
                    System.out.print("Enter Book ID to update: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    Book existingBook = service.getBookById(bookId);

                    if (existingBook == null) {
                        System.out.println("Book not found.");
                        break;
                    }

                    System.out.print("Enter New Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter New Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter New Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    if (existingBook instanceof PrintedBook) {
                        System.out.print("Enter Number of Pages: ");
                        int pages = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Publisher: ");
                        String publisher = sc.nextLine();

                        Book updatedBook = new PrintedBook(
                                bookId, title, author, price,
                                existingBook.isAvailable(), pages, publisher
                        );

                        service.updateBook(bookId, updatedBook);

                    } else if (existingBook instanceof Ebook) {
                        System.out.print("Enter File Size: ");
                        int fileSize = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter File Type: ");
                        String fileType = sc.nextLine();

                        Book updatedBook = new Ebook(
                                bookId, title, author, price,
                                existingBook.isAvailable(), fileSize, fileType
                        );

                        service.updateBook(bookId, updatedBook);
                    }

                    break;
                }

                case 5: {
                    System.out.print("Enter Book ID to delete: ");
                    int bookId = sc.nextInt();

                    service.deleteBook(bookId);
                    break;
                }

                case 6: {
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    int phoneNumber = sc.nextInt();

                    service.createMember(
                            memberId, name, email, phoneNumber
                    );

                    break;
                }

                case 7: {
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();

                    Member member = service.getMemberById(memberId);

                    if (member == null) {
                        System.out.println("Member not found.");
                    } else {
                        member.displayMemberDetails();
                    }

                    break;
                }

                case 8: {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();

                    service.borrowBook(bookId, memberId);
                    break;
                }

                case 9: {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();

                    service.returnBook(bookId, memberId);
                    break;
                }

                case 10: {
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();

                    List<Book> borrowedBooks =
                            service.getBorrowedBooks(memberId);

                    if (borrowedBooks != null) {
                        if (borrowedBooks.isEmpty()) {
                            System.out.println("No books borrowed by this member.");
                        } else {
                            for (Book book : borrowedBooks) {
                                book.displayDetails();
                                System.out.println("-------------------------");
                            }
                        }
                    }

                    break;
                }

                case 11: {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    System.out.print("Enter Number of Late Days: ");
                    int days = sc.nextInt();

                    if (days < 0) {
                        System.out.println("Late days cannot be negative.");
                    } else {
                        int fee = service.calculateLateFee(bookId, days);
                        System.out.println("Late Fee: Rs. " + fee);
                    }

                    break;
                }

                case 0:
                    System.out.println("Thank you for using the Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}