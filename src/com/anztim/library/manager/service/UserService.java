package com.anztim.library.manager.service;

import com.anztim.library.manager.dao.LoginDao;
import com.anztim.library.manager.dao.UserDao;
import com.anztim.library.manager.domain.Login;
import com.anztim.library.manager.domain.User;
import com.anztim.library.manager.utils.DatabaseUtil;
import com.anztim.library.manager.utils.ShaUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author anztim
 */
public class UserService {
    private LoginDao loginDao = new LoginDao();
    private UserDao userDao = new UserDao();

    public User get(int userId) {
        try {
            return userDao.getById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User get(String loginName) {
        int userId = -1;
        try {
            userId = loginDao.getUserId(loginName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userId != -1) return get(userId);
        return null;
    }

    public int updateAll(User user) {
        int updated = 0;
        try {
            updated = userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public int updateInfo(User user) {
        int updated = 0;
        try {
            updated = userDao.basicUpdate("UPDATE t_user SET " +
                            "user_name=?," +
                            "id_num=?," +
                            "phone_num=?," +
                            "email=?" +
                            "WHERE user_id=?",
                    user.getUserName(),
                    user.getIdNum(),
                    user.getPhoneNum(),
                    user.getEmail(),
                    user.getUserId()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public int updatePrivilege(User user) {
        int updated = 0;
        try {
            updated = userDao.basicUpdate("UPDATE t_user SET " +
                            "type=?," +
                            "cash_pledge=?," +
                            "group_id=?," +
                            "WHERE user_id=?",
                    user.getType(),
                    user.getCashPledge(),
                    user.getGroupId(),
                    user.getUserId()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public int delete(User user) {
        int updated = 0;
        try {
            updated = userDao.basicUpdate("UPDATE t_user SET type='DELETED' WHERE user_id=?", user.getUserId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public int add(User user, String loginName, String scrPassword) {
        int updated = 0;
        Connection connection;
        try {
            connection = DatabaseUtil.getConnection();
            connection.setAutoCommit(false);
            int userId = userDao.insert(connection, user);
            if (userId != -1) {
                Login login = new Login();
                String salt = UUID.randomUUID().toString();
                login.setLoginName(loginName);
                login.setPassword(ShaUtil.sha256(scrPassword + salt));
                login.setSalt(salt);
                login.setUserId(userId);
                updated = loginDao.insert(connection, login);
                connection.commit();
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }
}
