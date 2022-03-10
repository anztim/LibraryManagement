package com.anztim.library.manager.dao;

import com.anztim.library.manager.domain.Book;

import java.sql.SQLException;

/**
 * @author anztim
 */
public class BookDao extends AbstractDao<Book> {
    public static final String FULL_FIELD_LIST = "book_id, book_info_id, location";

    public BookDao() {
        super(Book.class);
    }

    public Book getById(String bookId) throws SQLException {
        return basicQuery("SELECT " + FULL_FIELD_LIST + " FROM t_book WHERE book_id=?", bookId);
    }

    public int insert(Book obj) throws SQLException {
        return basicUpdate("INSERT INTO t_book(" + FULL_FIELD_LIST + ") VALUES(?,?,?)", obj.getBookId(), obj.getBookInfoId(), obj.getLocation());
    }

    public int update(Book book) throws SQLException {
        return basicUpdate("UPDATE t_book SET " +
                "book_info_id=?, " +
                "location=? " +
                "WHERE book_id=?",
                book.getBookInfoId(),
                book.getLocation(),
                book.getBookId()
        );
    }
}
