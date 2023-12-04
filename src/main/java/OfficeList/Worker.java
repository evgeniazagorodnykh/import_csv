package OfficeList;

public class Worker {
    final private int id;
    final private String name;
    final private String gender;
    final private Division division;
    final private double salary;
    final private String birth;

    public Worker(int id, String name, String gender, Division division, double salary, String birth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gender + " " + division + " " + salary + " " + birth;
    }

}
