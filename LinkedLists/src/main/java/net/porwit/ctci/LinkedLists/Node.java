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
    
    public static Node<Integer> sum(Node<Integer> d1, Node<Integer> d2) {
    	Node<Integer> result = null, d1runner, d2runner;
    	
    	d1runner = d1;
    	d2runner = d2;
    	int carry = 0;
    	while (d1runner != null && d2runner != null) {
    		int r = d1runner.data.intValue() + d2runner.data.intValue() + carry;
    		carry = r/10;
    		r = r % 10;
    		d1runner = d1runner.next;
    		d2runner = d2runner.next;
    		Node<Integer> n = new Node<Integer>(new Integer(r));
    		if(result == null) {
    			result = n;
    		} else {
    			result = result.append(n);
    		}
    	}
    	
    	if(carry != 0) {
    		Node<Integer> n = new Node<Integer>(new Integer(carry));
    		result = result.append(n);
    	}
    	
    	return result;
    }

	public boolean isPalindrome() {
		int ind = 0;
		Node<E> runner = this;
		Node<E> backRunner = null;
		boolean isPalindrome = true;
		while(runner != null)
		{
			backRunner = this.getKthToLast(ind);
			if(runner.data.compareTo(backRunner.data) != 0) {
				isPalindrome = false;
				break;
			}
			runner = runner.next;
			ind++;
			if(backRunner == this) {
				break;
			}
		}
		
		return isPalindrome;
	}
	
	public Node<E> intersection(Node<E> l1, Node<E> l2) {
		Node<E> intersect = null, l1runner = l1, l2runner = l2;
		// get length of both lists
		int len1 = 0, len2 = 0;
		while(l1runner != null && l1runner.next != null) {
			l1runner = l1runner.next;
			len1++;
		}
		while(l2runner != null && l2runner.next != null) {
			l2runner = l2runner.next;
			len2++;
		}
		// at end of both lists -- see if that's the same spot
		if(l2runner == l1runner) {
			// both lists ended with the same node
			l1runner = l1;
			l2runner = l2;
			// check if one list is longer than the other and adjust runners
			if(len1 > len2) {
				for(int i = 0; i < len1 - len2; i++) {
					l1runner = l1runner.next;
				}
			} else if(len2 > len1) {
				for(int i = 0; i < len2 - len1; i++) {
					l2runner = l2runner.next;
				}
			}
			// both runners should now be equidistant from end
			while(l1runner != null && l2runner != null) {
				if(l1runner == l2runner) {
					intersect = l1runner;
					break;
				} else {
					l1runner = l1runner.next;
					l2runner = l2runner.next;
				}
			}
		}
		return intersect;
	}

	public Node<E> detectLoop() {
		Node<E> slow = this;
		Node<E> fast = this;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				break;
			}
		}
		slow = this;
		while(slow != null) {
			if(slow == fast) {
				break;
			} else {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
	}
}
