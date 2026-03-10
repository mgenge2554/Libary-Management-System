import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//Variables


        Admin admin1 = new Admin("Mgenge", "password");
        Admin admin2 = new Admin("Mpowell", "password1");
        Admin admin3 = new Admin("Pwait", "password2");
        ArrayList<Admin> AdminLogInfo = new ArrayList<>();
        AdminLogInfo.add(admin1);
        AdminLogInfo.add(admin2);
        AdminLogInfo.add(admin3);
        int AdminLength = AdminLogInfo.toArray().length;

        ArrayList<String> rentedList = new ArrayList<>();

        User user1 = new User("Mgenge", "password");
        User user2 = new User("Mpowell", "password1");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        int usersLength = users.toArray().length;

        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("Mistborn", 600, "Brandon Sanderson", false);
        Book book2 = new Book("Mistborn 2", 592, "Brandon Sanderson", false);
        Book book3 = new Book("Harry Potter and the Philosopher's Stone", 223, "JK Rowling", false);
        Book book4 = new Book("Harry Potter and the Chamber of Secrets", 317, "JK Rowling", false);
        Book book5 = new Book("Harry Potter and the Prisoner of Azkaban", 317, "JK Rowling", false);
        Book book6 = new Book("Harry Potter and the Goblet of fire", 636, "JK Rowling", false);
        Book book7 = new Book("Harry Potter and the Order of the Phoenix ", 766, "JK Rowling", false);
        Book book8 = new Book("Harry Potter and Half Blood Prince", 607, "JK Rowling", false);
        Book book9 = new Book("Harry Potter and the Deathly Hallows", 607, "JK Rowling", false);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);


        int libaryLength = books.toArray().length;

        LocalDateTime beginTime = LocalDateTime.now();
        LocalDateTime endTime = beginTime.plusMinutes(1);


        char logInChoice;
        char AdminChoice;
        String username;
        String password;
        boolean isRunning = true;
        boolean isLogedIn = true;
        boolean isCorrect = true;
        boolean choice = true;


        //Libary system (log in)
        while (isRunning) {

            System.out.println("""
                    Welcome to the Libary System. Please select an option:
                    1. Admin Login
                    2. Customer Login
                    3. Turn off""");

            logInChoice = scanner.next().charAt(0);
            scanner.nextLine();


            if (logInChoice == '1') {

                    System.out.println("Please enter your Username and password");
                    System.out.print("Username: \n");

                    username = scanner.nextLine();
                    System.out.println(username);
                    System.out.println("Password: ");

                    password = scanner.nextLine();
                    System.out.println(password);
                    isLogedIn = true;


                    // Admin menu
                while (isLogedIn) {
                    for (int i = 0; i < AdminLength; i++) {
                        if (AdminLogInfo.get(i).getUsername().equals(username) && (AdminLogInfo.get(i).getPassword().equals(password))) {

                            System.out.println("Welcome " + username);
                            System.out.println("""
                                    Please choose an Option
                                    1. Add a book to the libary
                                    2. Remove a book
                                    3. Add an account
                                    4. View Libary
                                    5. Log out
                                    """);

                            AdminChoice = scanner.next().charAt(0);
                            scanner.nextLine();



                                if (AdminChoice == '1') {
                                    choice = true;


                                    System.out.print("please input a Book title: ");
                                    String bookTitle = scanner.nextLine();

                                    System.out.print("please input a Book Author: ");

                                    String bookAuthor = scanner.nextLine();

                                    System.out.print("please input the number of pages: ");
                                    int bookPages = scanner.nextInt();
                                    boolean isRented = false;


                                    Book book = new Book(bookTitle, bookPages, bookAuthor, isRented);
                                    book.displayInfo();
                                    books.add(book);
                                    System.out.println("Book has been added");

                                    libaryLength = books.toArray().length;
                                    choice = false;
                                } else if (AdminChoice == '2') {

                                    System.out.print("Type in a Book title to delete: ");
                                    String search = scanner.nextLine();

                                    for (int y = 0; y < libaryLength; y++) {
                                        for (Book book : books) {
                                            if (search.equals(book.getTitle())) {
                                                books.remove(book);
                                                System.out.println("book deleted");
                                                break;

                                            }


                                        }
                                    }

                                } else if (AdminChoice == '3') {

                                        while (isCorrect) {
                                            System.out.print("please enter a Username: ");
                                            username = scanner.nextLine();
                                            System.out.print("please enter a Password: ");
                                            password = scanner.nextLine();

                                            if (username.length() < 4 || username.length() > 12) {
                                                System.out.println("username must be between 4 - 12 characters");

                                            } else if (username.contains(" ") || username.contains("_")) {
                                                System.out.println("make sure there is no spaces or _");
//a
                                            } else if (!password.contains("!") && !password.contains("£")
                                                    && !password.contains("#") && !password.contains("%") &&
                                                    !password.contains("@")) {
                                                System.out.println("A password must include a !, £, #, %, @");

                                            } else {
                                                users.add(new User(username, password));
                                                //System.out.println(Arrays.asList(users)); // Confirms data entered
                                                System.out.println("new user added");
                                                isCorrect = false;
                                                isLogedIn = true;

                                            }
                                        }



                                } else if (AdminChoice == '4') {
                                    libaryLength = books.toArray().length;
                                    for (int y = 0; y < libaryLength; y++) {
                                        books.get(y).displayInfo();
                                        isLogedIn = true;
                                    }
                                } else if (AdminChoice == '5') {
                                    isLogedIn = false;

                                }

                        }
                    }
                }
            } else if (logInChoice == '2') {
                isLogedIn = true;

                    System.out.println("Please enter your Username and password");
                    System.out.print("Username: ");

                    username = scanner.nextLine();
                    System.out.println(username);

                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    System.out.println(password);
                while (isLogedIn) {




                    for (int i = 0; i < users.toArray().length; i++) {
                        if (users.get(i).getUsername().equals(username) && (users.get(i).getPassword().equals(password))) {
                            System.out.println("Welcome " + username);
                            System.out.println("""
                                        Please choose an Option
                                           1. Search a book
                                           2. Return a book
                                           3. Log out
                                        """);
                            char option = scanner.next().charAt(0);
                            scanner.nextLine();

                            if (option == '1') {

                                System.out.println("Please type in a book title: ");
                                String TitleSearch = scanner.nextLine();
                                System.out.println(TitleSearch);


                                for (Book book : books) {
                                    if (TitleSearch.equals(book.getTitle())) {
                                        System.out.println("Book found");
                                        if (book.isRented) {
                                            System.out.println("cannot be rented");
                                        } else if (!book.isRented) {
                                            System.out.println("Would you like to rent? [Y/N] ");
                                            char answer = scanner.next().toUpperCase().charAt(0);
                                            if (answer == 'Y') {
                                                book.setisRented(true);
                                                user1.numberOfBooks++;
                                                System.out.println(users.get(i).numberOfBooks);
                                                rentedList.add(TitleSearch);
                                                System.out.println(rentedList);
                                                Renting();

                                            } else {
                                                System.out.println("not found");
                                            }
                                            if (users.get(i).numberOfBooks > 3) {
                                                book.setisRented(false);
                                                System.out.println("you have too many books out");
                                                users.get(i).numberOfBooks--;
                                                System.out.println(users.get(i).numberOfBooks);

                                            }
                                        }
                                    }
                                }
                            } else if (option == '2') {
                                System.out.print("please enter the title of the book: ");
                                String bookReturn = scanner.nextLine();
                                for (int y = 0; y < books.toArray().length; y++) {
                                    if (bookReturn.equals(books.get(y).getTitle())) {
                                        if (books.get(y).isRented) {
                                            books.get(y).setisRented(false);
                                            users.get(y).numberOfBooks--;
                                            rentedList.remove(bookReturn);
                                            System.out.println("book has been returned");
                                            System.out.println(rentedList);

                                            LocalDateTime returnTime = LocalDateTime.now();
                                            if (returnTime.isAfter(endTime)) {
                                                System.out.println("LATE!!!!!");
                                            }
                                        }
                                    }
                                }
                            } else if (option == '3') {
                                isLogedIn = false;
                            }
                        }
                    }
                }

            } else if (logInChoice == '3') {
                System.out.println("Thank you");
                isRunning = false;
            }
        }

        scanner.close();
    }
    static void Renting () {


        LocalDateTime beginTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(beginTime.format(formatter));
        System.out.println("Your Book due date is " + endTime.format(formatter));

    }
    static void Returned (LocalDateTime endTime){
        LocalDateTime returnTime = LocalDateTime.now();


    }
}