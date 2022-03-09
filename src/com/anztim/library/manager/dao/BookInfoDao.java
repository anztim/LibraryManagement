package com.anztim.library.manager.dao;

import com.anztim.library.manager.domain.BookInfo;

import java.sql.SQLException;

/**
 * @author anztim
 */
public class BookInfoDao extends AbstractDao<BookInfo> {

    public static final String FULL_FIELD_LIST = "info_id,isbn,copies,title,subtitle,original_title,author,translator,publish,publishDate,pages,price,binding,series,douban_id,book_intro,author_intro,cover";

    public BookInfoDao() {
        super(BookInfo.class);
    }

    public BookInfo getBasicInfoById(int id) throws SQLException {
        return basicQuery("SELECT info_id,isbn,copies,title,subtitle,original_title,author,translator,publish,publishDate,pages,price,binding,series FROM t_book_info WHERE info_id=?", id);
    }

    public BookInfo getById(int id) throws SQLException {
        return basicQuery("SELECT " + FULL_FIELD_LIST + " FROM t_book_info WHERE info_id=?", id);
    }

    public int insert(BookInfo obj) throws SQLException {
        return basicUpdate("INSERT INTO t_book_info(" + FULL_FIELD_LIST + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                null, obj.getIsbn(), obj.getCopies(), obj.getTitle(), obj.getSubtitle(),
                obj.getOriginalTitle(), obj.getAuthor(), obj.getTranslator(), obj.getPublish(),
                obj.getPublishDate(), obj.getPages(), obj.getPrice(), obj.getSeries(), obj.getDoubanId(),
                obj.getBookIntro(), obj.getAuthorIntro(), obj.getCover()
        );
    }

}
