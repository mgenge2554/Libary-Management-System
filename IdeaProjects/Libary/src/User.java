import java.util.ArrayList;

public class User {
    String username;
    String password;
    int numberOfBooks = 0;
    ArrayList<String> rentedList = new ArrayList<>();

    User(String username, String password){
        this.username = username;
        this.password = password;

    }
    String getUsername(){
        return this.username;
    }

    String getPassword(){
        return this.password;
    }


}