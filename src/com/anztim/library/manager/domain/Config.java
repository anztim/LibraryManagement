package com.anztim.library.manager.domain;

/**
 * @author anztim
 */
@SuppressWarnings("unused")
public class Config {
    private String	configKey;
    private String	configValue;

    public Config(String configKey, String configValue) {
        this.configKey = configKey;
        this.configValue = configValue;
    }

    public Config() {
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}
