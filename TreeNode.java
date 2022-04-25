import com.sun.source.tree.Tree;

public class TreeNode<T> {
    protected T element;
    protected  TreeNode<T> Ld;
    protected TreeNode<T> Rd;

    /**
     * new treenode with left and right child set to null and data
     * set to the dataNode
     * @param dataNode
     */
    TreeNode(T dataNode) {
        this.Ld = null;
        this.Rd = null;
        this.element = dataNode;
    }

    /**
     * used for making deep copies
     * @param node
     */
    TreeNode(TreeNode<T> node) {
        new TreeNode<T>(node);
    }

    /**
     * getter for element
     * @return
     */
    public T getElement() {
        return element;
    }
}
