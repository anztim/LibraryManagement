package com.anztim.library.manager.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author anztim
 */
public class DatabaseUtil {
    private DatabaseUtil() {
    }

    private static DataSource dataSource;

    static {
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void init() throws Exception {
        Properties pro = new Properties();

        pro.load(DatabaseUtil.class.getResourceAsStream("db.properties"));

        if (!(pro.containsKey("url") && pro.containsKey("username") && pro.containsKey("password"))) return;

        dataSource = DruidDataSourceFactory.createDataSource(pro);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static QueryRunner getQueryRunner() {
        return new QueryRunner(dataSource);
    }

}
