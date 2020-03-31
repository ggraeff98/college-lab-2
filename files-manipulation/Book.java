public class Book {

    private String title;
    private String isbn;
    private String publishingCompany;
    private String url;
    private double price;

    Book(String title, String isbn, String publishingCompany, String url, double price) {
        this.title = title;
        this.isbn = isbn;
        this.publishingCompany = publishingCompany;
        this.url = url;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String editora) {
        this.publishingCompany = editora;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishingCompany='" + publishingCompany + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                '}';
    }
}
