package baseSystem;

import users.Person;

public interface ManagementServiceInter {

    boolean adminSpecification();//booelan edib return verecem gorek ne olur )
    boolean teacherSpecification();
    boolean studentSpecification(Person person);//paramter kimi login olmus useri buraya otururem biliremki instance of methoduna giribse onsuzda studentdir bu birde instance of yazmaga ehtoiiyac yoxdur unutmayin

}
