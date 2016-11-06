package com.vips.mobile.dinner.domain;


import java.io.Serializable;

/**
 * Created by cielleech on 2016/11/6.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -7020619477594468968L;

    private Long id;

    private String employeeId;

    private String name;

    private String nickname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
