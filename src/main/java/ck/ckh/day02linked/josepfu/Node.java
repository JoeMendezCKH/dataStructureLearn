package ck.ckh.day02linked.josepfu;

import lombok.Getter;
import lombok.Setter;

/**
 * 约瑟夫问题的节点类
 * @author Joe
 * @create 2019/10/16 15:38
 */
@Getter
@Setter
public class Node {
    private int no;
    public Node next;

    public Node(int no){
        this.no = no;
    }
}
