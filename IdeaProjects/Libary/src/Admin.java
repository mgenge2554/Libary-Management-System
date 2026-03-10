public class Admin {
    String username;
    String password;

    Admin(String username, String password){
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
