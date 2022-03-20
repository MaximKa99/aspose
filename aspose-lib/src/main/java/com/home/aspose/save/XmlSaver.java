package com.home.aspose.save;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.home.aspose.exception.SaveException;
import com.home.aspose.model.Document;

import java.io.OutputStream;

public class XmlSaver implements Saver {
    @Override
    public void save(Document document, OutputStream outputStream) {
        XmlMapper xmlMapper = new XmlMapper();

        try {
            xmlMapper.writeValue(outputStream, document);
        } catch (Exception e) {
            throw new SaveException(e.getMessage());
        }
    }
}
