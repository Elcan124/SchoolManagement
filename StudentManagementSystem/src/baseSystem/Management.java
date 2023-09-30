package baseSystem;

import exception.AppException;
import  static exception.EnumException.*;
import globalDatas.GlobalData;
import menuEnums.AdminMenu;
import menuEnums.StudentMenu;
import menuEnums.TeacherMenu;
import service.AdminServiceInter;
import service.StudentServiceInter;
import service.TeacherServiceInter;
import service.impl.AdminServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;
import users.Person;
import users.Student;
import util.Util;

import java.sql.SQLOutput;

public class Management implements ManagementServiceInter {


    AdminServiceInter adminService = new AdminServiceImpl();

    StudentServiceInter studentService = new StudentServiceImpl();

    TeacherServiceInter teacherService = new TeacherServiceImpl();

    @Override
    public boolean adminSpecification() {
        printMenuForAdmin();
        boolean backToLogin = false;
        //menu çap olundu daha sonra bir option almaliyam
        int option = Util.requireInt("Please insert option :");
        int id = 0;
        boolean isTeacherOrStudentValid;
        switch (option) {
            case 1:
                adminService.addStudent();
                break;
            case 2:
                adminService.addTeacher();
                break;

            case 3:
                isTeacherOrStudentValid = Util.printUsersExceptAdmin();

                try{
                   if(!isTeacherOrStudentValid){
                       throw new AppException(USER_NOT_FOUND_EXCEPTION);
                   }

                        int userId = Util.requireInt("Please insert users id which you want to delete");
                        adminService.deleteUserById(userId);


                }catch (AppException ex){
                    System.out.println(ex.getMessage());
                }

                break;

            case 4:
                adminService.updateUserById(id);
                break;
            case 5:
                isTeacherOrStudentValid = Util.printUnBlockedUsersExceptAdmin();//yuxarida yaratdim ki her defe yeni vairable yaratmayim
                if (isTeacherOrStudentValid) {//clientden idni alaq
                    int userId = Util.requireInt("Please insert users id which you want to block");
                    adminService.blockUserById(userId);//idni aldim keçek implementasiyasini yazmaga
                } else {
                    System.out.println("There is no Student or Teacher in System");
                }


                break;
            case 6:
                isTeacherOrStudentValid = Util.printBlockedUsersExceptAdmin();//yuxarida yaratdim ki her defe yeni vairable yaratmayim
                if (isTeacherOrStudentValid) {//clientden idni alaq
                    int userId = Util.requireInt("Please insert users id which you want to unBlock");
                    adminService.openBlockById(userId);
                } else {
                    System.out.println("There is no Student or Teacher in System");
                }

                break;
            case 7:
                String name = Util.requireString("Please enter name for search");
                adminService.searchUserByName(name);
                break;
            case 8:
                adminService.changePasswordById(1);
                break;
            case 9:
                adminService.searchUserById(121321);//yeniki bunlar ele bele deyerlerdir  error vermesin deye elimle daxil edirem
                break;
            case 10:
                backToLogin = adminService.backToLogin();
                return backToLogin;//retun vermisem deye breake hec gire bilmeyecek xeta verirdi ona gore


            case 0:
                adminService.exit();
                break;

            default:
                System.out.println("Wrong option!!!!");
        }


        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            System.out.println(GlobalData.personDinamicArray.get(i).getName() + " " + GlobalData.personDinamicArray.get(i).getBirthDate());
        }//burada çap edecem gorum düzgün elave edibdirmi
        return true;
    }

    @Override
    public boolean teacherSpecification() {
        printTeacherMenu();
        int option = Util.requireInt("Please insert option");

        switch (option) {
            case 1:
                teacherService.seeAllStudents();

                break;
            case 2:
                teacherService.seeAllClasses();
                break;
            case 3:
                teacherService.addStudentToClass();
                break;
            case 4:
                return teacherService.backToLogin();

            case 5:
                teacherService.exit();
            default:
                System.out.println("Wrong input");


        }


        return true;
    }

    @Override
    public boolean studentSpecification(Person loggedInPerson) {//method parametr dondersn ki o biri terefde yoxlaya bilim siz istenesiz inte gorede neyise yoxlaya bnilerisniz meseelen method 1 dondurubse demeli backtologin isteyir falan men booleanla edirem
        printMenuForStudent();
        int option = Util.requireInt("Please insert option ");
        switch (option) {
            case 1:
                studentService.seeOwnInfo(loggedInPerson);
                break;
            case 2:
                studentService.resetPassword(loggedInPerson);
                break;
            case 3:
                return studentService.backToLogin();

            case 0:
                studentService.exit();
                break;
            default:
                System.out.println("Wrong input!!!!!!!!");


        }
        return true;//problem burdadır en sonra false yox true qaytarmalıdır ki whileden cixmasin true dedikde backtologin true olur cixir whiledan
    }
    /*
      SEE_OWN_INFO(1, "See own info"),
    RESET_PASSWORD(2 , "Reset password"),
    BACK_TO_LOGIN(3 , "Back to login"),
    EXIT(0 , "EXIT!");
     */

    private void printMenuForAdmin() {
        for (AdminMenu adminMenu : AdminMenu.values()) {

            System.out.println("[" + adminMenu.getId() + "]" + ":------>>> " + adminMenu.getOption());
        }

        //adminden basqa butun userleri çap elemek üçün method yazaq static methid olsun


    }

    private void printMenuForStudent() {


        for (StudentMenu studentMenu : StudentMenu.values()) {

            System.out.println("[" + studentMenu.getId() + "]" + ":------>>> " + studentMenu.getOption());

        }
    }

    private void printTeacherMenu() {
        for (TeacherMenu teacherMenu : TeacherMenu.values()) {
            System.out.println("[" + teacherMenu.getId() + "]" + "------>>>> " + teacherMenu.getOption());
        }

    }
}
