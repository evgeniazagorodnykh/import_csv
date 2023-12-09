package OfficeList;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyCsvReaderTest {

    @Test
    void readRightTest() throws Exception {
        MyCsvReader reader = new MyCsvReader();
        List<Worker> testOffice = reader.read(new File("src/main/resources/test1.csv"));

        assertEquals("20000 Evgenia Female I 1000.0 04.08.2003",
                testOffice.get(0).toString());
    }
}