package com.crb.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author crb
 * @since 2022-05-19
 */
@TableName("administrator")
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String password;

    private String gender;

    private String department;

    private Boolean superadmin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public Boolean getSuperadmin() {
        return superadmin;
    }

    public void setSuperadmin(Boolean superadmin) {
        this.superadmin = superadmin;
    }

    @Override
    public String toString() {
        return "Administrator{" +
            "id=" + id +
            ", name=" + name +
            ", password=" + password +
            ", gender=" + gender +
            ", department=" + department +
            ", superadmin=" + superadmin +
        "}";
    }
}
