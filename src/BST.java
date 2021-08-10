import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Your implementation of a BST.
 *
 * @author Qingyuan Zhang
 * @version 1.0
 * @userid qzhang417
 * @GTID 903497782
 * <p>
 * Collaborators:
 * <p>
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */
public class BST<T extends Comparable<? super T>> {

    // Do not add new instance variables or modify existing ones.
    private BSTNode<T> root;
    private int size;

    /**
     * Constructs a new BST.
     * <p>
     * This constructor should initialize an empty BST.
     * <p>
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public BST() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Constructs a new BST.
     * <p>
     * This constructor should initialize the BST with the data in the
     * Collection. The data should be added in the same order it is in the
     * Collection.
     * <p>
     * Hint: Not all Collections are indexable like Lists, so a regular for loop
     * will not work here. However, all Collections are Iterable, so what type
     * of loop would work?
     *
     * @param data the data to add to the tree
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot insert null data into data structure");
        }
        for (T i : data) {
            if (i == null) {
                throw new IllegalArgumentException("Cannot insert null data into data structure");
            }
            add(i);
        }
    }

    /**
     * Adds the element to the tree.
     * <p>
     * The data becomes a leaf in the tree.
     * <p>
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     * <p>
     * Must be O(log n) for a balanced tree and O(n) for worst case.
     * <p>
     * This method must be implemented recursively.
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Cannot insert null data into data structure");
        }
        BSTNode<T> curr = root;
        root = add(data, curr);
    }

    /**
     * helper method for add.
     *
     * @param data the data to add
     * @param curr the node being traversed
     * @return the node which contains the data added
     */
    private BSTNode<T> add(T data, BSTNode<T> curr) {
        BSTNode<T> returnData = new BSTNode<>(data);
        if (curr == null) {
            size++;
            return returnData;
        } else if (0 < data.compareTo(curr.getData())) {
            curr.setRight(add(data, curr.getRight()));
        } else if (0 > data.compareTo(curr.getData())) {
            curr.setLeft(add(data, curr.getLeft()));
        }
        return curr;
    }

    /**
     * Removes and returns the element from the tree matching the given
     * parameter.
     * <p>
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the predecessor to
     * replace the data. You MUST use recursion to find and remove the
     * predecessor (you will likely need an additional helper method to
     * handle this case efficiently).
     * <p>
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     * <p>
     * Hint: Should you use value equality or reference equality?
     * <p>
     * Must be O(log n) for a balanced tree and O(n) for worst case.
     * <p>
     * This method must be implemented recursively.
     *
     * @param data the data to remove
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T remove(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Cannot remove null data from data structure");
        }
        BSTNode<T> dummy = new BSTNode<>(null);
        root = remove(root, data, dummy);
        return dummy.getData();
    }

    /**
     * the helper method for remove.
     *
     * @param curr  the current node being traversed
     * @param data  the data to be removed
     * @param dummy the place holder node for the removed data when found
     * @return the pointer reinforcement node
     */
    private BSTNode<T> remove(BSTNode<T> curr, T data, BSTNode<T> dummy) {
        if (curr == null) {
            throw new NoSuchElementException("Cannot remove a data that's not within the data structure");
        } else if (data.compareTo(curr.getData()) < 0) {
            curr.setLeft(remove(curr.getLeft(), data, dummy));
        } else if (data.compareTo(curr.getData()) > 0) {
            curr.setRight(remove(curr.getRight(), data, dummy));
        } else {
            dummy.setData(curr.getData());
            size--;
            if (curr.getRight() == null && curr.getLeft() == null) {
                return null;
            } else if (curr.getLeft() != null && curr.getRight() == null) {
                return curr.getLeft();
            } else if (curr.getLeft() == null && curr.getRight() != null) {
                return curr.getRight();
            } else {
                BSTNode<T> dummy2 = new BSTNode<T>(null);
                assert curr.getRight() != null;
                curr.setRight(removeSuccessor(curr.getRight(), dummy2));
                curr.setData(dummy2.getData());
            }
        }
        return curr;
    }

    /**
     * the helper method for the root removal using successor removal.
     *
     * @param curr  the current node being traversed
     * @param dummy the place holder node
     * @return the node with the removed data
     */
    private BSTNode<T> removeSuccessor(BSTNode<T> curr, BSTNode<T> dummy) {
        if (curr.getLeft() == null) {
            dummy.setData(curr.getData());
            return curr.getRight();
        } else {
            curr.setLeft(removeSuccessor(curr.getLeft(), dummy));
        }
        return curr;
    }

    /**
     * Returns the element from the tree matching the given parameter.
     * <p>
     * Hint: Should you use value equality or reference equality?
     * <p>
     * Must be O(log n) for a balanced tree and O(n) for worst case.
     * <p>
     * This method must be implemented recursively.
     * <p>
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * @param data the data to search for in the tree
     * @return the data in the tree equal to the parameter
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data structure does not contain null entries");
        }
        if (!contains(data)) {
            throw new java.util.NoSuchElementException("The data is not contained in the data structure");
        }
        return getHelper(data, root);
    }

    /**
     * the helper method for get.
     *
     * @param data the data to be searched
     * @param curr the current node being traversed
     * @return the node containing the data that was found
     */
    private T getHelper(T data, BSTNode<T> curr) {
        if (curr == null) {
            throw new IllegalArgumentException("Cannot insert null data");
        }
        if (data.compareTo(curr.getData()) < 0) {
            return getHelper(data, curr.getLeft());
        } else if (data.compareTo(curr.getData()) > 0) {
            return getHelper(data, curr.getRight());
        } else {
            return curr.getData();
        }
    }

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     * <p>
     * Hint: Should you use value equality or reference equality?
     * <p>
     * Must be O(log n) for a balanced tree and O(n) for worst case.
     * <p>
     * This method must be implemented recursively.
     *
     * @param data the data to search for in the tree.
     * @return true if the parameter is contained within the tree, false
     * otherwise
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("The data structure does not contain null entries");
        }
        T searchData = containsHelper(data, root);
        if (searchData != null) {
            return (searchData).compareTo(data) == 0;
        } else {
            return false;
        }

    }

    /**
     * the helper method for contains.
     *
     * @param data the data to be searched
     * @param curr the current node being traversed
     * @return data contained in within the node with the tree
     */
    private T containsHelper(T data, BSTNode<T> curr) {
        if (curr == null) {
            return null;
        } else if (curr.getData().equals(data)) {
            return curr.getData();
        } else if (0 < data.compareTo(curr.getData())) {
            return containsHelper(data, curr.getRight());
        } else if (0 > data.compareTo(curr.getData())) {
            return containsHelper(data, curr.getLeft());
        }
        return curr.getData();
    }

    /**
     * Generate a pre-order traversal of the tree.
     * <p>
     * Must be O(n).
     * <p>
     * This method must be implemented recursively.
     *
     * @return the preorder traversal of the tree
     */
    public List<T> preorder() {
        List<T> returnData = new ArrayList<>();
        preorderHelper(root, returnData);
        return returnData;
    }

    private void preorderHelper(BSTNode<T> curr, List<T> list) {
        if (curr == null) {
            return;
        } else {
            list.add(curr.getData());
            preorderHelper(curr.getLeft(), list);
            preorderHelper(curr.getRight(), list);
        }
    }

    /**
     * Generate a in-order traversal of the tree.
     * <p>
     * Must be O(n).
     * <p>
     * This method must be implemented recursively.
     *
     * @return the inorder traversal of the tree
     */
    public List<T> inorder() {
        List<T> returnData = new ArrayList<>();
        inorderHelper(root, returnData);
        return returnData;
    }

    private void inorderHelper(BSTNode<T> curr, List<T> list) {
        if (curr == null) {
            return;
        } else {
            inorderHelper(curr.getLeft(), list);
            list.add(curr.getData());
            inorderHelper(curr.getRight(), list);
        }
    }

    /**
     * Generate a post-order traversal of the tree.
     * <p>
     * Must be O(n).
     * <p>
     * This method must be implemented recursively.
     *
     * @return the postorder traversal of the tree
     */
    public List<T> postorder() {
        List<T> returnData = new ArrayList<>();
        postorderHelper(root, returnData);
        return returnData;
    }

    private void postorderHelper(BSTNode<T> curr, List<T> list) {
        if (curr == null) {
            return;
        } else {
            postorderHelper(curr.getLeft(), list);
            postorderHelper(curr.getRight(), list);
            list.add(curr.getData());
        }
    }

    /**
     * Generate a level-order traversal of the tree.
     * <p>
     * This does not need to be done recursively.
     * <p>
     * Hint: You will need to use a queue of nodes. Think about what initial
     * node you should add to the queue and what loop / loop conditions you
     * should use.
     * <p>
     * Must be O(n).
     *
     * @return the level order traversal of the tree
     */
    public List<T> levelorder() {
        List<T> returnData = new ArrayList<T>();
        levelorderHelper(root, returnData);
        return returnData;
    }

    private void levelorderHelper(BSTNode<T> node, List<T> returnData) {
        if (root == null) {
            return;
        }
        Queue<BSTNode<T>> tempQ = new LinkedList<>();
        tempQ.add(root);
        while (!tempQ.isEmpty()) {
            BSTNode<T> curr = tempQ.poll();
            if (curr.getLeft() != null) {
                tempQ.add(curr.getLeft());
            }
            if (curr.getRight() != null) {
                tempQ.add(curr.getRight());
            }
            returnData.add(curr.getData());
        }
    }

    /**
     * Returns the height of the root of the tree.
     * <p>
     * A node's height is defined as max(left.height, right.height) + 1. A
     * leaf node has a height of 0 and a null child should be -1.
     * <p>
     * Must be O(n).
     * <p>
     * This method must be implemented recursively.
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    public int height() {
        return heightHelper(root);
    }

    /**
     * the height helper method.
     *
     * @param curr the node being traversed
     * @return the height of the BST
     */
    private int heightHelper(BSTNode<T> curr) {
        if (curr == null) {
            return -1;
        } else {
            int leftHeight = heightHelper(curr.getLeft());
            int rightHeight = heightHelper(curr.getRight());
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    /**
     * Clears the tree.
     * <p>
     * Clears all data and resets the size.
     * <p>
     * Must be O(1).
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * This method checks whether a binary tree meets the criteria for being
     * a binary search tree.
     * <p>
     * This method is a static method that takes in a BSTNode called
     * {@code treeRoot}, which is the root of the tree that you should check.
     * <p>
     * You may assume that the tree passed in is a proper binary tree; that is,
     * there are no loops in the tree, the parent-child relationship is
     * correct, that there are no duplicates, and that every parent has at
     * most 2 children. So, what you will have to check is that the order
     * property of a BST is still satisfied.
     * <p>
     * Should run in O(n). However, you should stop the check as soon as you
     * find evidence that the tree is not a BST rather than checking the rest
     * of the tree.
     * <p>
     * This method must be implemented recursively.
     *
     * @param <T>      the generic typing
     * @param treeRoot the root of the binary tree to check
     * @return true if the binary tree is a BST, false otherwise
     */
    public static <T extends Comparable<? super T>> boolean isBST(
        BSTNode<T> treeRoot) {

        return false;
    }

    /**
     * Returns the root of the tree.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
