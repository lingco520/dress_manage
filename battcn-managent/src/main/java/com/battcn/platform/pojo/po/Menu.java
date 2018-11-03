package com.battcn.platform.pojo.po;

import javax.persistence.*;

import com.battcn.platform.pojo.RecordEntity;


/**
 * @author Levin
 */
@Table(name = "t_sys_menu")
public class Menu extends RecordEntity {


    private static final long serialVersionUID = 5460695457049484647L;

    /**
     * 自增ID
     */
    @Id
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 图标
     */
    private String icon;

    /**
     * 渠道
     */
    private String channel;

    private String param;

    /**
     * 是否启用 0=禁用 1=启用
     */
    private Boolean locked;

    /**
     * 父级编号
     */
    @Column(name = "pater_id")
    private Integer paterId;

    /**
     * 排序编号
     */
    private Integer ordno;

    /**
     * 级别
     */
    @Column(name = "n_level")
    private Integer nLevel;

    /**
     * tree所需
     */
    private String scort;

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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取渠道
     *
     * @return channel - 渠道
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 设置渠道
     *
     * @param channel 渠道
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * @return param
     */
    public String getParam() {
        return param;
    }

    /**
     * @param param
     */
    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
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
     * 获取父级编号
     *
     * @return pater_id - 父级编号
     */
    public Integer getPaterId() {
        return paterId;
    }

    /**
     * 设置父级编号
     *
     * @param paterId 父级编号
     */
    public void setPaterId(Integer paterId) {
        this.paterId = paterId;
    }

    /**
     * 获取排序编号
     *
     * @return ordno - 排序编号
     */
    public Integer getOrdno() {
        return ordno;
    }

    /**
     * 设置排序编号
     *
     * @param ordno 排序编号
     */
    public void setOrdno(Integer ordno) {
        this.ordno = ordno;
    }

    /**
     * 获取级别
     *
     * @return n_level - 级别
     */
    public Integer getnLevel() {
        return nLevel;
    }

    /**
     * 设置级别
     *
     * @param nLevel 级别
     */
    public void setnLevel(Integer nLevel) {
        this.nLevel = nLevel;
    }

    /**
     * 获取tree所需
     *
     * @return scort - tree所需
     */
    public String getScort() {
        return scort;
    }

    /**
     * 设置tree所需
     *
     * @param scort tree所需
     */
    public void setScort(String scort) {
        this.scort = scort == null ? null : scort.trim();
    }

    public Menu() {
    }

    public Menu(Boolean locked) {
        super();
        this.locked = locked;
    }


}