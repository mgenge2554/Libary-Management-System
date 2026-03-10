public class Book {
    String title;
    int pages;
    String author;
    boolean isRented;


    Book(String title, int pages, String author, boolean isRented) {
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.isRented = isRented;


    }

    void displayInfo() {
        System.out.println("------------------------------");
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("# of pages: " + this.pages);
        System.out.println("Rented: " + this.isRented);
        System.out.println("------------------------------");
    }

    String getTitle() {
        return this.title;
    }
    String getAuthor() {
        return this.author;
    }
    boolean getisRented(){
        return this.isRented;
    }

    void setisRented(boolean isRented) {
        this.isRented = isRented;
    }

}
