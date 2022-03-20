package com.home.aspose;

import com.home.aspose.model.Car;
import com.home.aspose.model.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OperationsTest {

    @Test
    public void test_add_record() {
        List<Car> cars = new ArrayList<>(
                Arrays.asList(
                        new Car(new Date(), "test1", 10000),
                        new Car(new Date(), "test2", 20000)
                )
        );
        Document document = new Document(cars);

        Car expected = new Car(new Date(), "test3", 30000);

        int index = document.addRecord(expected);

        Car actual = document.getCars().get(index);

        assertCars(expected, actual);
    }

    @Test
    public void test_delete_record() {
        Car expected = new Car(new Date(), "test1", 10000);

        List<Car> cars = new ArrayList<>(
                Arrays.asList(
                        expected,
                        new Car(new Date(), "test2", 20000)
                )
        );
        Document document = new Document(cars);

        Car actual = document.deleteRecord(0);

        Assertions.assertEquals(1, document.getCars().size());
        assertCars(expected, actual);
    }

    @Test
    public void test_delete_record_not_existing() {
        List<Car> cars = new ArrayList<>(
                Arrays.asList(
                        new Car(new Date(), "test1", 10000),
                        new Car(new Date(), "test2", 20000)
                )
        );
        Document document = new Document(cars);

        Assertions.assertThrows(IndexOutOfBoundsException.class , () -> document.deleteRecord(10));
    }

    @Test
    public void test_update_record() {
        List<Car> cars = new ArrayList<>(
                Arrays.asList(
                        new Car(new Date(), "test1", 10000),
                        new Car(new Date(), "test2", 20000)
                )
        );
        Document document = new Document(cars);

        Car expected = new Car(new Date(), "test3", 30000);

        int updatedIndex = 1;

        document.updateRecord(updatedIndex, expected);

        Car actual = document.getCars().get(updatedIndex);

        Assertions.assertEquals(2, document.getCars().size());
        assertCars(expected, actual);
    }

    @Test
    public void test_update_record_not_existing() {
        List<Car> cars = new ArrayList<>(
                Arrays.asList(
                        new Car(new Date(), "test1", 10000),
                        new Car(new Date(), "test2", 20000)
                )
        );
        Document document = new Document(cars);

        int updatedIndex = 10;

        Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> document.updateRecord(updatedIndex, new Car(new Date(), "test3", 30000))
        );
    }

    private void assertCars(Car expected, Car actual) {
        Assertions.assertEquals(expected.getPrice(), actual.getPrice());
        Assertions.assertEquals(expected.getBrandName(), actual.getBrandName());
        Assertions.assertEquals(expected.getDate(), actual.getDate());
    }
}
