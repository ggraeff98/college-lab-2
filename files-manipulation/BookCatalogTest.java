import java.io.*;

public class BookCatalogTest {

    private static final String DIRECTORY = "home/books.txt";

    public static void main(String[] args) {

        BookCatalog bookCatalog = new BookCatalog(7);

        bookCatalog.list();

        File file = new File(DIRECTORY);

        if  (!file.exists()) {
            try {
                if (file.exists()) return;
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            bookCatalog.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bookCatalog.list();
        System.out.println();

        Book book = new Book(
                "Livro NOVO",
                "1234567891234",
                "Editora NOVA",
                "www.L&GFOREVER.com",
                19.99);

        bookCatalog.add(book);
        bookCatalog.list();
        System.out.println();

        bookCatalog.remove(1);
        bookCatalog.list();

        try {
            bookCatalog.save(new File(String.valueOf(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
