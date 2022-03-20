package com.home.aspose.load;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.home.aspose.exception.LoadException;
import com.home.aspose.model.Document;

import java.io.InputStream;

/**
 * This class provides functionality to load data from xml files
 */
public class XmlLoader implements Loader {
    @Override
    public Document load(InputStream inputStream) {
        XmlMapper mapper = new XmlMapper();

        try {
            return mapper.readValue(inputStream, Document.class);
        } catch (Exception e) {
            throw new LoadException(e.getMessage());
        }
    }
}
