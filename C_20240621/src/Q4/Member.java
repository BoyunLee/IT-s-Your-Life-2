package Q4;

import java.util.ArrayList;

public class Member {
    private int memberId;
    private String name;
    private ArrayList<Book> booksBorrowed;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.booksBorrowed = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void borrowBook(Book book) {
        booksBorrowed.add(book);
    }

    public void returnBook(Book book) {
        booksBorrowed.remove(book);
    }

    public ArrayList<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                '}';
    }

    public void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        for (Book book : booksBorrowed) {
            System.out.println(book);
        }
    }
}
