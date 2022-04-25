import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    private TreeNode<String> root = null;
    private  String fetchedLetter;

    MorseCodeTree() {
        buildTree();
    }
    /**
     * Returns a reference to the root
     *
     * @return reference to root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * Adds result to the correct position in the tree based on the code
     * This method will call the recursive method addNode
     *
     * @param code   the code for the new node to be added
     * @param result
     * @return the linkedConverterTree with the new node added
     */
    @Override
    public LinkedConverterTreeInterface<String> insert(String code, String result) {
        addNode(root,code,result);
        return this;
    }

    /**
     * Fetch the data in the tree based on the code
     * This method will call the recursive method fetchNode
     *
     * @param code the code that describes the traversals within the tree
     * @return the result that corresponds to the code
     */
    @Override
    public String fetch(String code) {
        return fetchNode(root,code);
    }

    /**
     * This operation is not supported for a LinkedConverterTree
     *
     * @param data data of node to be deleted
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        return null;
    }

    /**
     * This operation is not supported for a LinkedConverterTree
     *
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        return null;
    }

    /**
     * This method builds the LinkedConverterTree by inserting TreeNodes<T>
     * into their proper locations
     */
    @Override
    public void buildTree() {
        root = new TreeNode<String>("");
        // First level
        insert(".", "e");
        insert("-", "t");
        //Second Level
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        //Third Level
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        //Fourth Level
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    /**
     * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
     * Used for testing to make sure tree is built correctly
     *
     * @return an ArrayList of the items in the linked Tree
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<String>();
        LNRoutputTraversal(root,list);
        return list;

    }

    /**
     * The recursive method to put the contents of the linked converter tree in an ArrayList<T>
     * LNR (Inorder)
     *
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if(root!=null) {
            LNRoutputTraversal(root.Ld, list);
            list.add(root.getElement());
            LNRoutputTraversal(root.Rd, list);
        }
    }

    /**
     * This is the recursive method that fetches the data of the TreeNode
     * that corresponds with the code
     *
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of fetchNode
     * @return the data corresponding to the code
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) {

        if(code.length() == 1) {
            if(code.equals("."))
                fetchedLetter = root.Ld.getElement();
            else
                fetchedLetter =  root.Rd.getElement();
        } else {
            if(code.charAt(0) == '.')
                fetchNode(root.Ld,code.substring(1));
            else
                fetchNode(root.Rd,code.substring(1));
        }
        return fetchedLetter;
    }

    /**
     * This is a recursive method that adds element to the correct position
     * in the tree based on the code.
     *
     * @param root   the root of the tree for this particular recursive instance of addNode
     * @param code   the code for this particular recursive instance of addNode
     * @param letter the data of the new TreeNode to be added
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if(code.length() == 1) {
            if(code.equals("."))
                root.Ld = new TreeNode<String>(letter);
            else
                root.Rd = new TreeNode<String>(letter);
            return;
        } else {
            if(code.charAt(0) == '.')
                addNode(root.Ld,code.substring(1),letter);
            else
                addNode(root.Rd,code.substring(1),letter);
        }
    }

    /**
     * sets the root of the Tree
     *
     * @param newNode a TreeNode<T> that will be the new root
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }
}
