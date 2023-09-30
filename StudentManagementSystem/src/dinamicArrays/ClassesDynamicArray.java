package dinamicArrays;

import classes.Classes;
import users.Person;

import java.io.Serializable;

public class ClassesDynamicArray implements Serializable {

        public Classes[] classes;

        public ClassesDynamicArray() {
            classes = new Classes[0];
        }


        public void add(Classes cls) {
            Classes[] newClases = new Classes[classes.length + 1];

            for (int i = 0; i < classes.length; i++) {
                newClases[i] = classes[i];
            }
            newClases[classes.length] = cls;

            classes = newClases;

        }

        public void delete(int index) throws IllegalArgumentException {
            if (index < 0 || index >= classes.length) {
                throw new IllegalArgumentException("Out of index");
            }
            Classes[] newArray = new Classes[classes.length - 1];

            for (int i = 0, k = 0; i < classes.length; i++) {
                if (i == index) {
                    continue;
                }

                newArray[k++] = classes[i];


            }
            classes = newArray;


        } //get methodunu yazaq

        public Classes get(int index) {
            if (index < 0 || index >= classes.length) {
                throw new IllegalArgumentException();
            }
            return classes[index];

        }

        public int getSize() {

            return classes.length;
        }


    }

