package by.bsu.kiselevar.lab1.utili.implement;

import by.bsu.kiselevar.lab1.entity.Group;
import by.bsu.kiselevar.lab1.entity.Students;
import by.bsu.kiselevar.lab1.utili.MidRaiting;


import java.util.ArrayList;

public class MidRaitingImp implements MidRaiting {

    @Override
    public double count(Group group) {
        if (group == null) {
            return -1;
        }

        ArrayList<Students> students = group.getStudents();

        double midRaitingSum = 0;
        double midRaitingAmount = 0;


        for (Students student : students) {
            if (student.getRaiting() != null) {
                for (int raiting : student.getRaiting()) {
                    midRaitingSum += raiting;
                    midRaitingAmount++;
                }
            }
        }

        if (midRaitingAmount > 0) {
            double midRaitingGroup = midRaitingSum / midRaitingAmount;
            return Math.rint(100.0 * midRaitingGroup) / 100.0 ;
        }

        return 0;
    }


    @Override
    public double count(Students student) {
        if (student == null) {
            return -1;
        }

        double midRaitingSum = 0;
        double midRaitingAmount = 0;

        if (student.getRaiting() != null) {
            for (int raiting : student.getRaiting()) {
                midRaitingSum += raiting;
                midRaitingAmount++;
            }
        }

        if (midRaitingAmount > 0) {
            double midRaiting = midRaitingSum / midRaitingAmount;
            return Math.rint(100.0 * midRaiting) / 100.0 ;
        }

        return 0;
    }
}
