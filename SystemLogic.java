import java.util.Scanner;

public class SystemLogic {
    public static void main(String[] args) {
        inventory library = new inventory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Search by title");
            System.out.println("5. Print all books");
            System.out.println("6. Exit");
            System.out.print("Select from the menu: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter the Book's ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter the Book's Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter the Book's Author: ");
                        String author = scanner.nextLine();

                        System.out.print("Enter the Book's ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Enter the number of pages: ");
                        int pages = Integer.parseInt(scanner.nextLine());

                        book newBook = new book(id, title, author, isbn, pages);
                        library.addBook(newBook);
                        break;

                    case 2:
                        System.out.print("Enter the book's ID: ");
                        int borrowId = Integer.parseInt(scanner.nextLine());
                        library.borrowBook(borrowId);
                        break;

                    case 3:
                        System.out.print("Enter the book's ID: ");
                        int returnId = Integer.parseInt(scanner.nextLine());
                        library.returnBook(returnId);
                        break;

                    case 4:
                        System.out.print("Enter the Book's title: ");
                        String searchTitle = scanner.nextLine();
                        library.searchByTitle(searchTitle);
                        break;

                    case 5:
                        library.printAll();
                        break;

                    case 6:
                        System.out.println("Closing!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Selection not available.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Selection not available.");
            } catch (Exception e) {
                System.out.println("Selection not available.");
            }
        }
    }
}
