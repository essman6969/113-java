public class PhysicalBook extends Book {
    private String shalflocation;

    public PhysicalBook(String title, String author, String shalflocation) {
        super(title, author);
        this.shalflocation = shalflocation;
    }

    public String getShalflocation() {
        return shalflocation;
    }

    @Override
    public String toString() {
        return super.toString() + ", 地點: " + shalflocation;
    }
}
