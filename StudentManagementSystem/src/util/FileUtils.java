package util;

import classes.Classes;
import dinamicArrays.ClassesDynamicArray;
import dinamicArrays.PersonDinamicArray;
import globalDatas.GlobalData;
import users.Person;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileUtils {


    public static void saveAll(String fileName) {//"test.txt
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {

            objectOutputStream.writeObject(GlobalData.personDinamicArray);
            objectOutputStream.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public static ArrayList<Person> readAll(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            ArrayList<Person> personDinamicArray = (ArrayList<Person>) objectInputStream.readObject();

            return personDinamicArray;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    public static void writeLogToFile(String fileName, String log) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));

            bufferedWriter.write(log);
            bufferedWriter.newLine();

            bufferedWriter.flush();

            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }


    public static void saveAllClasses(String fileName) {//classes.ser
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {

            objectOutputStream.writeObject(GlobalData.classesDynamicArray);
            objectOutputStream.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public static ArrayList<Classes> readClassesDynamicArray(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            ArrayList<Classes> classesDynamicArray = (ArrayList<Classes>) objectInputStream.readObject();

            return classesDynamicArray;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

}
