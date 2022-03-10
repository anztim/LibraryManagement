package com.anztim.library.manager.domain;

/**
 * @author anztim
 */
@SuppressWarnings("unused")
public class Login {

    private Integer loginId;
    private String loginName;
    private String password;
    private String salt;
    private Integer userId;

    public Login() {
    }

    public Login(Integer loginId, String loginName, String password, String salt, Integer userId) {
        this.loginId = loginId;
        this.loginName = loginName;
        this.password = password;
        this.salt = salt;
        this.userId = userId;
    }

    public Integer getLoginId() {
        return this.loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
