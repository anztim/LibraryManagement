package com.anztim.library.manager.domain;

import java.util.UUID;

/**
 * @author anztim
 */
@SuppressWarnings("unused")
public class Book {
    private String	bookId;
    private Integer	bookInfoId;
    private String location;

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(Integer bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
