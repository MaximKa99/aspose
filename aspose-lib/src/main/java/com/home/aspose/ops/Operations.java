package com.home.aspose.ops;

import com.home.aspose.model.Car;

/**
 * This interface describes API for manipulating a document
 */
public interface Operations<T> {
    /**
     * It modifies the specified record with given index
     * @param index index of record
     * @param updatedRecord updated entity
     */
    void updateRecord(int index, Car updatedRecord);

    /**
     * It deletes record with the specified index
     * @param index index of the record that must be deleted
     * @return deleted entity
     */
    Car deleteRecord(int index);

    /**
     * It adds a new record
     * @param record the adding record
     * @return index of added entity
     */
    int addRecord(Car record);
}
