package com.fmi.master.models;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://books", name = "", propOrder = {"book"})
@XmlRootElement(namespace = "http://books", name = "updateBookResponse")
public class UpdateBookResponse {
    @XmlElement(namespace = "http://books")
    protected Book book;
}
