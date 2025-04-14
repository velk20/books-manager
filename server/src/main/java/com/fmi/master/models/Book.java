package com.fmi.master.models;

import com.jakewharton.fliptables.FlipTable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {"id", "title", "author", "pages"})
public class Book {
    protected long id;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String author;
    @XmlElement(required = true)
    protected int pages;

    @Override
    public String toString()
    {
        String[][] data = {{String.valueOf(this.id), this.title, this.author, String.valueOf(this.pages)}};
        return FlipTable.of(getHeaders(), data);
    }

    public static String[] getHeaders(){
        return new String[]{"ID", "Title", "Author", "Pages"};
    }
}
