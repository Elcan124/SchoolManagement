package users;

import java.io.Serializable;
import java.time.LocalDate;

public  abstract class Person implements Serializable { //her bir personda ad soyad ve dogum tarixi vardır
   protected String name;
   protected String surname;
   protected LocalDate birthDate;

    public Person(String name, String surname, LocalDate birthDate) {//avtomatik personda consturctoru yaratdim

        this.name = name;
        this.surname=surname;
        this.birthDate=birthDate;
    }

    //constructor hissesni sonra yaradacam //yaratdim




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
