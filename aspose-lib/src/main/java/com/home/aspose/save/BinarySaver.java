package com.home.aspose.save;

import com.home.aspose.constant.BinaryConstant;
import com.home.aspose.exception.SaveException;
import com.home.aspose.model.Car;
import com.home.aspose.model.Document;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

public class BinarySaver implements Saver {
    @Override
    public void save(Document document, OutputStream outputStream) {
        DataOutput dataOutput = new DataOutputStream(outputStream);

        try {
            outputStream.write(BinaryConstant.header);

            int recordsCount = document.getCars().size();

            dataOutput.writeInt(recordsCount);

            int i = 0;
            while (i < recordsCount) {
                Car car = document.getCars().get(i);

                Date date = car.getDate();
                String brandName = car.getBrandName();

                Calendar calendar = Calendar.getInstance();

                calendar.setTime(date);

                dataOutput.writeShort(calendar.get(Calendar.DAY_OF_MONTH));
                dataOutput.writeShort(calendar.get(Calendar.MONTH) + 1);
                dataOutput.writeInt(calendar.get(Calendar.YEAR));
                dataOutput.writeShort(brandName.length());
                dataOutput.writeUTF(brandName);
                dataOutput.writeInt(car.getPrice());

                i++;
            }
        } catch (IOException e) {
            throw new SaveException(e.getMessage());
        }
    }
}
