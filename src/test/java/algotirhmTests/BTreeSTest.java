
package algotirhmTests;

import org.junit.Assert;
import org.junit.Test;
import algorithm.BTreeS;
public class BTreeSTest extends Assert {
    final int TEST_NUMBER = 666;

    @Test
    public void testSearch() {
        BTreeS btree = new BTreeS();
        int[] i = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int n : i) {
            btree.insert(n);
        }
        for (int n : i) {
            assertEquals(btree.search(n), true);
        }
    }

    @Test
    public void testSearchF() {
        BTreeS btree = new BTreeS();
        int[] i = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int n : i) {
            btree.insert(n);
        }
        assertEquals(btree.search(TEST_NUMBER), false);
    }

    @Test
    public void testDelete() {
        BTreeS btree = new BTreeS();
        int[] i = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 666};
        for (int n : i) {
            btree.insert(n);
        }
        assertEquals(btree.delete(TEST_NUMBER), true);
    }

    @Test
    public void testDeleteF() {
        BTreeS btree = new BTreeS();
        int[] i = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int n : i) {
            btree.insert(n);
        }
        assertEquals(btree.delete(TEST_NUMBER), false);
    }

    @Test
    public void testDelEmptyBTree() {
        BTreeS btree = new BTreeS();
        assertEquals(btree.delete(TEST_NUMBER), false);
    }

    @Test
    public void testSearchEmptyBTree() {
        BTreeS btree = new BTreeS();
        assertEquals(btree.search(TEST_NUMBER), false);
    }

    @Test
    public void testInsert() {
        BTreeS btree = new BTreeS();
        int[] i = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int n : i) {
            btree.insert(n);
        }
    }

    @Test
    public void testPrint() {
        BTreeS btree = new BTreeS();
        int[] i = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int n : i) {
            btree.insert(n);
        }
        btree.print();
        assertEquals(btree.print(), true);
    }
}


