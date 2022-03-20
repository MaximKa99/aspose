package com.home.aspose.save;

import com.home.aspose.model.Document;

import java.io.OutputStream;

public interface Saver {
    void save(Document document, OutputStream outputStream);
}
