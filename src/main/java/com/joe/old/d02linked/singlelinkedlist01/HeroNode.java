package com.joe.old.d02linked.singlelinkedlist01;

import lombok.*;

/**
 * @author Joe
 * @create 2020/3/5 11:14
 * hero node object is a node
 */
@ToString(exclude = "next")
public class HeroNode {
    private int id;
    private String name;
    private String nickName;
    public HeroNode next;

    public HeroNode(int id, String name, String nickName) {
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
