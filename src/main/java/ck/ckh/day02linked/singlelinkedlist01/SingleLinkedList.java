package ck.ckh.day02linked.singlelinkedlist01;

/**
 * @author Joe
 * @create 2020/3/5 11:23
 */
public class SingleLinkedList {
    /**
     * init a head node
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * ignore the id sequence
     * find the last node , add the target node to the next
     *
     * @param node target node
     */
    public void add(HeroNode node) {
        HeroNode temp = head;
        // traversal linked
        while (temp.next != null) {
            temp = temp.next;
        }
        // now the temp is pointer the end of the linked
        temp.next = node;
    }

    public void list() {
        if (head.next == null) {
            throw new RuntimeException("linked is empty");
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void addByOrder(HeroNode node) {
        /* sign the hero exist */
        boolean flag = false;
        int id = node.getId();
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                // temp is the end
                break;
            } else if (temp.next.getId() > id) {
                //find the location
                break;
            } else if (temp.next.getId() == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("this node id is already exist: " + id + "\t");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }


    /**
     * update the node information from id
     */
    public void update(int id, String name, String nickName) {
        if (head.next == null) {
            throw new RuntimeException("linked is empty");
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getId() == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.setName(name);
            temp.setNickName(nickName);
        } else {
            throw new RuntimeException("the id " + id + " is not exist");
        }
    }

    public boolean delete(int id) {
        if (head.next == null) {
            throw new RuntimeException("linked is empty");
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                // end linked
                break;
            }
            if (temp.next.getId() == id) {
                // FIND
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("this id is not exist : " + id);
        }
        return flag;
    }

    public HeroNode getHead() {
        return head;
    }

}
