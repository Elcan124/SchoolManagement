package service.impl;

import service.StudentServiceInter;
import users.Person;
import users.Student;
import util.Util;

import java.sql.SQLOutput;

public class StudentServiceImpl implements StudentServiceInter {
    @Override
    public void seeOwnInfo(Person person) {

        Student student = (Student) person ;
        System.out.println(student);
    }

    @Override
    public void resetPassword(Person person) {//reset password hissesi buirada da PErosnu (studenti) parametr kmi oturek
        //cast etmeyi unutduq yoxsa password fieldini gormeyeceyik
        Student student = (Student) person;
        String oldPassword = Util.requireString("Please insert old password");

        if(oldPassword.equals(student.getPassword())){
            String newPassword = Util.requireString("Please insert new password");//burada yeni sifreni alaq daha sonra setPAssword methodunu cagirib set edek
            student.setPassword(newPassword);//yeni passwordu set etdik
            System.out.println("Password has been changed !!");
        }else{//kohne sifreni duzgun daxil etmese return deyek methoddan cixaq
            return;//back to logini duzeldek
        }


    }

    @Override
    public boolean backToLogin() {
    return false;
    }

    @Override
    public void exit() {

    }
}
