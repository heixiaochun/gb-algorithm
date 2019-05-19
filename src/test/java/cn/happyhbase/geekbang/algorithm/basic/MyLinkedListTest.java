package cn.happyhbase.geekbang.algorithm.basic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author heixiaochun
 * @date 2019/5/9
 */
public class MyLinkedListTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testWithIndexOutOfBoundsExceptionGt() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "a");
        list.add(0, "b");
        list.add(2, "b");
        list.add(4, "c");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testWithIndexOutOfBoundsExceptionLt() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "a");
        list.add(-1, "a");
    }

    @Test
    public void testAddWithIndex() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "a");
        list.add(0, "b");
        list.add(2, "c");
        Assert.assertEquals("[b,a,c]", list.toString());
    }

    @Test
    public void testAdd() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "e");
        list.add(0, "f");
        list.add(2, "a");
        list.add("g");
        list.add(4, "z");
        list.add(0, "l");
        list.add(1, "G");
        list.add(7, "P");
        list.add("F");
        Assert.assertEquals("[l,G,f,e,a,g,z,P,F]", list.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBoundsExceptionGt() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "X");
        list.add(0, "Y");
        list.add(0, "Z");
        list.get(0);
        list.get(1);
        list.get(2);
        list.get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBoundsExceptionLt() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "X");
        list.add(0, "Y");
        list.add(0, "Z");
        list.get(0);
        list.get(1);
        list.get(2);
        list.get(-1);
    }

    @Test
    public void testGet() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "X");
        list.add(0, "Y");
        list.add(0, "Z");
        list.add("O");
        list.add("P");
        list.add("Q");
        Assert.assertEquals("Z", list.get(0));
        Assert.assertEquals("Y", list.get(1));
        Assert.assertEquals("X", list.get(2));
        Assert.assertEquals("O", list.get(3));
        Assert.assertEquals("P", list.get(4));
        Assert.assertEquals("Q", list.get(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexOutOfBoundsExceptionGt() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "X");
        list.add(0, "Y");
        list.add(0, "Z");
        list.remove(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexOutOfBoundsExceptionLt() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "X");
        list.add(0, "Y");
        list.add(0, "Z");
        list.remove(-1);
    }

    @Test
    public void testGetSize() {
        MyLinkedList list = new MyLinkedList();
        Assert.assertEquals(0, list.getSize());
        list.add(0, "X");
        Assert.assertEquals(1, list.getSize());
        list.add(0, "Y");
        Assert.assertEquals(2, list.getSize());
        list.add(0, "Z");
        Assert.assertEquals(3, list.getSize());
        list.remove(0);
        Assert.assertEquals(2, list.getSize());
        list.remove(0);
        Assert.assertEquals(1, list.getSize());
        list.remove(0);
        Assert.assertEquals(0, list.getSize());
    }

    @Test
    public void testRemove() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "X");
        list.add(0, "Y");
        list.add(0, "Z");
        list.remove(0);
        Assert.assertEquals("[Y,X]", list.toString());
        list.remove(0);
        list.remove(0);
        list.add("O");
        list.add("P");
        list.add("Q");
        list.remove(2);
        list.remove(1);
        list.remove(0);
        Assert.assertEquals(0, list.getSize());

    }

}