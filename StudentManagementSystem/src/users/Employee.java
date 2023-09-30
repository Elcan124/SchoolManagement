package users;

import java.time.LocalDate;

public abstract class Employee  extends Person{


     private double salary;
//super keyword vasitesile Employeenin super classına yəni PErsona name surname ve birthdateni oturek!
    public Employee(double salary  , String name  , String surname , LocalDate birthDate) {
        super(name , surname , birthDate);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
