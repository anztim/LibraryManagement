package com.anztim.library.manager.dao;

import com.anztim.library.manager.domain.Config;

import java.sql.SQLException;

/**
 * @author anztim
 */
public class ConfigDao extends AbstractDao<Config> {
    public ConfigDao() {
        super(Config.class);
    }

    public String getValue(String key) throws SQLException {
        return (String) basicQueryScalar("SELECT 'value' FROM t_config WHERE config_key=?", key);
    }

    public int setValue(String key, String value) throws SQLException {
        return basicUpdate("UPDATE t_config SET config_value=? WHERE config_key=?", value, key);
    }
}
