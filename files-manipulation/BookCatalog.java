import java.io.*;

public class BookCatalog implements IBookCatalog {

    Book[] booksList;
    int storedAmountOfBooks = 0;

    BookCatalog(int arrayLength) {
        booksList = new Book[arrayLength];
    }

    @Override
    public void load(File file) throws Exception {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            while(line != null) {
                String[] bookInfo = line.split(";");

                try {
                    Book book = new Book(bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], Double.valueOf(bookInfo[4]));
                    booksList[storedAmountOfBooks] = book;
                    storedAmountOfBooks++;
                    line = bufferedReader.readLine();
                } catch (IndexOutOfBoundsException e) {
                    throw new StorageLimitException("You need more spaces to store new books!");
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new FileReaderException("Can't read this file!");
        }
    }

    @Override
    public void list() {
        for (int i = 0; i < booksList.length; i++) {
            System.out.println(booksList[i]);
        }
    }

    @Override
    public void add(Book book) {

        if (booksList.length - storedAmountOfBooks <= 0) {
            System.out.println("None spaces to store new books!");
            return;
        }

        booksList[storedAmountOfBooks] = book;
        System.out.println();

        for (int i = 0; i < booksList.length; i++) {
            if (booksList[i] == null) break;
        }
    }

    @Override
    public void remove(int bookPositionOnList) {
        if (booksList.length <= bookPositionOnList) {
            System.out.println("Invalid position!");
            return;
        }

        if (booksList[bookPositionOnList] == null) {
            System.out.println("Any books stored in this position yet!");
            return;
        }

        for (int i = 0; i < booksList.length - 1; i++) {
            if (i >= bookPositionOnList) {
                booksList[i] = booksList[i + 1];
            }
        }
        booksList[booksList.length - 1] = null;
    }

    @Override
    public void save(File file) throws IOException {
        FileWriter fw = new FileWriter(file);

        for (int i = 0; i < booksList.length; i++) {
            if (booksList[i] == null) break;
            fw.write(booksList[i].getTitle() + ";"
                    + booksList[i].getIsbn() + ";"
                    + booksList[i].getPublishingCompany() + ";"
                    + booksList[i].getUrl() + ";"
                    + booksList[i].getPrice());
            fw.write("\n");
        }
        fw.close();
    }
}
