package com.anztim.library.manager.dao;

import com.anztim.library.manager.domain.Login;

import java.sql.SQLException;

/**
 * @author anztim
 */
public class LoginDao extends AbstractDao<Login>{
    public LoginDao() {
        super(Login.class);
    }
}
