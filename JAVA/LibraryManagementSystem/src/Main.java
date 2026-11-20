
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Remove Book");
            System.out.println("4. Register Member");
            System.out.println("5. Display Members");
            System.out.println("6. Remove Member");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(bookId, title, author));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    library.removeBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    library.addMember(
                            new Member(memberId, name, email, phone)
                    );
                    break;

                case 5:
                    library.displayMembers();
                    break;

                case 6:
                    System.out.print("Enter Member ID: ");
                    library.removeMember(sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter Book ID: ");
                    int issueId = sc.nextInt();

                    System.out.print("Enter Member ID: ");
                    int issueMemberId = sc.nextInt();

                    library.issueBook(issueId, issueMemberId);
                    break;

                case 8:
                    System.out.print("Enter Book ID: ");
                    library.returnBook(sc.nextInt());
                    break;

                case 0:
                    System.out.println("Exiting Library Management System...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
