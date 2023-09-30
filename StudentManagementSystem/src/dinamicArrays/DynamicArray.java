package dinamicArrays;

import users.Person;

import java.io.Serializable;

public class DynamicArray<T> implements Serializable {

    public Object[] array;

    public DynamicArray() {
        array = new Object[0];
    }


    public void add(T person) {
        Object[] newPersons = new Object[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newPersons[i] = array[i];
        }
        newPersons[array.length] = person;

        array = newPersons;

    }

    public void delete(int index) throws IllegalArgumentException{
        if(index<0 || index>= array.length){
            throw new IllegalArgumentException("Out of index");
        }
        Object[] newArray = new Object[array.length-1];

        for(int i = 0, k = 0; i< array.length ; i++){
            if(i==index){
                continue;
            }

            newArray[k++]= array[i];


        }
        array =newArray;



    }
    public T get(int index){
        if(index<0 || index>= array.length){//oz exception classarımızı sonradan yazib tetbig edeceyik
            throw new IllegalArgumentException();
        }
        return (T) array[index];

    }
    public int getSize(){

        return array.length;
    }

}
