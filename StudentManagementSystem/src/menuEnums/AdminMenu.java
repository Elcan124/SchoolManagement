package menuEnums;

public enum AdminMenu { // student menunuda yazaq sonra test merhelesine keçek
    ADD_STUDENT(1 , "Add Student"),
    ADD_TEACHER(2 , "Add Teacher"),
    DELETE_USER_BY_ID(3 ,"Delete User by ID"),
    UPDATE_USER_BY_ID(4, "Update User by ID"),
    BLOCK_STUDENT_BY_ID(5 , "Block Student by ID"),
    OPEN_BLOCK_BY_ID(6 , "Open Block by ID"),
    SEARCH_USER_BY_NAME(7 , "Search User by Name"),
    CHANGE_PASSWORD(8 , "Change password for any User"),
    SEARCH_USER_BY_ID(9 , "Search User by Id"),
    BACK_TO_LOGIN(10, "Back to login"),
    EXIT(0 , "EXIT!!!");


    private int id;
    private String option;

    AdminMenu(int id, String option) {
        this.id = id;
        this.option = option;

    }
//getter


    public int getId() {
        return id;
    }

    public String getOption() {
        return option;
    }
}
/*
                           <1> Add Student ->>>> Student elave etmek imkanı
                           <2> Add Teacher ->>>> teacher elave  etmek  imkanı
                           <3> Delete User by ID ->>>> İdye gore istenilen istifadeçini  silmə imkanı

                           <5> Update Student by İd->>>> idye gore istenilen useri update etmek imkanı

                           <7> Block User by İD ->>>> idye gore istenilen  useri blocklama imkanı

                           <9> Open Block by ID // idye gore istenilen useri blocklama imkani
                           <10> Search User (by Name) // ada gore user axtarma imkanı

                           <12>Change password for any User // istenilen userin passwordunu deyisme imkani
                           <13> Search User (by ID) // Idye gore user axtarmaq

                           <15> Back to Log in
                           <0> Exit!
 */