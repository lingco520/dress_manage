package com.battcn.platform.pojo.po;

import javax.persistence.*;

import com.battcn.platform.pojo.RecordEntity;


/**
 * @author Levin
 */
@Table(name = "t_sys_operate")
public class Operate extends RecordEntity {


    private static final long serialVersionUID = 5943708964724195548L;

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 菜单ID
     */
    @Column(name = "menu_id")
    private Integer menuId;

    /**
     * 选项
     */
    private String op;

    /**
     * 名字
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序号
     */
    private Integer ordno;

    /**
     * 是否显示出来
     */
    @Column(name = "display")
    private Boolean display;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单ID
     *
     * @return menu - 菜单ID
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取选项
     *
     * @return op - 选项
     */
    public String getOp() {
        return op;
    }

    /**
     * 设置选项
     *
     * @param op 选项
     */
    public void setOp(String op) {
        this.op = op == null ? null : op.trim();
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 获取排序号
     *
     * @return ordno - 排序号
     */
    public Integer getOrdno() {
        return ordno;
    }

    /**
     * 设置排序号
     *
     * @param ordno 排序号
     */
    public void setOrdno(Integer ordno) {
        this.ordno = ordno;
    }

    /**
     * 获取是否显示出来
     *
     * @return show - 是否显示出来
     */
    public Boolean getDisplay() {
        return display;
    }

    /**
     * 设置是否显示出来
     *
     * @param display 是否显示出来
     */
    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Operate() {
    }

    public Operate(Integer menuId) {
        super();
        this.menuId = menuId;
    }

}