package com.anztim.library.manager.service;

import com.anztim.library.manager.dao.LoginDao;
import com.anztim.library.manager.dao.UserDao;
import com.anztim.library.manager.domain.Login;
import com.anztim.library.manager.domain.User;
import com.anztim.library.manager.utils.ShaUtil;

import java.sql.SQLException;

/**
 * @author anztim
 */
public class LoginService {
    private LoginDao loginDao = new LoginDao();
    private UserDao userDao = new UserDao();

    public User login(String loginName, String scrPassword) {
        User user = null;
        try {
            Login login = loginDao.getByLoginNameWithSalt(loginName);
            login.setPassword(ShaUtil.sha256(scrPassword+login.getSalt()));
            int user_id = loginDao.match(login);
            if (user_id != -1) user = userDao.getById(user_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
