package service.impl;

import baseSystem.GlobalStrings;
import classes.Classes;
import globalDatas.GlobalData;
import service.ClassesServiceInter;
import users.Person;
import users.Student;
import util.FileUtils;
import util.Util;

import java.time.LocalDateTime;

//1 Print students  ->Student
//2 Print Classes -> ClassName

public class ClassesService implements ClassesServiceInter {
    @Override
    public void addStudentToClass() {
        Util.printStudents();
        int studentId = Util.requireInt("Please enter student id which you want to add to class");
        Student selectedStudent = getStudentById(studentId);

        Util.printClasses();
        String selectedClassName = Util.requireString("Please enter class name to add Student");
        Classes selectedClasses = null;
        for (int i = 0; i < GlobalData.classesDynamicArray.getSize(); i++) {
            Classes classes = GlobalData.classesDynamicArray.get(i);
            if (classes.getName().equalsIgnoreCase(selectedClassName)) {
                selectedClasses = classes;
            }

        }
        selectedClasses.getStudentsDinamicArray().add(selectedStudent);
        System.out.println("Student:" + selectedStudent.getName() + "added to new class " + selectedClasses.getName());
        String log = "Student:" + selectedStudent.getName() + "added to new class " + selectedClasses.getName() + " Time: " + LocalDateTime.now();
        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
    }


    private Student getStudentById(int id) {
        Student student = null;

        for (int i = 0; i < GlobalData.personDinamicArray.getSize(); i++) {
            Person person = GlobalData.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student selectedStudent = (Student) person;
                if (selectedStudent.getId() == id) {
                    student = selectedStudent;
                    return student;
                }
            }
        }
        return student;
    }

}
