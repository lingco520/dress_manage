package com.battcn.platform.pojo.po;

import javax.persistence.*;

import com.battcn.platform.pojo.RecordEntity;


/**
 * @author Levin
 */
@Table(name = "t_sys_manager")
public class Manager extends RecordEntity {

    private static final long serialVersionUID = -3467360899069048896L;

    /**
     * 自增ID
     */
    @Id
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    @Column(name = "role_id")
    private Byte roleId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 验证凭证
     */
    private String credential;

    /**
     * 是否启用 0=禁用 1=启用
     */
    private Boolean locked;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 类型
     */
    private String type;

    /**
     * 头像
     */
    private String photo;

    /**
     * 登陆IP
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取角色
     *
     * @return role_id - 角色
     */
    public Byte getRoleId() {
        return roleId;
    }

    /**
     * 设置角色
     *
     * @param roleId 角色
     */
    public void setRoleId(Byte roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取验证凭证
     *
     * @return credential - 验证凭证
     */
    public String getCredential() {
        return credential;
    }

    /**
     * 设置验证凭证
     *
     * @param credential 验证凭证
     */
    public void setCredential(String credential) {
        this.credential = credential == null ? null : credential.trim();
    }

    /**
     * 获取是否启用 0=禁用 1=启用
     *
     * @return locked - 是否启用 0=禁用 1=启用
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * 设置是否启用 0=禁用 1=启用
     *
     * @param locked 是否启用 0=禁用 1=启用
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取头像
     *
     * @return photo - 头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置头像
     *
     * @param photo 头像
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 获取登陆IP
     *
     * @return last_login_ip - 登陆IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置登陆IP
     *
     * @param lastLoginIp 登陆IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Manager() {
    }

    public Manager(String name) {
        super();
        this.name = name;
    }

}