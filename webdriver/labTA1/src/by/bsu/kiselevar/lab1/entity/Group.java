package by.bsu.kiselevar.lab1.entity;

import by.bsu.kiselevar.lab1.entity.Students;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Group {

    private static int currentId = 1;

    private int id = currentId++;

    private ArrayList<Students> students = new ArrayList<>();

    public Students getStudent(int index) {
        if (students.isEmpty() || index < 0 || index >= students.size()) {
            return null;
        }
        return students.get(index);
    }

    public ArrayList<Students> getStudents() {
        return new ArrayList<>(students);
    }

    public boolean addStudent(Students student) {
        if (student == null || student.getGroup() != null) {
            return false;
        }

        students.add(student);
        student.setGroup(this);
        return true;
    }

    public boolean deleteStudent(int studentId) {
        Iterator<Students> studentIterator = students.iterator();
        Students student;
        while (studentIterator.hasNext()) {
            student = studentIterator.next();
            if (student.getId() == studentId) {
                studentIterator.remove();
                student.setGroup(null);
                return true;
            }
        }
        return true;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() != Group.class) return false;
        Group group = (Group) o;
        return id == group.id &&
                students.equals(group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, students);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", students=" + students +
                '}';
    }
}
