package cn.happyhbase.geekbang.algorithm.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 简单链表java实现
 *heixiaochun
 * @author
 * @date 2019/5/9
 */
public class MyLinkedList<E> implements Iterable {

    /**
     * 链表虚拟首节点，一个sentinel对象
     */
    private Node<E> virtualHead = new Node<>(null, null);

    /**
     * 链表元素个数
     */
    private int size = 0;

    /**
     * 在链尾新增一个节点
     *
     * @param element
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 将元素插入链表的第index的位置
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ", not correct, size: " + size);
        }
        int count = 0;
        // 找到插入位置的前一个节点
        Node targetNode = virtualHead;
        while (count++ < index) {
            targetNode = targetNode.next;
        }
        // 执行插入操作
        Node currentNode = new Node(element, targetNode.next);
        targetNode.next = currentNode;
        size++;
    }

    /**
     * 删除第index个元素，并返回删除的值
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", not correct, size: " + size);
        }
        int count = 0;
        // 找到要删除元素的前一个元素
        Node targetNode = virtualHead;
        while (count++ < index) {
            targetNode = targetNode.next;
        }
        // 要删除的元素
        Node<E> deletedNode = targetNode.next;
        targetNode.next = deletedNode.next;
        deletedNode.next = null;
        size--;
        return deletedNode.element;
    }

    /**
     * 获取第index个元素的值
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", not correct, size: " + size);
        }
        int count = 0;
        // 找到第index个节点
        Node<E> targetNode = virtualHead;
        while (count++ <= index) {
            targetNode = targetNode.next;
        }
        return targetNode.element;
    }

    /**
     * 返回链表的长度
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回iterator对象
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    /**
     * MyLinkedList迭代器
     */
    private class MyLinkedListIterator implements Iterator<E> {

        /**
         * 当前迭代器位置
         */
        private int position = 0;

        /**
         * 当前节点
         */
        private Node<E> currentNode = virtualHead;

        /**
         * 下一个节点
         */
        private Node<E> nextNode = virtualHead.next;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("index: " + position + ", not correct, size: " + size);
            }
            currentNode = nextNode;
            nextNode = nextNode.next;
            position++;
            return currentNode.element;
        }

        @Override
        public void remove() {
            MyLinkedList.this.remove(--position);
        }
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node node = virtualHead;
        while ((node = node.next) != null) {
            sb.append(node.element).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

}
