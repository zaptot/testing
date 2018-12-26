package by.bsu.kiselevar.lab1.data;

import by.bsu.kiselevar.lab1.entity.Group;

import java.util.ArrayList;

public class GroupBook {

    private static GroupBook book = new GroupBook();

    private ArrayList<Group> groups = new ArrayList<>();

    public static GroupBook getInstance() {
        return book;
    }

    private GroupBook() {
        StudentBook studentBook = StudentBook.getBook();
        Group group;
        for (int i = 0; i < 2; i++) {
            group = new Group();
            for (int j = 8 * i + 1; j <= 8 * i + 8; j++) {
                group.addStudent(studentBook.get(j));
            }
            groups.add(group);
        }
    }

    public Group get(int groupId) {
        if (groupId < 0 || groupId > 1) {
            return null;
        }

        for (Group group : groups) {
            if (group.getId() == groupId) {
                return group;
            }
        }

        return null;
    }

    public ArrayList<Group> getGroups() {
        return new ArrayList<>(groups);
    }

}
