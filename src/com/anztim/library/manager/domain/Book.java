package com.anztim.library.manager.domain;

import java.util.UUID;

/**
 * @author anztim
 */
@SuppressWarnings("unused")
public class Book {
    private String	bookId;
    private Integer	bookInfoId;

    public Book() {
    }

    public Book(String bookId, Integer bookInfoId) {
        this.bookId = bookId;
        this.bookInfoId = bookInfoId;
    }

    public Book(Integer bookInfoId) {
        this.bookId = UUID.randomUUID().toString();
        this.bookInfoId = bookInfoId;
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
}
