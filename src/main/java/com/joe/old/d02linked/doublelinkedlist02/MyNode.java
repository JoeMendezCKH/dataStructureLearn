package com.joe.old.d02linked.doublelinkedlist02;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Joe
 * @create 2020/3/7 14:25
 */
@ToString(exclude = {"next", "pre"})
public class MyNode {
    private int id;
    private String name;
    private String nickName;

    /**
     * pointer the previous node
     */
    public MyNode pre;
    public MyNode next;

    public MyNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
