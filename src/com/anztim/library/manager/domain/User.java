package com.anztim.library.manager.domain;

/**
 * @author anztim
 */
@SuppressWarnings("unused")
public class User {
    private Integer	userId;
    private String	type;
    private String	userName;
    private String	idNum;
    private Integer	cashPledge;
    private Integer	groupId;
    private String	phoneNum;
    private String	email;

    public User() {
    }

    public User(Integer userId, String type, String userName, String idNum, Integer cashPledge, Integer groupId, String phoneNum, String email) {
        this.userId = userId;
        this.type = type;
        this.userName = userName;
        this.idNum = idNum;
        this.cashPledge = cashPledge;
        this.groupId = groupId;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public Integer getCashPledge() {
        return cashPledge;
    }

    public void setCashPledge(Integer cashPledge) {
        this.cashPledge = cashPledge;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
