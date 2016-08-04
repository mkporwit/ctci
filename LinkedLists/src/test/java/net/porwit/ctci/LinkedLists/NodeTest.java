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
}
