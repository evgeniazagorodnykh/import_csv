package OfficeList;

public class Division {
    final private int id;
    final private String name;
    private int newId = 1;

    public Division(String name) {
        this.id = newId;
        this.name = name;
        newId++;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
