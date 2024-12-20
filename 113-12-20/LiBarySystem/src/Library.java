import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("書籍 " + book.getTitle());
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("會員 " + member.getName());
    }

    public void listBooks() {
        System.out.println("圖書館的書籍清單:");
        if (books.isEmpty()) {
            System.out.println("無書籍。");
        } else {
            for (Book book : books) {
                System.out.println("  - " + book.getTitle() + "狀態" + ((book.isBorrowed()) ? "已借閱 ":"可借閱"));
            }
        }
    }

    public Member getMember(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }
}
