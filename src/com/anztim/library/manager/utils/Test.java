package com.anztim.library.manager.utils;

import com.anztim.library.manager.dao.*;
import com.anztim.library.manager.domain.*;
import com.anztim.library.manager.service.LoginService;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.UUID;

/**
 * @author anztim
 */
public class Test {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setType("READER");
        user.setUserName("Orange");
        user.setIdNum("888888888888888888");
        user.setCashPledge(0);
        user.setGroupId(1);
        user.setPhoneNum("");
        user.setEmail("i@azti.me");
        int re = new UserDao().insert(user);
    }
}
