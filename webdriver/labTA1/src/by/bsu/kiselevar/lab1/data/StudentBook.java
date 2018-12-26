package by.bsu.kiselevar.lab1.data;

import by.bsu.kiselevar.lab1.entity.Students;

import java.util.ArrayList;

public class StudentBook {

    private static StudentBook book = new StudentBook();

    private ArrayList<Students> student = new ArrayList<>();

    public static StudentBook getBook(){return book;}

    private StudentBook(){
        for (int i=0;i<20;i++){
            student.add(new Students("Name"+i,"Surname"+i,new int[]{
                    (int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5),
                    (int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5),
                    (int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5),
                    (int) (Math.random() * 5), (int) (Math.random() * 5)
            }));
        }
    }

    public Students get(int studentsId){
        if (studentsId < 1 || studentsId > 20) {
            return null;
        }
        for (Students student : student) {
            if (student.getId() == studentsId) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Students> getStudents() {
        return new ArrayList<>(student);
    }
}
