package com.anztim.library.manager.dao;

import com.anztim.library.manager.domain.User;
import com.anztim.library.manager.utils.DatabaseUtil;

import java.sql.*;

/**
 * @author anztim
 */
public class UserDao extends AbstractDao<User> {
    public static final String FULL_FIELD_LIST = "user_id,type,user_name,id_num,cash_pledge,group_id,phone_num,email";

    public UserDao() {
        super(User.class);
    }

    public User getById(int id) throws SQLException {
        return basicQuery("SELECT " + FULL_FIELD_LIST + " FROM t_user WHERE user_id=?", id);
    }

    public int insert(User obj) throws SQLException {
        int user_id = -1;
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO t_user(" + FULL_FIELD_LIST + ") VALUES(null,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, obj.getType());
        statement.setString(2, obj.getUserName());
        statement.setString(3, obj.getIdNum());
        statement.setInt(4, obj.getCashPledge());
        statement.setInt(5, obj.getGroupId());
        statement.setString(6, obj.getPhoneNum());
        statement.setString(7, obj.getEmail());
        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            user_id = resultSet.getInt(1);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return user_id;
    }

    public int update(User obj) throws SQLException {
        return basicUpdate("UPDATE t_user SET " +
                "type=?," +
                "user_name=?," +
                "id_num=?," +
                "cash_pledge=?," +
                "group_id=?," +
                "phone_num=?," +
                "email=?" +
                "WHERE user_id=?",
                obj.getType(),
                obj.getUserName(),
                obj.getIdNum(),
                obj.getCashPledge(),
                obj.getGroupId(),
                obj.getPhoneNum(),
                obj.getEmail(),
                obj.getUserId()
        );
    }
}
