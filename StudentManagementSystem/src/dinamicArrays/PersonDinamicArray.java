package dinamicArrays;

import users.Person;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public class PersonDinamicArray implements Serializable {

    public Person[] persons;

    public PersonDinamicArray() {
        persons = new Person[0];
    }


    public void add(Person person) {
        Person[] newPersons = Arrays.copyOf(persons , persons.length+1);

        for (int i = 0; i < persons.length; i++) {
            newPersons[i] = persons[i];
        }
        newPersons[persons.length] = person;

        persons = newPersons;

    }//diger methodalr; da yazaq +delete methodu da elave oluncaq indexe gore sileceyik deleteni yazaq ele

    public void delete(int index) throws IllegalArgumentException{
        if(index<0 || index>=persons.length){
            throw new IllegalArgumentException("Out of index");
        }
        Person[] newArray = new Person[persons.length-1];

        for(int i = 0 , k=0; i< persons.length ; i++){
            if(i==index){
                continue;
            }

            newArray[k++]=persons[i];


        }
         persons=newArray;



    } //get methodunu yazaq

    public Person get(int index){
        if(index<0 || index>=persons.length){//oz exception classarımızı sonradan yazib tetbig edeceyik
           throw new IllegalArgumentException();
        }
        return persons[index];

    }
    public int getSize(){

        return persons.length;
    }

}
