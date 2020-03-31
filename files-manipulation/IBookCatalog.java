import java.io.File;
import java.io.IOException;

public interface IBookCatalog {
    void load(File file) throws Exception;

    void list();

    void add(Book book);

    void remove(int bookPositionOnList);

    void save(File file) throws IOException;
}
