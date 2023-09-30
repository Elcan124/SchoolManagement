package menuEnums;

public enum FirstMenyu {
    LOGIN(1, "Login"), EXIT(0, "Exit!");  //ve bunların idsi olsun birde String tipinde açıqlaması

    private int id;
    private String option;


    FirstMenyu(int id, String option) { // ötürülen parametrlerle field adı eyni oldugu üçün this keywordunde istifade etdik
        this.id = id;
        this.option = option;
    }

    //getter methodu yazaq Settere ehtiyac yoxdur onsuz bunlar static melummatalrdi

    public String getOption(){

        return this.option;//this. yazsaqda olar yazmasaqda hansisa parametr oturmemişik ki onunla conflict versin ona gore ferqi yoxdu
    }

    public int getId(){

        return id;

    }
    }








/*
Ilk menyu Login:
[1] : Login
[2] : Exit

ikinci menyu : Userin Admin Student yada Teacher kimi login olmasından asılı olaraq dəyişilir


Student kimi login olubsa:
[1] : See own info // sadece ozu haqqinda melumatlari gore biler
[2] : Reset password //şifrəsini dəyişdirə bilər
[3] : Back to login // login sehifesine geri qayit
[4] : Exit!!! //sistemdən çıxış

Admin kimi login olubsa :
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

Teacher kimi login olmuşsa aşağıdakıları ede biler :
          <1> : See all Students ->>>> bütün Studentleri görmə imkanı
          <2> : See All classes ->>>> bütün Classları görmə imkanı
          <3> : Add Student to class ->>>> her hansısa classa student əlavə etmək imkanı
          <4> : Back to login ->>>> login sehifesni geri qayıtmaq
          <0> : Exit! ->>>> Sistemden çıxış



 */