package com.joe.old.d02linked.singlelinkedlist01;

import lombok.*;

/**
 * @author Joe
 * @create 2020/3/5 11:14
 * hero node object is a node
 */
@Getter
@Setter
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
}
