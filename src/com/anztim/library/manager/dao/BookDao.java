package com.anztim.library.manager.dao;

import com.anztim.library.manager.domain.Book;

import java.sql.SQLException;

/**
 * @author anztim
 */
public class BookDao extends AbstractDao<Book> {
    public static final String FULL_FIELD_LIST = "book_id, book_info_id";

    public BookDao() {
        super(Book.class);
    }

    public Book getById(int id) throws SQLException {
        return basicQuery("SELECT " + FULL_FIELD_LIST + " FROM t_book WHERE book_id=?", id);
    }

    public int insert(Book obj) throws SQLException {
        return basicUpdate("INSERT INTO t_book(" + FULL_FIELD_LIST + ") VALUES(?,?)", obj.getBookId(), obj.getBookInfoId());
    }
}
