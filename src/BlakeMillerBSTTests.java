import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BlakeMillerBSTTests {
    private final int TIMEOUT = 1000;
    private BST<Integer> bst1;
    private BST<Integer> bst2;
    private BST<String> bst3;
    private BST<String> bst4;

    @Before
    public void setUp() {
        Collection<Integer> initialValues = new ArrayList<>();
        initialValues.add(0);
        initialValues.add(10);
        initialValues.add(5);
        initialValues.add(6);
        initialValues.add(2);
        initialValues.add(4);
        initialValues.add(7);
        initialValues.add(8);
        initialValues.add(9);
        initialValues.add(19);

        Collection<Integer> initialValues2 = new ArrayList<>();
        initialValues2.add(-5);
        initialValues2.add(-99);
        initialValues2.add(-100);
        initialValues2.add(-68);
        initialValues2.add(-53);
        initialValues2.add(6);
        initialValues2.add(32);
        initialValues2.add(65);
        initialValues2.add(-3);
        initialValues2.add(0);
        initialValues2.add(1);

        Collection<String> initialValues4 = new ArrayList<>();
        initialValues4.add("cat");
        initialValues4.add("dog");
        initialValues4.add("a");
        initialValues4.add("b");
        initialValues4.add("x");

        bst1 = new BST<>(initialValues);
        bst2 = new BST<>(initialValues2);
        bst3 = new BST<>();
        bst4 = new BST<>(initialValues4);
    }

    @Test(timeout = TIMEOUT)
    public void testPreorder() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(10);
        result.add(5);
        result.add(2);
        result.add(4);
        result.add(6);
        result.add(7);
        result.add(8);
        result.add(9);
        result.add(19);

        assertEquals(result, bst1.preorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPreorder2() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-5);
        result.add(-99);
        result.add(-100);
        result.add(-68);
        result.add(-53);
        result.add(6);
        result.add(-3);
        result.add(0);
        result.add(1);
        result.add(32);
        result.add(65);

        assertEquals(result, bst2.preorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPreorder3() {
        ArrayList<String> result = new ArrayList<String>();
        assertEquals(result, bst3.preorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPreorder4() {
        ArrayList<String> result = new ArrayList<String>();

        result.add("cat");
        result.add("a");
        result.add("b");
        result.add("dog");
        result.add("x");

        assertEquals(result, bst4.preorder());
    }

    @Test(timeout = TIMEOUT)
    public void testInorder() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(2);
        result.add(4);
        result.add(5);
        result.add(6);
        result.add(7);
        result.add(8);
        result.add(9);
        result.add(10);
        result.add(19);

        assertEquals(result, bst1.inorder());
    }

    @Test(timeout = TIMEOUT)
    public void testInorder2() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-100);
        result.add(-99);
        result.add(-68);
        result.add(-53);
        result.add(-5);
        result.add(-3);
        result.add(0);
        result.add(1);
        result.add(6);
        result.add(32);
        result.add(65);

        assertEquals(result, bst2.inorder());
    }

    @Test(timeout = TIMEOUT)
    public void testInorder3() {
        ArrayList<String> result = new ArrayList<String>();
        assertEquals(result, bst3.inorder());
    }

    @Test(timeout = TIMEOUT)
    public void testInorder4() {
        ArrayList<String> result = new ArrayList<String>();

        result.add("a");
        result.add("b");
        result.add("cat");
        result.add("dog");
        result.add("x");

        assertEquals(result, bst4.inorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPostorder() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(4);
        result.add(2);
        result.add(9);
        result.add(8);
        result.add(7);
        result.add(6);
        result.add(5);
        result.add(19);
        result.add(10);
        result.add(0);

        assertEquals(result, bst1.postorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPostorder2() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-100);
        result.add(-53);
        result.add(-68);
        result.add(-99);
        result.add(1);
        result.add(0);
        result.add(-3);
        result.add(65);
        result.add(32);
        result.add(6);
        result.add(-5);

        assertEquals(result, bst2.postorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPostorder3() {
        ArrayList<String> result = new ArrayList<String>();
        assertEquals(result, bst3.postorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPostorder4() {
        ArrayList<String> result = new ArrayList<String>();
        result.add("b");
        result.add("a");
        result.add("x");
        result.add("dog");
        result.add("cat");

        assertEquals(result, bst4.postorder());
    }

    @Test(timeout = TIMEOUT)
    public void testLevelorder() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(10);
        result.add(5);
        result.add(19);
        result.add(2);
        result.add(6);
        result.add(4);
        result.add(7);
        result.add(8);
        result.add(9);

        assertEquals(result, bst1.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testLevelorder2() {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-5);
        result.add(-99);
        result.add(6);
        result.add(-100);
        result.add(-68);
        result.add(-3);
        result.add(32);
        result.add(-53);
        result.add(0);
        result.add(65);
        result.add(1);

        assertEquals(result, bst2.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testLevelorder3() {
        ArrayList<String> result = new ArrayList<String>();
        assertEquals(result, bst3.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testLevelorder4() {
        ArrayList<String> result = new ArrayList<String>();

        result.add("cat");
        result.add("a");
        result.add("dog");
        result.add("b");
        result.add("x");

        assertEquals(result, bst4.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testHeight() {
        assertEquals(6, bst1.height());
    }

    @Test(timeout = TIMEOUT)
    public void testHeight2() {
        assertEquals(6, bst1.height());
    }

    @Test(timeout = TIMEOUT)
    public void testHeight3() {
        assertEquals(-1, bst3.height());
    }

    @Test(timeout = TIMEOUT)
    public void testHeight4() {
        assertEquals(2, bst4.height());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        bst1.clear();
        assertEquals(0, bst1.size());
        assertEquals(new ArrayList<BSTNode<Integer>>(), bst1.preorder());
    }

    @Test(timeout = TIMEOUT)
    public void testSize() {
        assertEquals(10, bst1.size());
    }

    @Test(timeout = TIMEOUT)
    public void testSize2() {
        assertEquals(11, bst2.size());
    }

    @Test(timeout = TIMEOUT)
    public void testSize3() {
        assertEquals(0, bst3.size());
    }

    @Test(timeout = TIMEOUT)
    public void testSize4() {
        assertEquals(5, bst4.size());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveZeroChildren() {
        Collection<Integer> initialValues = new ArrayList<>();
        initialValues.add(0);
        initialValues.add(5);
        initialValues.add(6);
        initialValues.add(-4);
        initialValues.add(-6);
        initialValues.add(22);

        BST bst = new BST(initialValues);
        bst.remove(22);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(-6);
        expected.add(-4);
        expected.add(0);
        expected.add(5);
        expected.add(6);
        assertEquals(expected, bst.inorder());

        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(0);
        expected2.add(-4);
        expected2.add(5);
        expected2.add(-6);
        expected2.add(6);

        assertEquals(expected2, bst.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveOneChildren() {
        Collection<Integer> initialValues = new ArrayList<>();
        initialValues.add(0);
        initialValues.add(5);
        initialValues.add(6);
        initialValues.add(-4);
        initialValues.add(-6);
        initialValues.add(22);

        BST bst = new BST(initialValues);
        bst.remove(6);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(-6);
        expected.add(-4);
        expected.add(0);
        expected.add(5);
        expected.add(22);
        assertEquals(expected, bst.inorder());

        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(0);
        expected2.add(-4);
        expected2.add(5);
        expected2.add(-6);
        expected2.add(22);

        assertEquals(expected2, bst.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveTwoChildren() {
        Collection<Integer> initialValues = new ArrayList<>();
        initialValues.add(0);
        initialValues.add(5);
        initialValues.add(6);
        initialValues.add(-4);
        initialValues.add(-6);
        initialValues.add(22);

        BST bst = new BST(initialValues);
        bst.remove(0);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(-6);
        expected.add(-4);
        expected.add(5);
        expected.add(6);
        expected.add(22);
        assertEquals(expected, bst.inorder());

        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(-4);
        expected2.add(-6);
        expected2.add(5);
        expected2.add(6);
        expected2.add(22);

        assertEquals(expected2, bst.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testRemove2() {
        Collection<Integer> initialValues = new ArrayList<>();
        initialValues.add(6);
        initialValues.add(20);
        initialValues.add(42);
        initialValues.add(14);
        initialValues.add(21);
        initialValues.add(0);
        initialValues.add(4);

        BST bst = new BST(initialValues);
        assertEquals(7, bst.size());
        bst.remove(6);
        bst.remove(20);
        bst.remove(14);
        bst.remove(4);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(42);
        expected.add(21);

        assertEquals(expected, bst.levelorder());
        assertEquals(3, bst.size());
    }

    @Test(timeout = TIMEOUT)
    public void testRemove3() {
        Collection<Integer> initialValues = new ArrayList<>();
        initialValues.add(20); //
        initialValues.add(-5);
        initialValues.add(-4);
        initialValues.add(47);
        initialValues.add(15); //
        initialValues.add(49);
        initialValues.add(16); //
        initialValues.add(18);
        initialValues.add(2);

        BST bst = new BST(initialValues);
        bst.remove(20);
        bst.remove(15);
        bst.remove(16);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(18);
        expected.add(-5);
        expected.add(47);
        expected.add(-4);
        expected.add(49);
        expected.add(2);

        assertEquals(expected, bst.levelorder());
        assertEquals(6, bst.size());
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeDNEInTreeException() {
        Collection<Integer> initialValues = new ArrayList<>();
        initialValues.add(20); //
        initialValues.add(-5);
        initialValues.add(-4);
        initialValues.add(47);
        initialValues.add(15); //
        initialValues.add(49);
        initialValues.add(16); //
        initialValues.add(18);
        initialValues.add(2);

        BST bst = new BST(initialValues);
        bst.remove(14);
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        Integer seven = new Integer(7);
        Integer six = new Integer(6);
        Integer four = new Integer(4);
        Integer five = new Integer(5);
        Integer nine = new Integer(9);

        BST bst = new BST();
        bst.add(seven);
        bst.add(six);
        bst.add(four);
        bst.add(five);
        bst.add(nine);

        assertEquals(nine, bst.get(9));
        assertEquals(five, bst.get(5));

        assertEquals(5, bst.size());
    }

    @Test(timeout = TIMEOUT)
    public void testContains() {
        BST bst = new BST();
        bst.add(4);
        bst.add(9);
        bst.add(5);
        bst.add(-1);
        bst.add(42);
        bst.add(192);

        assertTrue(bst.contains(192));
        assertTrue(bst.contains(42));
        assertFalse(bst.contains(40));
        assertTrue(bst.contains(4));
        assertTrue(bst.contains(9));
        assertTrue(bst.contains(5));
        assertFalse(bst.contains(65));
        assertFalse(bst.contains(99));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testNullAdd() {
        BST bst = new BST();
        bst.add(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testNullRemove() {
        BST bst = new BST();
        bst.add(5);

        bst.remove(null);
    }

    @Test(timeout = TIMEOUT)
    public void addDuplicate() {
        BST bst = new BST();
        bst.add(5);
        bst.add(6);
        bst.add(4);
        bst.add(5);
        bst.add(4);
        bst.add(6);
        bst.add(7);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(4);
        expected.add(6);
        expected.add(7);

        assertEquals(expected, bst.levelorder());
        assertEquals(4, bst.size());
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeDNEInTree() {
        BST bst = new BST();
        bst.add(5);

        bst.remove(4);
    }

    @Test(timeout = TIMEOUT)
    public void treeIsBST() {
        assertTrue(BST.isBST(bst1.getRoot()));
        bst1.getRoot().getRight().getRight().setData(-100);
        assertFalse(BST.isBST(bst1.getRoot()));

        assertTrue(BST.isBST(bst2.getRoot()));
        bst2.getRoot().getLeft().getRight().setData(10000);
        assertFalse(BST.isBST(bst2.getRoot()));

        assertTrue(BST.isBST(bst3.getRoot()));

        assertTrue(BST.isBST(bst4.getRoot()));
        bst4.getRoot().setData("k");
        assertFalse(BST.isBST(bst4.getRoot()));

        BST bst = new BST();
        bst.add(2);
        bst.add(3);
        bst.add(5);
        bst.add(4);

        assertTrue(BST.isBST(bst.getRoot()));

        bst.getRoot().getRight().setData(0);

        assertFalse(BST.isBST(bst.getRoot()));

        assertTrue(BST.isBST(null));
    }

    @Test(timeout = TIMEOUT)
    public void treeIsBSTMultilayer() {
        // Thanks to the top poster for catching this edge case
        BST<Float> bst = new BST<Float>();

        bst.add(5F);
        bst.add(4F);
        bst.add(7F);
        bst.add(1F);
        bst.add(4.5F);
        bst.add(6F);
        bst.add(8F);
        bst.add(0F);
        bst.add(2F);
        bst.add(4.3F);

        assertTrue(BST.isBST(bst.getRoot()));

        bst.getRoot().getLeft().getRight().setData(10F);
        bst.getRoot().getLeft().getRight().getLeft().setData(11F);

        assertFalse(BST.isBST(bst.getRoot()));
    }
}