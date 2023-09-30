package service;

import users.Person;

public interface StudentServiceInter {
    void seeOwnInfo(Person person);
    void resetPassword(Person person);
    boolean backToLogin();
    void exit();

}
