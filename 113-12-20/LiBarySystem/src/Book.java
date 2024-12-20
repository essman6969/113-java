public class Book implements Borrowable {
    private String title;
    private String author;
    private boolean isborrowed ;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isborrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean isBorrowed() {
        return isborrowed;
    }

    @Override
    public void borrow() {
        if(!isborrowed){
            isborrowed = true;
            System.out.println("您以借閱 " + title + " 作者 " + author);
        }
        else {
            System.out.println(title + "此書已被借閱");
        }
    }

    @Override
    public void returnItem() {
        if(isborrowed){
            isborrowed = false;
            System.out.println("您已歸還 " + title + " 作者 " + author);
        }
        else {
            System.out.println(title + "此書未被借閱");
        }
    }

    @Override
    public String toString() {
        return "書名: " + title + ". 作者: " + author + ", 狀態: " + (isborrowed ? "已借閱" : "可借閱");
    }
}
