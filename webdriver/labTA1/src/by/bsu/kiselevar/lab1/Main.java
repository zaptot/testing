package by.bsu.kiselevar.lab1;

import by.bsu.kiselevar.lab1.data.GroupBook;
import by.bsu.kiselevar.lab1.data.StudentBook;
import by.bsu.kiselevar.lab1.entity.Group;
import by.bsu.kiselevar.lab1.entity.Students;
import by.bsu.kiselevar.lab1.utili.MidRaiting;
import by.bsu.kiselevar.lab1.utili.implement.MidRaitingImp;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        StudentBook studentBook = StudentBook.getBook();
        GroupBook groupBook = GroupBook.getInstance();

        MidRaiting midRaiting = new MidRaitingImp();

        ArrayList <Students> student = studentBook.getStudents();

        for (Students students : student){
            System.out.println("Students: " + student.toString() + "\n"
                    +"Student mid raiting: " + midRaiting.count(students));
        }

        ArrayList<Group> groups = groupBook.getGroups();

        for (Group group : groups) {
            System.out.println("Group:\n" + group.toString() + "\n"
                    + "Group mid raiting: " + midRaiting.count(group));
        }
    }
}
