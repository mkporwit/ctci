package net.porwit.ctci.LinkedLists;

class Node<E> {
    Node<E> next = null;
    E data;

    public Node(E d) {
        data = d;
    }

    public Node<E> append(Node<E> node) {
        Node<E> runner = this;
        while(this.next != null) {
            runner = runner.next;
        }
        node.next = runner.next;
        runner.next = node;

        return this;
    }

    public boolean contains(E data) {
        Node<E> runner = this;
        while(this.next != null) {
            if(data.equals(this.data)) {
                return true;
            }
        }
        return false;
    }
    
    public Node<E> removeDuplicates(Node<E> list) {
        return list;
    }
}
