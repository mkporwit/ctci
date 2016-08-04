package net.porwit.ctci.LinkedLists;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Unit test for Node
 */
public class NodeTest {
    @Test
    public void containTest() {
        Node<String> list = new Node<String>("aa");
        assertTrue("contains success", list.contains("aa"));
        assertFalse("contains failure", list.contains("ab"));
    }

    @Test
    public void appendTest() {
        Node<String> list = new Node<String>("aa");
        assertNotNull(list);
        list = list.append(new Node<String>("bb"));
        assertTrue("append contains success", list.contains("bb"));
        list = list.append(new Node<String>("cc"));
        assertTrue("append success again", list.contains("cc"));
        // Verify order
        Node<String> runner = list;
        assertNotNull(runner);
        assertEquals("first node is aa", "aa", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("second node is bb", "bb", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("third node is cc", "cc", runner.data);
        runner = runner.next;
        assertEquals("end of the line", null, runner);
    }
    
    @Test
    public void removeDuplicatesTest() {
    	Node<String> list = new Node<String>("aa");
    	list = list.append(new Node<String>("bb"));
    	list = list.append(new Node<String>("cc"));
    	list = list.append(new Node<String>("aa"));
    	assertTrue("contains duplicate", list.next.contains("aa"));
    	list = list.removeDuplicates();
    	assertFalse("no longer contains duplicate", list.next.contains("aa"));
    	list = list.append(new Node<String>("bb"));
    	list = list.append(new Node<String>("cc"));
    	list = list.append(new Node<String>("dd"));
    	assertTrue("contains duplicate bb", list.next.next.contains("bb"));
    	assertTrue("contains duplicate cc", list.next.next.next.contains("cc"));
    	list = list.removeDuplicates();
    	assertFalse("no longer contains duplicate bb", list.next.next.contains("bb"));
    	assertFalse("no longer contains duplicate cc", list.next.next.next.contains("cc"));
    	// Verify order
        Node<String> runner = list;
        assertNotNull(runner);
        assertEquals("first node is aa", "aa", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("second node is bb", "bb", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("third node is cc", "cc", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("fourth node is dd", "dd", runner.data);
        runner = runner.next;
        assertEquals("end of the line", null, runner);
    }
    
    @Test
    public void findKthToLastTest() {
    	Node<String> list = new Node<String>("aa");
       	list = list.append(new Node<String>("bb"));
    	list = list.append(new Node<String>("cc"));
    	list = list.append(new Node<String>("dd"));
    	list = list.append(new Node<String>("ee"));    	
    	list = list.append(new Node<String>("ff"));    	
    	list = list.append(new Node<String>("gg"));
    	Node<String> kth = list.getKthToLast(3);
    	assertEquals("4th from last is dd", "dd", kth.data);
    	kth = list.getKthToLast(0);
    	assertEquals("0th from last is gg (last node", "gg", kth.data);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void findKthToLastNegativeArgTest() {
    	Node<String> list = new Node<String>("aa");
       	list = list.append(new Node<String>("bb"));
    	list = list.append(new Node<String>("cc"));
    	list = list.append(new Node<String>("dd"));
    	list = list.append(new Node<String>("ee"));    	
    	list = list.append(new Node<String>("ff"));    	
    	list = list.append(new Node<String>("gg"));
    	Node<String> kth = list.getKthToLast(-1);
    }
    
    @Test(expected=IndexOutOfBoundsException.class) 
    public void findKthToLastOutOfBoundsArgTest() {
    	Node<String> list = new Node<String>("aa");
    	list = list.append(new Node<String>("bb"));
    	list = list.append(new Node<String>("cc"));
    	list = list.append(new Node<String>("dd"));
    	list = list.append(new Node<String>("ee"));    	
    	list = list.append(new Node<String>("ff"));    	
    	list = list.append(new Node<String>("gg"));
    	Node<String> kth = list.getKthToLast(10);
    }
    
    @Test
    public void deleteFromMiddleTest() {
    	Node<String> list = new Node<String>("aa");
    	list = list.append(new Node<String>("bb"));
    	list = list.append(new Node<String>("cc"));
    	list.deleteFromMiddle(list.next);
    	assertTrue("still contains aa", list.contains("aa"));
    	assertTrue("still contains cc", list.contains("cc"));
    	assertFalse("does not contain bb", list.contains("bb"));
    }
    
    @Test
    public void partitionTest() {
    	Node<String> list = new Node<String>("aa");
    	list = list.append(new Node<String>("bb"));
    	list = list.append(new Node<String>("cc"));
    	list = list.append(new Node<String>("aa"));
    	list = list.append(new Node<String>("dd"));
    	list = list.append(new Node<String>("bb"));
    	list = list.append(new Node<String>("ee"));
    	list = list.partition("cc");
    	// Verify order
        Node<String> runner = list;
        assertNotNull(runner);
        assertEquals("first node is aa", "aa", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("second node is bb", "bb", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("third node is aa", "aa", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("fourth node is bb", "bb", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("fifth node is cc", "cc", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("sixth node is dd", "dd", runner.data);
        runner = runner.next;
        assertNotNull(runner);
        assertEquals("seventh node is ee", "ee", runner.data);
        runner = runner.next;
        assertEquals("end of the line", null, runner);
    }
    
    @Test
    public void sumTest() {
    	Node<Integer> d1 = new Node<Integer>(new Integer(7));
    	d1 = d1.append(new Node<Integer>(new Integer(1)));
    	d1 = d1.append(new Node<Integer>(new Integer(6)));
    	Node<Integer> d2 = new Node<Integer>(new Integer(5));
    	d2 = d2.append(new Node<Integer>(new Integer(9)));
    	d2 = d2.append(new Node<Integer>(new Integer(2)));
    	Node<Integer> result = Node.sum(d1, d2);
    	assertNotNull(result);
    	// Verify order
    	Node<Integer> runner = result;
    	assertEquals("first node is 2", 2, runner.data.intValue());
    	runner = runner.next;
    	assertEquals("second node is 1", 1, runner.data.intValue());
    	runner = runner.next;
    	assertEquals("third node is 9", 9, runner.data.intValue());
    	Node<Integer> d3 = new Node<Integer>(new Integer(5));
    	d3 = d3.append(new Node<Integer>(new Integer(9)));
    	d3 = d3.append(new Node<Integer>(new Integer(5)));
    	result = Node.sum(d1, d3);
    	// Verify order
    	runner = result;
    	assertEquals("first node is 2", 2, runner.data.intValue());
    	runner = runner.next;
    	assertEquals("second node is 1", 1, runner.data.intValue());
    	runner = runner.next;
    	assertEquals("third node is 2", 2, runner.data.intValue());
    	runner = runner.next;
    	assertEquals("fourth node is 1", 1, runner.data.intValue());
     }
    
    @Test
    public void palindromeTest() {
    	Node<String> list = new Node<String>("t");
    	list = list.append(new Node<String>("a"));
    	list = list.append(new Node<String>("c"));
    	list = list.append(new Node<String>("o"));
    	list = list.append(new Node<String>("c"));
    	list = list.append(new Node<String>("a"));
    	list = list.append(new Node<String>("t"));
    	assertTrue("tacocat is a palindrome", list.isPalindrome());
    	list = new Node<String>("t");
    	list = list.append(new Node<String>("a"));
    	list = list.append(new Node<String>("c"));
    	list = list.append(new Node<String>("o"));
    	list = list.append(new Node<String>("b"));
    	list = list.append(new Node<String>("a"));
    	list = list.append(new Node<String>("t"));
    	assertFalse("tacobat is not a palindrome", list.isPalindrome());
    	list = new Node<String>("t");
    	assertTrue("t is a palindrome", list.isPalindrome());
    	list = new Node<String>("t");
    	list = list.append(new Node<String>("t"));
    	assertTrue("tt is a palindrome", list.isPalindrome());
    }
    
    @Test
    public void intersectionTest() {
    	Node<String> l1 = new Node<String>("aa");
    	l1 = l1.append(new Node<String>("bb"));
    	l1 = l1.append(new Node<String>("cc"));
    	l1 = l1.append(new Node<String>("dd"));
    	l1 = l1.append(new Node<String>("ee"));
    	Node<String> l2 = new Node<String>("zz");
    	l2 = l2.append(new Node<String>("yy"));
    	l2 = l2.append(new Node<String>("xx"));
    	assertNull("no intersecting nodes", l1.intersection(l1, l2));
    	Node<String> iNode = new Node<String>("oo");
    	l1 = l1.append(iNode);
    	l2 = l2.append(iNode);
    	Node<String> ret = l1.intersection(l1, l2);
    	assertNotNull("found an intersecting node", ret);
    	assertEquals("refers to the same node", iNode, ret);
    	Node<String> someNode = new Node<String>("pp");
    	l1 = l1.append(someNode);
    	ret = l1.intersection(l1, l2);
    	assertNotNull("found an intersecting node", ret);
    	assertEquals("refers to the first intersecting node", iNode, ret);
    }
    @Test
    public void detectLoopTest() {
    	Node<String> list = new Node<String>("a");
    	list = list.append(new Node<String>("b"));
    	list = list.append(new Node<String>("c"));
    	list = list.append(new Node<String>("d"));
    	list = list.append(new Node<String>("e"));
    	Node<String> circ = new Node<String>("f");
    	circ.next = list.next.next;
    	list = list.append(circ);
    	Node<String> ret = list.detectLoop();
    	assertNotNull(ret);
    	assertEquals("first looping node", list.next.next, ret);
    	
    }
}
