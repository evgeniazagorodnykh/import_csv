package OfficeList;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class MyCsvReader {

    /**
     * Считывает данные из файла в список
     * @param file путь до csv файла
     * @return список с данными
     * @throws Exception возникает ошибка в чтении файла
     */
    public List<Worker> read(File file) throws Exception {
        String [] record;
        CSVReader csvReader = null;
        List<Worker> office = new ArrayList<>();
        List<Division> divisions = new ArrayList<>();

        try {
            csvReader = new CSVReaderBuilder(new FileReader(file))
                    .withCSVParser(new CSVParserBuilder()
                            .withSeparator(';')
                            .build())
                    .build();

            int currentLine = 0;

            while ((record = csvReader.readNext()) != null) {

                if (record.length == 6 && currentLine > 0) {
                    String divisionName = record[4];

                    Division division = null;
                    for (Division d : divisions) {
                        if (d.getName().equals(divisionName)) {
                            division = d;
                            break;
                        }
                    }

                    if (division == null) {
                        division = new Division(divisionName);
                        divisions.add(division);
                    }

                    Worker man = new Worker(
                            Integer.parseInt(record[0]),
                            record[1],
                            record[2],
                            division,
                            Double.parseDouble(record[5]),
                            record[3]
                    );

                    office.add(man);
                }
                currentLine++;
            }
        } finally {
            if (csvReader != null) {
                csvReader.close();
            }
        }
        return office;
    }
}
