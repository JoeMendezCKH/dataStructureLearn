package ck.ckh.d02linked.doublelinkedlist02;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Joe
 * @create 2020/3/7 14:25
 */
@Getter
@Setter
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
}
