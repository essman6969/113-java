import java.util.ArrayList;

public class Member extends Person{
    private ArrayList<Book> borrowedBooks;

    public Member(String name) {
        super(name);
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            book.borrow();
            borrowedBooks.add(book);
        } else {
            System.out.println(getName() + " 無法借閱 " + book.getTitle() + "，因為已被借走。");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnItem();
            borrowedBooks.remove(book);
        } else {
            System.out.println(getName() + " 無法歸還 " + book.getTitle() + "，因為未借閱。");
        }
    }

    public void listBorrowedBooks() {
        System.out.println(getName() + " 借閱的書籍清單:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("無借閱書籍。");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println("  - " + book.getTitle());
            }
        }
    }
}
