package com.anztim.library.manager.service;

import com.anztim.library.manager.dao.ConfigDao;
import com.anztim.library.manager.domain.Config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anztim
 */
public class ConfigService {
    private static Map<String, String> config;

    static {
        config = new HashMap<>();
        load();
    }

    public static void load() {
        List<Config> configList = null;
        try {
            configList = new ConfigDao().getList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (configList == null) return;
        for (Config c : configList) {
            config.put(c.getConfigKey(), c.getConfigValue());
        }
    }

    private ConfigDao configDao = new ConfigDao();

    public int set(String key, String value) {
        int updated = 0;
        try {
            if (get(key) != null) {
                updated = configDao.setValue(key, value);
            } else {
                updated = configDao.add(key, value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConfigService.load();
        return updated;
    }

    public String get(String key) {
        if (!ConfigService.config.containsKey(key)) {
            load();
            if (!ConfigService.config.containsKey(key)) {
                return null;
            }
        }
        return ConfigService.config.get(key);
    }
}
