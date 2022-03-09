package com.anztim.library.manager.dao;

import com.anztim.library.manager.domain.Group;

import java.sql.SQLException;

/**
 * @author anztim
 */
public class GroupDao extends AbstractDao<Group>{
    public static final String FULL_FIELD_LIST = "group_id,basic_cash_pledge,borrow_limit,time_limit,renew_limit";
    public GroupDao() {
        super(Group.class);
    }

    public Group getById(int id) throws SQLException {
        return basicQuery("SELECT "+FULL_FIELD_LIST+" FROM t_group WHERE group_id=?",id);
    }

    public int insert(Group obj) throws SQLException {
        return basicUpdate("INSERT INTO t_borrow(" + FULL_FIELD_LIST + ") VALUES(?,?,?,?,?,?)",
                null, obj.getBasicCashPledge(), obj.getBorrowLimit(),
                obj.getTimeLimit(), obj.getRenewLimit()
        );
    }
}
