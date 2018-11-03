package com.battcn.framework.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构
 *
 * @author Levin
 * @since 2018-01-10
 */
public class TreeNode implements java.io.Serializable {

    private static final long serialVersionUID = 7167292131071749703L;

    private Integer id;
    private Integer pid;
    private String text;
    private String icon;
    private Object attributes;
    private List<TreeNode> children = new ArrayList<>();

    public TreeNode() {
    }

    public TreeNode(Integer id, String text, String icon) {
        super();
        this.id = id;
        this.text = text;
        this.icon = icon;
    }

    public TreeNode(Integer id, String text, String icon, List<TreeNode> children) {
        super();
        this.id = id;
        this.text = text;
        this.icon = icon;
        this.children = children;
    }

    public TreeNode(Integer id, Integer pid, String text, Object attributes, List<TreeNode> children) {
        super();
        this.id = id;
        this.pid = pid;
        this.text = text;
        this.attributes = attributes;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

}