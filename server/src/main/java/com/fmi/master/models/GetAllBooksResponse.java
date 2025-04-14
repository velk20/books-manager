package com.fmi.master.models;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://books", name = "", propOrder = {"books"})
@XmlRootElement(namespace = "http://books", name = "getAllBooksResponse")
public class GetAllBooksResponse {

    @XmlElement(namespace = "http://books")
    protected List<Book> books;
}
