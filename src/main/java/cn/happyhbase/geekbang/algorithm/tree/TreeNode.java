package cn.happyhbase.geekbang.algorithm.tree;

/**
 * Simple TreeNode
 */
class TreeNode {

    private int data;

    private TreeNode parent;

    private TreeNode leftChild;

    private TreeNode rightChild;

    public TreeNode() {
    }

    public TreeNode(int data, TreeNode parent, TreeNode leftChild, TreeNode rightChild) {
        this.data = data;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * 是否为根节点
     *
     * @return
     */
    public boolean isRoot() {
        return parent == null;
    }

    /**
     * 是否为叶子节点
     *
     * @return
     */
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

}