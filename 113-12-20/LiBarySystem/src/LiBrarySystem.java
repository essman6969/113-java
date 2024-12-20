public class LiBrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        // 添加書籍
        Book book1 = new PhysicalBook("Java 入門", "李四", "A1-3");
        Book book2 = new PhysicalBook("資料結構", "王五", "B2-1");
        Book book3 = new EBook("設計模式", "張三", "www.download.com/design-patterns");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // 添加會員
        Member member1 = new Member("小明");
        Member member2 = new Member("小紅");
        library.addMember(member1);
        library.addMember(member2);

        // 借閱書籍
        member1.borrowBook(book1);
        member1.borrowBook(book3);
        member1.listBorrowedBooks();

        // 另一位會員嘗試借閱已借出的書
        member2.borrowBook(book1);

        // 歸還書籍
        member1.returnBook(book1);
        member1.listBorrowedBooks();

        // 列出圖書館書籍
        library.listBooks();
    }
}

