package service;

public interface AdminServiceInter {
    void addStudent();//method adlari balaca ((
    void addTeacher();
    void deleteUserById(int id);//bu method parametr kimi id qebul etmelidir çünki men idsine gore silirem
    void updateUserById(int id);
    void blockUserById(int id);//burada student yox user yazdim çünki dmin teacheride studenti de block ede biler
    void openBlockById(int id);
    void searchUserByName(String name);//ada gore axtaris parametr kimi string qebul edirme çünki name strngdir
    void changePasswordById(int id);
    void searchUserById(int id);
    boolean backToLogin();
    void exit(); //dediyim kimibu methodların tipi deyisile biler return typeları ola biler yazdigca goreceyik helelik hamisini void eledim!

}
