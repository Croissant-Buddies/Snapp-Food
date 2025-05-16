import java.util.ArrayList;
import java.util.List;

  abstract class User {
    private String name;
    private String number;
    private String email;
    private String password;
    private String role;
    //Editable
    private String photo;

    public User(String name, String number, String email, String password, String role) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
class Buyer extends User {

    String address;
    List<Food> cart;
    public Buyer(String name, String number, String email, String password, String role, String address) {
        super(name, number, email, password, role);
        this.address = address;
        this.cart = new ArrayList<>();
    }
}
class Seller extends User {
    String address;
    //Editable
    String creditCard;
    String bio;
    String restoInfo;
    boolean hasResto;
    public Seller(String name, String number, String email, String password, String role,
                  String address, String creditCard, String bio, String restoInfo, boolean hasResto) {
        super(name, number, email, password, role);
        this.address = address;
        this.creditCard = creditCard;
        this.bio = bio;
        this.restoInfo = restoInfo;
        this.hasResto = hasResto;
    }
}
class DeliveryPerson extends User {
    //Editable
    String creditCard;
    public DeliveryPerson(String name, String number, String email, String password, String role, String creditCard) {
        super(name, number, email, password, role);
        this.creditCard = creditCard;
    }
}
class Food{
    String name;
    String photo;
    String bio;
    String Price;
    boolean isAvailable;
    String category;
    String keyWords;
}
class Restaurant{
    String name;
    String location;
    String number;
    String timeStart;
    String timeEnd;
    String logo;
    String category;
    List<Food> menu;
}
class Admin{}
interface Input{}
interface Output{}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}