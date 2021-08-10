import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * @author Rudresh Patel
 * @version 1.2
 *
 * This JUnit file maybe updated to include diagrams and more conditions to test the BST.
 * Personal Confidence Level on these unit tests: 80%
 *
 * NOTE: Base template for these tests was taken from the "BSTStudentTest.java" file provided by the TAs.
 *       Some tests maybe similar if not same to the provided student tests by the TAs.
 */
public class RudreshPatelBSTTests {

    private static final int TIMEOUT = 200;
    private BST<Integer> bst;
    private int i;

    @Before
    public void setup() {
        bst = new BST<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, bst.size());
        assertNull(bst.getRoot());
    }

    @Test(timeout = TIMEOUT)
    public void testConstructorAndClear() {

        List<Integer> toAdd = new ArrayList<>();
        toAdd.add(10);
        toAdd.add(9);
        toAdd.add(11);
        toAdd.add(4);
        toAdd.add(16);
        toAdd.add(8);
        toAdd.add(12);
        toAdd.add(3);
        toAdd.add(17);
        toAdd.add(7);
        toAdd.add(13);
        toAdd.add(2);
        toAdd.add(18);
        toAdd.add(6);
        toAdd.add(14);
        toAdd.add(1);
        toAdd.add(19);
        toAdd.add(5);
        toAdd.add(15);
        toAdd.add(0);
        toAdd.add(20);

        bst = new BST<>(toAdd);

        assertEquals((Integer) 10, bst.getRoot().getData());
        assertEquals((Integer) 9, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 11, bst.getRoot().getRight().getData());

        assertEquals((Integer) 4, bst.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 16, bst.getRoot().getRight().getRight().getData());

        assertEquals((Integer) 3, bst.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 2, bst.getRoot().getLeft().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 1, bst.getRoot().getLeft().getLeft().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 0, bst.getRoot().getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().getData());

        assertEquals((Integer) 8, bst.getRoot().getLeft().getLeft().getRight().getData());
        assertEquals((Integer) 7, bst.getRoot().getLeft().getLeft().getRight().getLeft().getData());
        assertEquals((Integer) 6, bst.getRoot().getLeft().getLeft().getRight().getLeft().getLeft().getData());
        assertEquals((Integer) 5, bst.getRoot().getLeft().getLeft().getRight().getLeft().getLeft().getLeft().getData());

        assertEquals((Integer) 12, bst.getRoot().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 13, bst.getRoot().getRight().getRight().getLeft().getRight().getData());
        assertEquals((Integer) 14, bst.getRoot().getRight().getRight().getLeft().getRight().getRight().getData());
        assertEquals((Integer) 15, bst.getRoot().getRight().getRight().getLeft().getRight()
                .getRight().getRight().getData());

        assertEquals((Integer) 17, bst.getRoot().getRight().getRight().getRight().getData());
        assertEquals((Integer) 18, bst.getRoot().getRight().getRight().getRight().getRight().getData());
        assertEquals((Integer) 19, bst.getRoot().getRight().getRight().getRight().getRight().getRight().getData());
        assertEquals((Integer) 20, bst.getRoot().getRight().getRight().getRight().getRight()
                .getRight().getRight().getData());

        assertEquals(21, bst.size());

        bst.clear();
        assertEquals(0, bst.size());
        assertNull(bst.getRoot());
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {

        //Test 1: Empty BST check
        assertEquals(0, bst.size());
        assertNull(bst.getRoot());

        //Test 2: single element
        bst.add(10);
        assertEquals(1, bst.size());
        assertEquals((Integer) 10, bst.getRoot().getData());

        //Test 3: three elements
        bst.add(5);
        bst.add(15);
        assertEquals(3, bst.size());
        assertEquals((Integer) 10, bst.getRoot().getData());
        assertEquals((Integer) 5, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 15, bst.getRoot().getRight().getData());

        //Test 4: Proper node placement
        bst.add(4);
        bst.add(6);
        bst.add(14);
        bst.add(16);
        assertEquals(7, bst.size());
        assertEquals((Integer) 10, bst.getRoot().getData());

        assertEquals((Integer) 5, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 15, bst.getRoot().getRight().getData());

        assertEquals((Integer) 4, bst.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 6, bst.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 14, bst.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 16, bst.getRoot().getRight().getRight().getData());

        //Test 5: --- Edge Case --- duplicate item
        bst.add(5);
        bst.add(10);
        bst.add(14);
        bst.add(6);

        assertEquals(7, bst.size());
        assertEquals((Integer) 10, bst.getRoot().getData());

        assertEquals((Integer) 5, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 15, bst.getRoot().getRight().getData());

        assertEquals((Integer) 4, bst.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 6, bst.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 14, bst.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 16, bst.getRoot().getRight().getRight().getData());

        assertNull(bst.getRoot().getLeft().getLeft().getLeft()); // null nodes of 4
        assertNull(bst.getRoot().getLeft().getLeft().getRight());

        assertNull(bst.getRoot().getLeft().getRight().getLeft()); // null nodes of 6
        assertNull(bst.getRoot().getLeft().getRight().getRight()); // null nodes of 6

        assertNull(bst.getRoot().getRight().getLeft().getLeft()); // null nodes of 14
        assertNull(bst.getRoot().getRight().getLeft().getRight());

        assertNull(bst.getRoot().getRight().getRight().getLeft()); // null nodes of 16
        assertNull(bst.getRoot().getRight().getRight().getRight());
    }


    @Test(timeout = TIMEOUT)
    public void testRemove() {
        Integer node1 = 10;
        Integer node2 = 5;
        Integer node3 = 15;
        Integer node4 = 4;
        Integer node5 = 6;
        Integer node6 = 14;
        Integer node7 = 16;

        bst.add(node1);
        bst.add(node2);
        bst.add(node3);
        bst.add(node4);
        bst.add(node5);
        bst.add(node6);
        bst.add(node7);
        assertEquals(7, bst.size());

        /*
         Here, There are three cases:
         1: The node containing the data is a leaf (no children).
         2: The node containing the data has one child. In this case, simply replace it with its child.
         3: The node containing the data has 2 children. Use the predecessor to replace the data.
         */

        // Case 1: Data in leaf

        assertSame(node5, bst.remove(6));

        // This was copied from add method therefore nothing is changed (after adding the last element).
        assertEquals(6, bst.size());
        assertEquals((Integer) 10, bst.getRoot().getData());

        assertEquals((Integer) 5, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 15, bst.getRoot().getRight().getData());

        assertEquals((Integer) 4, bst.getRoot().getLeft().getLeft().getData());
        //assertEquals((Integer) 6, bst.getRoot().getLeft().getRight().getData()); ------ Deleted Node ------
        assertEquals((Integer) 14, bst.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 16, bst.getRoot().getRight().getRight().getData());

        assertNull(bst.getRoot().getLeft().getRight()); // Node5 (which contains 6) itself
        assertNull(bst.getRoot().getLeft().getLeft().getLeft()); // null nodes of 4
        assertNull(bst.getRoot().getLeft().getLeft().getRight());
        //assertNull(bst.getRoot().getLeft().getRight().getLeft()); // null nodes of 6
        //assertNull(bst.getRoot().getLeft().getRight().getRight());
        assertNull(bst.getRoot().getRight().getLeft().getLeft()); // null nodes of 14
        assertNull(bst.getRoot().getRight().getLeft().getRight());
        assertNull(bst.getRoot().getRight().getRight().getLeft()); // null nodes of 16
        assertNull(bst.getRoot().getRight().getRight().getRight());


        //Case 2: Node containing one child
        // Here, we will add three more elements to test this case.

        Integer node8 = 25;
        Integer node9 = 20;
        Integer node10 = 30;

        bst.add(node8);
        bst.add(node9);
        bst.add(node10);

        assertEquals(9, bst.size());

        // Now, we will delete node7 (which is 16)

        assertSame(node7, bst.remove(16));


        assertEquals(8, bst.size());
        assertEquals((Integer) 10, bst.getRoot().getData());

        assertEquals((Integer) 5, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 15, bst.getRoot().getRight().getData());

        assertEquals((Integer) 4, bst.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 14, bst.getRoot().getRight().getLeft().getData());
        //assertEquals((Integer) 16, bst.getRoot().getRight().getRight().getData()); --- Deleted Node ---
        assertEquals((Integer) 25, bst.getRoot().getRight().getRight().getData());
        assertEquals((Integer) 20, bst.getRoot().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 30, bst.getRoot().getRight().getRight().getRight().getData());

        assertNull(bst.getRoot().getLeft().getRight()); // Node5 (which contains 6) itself
        assertNull(bst.getRoot().getLeft().getLeft().getLeft()); // null nodes of 4
        assertNull(bst.getRoot().getLeft().getLeft().getRight());
        assertNull(bst.getRoot().getRight().getLeft().getLeft()); // null nodes of 14
        assertNull(bst.getRoot().getRight().getLeft().getRight());
        //assertNull(bst.getRoot().getRight().getRight().getLeft()); // null nodes of 16 -- THESE NODES WERE REPLACED --
        //assertNull(bst.getRoot().getRight().getRight().getRight());
        assertNull(bst.getRoot().getRight().getRight().getLeft().getLeft()); // null nodes of 20
        assertNull(bst.getRoot().getRight().getRight().getLeft().getRight());
        assertNull(bst.getRoot().getRight().getRight().getRight().getLeft()); // Null nodes of 30
        assertNull(bst.getRoot().getRight().getRight().getRight().getRight());

        //Case 3: Two children. we will replace using predecessor.
        // We will fill up the BST by adding four elements

        Integer node11 = 12;
        Integer node12 = 3;
        Integer node13 = 6;  // ---- we will use 6 again.
        Integer node14 = 11;
        Integer node15 = 13;

        bst.add(12);
        bst.add(3);
        bst.add(6);
        bst.add(11);
        bst.add(13);

        assertEquals(13, bst.size());


        assertSame(node3, bst.remove(15));
        assertEquals(12, bst.size());

        assertEquals((Integer) 10, bst.getRoot().getData());

        assertEquals((Integer) 5, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 14, bst.getRoot().getRight().getData());

        assertEquals((Integer) 4, bst.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 6, bst.getRoot().getLeft().getRight().getData());
        assertEquals((Integer) 12, bst.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 25, bst.getRoot().getRight().getRight().getData());

        assertEquals((Integer) 3, bst.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 11, bst.getRoot().getRight().getLeft().getLeft().getData());
        assertEquals((Integer) 13, bst.getRoot().getRight().getLeft().getRight().getData());

        assertEquals((Integer) 20, bst.getRoot().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 30, bst.getRoot().getRight().getRight().getRight().getData());


        assertNull(bst.getRoot().getRight().getLeft().getLeft().getLeft()); // 11
        assertNull(bst.getRoot().getRight().getLeft().getLeft().getRight());

        assertNull(bst.getRoot().getRight().getLeft().getRight().getLeft()); // 13
        assertNull(bst.getRoot().getRight().getLeft().getRight().getRight());

        assertNull(bst.getRoot().getRight().getRight().getLeft().getLeft()); // 20
        assertNull(bst.getRoot().getRight().getRight().getLeft().getRight());

        assertNull(bst.getRoot().getRight().getRight().getRight().getLeft()); // 30
        assertNull(bst.getRoot().getRight().getRight().getRight().getRight());

        // Edge Case: Removing the root of the tree
        assertSame(node1, bst.remove(10));
        assertEquals(11, bst.size());

        assertEquals((Integer) 6, bst.getRoot().getData());

        assertEquals((Integer) 5, bst.getRoot().getLeft().getData());
        assertEquals((Integer) 14, bst.getRoot().getRight().getData());

        assertEquals((Integer) 4, bst.getRoot().getLeft().getLeft().getData());
        assertEquals((Integer) 12, bst.getRoot().getRight().getLeft().getData());
        assertEquals((Integer) 25, bst.getRoot().getRight().getRight().getData());

        assertEquals((Integer) 3, bst.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals((Integer) 11, bst.getRoot().getRight().getLeft().getLeft().getData());
        assertEquals((Integer) 13, bst.getRoot().getRight().getLeft().getRight().getData());

        assertEquals((Integer) 20, bst.getRoot().getRight().getRight().getLeft().getData());
        assertEquals((Integer) 30, bst.getRoot().getRight().getRight().getRight().getData());


        assertNull(bst.getRoot().getLeft().getRight()); // This is to check if there is a
        // pointer at the predecessor's place

        assertNull(bst.getRoot().getLeft().getLeft().getLeft().getLeft()); // 3 children
        assertNull(bst.getRoot().getLeft().getLeft().getLeft().getRight());

        assertNull(bst.getRoot().getRight().getLeft().getLeft().getLeft()); // 11 children
        assertNull(bst.getRoot().getRight().getLeft().getLeft().getRight());

        assertNull(bst.getRoot().getRight().getLeft().getRight().getLeft()); // 13 children
        assertNull(bst.getRoot().getRight().getLeft().getRight().getRight());

        assertNull(bst.getRoot().getRight().getRight().getLeft().getLeft()); // 20 children
        assertNull(bst.getRoot().getRight().getRight().getLeft().getRight());

        assertNull(bst.getRoot().getRight().getRight().getRight().getLeft()); // 30 children
        assertNull(bst.getRoot().getRight().getRight().getRight().getRight());
    }

    @Test(timeout = TIMEOUT)
    public void testGetAndContains() {
        Integer node1 = 10;
        Integer node2 = 5;
        Integer node3 = 15;
        Integer node4 = 4;
        Integer node5 = 6;
        Integer node6 = 14;
        Integer node7 = 16;

        bst.add(node1);
        bst.add(node2);
        bst.add(node3);
        bst.add(node4);
        bst.add(node5);
        bst.add(node6);
        bst.add(node7);

        assertSame(node1, bst.get(10));
        assertTrue(bst.contains(10));
        assertSame(node2, bst.get(5));
        assertTrue(bst.contains(5));
        assertSame(node3, bst.get(15));
        assertTrue(bst.contains(15));
        assertEquals(node4, bst.get(4));
        assertTrue(bst.contains(4));
        assertEquals(node5, bst.get(6));
        assertTrue(bst.contains(6));
        assertEquals(node6, bst.get(14));
        assertTrue(bst.contains(14));
        assertEquals(node7, bst.get(16));
        assertTrue(bst.contains(16));

        assertFalse(bst.contains(0));
        assertFalse(bst.contains(1));
        assertFalse(bst.contains(3));
        assertFalse(bst.contains(8));
        assertFalse(bst.contains(17));
        assertFalse(bst.contains(9));
    }

    @Test(timeout = TIMEOUT)
    public void testPreorder() {

        addElementsToBST(1);

        List<Integer> preorder = new ArrayList<>();
        preorder.add(10);
        preorder.add(9);
        preorder.add(4);
        preorder.add(3);
        preorder.add(2);
        preorder.add(1);
        preorder.add(0);
        preorder.add(8);
        preorder.add(7);
        preorder.add(6);
        preorder.add(5);
        preorder.add(11);
        preorder.add(16);
        preorder.add(12);
        preorder.add(13);
        preorder.add(14);
        preorder.add(15);
        preorder.add(17);
        preorder.add(18);
        preorder.add(19);
        preorder.add(20);

        assertEquals(preorder, bst.preorder());

        bst.clear();

        addElementsToBST(2);

        preorder = new ArrayList<>();
        preorder.add(10);
        preorder.add(5);
        preorder.add(4);
        preorder.add(6);
        preorder.add(15);
        preorder.add(14);
        preorder.add(16);

        assertEquals(preorder, bst.preorder());
    }

    @Test(timeout = TIMEOUT)
    public void testInorder() {
        addElementsToBST(1);
        List<Integer> inorder = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            inorder.add(i);
        }
        assertEquals(inorder, bst.inorder());
        bst.clear();
        addElementsToBST(2);
        inorder = new ArrayList<>();
        inorder.add(4);
        inorder.add(5);
        inorder.add(6);
        inorder.add(10);
        inorder.add(14);
        inorder.add(15);
        inorder.add(16);
        assertEquals(inorder, bst.inorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPostorder() {
        addElementsToBST(1);

        List<Integer> postorder = new ArrayList<>();
        postorder.add(0);
        postorder.add(1);
        postorder.add(2);
        postorder.add(3);
        postorder.add(5);
        postorder.add(6);
        postorder.add(7);
        postorder.add(8);
        postorder.add(4);
        postorder.add(9);
        postorder.add(15);
        postorder.add(14);
        postorder.add(13);
        postorder.add(12);
        postorder.add(20);
        postorder.add(19);
        postorder.add(18);
        postorder.add(17);
        postorder.add(16);
        postorder.add(11);
        postorder.add(10);

        assertEquals(postorder, bst.postorder());

        bst.clear();

        addElementsToBST(2);

        postorder = new ArrayList<>();
        postorder.add(4);
        postorder.add(6);
        postorder.add(5);
        postorder.add(14);
        postorder.add(16);
        postorder.add(15);
        postorder.add(10);

        assertEquals(postorder, bst.postorder());
    }

    @Test(timeout = TIMEOUT)
    public void testLevelorder() {
        addElementsToBST(1);
        List<Integer> levelorder = new ArrayList<>();
        levelorder.add(10);
        levelorder.add(9);
        levelorder.add(11);
        levelorder.add(4);
        levelorder.add(16);
        levelorder.add(3);
        levelorder.add(8);
        levelorder.add(12);
        levelorder.add(17);
        levelorder.add(2);
        levelorder.add(7);
        levelorder.add(13);
        levelorder.add(18);
        levelorder.add(1);
        levelorder.add(6);
        levelorder.add(14);
        levelorder.add(19);
        levelorder.add(0);
        levelorder.add(5);
        levelorder.add(15);
        levelorder.add(20);

        assertEquals(levelorder, bst.levelorder());

        bst.clear();

        addElementsToBST(2);

        levelorder = new ArrayList<>();
        levelorder.add(10);
        levelorder.add(5);
        levelorder.add(15);
        levelorder.add(4);
        levelorder.add(6);
        levelorder.add(14);
        levelorder.add(16);

        assertEquals(levelorder, bst.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testHeight() {
        addElementsToBST(1);
        assertEquals(6, bst.height());
        bst.clear();
        addElementsToBST(2);
        assertEquals(2, bst.height());
    }

    @Test(timeout = TIMEOUT)
    public void testIsBST() {

        //Test 1: Simple test - left child greater than root
        /*
                    50
                  /    \   should return false
                75      25
        */

        BSTNode<Integer> root = new BSTNode<>(50);
        root.setLeft(new BSTNode<>(75));
        root.setRight(new BSTNode<>(25));

        assertEquals(false, BST.isBST(root));

        //Test 2: Complex test - largest element of left subtree greater than root
        /*
                    50
                  /    \   should return false
                25      75
               / \
             15   55

        */

        root = new BSTNode<>(50);
        root.setLeft(new BSTNode<>(25));
        root.setRight(new BSTNode<>(75));
        root.getLeft().setLeft(new BSTNode<>(15));
        root.getLeft().setRight(new BSTNode<>(55));

        assertEquals(false, BST.isBST(root));


        //Test 3: Complex test - smallest element of right subtree less than root
        /*
                    50
                  /    \   should return false
                25      75
                       /  \
                     15    85

        */

        root = new BSTNode<>(50);
        root.setLeft(new BSTNode<>(25));
        root.setRight(new BSTNode<>(75));
        root.getRight().setLeft(new BSTNode<>(15));
        root.getRight().setRight(new BSTNode<>(85));

        assertEquals(false, BST.isBST(root));


        //Test 4: simple test
        /*
                    50
                  /    \   should return true
                25      75
                /         \
              15           85

        */

        root = new BSTNode<>(50);
        root.setLeft(new BSTNode<>(25));
        root.setRight(new BSTNode<>(75));
        root.getLeft().setLeft(new BSTNode<>(15));
        root.getRight().setRight(new BSTNode<>(85));

        assertEquals(true, BST.isBST(root));


        //Test 5: simple test
        /*
                    50
                  /    \   should return true
                25      75
                       /  \
                     65    85

        */

        root = new BSTNode<>(50);
        root.setLeft(new BSTNode<>(25));
        root.setRight(new BSTNode<>(75));
        root.getRight().setLeft(new BSTNode<>(65));
        root.getRight().setRight(new BSTNode<>(85));

        assertEquals(true, BST.isBST(root));


        //Test 6: complex test
        /*
                    50
                  /    \   should return false
                25      75
                 \        \
                  15       85

        */

        root = new BSTNode<>(50);
        root.setLeft(new BSTNode<>(25));
        root.setRight(new BSTNode<>(75));
        root.getLeft().setRight(new BSTNode<>(15));
        root.getRight().setRight(new BSTNode<>(85));

        assertEquals(false, BST.isBST(root));


        //Test 7: complex test
        /*
                    50
                  /    \   should return false
                25      75
                /       /
              15       85

        */

        root = new BSTNode<>(50);
        root.setLeft(new BSTNode<>(25));
        root.setRight(new BSTNode<>(75));
        root.getLeft().setRight(new BSTNode<>(15));
        root.getRight().setLeft(new BSTNode<>(85));

        assertEquals(false, BST.isBST(root));
    }

    /**
     * Private method to add elements to BST
     * @param i int
     */
    private void addElementsToBST(int i) {

        if (i == 1) {
            bst.add(10);
            bst.add(9);
            bst.add(11);
            bst.add(4);
            bst.add(16);
            bst.add(8);
            bst.add(12);
            bst.add(3);
            bst.add(17);
            bst.add(7);
            bst.add(13);
            bst.add(2);
            bst.add(18);
            bst.add(6);
            bst.add(14);
            bst.add(1);
            bst.add(19);
            bst.add(5);
            bst.add(15);
            bst.add(0);
            bst.add(20);
        }

        if (i == 2) {
            bst.add(10);
            bst.add(5);
            bst.add(15);
            bst.add(4);
            bst.add(6);
            bst.add(14);
            bst.add(16);
        }
    }

    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||------------------------------------
    //||||||||||||||||||||||||| EXCEPTION TESTS ||||||||||||||||||||||||||||||||||||------------------------------------
    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||------------------------------------

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void constructorNullList() {
        ArrayList<Integer> collectionList = null;
        new BST(collectionList);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void constructorNullData() {
        ArrayList<Integer> collectionList = new ArrayList<>();
        collectionList.add(1);
        collectionList.add(null);
        collectionList.add(3);
        new BST(collectionList);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void addNullData() {
        bst.add(0);
        bst.add(null);
        bst.add(2);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void removeNullData() {
        bst.add(5);
        bst.add(0);
        bst.add(10);
        bst.remove(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void removeNotFoundData() {
        bst.add(5);
        bst.add(0);
        bst.add(10);
        bst.remove(5);
        bst.remove(20);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void getNullData() {
        bst.add(5);
        bst.add(0);
        bst.add(10);
        bst.get(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void getNotFoundData() {
        bst.add(5);
        bst.add(0);
        bst.add(10);
        bst.get(5);
        bst.get(20);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void containsNullData() {
        bst.add(5);
        bst.add(0);
        bst.add(10);
        bst.contains(null);
    }
}