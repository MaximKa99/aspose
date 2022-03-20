package com.home.aspose.load;

import com.home.aspose.constant.BinaryConstant;
import com.home.aspose.exception.LoadException;
import com.home.aspose.model.Car;
import com.home.aspose.model.Document;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * This class provides functionality to load data from binary files
 */
public class BinaryLoader implements Loader {
    private int[] leapYear = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int[] nonLeapYear = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    @Override
    public Document load(InputStream inputStream) {
        DataInput dataInput = new DataInputStream(inputStream);
        try {
            checkHeader(dataInput);

            int recordsCount = dataInput.readInt();

            List<Car> cars = new ArrayList<>();

            int i = 0;
            while (i < recordsCount) {
                Car car = parseCar(dataInput);
                cars.add(car);

                i++;
            }

            return new Document(cars);
        } catch (IOException e) {
            throw new LoadException(e.getMessage());
        }
    }

    /**
     * It checks header
     * @param dataInput source of data
     */
    private void checkHeader(DataInput dataInput) {
        try {
            if (dataInput.readByte() != BinaryConstant.header[0] || dataInput.readByte() != BinaryConstant.header[1]) {
                throw new LoadException("header format");
            }
        } catch (IOException e) {
            throw new LoadException("header format");
        }
    }

    /**
     * It parses bytes into car representation
     * @param dataInput source of data
     * @return car representation
     */
    private Car parseCar(DataInput dataInput) {
        try {
            int day = dataInput.readShort();
            int month = dataInput.readShort();
            int year = dataInput.readInt();

            checkDate(day, month, year);

            int brandNameLength = dataInput.readShort();

            String brandName = dataInput.readUTF();

            int price = dataInput.readInt();

            return new Car(new GregorianCalendar(year, month - 1, day).getTime(), brandName, price);
        } catch (IOException e) {
            throw new LoadException(e.getMessage());
        }
    }

    /**
     * It validates days', months', and years' values
     * @param day
     * @param month
     * @param year
     */
    private void checkDate(int day, int month, int year) {
        if (year < 0) {
            throw new LoadException("date format");
        }

        if (month > 12 || month < 0) {
            throw new LoadException("date format");
        }

        if (year % 4 == 0 && year % 100 != 0 && year % 400 == 0) {
            if (leapYear[month - 1] < day && day < 0) {
                throw new LoadException("date format");
            }
        } else {
            if (nonLeapYear[month - 1] < day && day < 0) {
                throw new LoadException("date format");
            }
        }
    }
}
