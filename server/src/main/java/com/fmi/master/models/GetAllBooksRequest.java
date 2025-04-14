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

@XmlRootElement(namespace = "http://books", name = "getAllBooksRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllBooksRequest {
}
