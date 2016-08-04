package net.porwit.ctci.LinkedLists;

class Node<E extends Comparable<E>> {
    Node<E> next = null;
    E data;

    public Node(E d) {
        data = d;
    }

    public Node<E> append(Node<E> node) {
        Node<E> runner = this;
        while(runner.next != null) {
            runner = runner.next;
        }
        // Don't need this since each new node is null-terminated by default, and this way it can append a node or a list to an existing list
        //node.next = runner.next;
        runner.next = node;

        return this;
    }

    public boolean contains(E data) {
        Node<E> runner = this;
        while(runner != null) {
            if(data.equals(runner.data)) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }
    
    public Node<E> removeDuplicates() {
    	Node<E> runner = this;
    	Node<E> newList = new Node<E>(this.data);
    	while(runner != null) {
    		if(!newList.contains(runner.data)) {
    			newList = newList.append(new Node<E>(runner.data));
    		}
    		runner = runner.next;
    	}
    	return newList;
    }
    
    /**
     * Returns the kth from end element of the list, zero indexed. So, if k is zero, it will return the last element
     * 
     * @param k -- the offset of the node from the end, zero-indexed
     * @return -- a reference to the node
     * @throws -- IllegalArgumentException if k < 0
     * @throws -- IndexOutOfBoundsException if k is greater than the number of nodes in the list
     */
    public Node<E> getKthToLast(int k) throws IllegalArgumentException {
    	if(k < 0) {
    		throw new IllegalArgumentException("k must be a positive value");
    	}
    	Node<E> cur = this;
    	Node<E> runner = this;
    	for(int i = 0; i < k; i++) {
    		if(runner.next != null) {
    			runner = runner.next;
    		} else {
    			throw new IndexOutOfBoundsException("k was [" + k + "] but only found [" + i + 1 + "] nodex");
    		}
    	}
    	while(runner.next != null) {
    		cur = cur.next;
    		runner = runner.next;
    	}
    	
    	return cur;
    }
    
    public void deleteFromMiddle(Node<E> node) {
    	if(node == null) {
    		return;
    	} else {
    		Node<E> runner = node.next;
    		while(runner != null) {
    			node.data = runner.data;
    			node = runner;
    			runner = runner.next;
    		}
    	}
    }
    
    public Node<E> partition(E data) {
    	if(data == null) {
    		return this;
    	}
    	if(!this.contains(data)) {
    		return this;
    	}
    	Node<E> leftPart = null, rightPart = null, middlePart = null, runner = this;
    	while(runner != null) {
    		Node<E> n = new Node<E>(runner.data);
    		if(runner.data.compareTo(data) == 0) {
    			if(middlePart == null) {
    				middlePart = n;
    			} else {
    				middlePart = middlePart.append(n);
    			}
    		} else if (runner.data.compareTo(data) < 0) {
    			if(leftPart == null) {
    				leftPart = n;
    			} else {
    				leftPart = leftPart.append(n);
    			}
    		} else if (runner.data.compareTo(data) > 0) {
    			if(rightPart == null) {
    				rightPart = n;
    			} else {
    				rightPart = rightPart.append(n);
    			}
    		}
    		runner = runner.next;
    	}
    	return leftPart.append(middlePart.append(rightPart));
    }
}
