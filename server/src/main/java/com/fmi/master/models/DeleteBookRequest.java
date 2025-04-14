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

@XmlRootElement(namespace = "http://books", name = "deleteBookRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteBookRequest {
    @XmlElement(namespace = "http://books")
    private Long id;
}
