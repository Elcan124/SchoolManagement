package util;

import globalDatas.GlobalData;
import users.Person;
import users.Student;
import users.Teacher;

import java.util.Scanner;

public class Util {
    public static int requireInt(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + ":");
        int result = sc.nextInt();

        return result;


    }//bu method yeqinki hamiya aydindir parametr olaraq string oytururem ve içeride clientdan int deyeri aliram
    public static double requireDouble(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + ":");
        double result = sc.nextDouble();

        return result;


    }
    public static String requireString(String title) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(title + ":");
        String result = scanner.nextLine();
        return result;
    }//clientdan string almaq üçün methodumuzu da yaratdiq


    public static boolean printUsersExceptAdmin() {//methoid geriye boolean qaytarsinki o biri terefde yoxclaya bilim
        boolean isFounded = false;
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);//dinamic arrayden cekdiyim useri perosna menimsedirem ki birde her deye GlobalData.personsdinamicarray.get(i) demeyek kodu qısaldaq
            if (person instanceof Student) {//eger person Student tipindedirse o zaman çap elesin bunun üçün studentde method yazaq
                Student student = (Student) person;
                isFounded = true;
                System.out.println(student);//studentin toString methodu cagirilacaqdir

            }//maraqlıdı dayandirim pproblemi tapim izah edecem
            if (person instanceof Teacher) {
                isFounded = true;//bu sekilde bilecek ki sistemde en azi bir user var(student veya teacher)
                Teacher teacher = (Teacher) person;
                System.out.println(teacher);//teacher üçünde tostringi elave edek ki melumatlari cap elesin
            }

        }

        return isFounded;
    }

    public static boolean printUnBlockedUsersExceptAdmin() {//methoid geriye boolean qaytarsinki o biri terefde yoxclaya bilim
        boolean isFounded = false;
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);//dinamic arrayden cekdiyim useri perosna menimsedirem ki birde her deye GlobalData.personsdinamicarray.get(i) demeyek kodu qısaldaq
            if (person instanceof Student) {

                Student student = (Student) person;
                if (!student.isBlocked()) {
                    isFounded = true;
                    System.out.println(student);//studentin toString methodu cagirilacaqdir
                }
            }//maraqlıdı dayandirim pproblemi tapim izah edecem
            if (person instanceof Teacher) {
                //bu sekilde bilecek ki sistemde en azi bir user var(student veya teacher)
                Teacher teacher = (Teacher) person;
                if (!teacher.isBlocked()) {
                    System.out.println(teacher);
                    isFounded = true;
                }
                //teacher üçünde tostringi elave edek ki melumatlari cap elesin
            }

        }

        return isFounded;
    }

    public static boolean printBlockedUsersExceptAdmin() {//methoid geriye boolean qaytarsinki o biri terefde yoxclaya bilim
        boolean isFounded = false;
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);//dinamic arrayden cekdiyim useri perosna menimsedirem ki birde her deye GlobalData.personsdinamicarray.get(i) demeyek kodu qısaldaq
            if (person instanceof Student) {

                Student student = (Student) person;
                if (student.isBlocked()) {
                    isFounded = true;
                    System.out.println(student);//studentin toString methodu cagirilacaqdir
                }
            }//maraqlıdı dayandirim pproblemi tapim izah edecem
            if (person instanceof Teacher) {
                //bu sekilde bilecek ki sistemde en azi bir user var(student veya teacher)
                Teacher teacher = (Teacher) person;
                if (teacher.isBlocked()) {
                    System.out.println(teacher);
                    isFounded = true;
                }
                //teacher üçünde tostringi elave edek ki melumatlari cap elesin
            }

        }

        return isFounded;
    }

    public static boolean printStudents() {
        boolean isFounded = false;
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                isFounded = true;
                System.out.println(student);
            }
        }
        return isFounded;
    }

    public static void printClasses() {
        for (int i = 0; i < GlobalData.classesDynamicArray.getSize(); i++) {
            System.out.println(GlobalData.classesDynamicArray.get(i).getName());
        }
    }


}
