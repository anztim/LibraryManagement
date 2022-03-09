package com.anztim.library.manager.dao;


import com.anztim.library.manager.domain.Borrow;

import java.sql.SQLException;

/**
 * @author anztim
 */
public class BorrowDao extends AbstractDao<Borrow> {
    public static final String FULL_FIELD_LIST = "borrow_id,position,book_id,user_id,borrow_date,due_date,renew_count";

    public BorrowDao() {
        super(Borrow.class);
    }

    public Borrow getById(int id) throws SQLException {
        return basicQuery("SELECT "+FULL_FIELD_LIST+" FROM t_borrow WHERE borrow_id=?", id);
    }

    public int insert(Borrow obj) throws SQLException {
        return basicUpdate("INSERT INTO t_borrow(" + FULL_FIELD_LIST + ") VALUES(?,?,?,?,?,?,?)",
                null, obj.getPosition(), obj.getBookId(), obj.getUserId(),
                obj.getBorrowDate(), obj.getDueDate(), obj.getRenewCount()

        );
    }
}
