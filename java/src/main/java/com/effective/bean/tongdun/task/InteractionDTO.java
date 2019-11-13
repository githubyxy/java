package com.effective.bean.tongdun.task;

import java.io.Serializable;

/**
 * 
 * @author yuxiaoyu
 *
 */
public class InteractionDTO implements Serializable {

    private static final long serialVersionUID = -5891007517680153856L;

    private String nodeName;

    private String role;

    private String content;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

