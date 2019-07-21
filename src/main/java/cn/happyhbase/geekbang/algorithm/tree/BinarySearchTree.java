package cn.happyhbase.geekbang.algorithm.tree;

/**
 * 二叉树查找
 * https://time.geekbang.org/column/article/68334
 *
 * @author heixiaochun
 * @date 2019/7/21
 */
public class BinarySearchTree {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 查找指定的节点，找不到返回null
     *
     * @param data
     * @return
     */
    public TreeNode find(int data) {
        TreeNode targetNode = root;
        while (targetNode != null) {
            if (data < targetNode.getData()) {
                targetNode = targetNode.getLeftChild();
            } else if (data > targetNode.getData()) {
                targetNode = targetNode.getRightChild();
            } else {
                return targetNode;
            }
        }
        return null;
    }

    /**
     * 添加一个节点
     *
     * @param data
     */
    public void add(int data) {
        // 当前根节点为空，则直接将data设置为根节点
        if (root == null) {
            root = new TreeNode(data, null, null, null);
            return;
        }
        // 找到待插入节点的父节点
        TreeNode targetNode = root;
        while (targetNode != null) {
            if (data < targetNode.getData()) {
                TreeNode leftChild = targetNode.getLeftChild();
                if (leftChild == null) {
                    targetNode.setLeftChild(new TreeNode(data, targetNode, null, null));
                    return;
                } else {
                    targetNode = leftChild;
                }
            } else {
                TreeNode rightChild = targetNode.getRightChild();
                if (rightChild == null) {
                    targetNode.setRightChild(new TreeNode(data, targetNode, null, null));
                    return;
                } else {
                    targetNode = rightChild;
                }
            }
        }
    }

    /**
     * 中序遍历节点
     */
    public void inOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderPrint(node.getLeftChild());
        System.out.println(node.getData());
        inOrderPrint(node.getRightChild());
    }

    public void inOrderPrint() {
        this.inOrderPrint(root);
    }

    /**
     * 移除一个节点
     *
     * @param data
     * @return
     */
    public boolean remove(int data) {
        return false;
    }

}
