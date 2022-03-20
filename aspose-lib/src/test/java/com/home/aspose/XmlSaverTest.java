package com.home.aspose;

import com.home.aspose.load.Loader;
import com.home.aspose.load.XmlLoader;
import com.home.aspose.model.Car;
import com.home.aspose.model.Document;
import com.home.aspose.save.Saver;
import com.home.aspose.save.XmlSaver;
import com.home.aspose.util.Utils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class XmlSaverTest {
    private final Saver saver = new XmlSaver();
    private final Loader loader = new XmlLoader();
    private final String filename = "src/test/resources/xml/save.xml";

    @Test
    public void test_simple() throws IOException {
        Date date = new Date(1223596800000L);

        List<Car> expectedList = Arrays.asList(new Car(date, "Alpha Romeo Brera", 37000));
        Document expected = new Document(expectedList);

        try (InputStream inputStream = new FileInputStream(filename); OutputStream outputStream = new FileOutputStream(filename)){
            saver.save(expected, outputStream);
            Utils.assertTwoDocs(expected, loader.load(inputStream));
        }

    }

    @Test
    public void test_load_triple_entity() throws IOException {
        Date dateOne = new Date(1223596800000L);
        Date dateTwo = new Date(1854748800000L);
        Date dateThree = new Date(1539129600000L);

        List<Car> expectedList = Arrays.asList(
                new Car(dateOne, "Alpha Romeo Brera", 37000),
                new Car(dateTwo, "Beta Romeo Brera", 27000),
                new Car(dateThree, "Fi Romeo Brera", 47000)
        );
        Document expected = new Document(expectedList);

        try (InputStream inputStream = new FileInputStream(filename); OutputStream outputStream = new FileOutputStream(filename)){
            saver.save(expected, outputStream);
            Utils.assertTwoDocs(expected, loader.load(inputStream));
        }

    }
}
