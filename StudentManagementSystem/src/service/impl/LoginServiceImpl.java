package service.impl;

import globalDatas.GlobalData;
import service.LoginServiceInter;
import users.Admin;
import users.Person;
import users.Student;
import users.Teacher;
import util.Util;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public class LoginServiceImpl implements LoginServiceInter { // login methodunu düzeldek bizden username istesin bele bir username  varsa daha sonra password istesin
    @Override
    public Person login(String username) {
        boolean isFounded = false;//boolean olaraq yaratdim eger tapilmadisa falsedi tapilsa true edecem
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);//dincamic arrayden bir bir Personları çekirem daha sonra username ile yoxlayacam
            if (person instanceof Admin) {
                Admin admin = (Admin) person;//eger çekdiyim person admindirse usernamesine gore yoxlayaq
                if (admin.getUsername().equals(username)) {

                    isFounded = true;
                   return  checkPasswordAdmin(admin);


                }
            } else if (person instanceof Student) {//burada çekdiyimiz personun student olub olmadiggini yoxlayaq daha sonra logine keçek
                Student student = (Student) person;
                if (student.getUsername().equals(username)) {//studentde yoxlayaq
                    isFounded = true;

                    if(student.isBlocked()){
                        System.out.println("You have been blocked please contact with admin");
                       //retun null yazsaq kifayetdir diger terefde nezere almisdiq nulla gore sehv xatirlamiramsa
                        return null;

                    }

                  //burada yazmisiq deye bizden ancaq bir defe teleb edecek passwordu
                    for (int j = 2; j >= 0; j--) {//tersden azaldaq ve else hissesine cap eden duzgun goruinsun
                        String password = Util.requireString("Please insert password:");
                        boolean banUser = false;
                        if (password.equals(student.getPassword())) {
                            return student;

                        } else {
                            System.out.println("Wrong password " + j + " attemps left");

                        }
                        if (j == 0) {//burada da eger j 0-a beraber olarsa ban edecek studenti
                            student.blockStudent();
                            System.out.println("You have been blocked please contact with admin");
                            return null;
                        }

                    }//burada yoxlayaq eger 3 defe sehv yazibsa blocklayaq


                }
            } else if (person instanceof Teacher) {//burada videonu dondurub siz ede bilersiniz daha sonra açın baxin
                Teacher teacher = (Teacher) person;
                if (teacher.getUsername().equals(username)) {
                    isFounded=true;
                    if(teacher.isBlocked()){
                        System.out.println("You have been blocked please contact with admin");
                        return null;
                    }

                    for (int j = 2; j >= 0; j--) {
                        String password = Util.requireString("Please insert password:");
                        boolean banUser = false;
                        if (password.equals(teacher.getPassword())) {//teacher get passwordu methodunu yaradaq
                            return teacher;

                        } else {
                            System.out.println("Wrong password " + j + " attemps left");

                        }
                        if (j == 0) {//burada da eger j 0-a beraber olarsa ban edecek studenti
                            teacher.blockTeacher();
                            System.out.println("You have been blocked please contact with admin");
                            return null;
                        }

                    }//burada yoxlayaq eger 3 defe sehv yazibsa blocklayaq


                }//login methodu çox qarışıq oldu bunu dersde daha optimal nece yaza bilerik ona baxarıq.


            }


        }
        if(isFounded==false){
            System.out.println("Cannot find user with this username ");
        }

        return null; //test edek
    }

    @Override
    public void exit() {//exit dedikde bu method çağırılsın
        System.out.println("Program closed good byee!!!");
         System.exit(0);
    }

    private Admin checkPasswordAdmin(Admin admin ) {



            String password = Util.requireString("Please insert password:");
            if (password.equals(admin.getPassword())) {

                return admin;
            }
  return null;
    }
}
