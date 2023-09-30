package util;

import classes.Classes;
import dinamicArrays.ClassesDynamicArray;
import dinamicArrays.PersonDinamicArray;
import globalDatas.GlobalData;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

    public static PersonDinamicArray readAll(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            PersonDinamicArray personDinamicArray = (PersonDinamicArray) objectInputStream.readObject();

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

    public static ClassesDynamicArray readClassesDynamicArray(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            ClassesDynamicArray classesDynamicArray = (ClassesDynamicArray) objectInputStream.readObject();

            return classesDynamicArray;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

}
