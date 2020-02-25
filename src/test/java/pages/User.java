package pages;

public class User {
    public String firstName;
    public String lastName;
    public String businessName;
    public String phone;
    public String email;
    public String password;

    public User emptyCredentials(){
        firstName = "";
        lastName = "";
        businessName = "";
        phone = "";
        email = "";
        password = "";
        return this;
    }

    public User wrongSignUp(){
        firstName = "Chris";
        lastName = "Lim";
        businessName = "Testing Program";
        phone = "1";
        email = "1";
        password = "1234567";
        return this;
    }

}
