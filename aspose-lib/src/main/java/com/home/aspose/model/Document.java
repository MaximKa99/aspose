package com.home.aspose.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.home.aspose.ops.Operations;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Java representation of document.
 * This class provides methods for manipulating data
 * of the document
 */

/**
 * I see one possible improvement. We can try to remove operations from this class
 * and leave only data. As I think, to work with this we need to add method that creates
 * a copy of the given object, and do all necessary actions with the copy using a class like "DocumentWorker".
 *
 * An additional improvement is to add history of the document to have an opportunity to rollback changes.
 */
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Document implements Operations<Document> {
    @JacksonXmlProperty(localName = "Car")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Car> cars;

    @Override
    public void updateRecord(int index, Car updatedRecord) {
        cars.set(index, updatedRecord);
    }

    @Override
    public Car deleteRecord(int index) {
        return cars.remove(index);
    }

    @Override
    public int addRecord(Car record) {
        cars.add(record);

        return cars.size() - 1;
    }
}
