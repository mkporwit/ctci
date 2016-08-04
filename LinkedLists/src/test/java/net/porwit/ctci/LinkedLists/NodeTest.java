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
        list = list.append(new Node<String>("aa"));
        assertNotNull(list);
    }
}
