package com.joe.old.d06hashtable.older;

/**
 * 雇员, 也就是节点类
 * Created by Mendez on 19/10/29 15:53
 * @author Joe
 */
public class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
