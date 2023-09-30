package service.impl;

import baseSystem.GlobalStrings;
import classes.Classes;
import exception.AppException;
import exception.EnumException;
import globalDatas.GlobalData;
import service.AdminServiceInter;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;
import util.FileUtils;
import util.Util;


import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Random;

import static exception.EnumException.CLASSES_NOT_FOUND_EXCEPTION;

public class AdminServiceImpl implements AdminServiceInter {//keçek studente qalanları qalsın


    @Override
    public void addStudent() { //int id, String email, String username ,String password ,String name, String surname, LocalDate birthDate
        String email = Util.requireString("Please insert email");
        String password = Util.requireString("Please insert pasword");
        String name = Util.requireString("Please insert name");
        String surname = Util.requireString("Please insert surname");//usernameni random yaradaq unique olsun bunun üçün bir method yazaq
        String username = getUsername(name, surname);//indi ise yaŞ hissesnie keçek bunun üçünde methiod yaradacam
        LocalDate birthDay = getBirthDate();//okay bütün fieldlari doldurduq gelek studenti yaradaq
        int id = GlobalData.id++;
        Student student = new Student(id, email, username, password, name, surname, birthDay);//dinamic arraye add etmeyi unutmayaq
        GlobalData.personDinamicArray.add(student);
        String log = "New Student added with this id: " + id + "  Username:" + username + " Time: " + LocalDateTime.now();
        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);

        System.out.println("Student " + name + " added succesfully!  \n" + "Username: " + username + "Password: " + password);


    }//elave edenden sonra username ve passwordu da çap elesin //indi admin menyusunu while-a salaq


    @Override
    public void addTeacher() {//salary classes
try {
    String email = Util.requireString("Please insert email");
    String password = Util.requireString("Please insert pasword");
    String name = Util.requireString("Please insert name");
    String surname = Util.requireString("Please insert surname");
    double salary = Util.requireDouble("Please insert salary");
    String username = getUsername(name, surname);//indi ise yaŞ hissesnie keçek bunun üçünde methiod yaradacam
    LocalDate birthDay = getBirthDate();//okay bütün fieldlari doldurduq gelek studenti yaradaq
    Classes classes = getClasses();
    if (classes == null) {
        throw new AppException(CLASSES_NOT_FOUND_EXCEPTION);
    }

    int id = GlobalData.id++;
    Teacher teacher = new Teacher(id, email, username, password, classes, salary, name, surname, birthDay);//dinamic arraye add etmeyi unutmayaq
    GlobalData.personDinamicArray.add(teacher);
    String log = "New Teacher added with this id: " + id + "  Username:" + username + " Time: " + LocalDateTime.now();
    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);

    System.out.println("Teacher " + name + " added succesfully!  \n" + "Username: " + username + "Password: " + password);
}catch (AppException ex){
    System.out.println(ex.getMessage());
}

    }

    @Override
    public void deleteUserById(int id) {//bir deyisen yaradaq hetta boolean yaradaq

        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {//yene cast etmeliyik çünki Studention yada teacherin icindeki idni gormeyecem
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == id) {//artiuq bu şerte girecekse men bilecem ki demeli tapib o zaman isfoundedi true edim

                    GlobalData.personDinamicArray.delete(i);//egerki i-ninci yerde duran personun (studentin) id-si parametr kimi oturduyum idye beraberdirse o zaman delete etsin hemin i-ninci yerde duran elementi
                    String log = "User deleted with this id:" + id + " " + person.getName() + " " + person.getSurname() + "Time: " + LocalDateTime.now();

                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                    System.out.println("Student with id: " + student.getId() + " has been deleted succesfully!");
                    return;
                }
            }
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getId() == id) {
                    GlobalData.personDinamicArray.delete(i);
                    System.out.println("Teacher with id: " + teacher.getId() + " has been deleted succesfully!");//burda da melumat üçün çap edek
                    return;
                }
            }
        }

    }

    @Override
    public void updateUserById(int id) {


    }

    @Override
    public void blockUserById(int id) {
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == id) {
                    student.blockStudent();//bloack student methodunu cagirdim ve student blocklanacaqdir
                    System.out.println("Student with id: " + student.getId() + "  has been blocked!!");
                    Admin admin = (Admin) GlobalData.loggedInPerson;
                    String log = "Student with id: " + student.getId() + "  has been blocked!!" + " Time:" + LocalDateTime.now() + " By admin:" + admin.getUsername();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                }
                if (person instanceof Teacher) {
                    Teacher teacher = (Teacher) person;
                    if (teacher.getId() == id) {
                        teacher.blockTeacher();//eyni qayda ile teacher ucunde
                        System.out.println("Teacher with id: " + student.getId() + "  has been blocked!!");
                        Admin admin = (Admin) GlobalData.loggedInPerson;
                        String log = "Teacher with id: " + teacher.getId() + "  has been blocked!!" + " Time:" + LocalDateTime.now() + " By admin:" + admin.getUsername();
                        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                    }


                }//test edek amaki loginde bunu nezere almamIşıq nezere alaq
            }
        }


    }

    @Override
    public void openBlockById(int id) {

        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == id) {
                    student.unBlockStudent();//bloack student methodunu cagirdim ve student blocklanacaqdir
                    System.out.println("Student with id: " + student.getId() + "  has been unblocked!!");
                    Admin admin = (Admin) GlobalData.loggedInPerson;
                    String log = "Student with id: " + student.getId() + "  has been unblocked!!" + " Time:" + LocalDateTime.now() + " By admin:" + admin.getUsername();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                }
                if (person instanceof Teacher) {
                    Teacher teacher = (Teacher) person;
                    if (teacher.getId() == id) {
                        teacher.unBlockTeacher();//eyni qayda ile teacher ucunde
                        System.out.println("Teacher with id: " + student.getId() + "  has been unblocked!!");
                        Admin admin = (Admin) GlobalData.loggedInPerson;
                        String log = "Teacher with id: " + teacher.getId() + "  has been unblocked!!" + " Time:" + LocalDateTime.now() + " By admin:" + admin.getUsername();
                        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                    }


                }//test edek amaki loginde bunu nezere almamIşıq nezere alaq
            }
        }

    }

    @Override
    public void searchUserByName(String name) {
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            String lowerName = name.toLowerCase();
            String personName = person.getName().toLowerCase();
            if (personName.contains(lowerName)) {
                System.out.println(person);
            }

        }


    }

    @Override
    public void changePasswordById(int id) {//bütün userlerin passwordunu deyissin

    }

    @Override
    public void searchUserById(int id) {//id ni daxil edim ve useri cap elesin

    }

    @Override
    public boolean backToLogin() {

        return false;

    }

    @Override
    public void exit() {
        FileUtils.saveAll(GlobalData.fileName);

        System.exit(0);
    }//bu interfaceni implement etmelidir //methidalri override etmeye mecbur edir


    private String getUsername(String name, String surname) {
//random class;ndan istifade edek
        Random random = new Random();

        int randomNumber = random.nextInt(10000);
        String username = name.substring(0, 3) + surname.substring(0, 4) + randomNumber;
        return username;
    }

    private LocalDate getBirthDate() {
        //istifadeciden 3 deyisen il ay gün alacam
        int year = Util.requireInt("Please insert birth year");
        int month = Util.requireInt("Please insert birth month");
        int day = Util.requireInt("Please insert birth day");
        return LocalDate.of(year, month, day);

    }


    private Classes getClasses(){
        Util.printClasses();
        String className = Util.requireString("Please insert classname which you want to add Teacher");
        for(int i = 0 ; i<GlobalData.classesDynamicArray.getSize();i++){
            Classes classes = GlobalData.classesDynamicArray.get(i);
            if(classes.getName().equalsIgnoreCase(className)){
                return classes;
            }

        }
        return null;
    }
}
