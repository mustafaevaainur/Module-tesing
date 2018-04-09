package algotirhmTests;

import org.junit.Assert;
import org.junit.Test;
import algorithm.BTreeS;



public class BTreeSTest extends Assert {
    final int TEST_NUMBER = 666;

    @Test
    public void test() {
        BTreeS<Integer> btree = new BTreeS<Integer>();
        int[] i = {10, 1, 2, 3, 8};
        for (int n : i) {
            btree.insert(n);
        }
        assertEquals(btree.print(), " 1 2 3 8 10");
        assertEquals(btree.preOrder(), "2 1 8 3 10 ");
        assertEquals(btree.postOrder(),"1 3 10 8 2 " );
    }

    @Test
    public void testDel() {
        BTreeS<Integer> btree = new BTreeS<Integer>();
        int[] i = {10, 1, 2, 3, 8};
        for (int n : i) {
            btree.insert(n);
        }
        btree.delete(3);
        assertEquals(btree.print(), " 1 2 8 10");
        assertEquals(btree.preOrder(), "2 1 8 10 ");
        assertEquals(btree.postOrder(),"1 10 8 2 " );
    }

    @Test
    public void testSearch() {
        BTreeS<Integer> btree = new BTreeS<Integer>();
        int[] i = {10, 1, 2, 3, 8};
        for (int n : i) {
            btree.insert(n);
            btree.print();
        }
        btree.search(1);
        assertEquals(btree.search(1), true);
    }

    @Test
    public void testSearch666() {
        BTreeS<Integer> btree = new BTreeS<Integer>();
        int[] i = {10, 1, 2, 3, 8};
        for (int n : i) {
            btree.insert(n);
        }
        assertEquals(btree.search(TEST_NUMBER), false);
    }

    @Test
    public void testinsert666() {
        BTreeS<Integer> btree = new BTreeS<Integer>();
        int[] i = {10, 1, 2, 3};
        for (int n : i) {
            btree.insert(n);
        }
        btree.insert(TEST_NUMBER);
        assertEquals(btree.print(), " 1 2 3 10 666");
        assertEquals(btree.preOrder(), "2 1 10 3 666 ");
        assertEquals(btree.postOrder(),"1 3 666 10 2 " );
    }
}