package menuEnums;

public enum TeacherMenu {//bu cür yazdıq  eyni qaydada keçek admini de yazaq sonra test edek
    SEE_ALL_STUDENTS(1, "See All Students"),
    SEE_ALL_CLASSES(2, "See all classes"),
    ADD_STUDENT_TO_CLASS(3, "Add Student to class"),
    BACK_TO_LOGIN(4, "Back to login"),
    EXIT(0, "Exit!!!");

    private int id;
    private String option;

    TeacherMenu(int id, String option) {
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
  <1> : See all Students ->>>> bütün Studentleri görmə imkanı
          <2> : See All classes ->>>> bütün Classları görmə imkanı
          <3> : Add Student to class ->>>> her hansısa classa student əlavə etmək imkanı
          <4> : Back to login ->>>> login sehifesni geri qayıtmaq
          <0> : Exit! ->>>> Sistemden çıxış
 */