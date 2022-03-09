package com.anztim.library.manager.dao;

import com.anztim.library.manager.domain.User;

import java.sql.SQLException;

/**
 * @author anztim
 */
public class UserDao extends AbstractDao<User>{
    public UserDao() {
        super(User.class);
    }

    public User getById(int id) throws SQLException {
        return basicQuery("SELECT user_id,type,user_name,id_num,cash_pledge,group_id,phone_num,email FROM t_user WHERE user_id=?",id);
    }
}
