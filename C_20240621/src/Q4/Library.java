package Q4;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Methods to manage books
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    // Methods to manage members
    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(int memberId) {
        members.removeIf(member -> member.getMemberId() == memberId);
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    public void listMembers() {
        System.out.println("Members of the library:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public ArrayList<Book> getBooksBorrowedByMember(Member member) {
        return member.getBooksBorrowed();
    }

    // Method to issue a book to a member
    public boolean issueBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            member.borrowBook(book);
            return true;
        }
        return false;
    }

    // Method to return a book from a member
    public boolean returnBook(Book book, Member member) {
        if (member.getBooksBorrowed().contains(book)) {
            book.setAvailable(true);
            member.returnBook(book);
            return true;
        }
        return false;
    }
}