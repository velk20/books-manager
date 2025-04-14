package com.fmi.master.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@XmlRootElement(namespace = "http://books", name = "updateBookRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateBookRequest {
    @XmlElement(namespace = "http://books")
    private long id;
    @XmlElement(namespace = "http://books")
    private String title;
    @XmlElement(namespace = "http://books")
    private String author;
    @XmlElement(namespace = "http://books")
    private int pages;
}
