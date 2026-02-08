import java.util.ArrayList;
import java.util.List;

public class inventory {
    private List<book> libraryList = new ArrayList<>();
    private List<book> borrowedList = new ArrayList<>();

    public void addBook(book book) {
        libraryList.add(book);
        System.out.println("Book added to the library.");
    }

    private book findId(List<book> list, int id) {
        for (book book : list) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(int id) {
        book borrowBook = findId(libraryList, id);
        if (borrowBook != null) {
            libraryList.remove(borrowBook);
            borrowedList.add(borrowBook);
            System.out.println("Book successfully borrowed.");
        } else {
            System.out.println("Selection not available!");
        }
    }

    public void returnBook(int id) {
        book returnBook = findId(borrowedList, id);
        if (returnBook != null) {
            borrowedList.remove(returnBook);
            libraryList.add(returnBook);
            System.out.println("Book successfully returned.");
        } else {
            System.out.println("Selection is not available!");
        }
    }

    public void printAll() {
        if (libraryList.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }
        System.out.println("Available Books:");
        for (book book : libraryList) {
            book.printBookInfo();
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("These are the available Books:");
        for (book book : libraryList) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                book.printBookInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }
}
