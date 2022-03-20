package com.home.aspose.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Java representation about car's record
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @JsonFormat(pattern = "dd.MM.yyyy")
    @JacksonXmlProperty(localName = "Date")
    private Date date;

    @JacksonXmlProperty(localName = "BrandName")
    private String brandName;

    @JacksonXmlProperty(localName = "Price")
    private Integer price;
}
