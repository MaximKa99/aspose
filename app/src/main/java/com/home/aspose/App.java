package com.home.aspose;

import com.home.aspose.load.BinaryLoader;
import com.home.aspose.load.Loader;
import com.home.aspose.load.XmlLoader;
import com.home.aspose.model.Car;
import com.home.aspose.model.Document;
import com.home.aspose.save.BinarySaver;
import com.home.aspose.save.Saver;
import com.home.aspose.save.XmlSaver;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        //example of creating of a document
        List<Car> cars = new ArrayList<>(List.of(
                new Car(new Date(), "name 1", 10000),
                new Car(new Date(), "name 2", 20000),
                new Car(new Date(), "name 3", 30000)
                ));
        Document document = new Document(cars);

        //examples of modification of the document
        //adding new records
        int index = document.addRecord(new Car(new Date(), "name 4", 40000));
        //modifying existing ones
        document.updateRecord(2, new Car(new Date(), "updated name 3", 30000));
        //deleting a record
        Car deleted = document.deleteRecord(3);

        /**
         * Here we can see how we can save or read the document from an external file.
         * Now we support two types of external files: Xml and Binary format
         */

        Saver xmlSaver = new XmlSaver();
        Saver binarySaver = new BinarySaver();

        try (OutputStream xmlOut = new FileOutputStream("example.xml");
             OutputStream binaryOut = new FileOutputStream("example")){
            xmlSaver.save(document, xmlOut);
            binarySaver.save(document, binaryOut);
        }

        Loader xmlLoader = new XmlLoader();
        Loader binaryLoader = new BinaryLoader();

        try (InputStream xmlIn = new FileInputStream("example.xml");
             InputStream binaryIn = new FileInputStream("example")){
            Document xmlDoc = xmlLoader.load(xmlIn);
            Document binaryDoc = binaryLoader.load(binaryIn);
        }

        /**
         * Using loaders and savers you can convert
         * document from one type to another
         */
    }
}
