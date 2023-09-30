import baseSystem.GlobalStrings;
import baseSystem.Management;
import baseSystem.ManagementServiceInter;
import exception.AppException;
import globalDatas.GlobalData;
import menuEnums.FirstMenyu;
import service.LoginServiceInter;
import service.impl.LoginServiceImpl;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;
import util.FileUtils;
import util.Util;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class Main {//bura kimi her sey əla diger serviceleri yazmaga çalışın video çox uzun oldu dersde qalanlarina baxariq bura kimi her sey okeydirse yeni seyleri rahatliqla elave ede bileceyik excpetionlari dersde elave ederik ve diger serciveleri bitirerik esas odu bura kimi baxib mentiqi tutdunsa fso sen hamisini yaza bilersen artiq )      helelik...

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<String>(10000);





        //evvel student elave edib sonra silecem // indi admin block etsin daha sonra student kimi login olmaya calisq amaki back to logi methodunu tamamlayaq once
        LoginServiceInter loginService = new LoginServiceImpl();

        ManagementServiceInter managementService = new Management();
        for(int i = 0  ; i< GlobalData.personDinamicArray.getSize();i++){
            System.out.println(GlobalData.personDinamicArray.get(i));
        }
        while (true) {//sonsuz while dongusu icerisine saldim
            for (FirstMenyu menu : FirstMenyu.values()) {

                System.out.println("[" + menu.getId() + "]" + ":------>>> " + menu.getOption());
            }
            int option = 0 ;
            try{
                option = Util.requireInt("Please select option:");
            }catch (InputMismatchException ex){
                System.out.println("Wrong input please insert again ");
                continue;
            }

            Person loggedInPerson = null;
            switch (option) {//break yazmamışam gedir case 0-a ve programı sonlandırır mende deirem niye hecne cap etmir (

                case 1:
                    String username = Util.requireString("Please enter username::");
                    boolean backToLogin = true;
                    loggedInPerson = loginService.login(username);//nezere almamisiq burda
                    GlobalData.loggedInPerson = loggedInPerson;




                    if (loggedInPerson != null) {//bu serti de elave edek persoon nulldan ferqlidirse girsin buraya
                        String log ="Person logged in with name: "+ loggedInPerson.getName()+" " + loggedInPerson.getSurname() + " " + "Time: "+ LocalDateTime.now().toString();
                        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME , log);
                        if (loggedInPerson instanceof Admin) {
                            //bu zaman admin methodunu çağıracam isimizi methoidlara ayırırq ki rahat olsun!
                            System.out.println("Welcome dear " + loggedInPerson.getName());
                            while (backToLogin) { // backtologin trueden ferqlidirse sonsuz devam elesin
                                backToLogin = managementService.adminSpecification();//əla isledi welcomu basqa yerde yazaq
                            }

                        } else if (loggedInPerson instanceof Teacher) {
                            while (backToLogin) {
                                System.out.println("Welcome dear " + loggedInPerson.getName());
                              backToLogin =  managementService.teacherSpecification();
                            }
                        } else if (loggedInPerson instanceof Student) {//bura qeder hersey əla
                            while (backToLogin) {
                                System.out.println("Welcome dear " + loggedInPerson.getName());//burada true yox artiq methoddan qayidani yocxlayaq
                                backToLogin = managementService.studentSpecification(loggedInPerson);//indi isteyirsiz test edek

                            }
                        }

                    }

                    break;
                case 0:
                    FileUtils.saveAll(GlobalStrings.SAVE_FILE_NAME);
                    FileUtils.saveAllClasses(GlobalStrings.SAVE_CLASSES_FILE_NAME);
                    loginService.exit();
                    break;
                default:
                    System.out.println("Wrong option");

            }//bu qeder logini qutardiq sonunda studentdeki xetalari düzletdik teacher üçünde eynisini edek


        }//test edek eger sistemde teacher ve ya student yoxdursa o zaman cap edecekki yoxdur


    }
}