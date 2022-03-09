package com.anztim.library.manager.utils;

import com.anztim.library.manager.dao.*;
import com.anztim.library.manager.domain.*;
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

/**
 * @author anztim
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Borrow borrow = new Borrow(0, "ACTIVE", "1290", 10, "2022-03-04", "2022-03-06", 0);
        new BorrowDao().insert(borrow);
    }
}
