package Q4;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        Book book2 = new Book("1984", "George Orwell", "2345678901");
        Book book3 = new Book("Ant", "Bernard Werber", "3456789012");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Adding members to the library
        Member member1 = new Member(1, "Alice");
        Member member2 = new Member(2, "Bob");
        library.addMember(member1);
        library.addMember(member2);

        // Issuing books to members
        library.issueBook(book1, member1);
        library.issueBook(book2, member2);

        // Listing books and members
        library.listBooks();
        library.listMembers();

        // Displaying books borrowed by members
        member1.displayBorrowedBooks();
        member2.displayBorrowedBooks();
    }
}