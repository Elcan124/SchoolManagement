package service.impl;

import classes.Classes;
import globalDatas.GlobalData;
import service.ClassesServiceInter;
import service.TeacherServiceInter;
import users.Person;
import users.Student;

public class TeacherServiceImpl implements TeacherServiceInter {//birdene login menu üçün interface qaldi onuda yaradaq

    private ClassesServiceInter classesService = new ClassesService();

    @Override
    public void seeAllStudents() {
        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println(student.getDetailsForTeacher());
            }


        }

    }

    @Override
    public void seeAllClasses() {
        for(int  i=0 ; i<GlobalData.classesDynamicArray.getSize() ; i++){
            Classes classes = GlobalData.classesDynamicArray.get(i);
            System.out.println(classes.getName());
            for(int j = 0 ; j<classes.getStudentsDinamicArray().getSize() ; j++){
                Student student = (Student) classes.getStudentsDinamicArray().get(j);
                System.out.println(student);
            }

        }

    }

    @Override
    public void addStudentToClass() {
        classesService.addStudentToClass();
    }

    @Override
    public boolean backToLogin() {
        return false;
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
