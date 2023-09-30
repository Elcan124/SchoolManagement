package menuEnums;

public enum StudentMenu { // test merhelesine keçek admin menuyu test edek digerleri de eyni seydi onsuz
    SEE_OWN_INFO(1, "See own info"),
    RESET_PASSWORD(2 , "Reset password"),
    BACK_TO_LOGIN(3 , "Back to login"),
    EXIT(0 , "EXIT!");

    private int id;
    private String option;

    StudentMenu(int id, String option){
        this.id=id;
        this.option=option;

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
Student kimi login olubsa:
[1] : See own info // sadece ozu haqqinda melumatlari gore biler
[2] : Reset password //şifrəsini dəyişdirə bilər
[3] : Back to login // login sehifesine geri qayit
[4] : Exit!!! //sistemdən çıxış
 */