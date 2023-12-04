package org.example;

import OfficeList.MyCsvReader;
import OfficeList.Worker;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        MyCsvReader reader = new MyCsvReader();
        List<Worker> tempOffice = reader.read(new File("src/main/resources/foreign_names.csv"));
        for (Worker worker : tempOffice) {
            System.out.println(worker);
        }
    }
}