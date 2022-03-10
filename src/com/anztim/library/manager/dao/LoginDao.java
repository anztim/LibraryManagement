package com.anztim.library.manager.dao;

import com.anztim.library.manager.domain.Login;

import java.sql.SQLException;

/**
 * @author anztim
 */
public class LoginDao extends AbstractDao<Login> {
    public LoginDao() {
        super(Login.class);
    }

    public Login getByLoginNameWithSalt(String loginName) throws SQLException {
        return basicQuery("SELECT login_id,login_name,salt,user_id FROM t_login WHERE login_name=?", loginName);
    }

    public Login getByLoginName(String loginName) throws SQLException {
        return basicQuery("SELECT login_id,login_name,user_id FROM t_login WHERE login_name=?", loginName);
    }

    public int match(Login login) throws SQLException {
        Long id = (Long) basicQueryScalar("SELECT user_id FROM t_login WHERE login_name=? AND password=?", login.getLoginName(), login.getPassword());
        if (id != null) return id.intValue();
        return -1;
    }
}
