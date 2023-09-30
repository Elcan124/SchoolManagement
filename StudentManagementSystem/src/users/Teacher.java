package users;

import classes.Classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Teacher extends Employee  implements Serializable {//teacharde elave olaraq Class saxlayacaq içerisinde class ise içerisinde Studentleri saxlayacq

    private int id;
    private String email;
    private String username;
    private String password;

    private Classes classes;//bu ise teacherin sinif rehberi oldugu sinifdir

    private boolean isBlocked = false;


//constructoru yeniden yaradaq


    public Teacher(int id, String email, String username, String password, Classes classes, double salary, String name, String surname, LocalDate birthDate) {
        super(salary, name, surname, birthDate);
        this.id = id;
        this.email = email;
        this.username = username;
        this.classes = classes;
        this.password = password;
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

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
    public void blockTeacher(){//block methoidlarini teacherede elave edek
        this.isBlocked=true;
        System.out.println("Teacher :"+this.id+" "+this.username+" "+ "has been blocked!!!");
    }

    public void unBlockTeacher(){
        this.isBlocked=false;
        System.out.println("Teacher :"+this.id+" "+this.username+" "+ "has been unblocked!!!");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "[id]=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", classes=" + classes +
                ", isBlocked=" + isBlocked +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}'+"\n";//eyni studentde oldugu kimi
    }
}