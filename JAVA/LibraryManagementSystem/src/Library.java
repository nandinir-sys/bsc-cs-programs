
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println("ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Available: " + book.isAvailable());
            System.out.println("----------------------");
        }
    }
    public Book searchBook(int id) {

        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }

        return null;
    }
    public void removeBook(int id) {

        Book book = searchBook(id);

        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member registered successfully!");
    }
    public void displayMembers() {

        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        for (Member member : members) {
            System.out.println("Member ID: " + member.getMemberId());
            System.out.println("Name: " + member.getName());
            System.out.println("Email: " + member.getEmail());
            System.out.println("Phone: " + member.getPhone());
            System.out.println("----------------------");
        }
    }
    public Member searchMember(int id) {

        for (Member member : members) {
            if (member.getMemberId() == id) {
                return member;
            }
        }

        return null;
    }
    public void removeMember(int id) {

        Member member = searchMember(id);

        if (member != null) {
            members.remove(member);
            System.out.println("Member removed successfully!");
        } else {
            System.out.println("Member not found.");
        }
    }
    public void issueBook(int bookId, int memberId) {

        Book book = searchBook(bookId);
        Member member = searchMember(memberId);

        if (book == null) {
            System.out.println("Book not found.");
        }
        else if (member == null) {
            System.out.println("Member not found.");
        }
        else if (!book.isAvailable()) {
            System.out.println("Book is already issued.");
        }
        else {
            book.setAvailable(false);
            System.out.println("Book issued successfully to " + member.getName());
        }
    }
    public void returnBook(int bookId) {

        Book book = searchBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
        }
        else if (book.isAvailable()) {
            System.out.println("This book was not issued.");
        }
        else {
            book.setAvailable(true);
            System.out.println("Book returned successfully!");
        }
    }
}
