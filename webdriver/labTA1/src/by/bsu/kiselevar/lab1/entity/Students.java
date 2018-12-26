package by.bsu.kiselevar.lab1.entity;

import java.util.Objects;
import java.util.Arrays;

public class Students {

    private static int actualId =1;
    private final int id;
    private String name;
    private String surname;
    private Group group;

    private int raiting[];

    public Students(String name, String surname, int []raiting){
        this.id=actualId++;
        this.name=name;
        this.surname=surname;
        this.raiting=raiting;
        this.group=group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRaiting(int[] raiting) {
        this.raiting = raiting;
    }

    public Group getGroup() {
        return group;
    }

    void setGroup(Group group) {
        this.group = group;
    }

    public int[] getRaiting() {
        return raiting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() != Students.class) return false;
        Students student = (Students) o;
        return id == student.id &&
                name.equals(student.name) &&
                surname.equals(student.surname) &&
                Arrays.equals(raiting, student.raiting);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, surname, name);
        result = 21 * result + Arrays.hashCode(raiting);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + name + '\'' +
                ", name='" + surname + '\'' +
                ", marks=" + Arrays.toString(raiting) +
                '}';
    }
}
