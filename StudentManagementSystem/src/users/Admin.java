package users;

import java.io.Serializable;
import java.time.LocalDate;

public class Admin extends Employee  implements Serializable { // id email username hamısında var deye bilersiniz ki niye bunları personda yaratmadiq çünki bütün personlar bu olmayada biler gelecekde elave edeceyimiz personlar bu xüsusiyyeti daşıçaya biler men eminemki bütün personlarda ad soyad ve dogum tarixi olacaq ona gore personda sadece ad soyad dogum tarixi yazdim

    private int id;
    private String email;
    private String username;
    private String password;//admin blocklana bilmez ona gore buraya elave etmirem



    public Admin(int id, String email, String username ,String password, double salary  , String name , String surname , LocalDate birthDate) {//indi ise diger fieldları ötürek super classa adminin super classı employyedir ve employye bizden salary isteyir
        super(salary , name , surname , birthDate); // super class yeni employeenin bele bur constructoru olmadigi üçün error verir gelin yaradaq.
        this.id = id;
        this.email = email;
        this.username = username;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
