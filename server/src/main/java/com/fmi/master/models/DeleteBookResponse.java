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
@XmlType(namespace = "http://books", name = "")
@XmlRootElement(namespace = "http://books", name = "deleteBookResponse")
public class DeleteBookResponse {
    @XmlElement(namespace = "http://books")
    protected String message;
}
