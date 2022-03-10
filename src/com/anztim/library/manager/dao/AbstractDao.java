package com.anztim.library.manager.dao;

import com.anztim.library.manager.utils.DatabaseUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author anztim
 */
abstract class AbstractDao<T> {
    Class<T> klass;
    QueryRunner qr = DatabaseUtil.getQueryRunner();

    public AbstractDao(Class<T> klass) {
        this.klass = klass;
    }

    public int basicUpdate(String sql, Object... parameters) throws SQLException {
        return qr.update(sql, parameters);
    }

    public T basicQuery(String sql, Object... parameters) throws SQLException {
        return qr.query(sql, new BeanHandler<>(klass, new BasicRowProcessor((new GenerousBeanProcessor()))), parameters);
    }

    public List<T> basicQueryList(String sql, Object... parameters) throws SQLException {
        return qr.query(sql, new BeanListHandler<>(klass, new BasicRowProcessor((new GenerousBeanProcessor()))), parameters);
    }

    public Object basicQueryScalar(String sql, Object... parameters) throws SQLException {
        return qr.query(sql, new ScalarHandler<>(), parameters);
    }

    public int basicUpdate(Connection connection, String sql, Object... parameters) throws SQLException {

        return new QueryRunner().update(connection, sql, parameters);
    }

    public T basicQuery(Connection connection, String sql, Object... parameters) throws SQLException {
        return new QueryRunner().query(connection, sql, new BeanHandler<>(klass, new BasicRowProcessor((new GenerousBeanProcessor()))), parameters);
    }

    public List<T> basicQueryList(Connection connection, String sql, Object... parameters) throws SQLException {
        return new  QueryRunner().query(connection, sql, new BeanListHandler<>(klass, new BasicRowProcessor((new GenerousBeanProcessor()))), parameters);
    }

    public Object basicQueryScalar(Connection connection, String sql, Object... parameters) throws SQLException {
        return new  QueryRunner().query(connection, sql, new ScalarHandler<>(), parameters);
    }
}
