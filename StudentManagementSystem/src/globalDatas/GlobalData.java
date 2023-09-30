package globalDatas;

import baseSystem.GlobalStrings;
import classes.Classes;
import dinamicArrays.ClassesDynamicArray;
import dinamicArrays.DynamicArray;
import dinamicArrays.PersonDinamicArray;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;
import util.FileUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GlobalData {//password fieldları yaddan çixib //idler sehv verirdi onuda duzeldek
    public static final String fileName = "persons.ser";
    public static int id;
    public static Person loggedInPerson = null;

    public static ArrayList<Classes> classesDynamicArray;

    public static ArrayList<Person> personDinamicArray;//dinamic array obyektimizi yaratdiq static blockda admin elave edek

    //id üçünde static deyerimiz olsun ve idni oradan çekek id unique olmalıdır her user (person) üçün ferqli
    static {

        personDinamicArray = FileUtils.readAll(GlobalStrings.SAVE_FILE_NAME);
        id = personDinamicArray.size();
        classesDynamicArray = FileUtils.readClassesDynamicArray(GlobalStrings.SAVE_CLASSES_FILE_NAME);


    }//program run olan zaman ilk admini yaradib personDincamic arraye elave edecekdir daha açıqlayıcı yazsaq
}
