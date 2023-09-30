package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Student extends Person implements Serializable {
    private int id ;
    private String email;
    private String username;
    private String password;

    private boolean isBlocked=false;//ilk başda false olsun çünki ilk basda yaradiramsa niyede blocklu halda yaradim?

//bunlar üçün blockla ve blockdan çıxar methodlarınıı da yazaq



    public Student(int id, String email, String username ,String password ,String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
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

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }//getter setterlari unutmusdum


    //indi  blockla ve blockdan çıxar methodlarini yazaq
    public void blockStudent(){
        this.isBlocked=true;//isBLockedi true edirem  daha sonra çap edek neticeni
        System.out.println("Student :"+this.id+" "+this.username+" "+ "has been blocked!!!");
    }//blockdan çıxarma methiodunu da yazaq

    public void unBlockStudent(){
        this.isBlocked=false;
        System.out.println("Student :"+this.id+" "+this.username+" "+ "has been unblocked!!!");//blocklama ve blockdan cixarma methodlario hazırdır
    }


    public String getDetailsForTeacher() {
        LocalDate currentTime= LocalDate.now();
        int age = Period.between(birthDate , currentTime).getYears();
        return "Student{" +
                "[id]=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +

                 " age->"+age+"\n"+
                '}'+"\n";
    }

    @Override
    public String toString() {//to string işimizi gorecek

        return "Student{" +
                "[id]=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                "age= "+ Period.between(birthDate , LocalDate.now()).getYears()+
                '}'+"\n";
    }
}
