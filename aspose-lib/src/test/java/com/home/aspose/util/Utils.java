package com.home.aspose.util;

import com.home.aspose.model.Car;
import com.home.aspose.model.Document;
import org.junit.jupiter.api.Assertions;

import java.util.Calendar;

public class Utils {

    public static void assertTwoDocs(Document expected, Document actual) {
        Assertions.assertEquals(expected.getCars().size(), actual.getCars().size());

        int i = 0;
        while (i < expected.getCars().size()) {
            Car expectedCar = expected.getCars().get(i);
            Car actualCar = actual.getCars().get(i);

            Calendar expectedCalendar = Calendar.getInstance();
            expectedCalendar.setTime(expectedCar.getDate());

            Calendar actualCalendar = Calendar.getInstance();
            actualCalendar.setTime(actualCar.getDate());

            Assertions.assertEquals(expectedCalendar.get(Calendar.YEAR), actualCalendar.get(Calendar.YEAR));
            Assertions.assertEquals(expectedCalendar.get(Calendar.MONTH), actualCalendar.get(Calendar.MONTH));
            Assertions.assertEquals(expectedCalendar.get(Calendar.DAY_OF_MONTH), actualCalendar.get(Calendar.DAY_OF_MONTH));
            Assertions.assertEquals(expectedCar.getPrice(), actualCar.getPrice());
            Assertions.assertEquals(expectedCar.getBrandName(), actualCar.getBrandName());

            i++;
        }
    }
}
