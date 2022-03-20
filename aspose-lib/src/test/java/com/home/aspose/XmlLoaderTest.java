package com.home.aspose;

import com.home.aspose.exception.LoadException;
import com.home.aspose.load.Loader;
import com.home.aspose.load.XmlLoader;
import com.home.aspose.model.Car;
import com.home.aspose.model.Document;
import com.home.aspose.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class XmlLoaderTest {
    private Loader loader = new XmlLoader();

    @Test
    public void test_load_single_entity() throws IOException {
        Date date = new Date(1223596800000L);

        List<Car> expectedList = Arrays.asList(new Car(date, "Alpha Romeo Brera", 37000));
        Document expected = new Document(expectedList);

        try (InputStream inputStream = new FileInputStream("src/test/resources/xml/single.xml") ){
            Document actual = loader.load(inputStream);
            Utils.assertTwoDocs(expected, actual);
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

        try (InputStream inputStream = new FileInputStream("src/test/resources/xml/triple.xml") ){
            Document actual = loader.load(inputStream);
            Utils.assertTwoDocs(expected, actual);
        }
    }

    @Test
    public void test_load_zero_entity() throws IOException {
        try (InputStream inputStream = new FileInputStream("src/test/resources/xml/zero.xml") ){
            Document actual = loader.load(inputStream);

            Assertions.assertNull(actual.getCars());
        }
    }

    @Test
    public void test_load_wrong_format_entity() throws IOException {
        try (InputStream inputStream = new FileInputStream("src/test/resources/xml/wrongFormat.xml") ){
            Assertions.assertThrows(LoadException.class, () -> loader.load(inputStream));
        }
    }
}
