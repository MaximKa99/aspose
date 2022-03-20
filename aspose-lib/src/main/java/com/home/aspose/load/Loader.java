package com.home.aspose.load;

import com.home.aspose.model.Document;

import java.io.InputStream;

/**
 * This interface provides API for loading data
 * from different types of sources
 */
public interface Loader {
    /**
     * It loads data from the file
     * @param inputStream file's name that contains the data
     * @return document's representation
     */
    Document load(InputStream inputStream);
}
