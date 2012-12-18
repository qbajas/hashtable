package test;

import exception.FullException;
import junit.framework.Assert;
import main.HashTable;
import main.Item;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Qba
 * Date: 18.12.12
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
public class HashTableTest {

    HashTable ht;


    @Before
    public void setUp() throws Exception {
        ht = new HashTable(10);
    }

    @Test
    public void testPutWithinArraySize() throws Exception {
        //given
        //when
        ht.put(new Item(9, "abc"));
        //then
        Assert.assertEquals(ht.get(9).getValue(), "abc");
    }

    @Test
    public void testPutOutsideArraySize() throws Exception {
        //given
        //when
        ht.put(new Item(10, "abc"));
        //then
        Assert.assertEquals(ht.get(10).getValue(), "abc");
    }

    @Test
    public void testMultipleValuesIntoBucket() throws Exception {
        //given
        //when
        ht.put(new Item(10, "abc1"));
        ht.put(new Item(0, "abc2"));
        //then
        Assert.assertEquals(ht.get(10).getValue(), "abc1");
        Assert.assertEquals(ht.get(0).getValue(), "abc2");
    }

    @Test
    public void testMultipleValuesIntoBucketAndCheckNext() throws Exception {
        //given
        //when
        ht.put(new Item(10, "abc1"));
        ht.put(new Item(0, "abc2"));
        ht.put(new Item(1, "abc3"));
        //then
        Assert.assertEquals(ht.get(10).getValue(), "abc1");
        Assert.assertEquals(ht.get(0).getValue(), "abc2");
        Assert.assertEquals(ht.get(1).getValue(), "abc3");
    }

    @Test
    public void testMultipleValuesIntoBucketAndCheckNext2() throws Exception {
        //given
        //when
        ht.put(new Item(10, "abc1"));
        ht.put(new Item(0, "abc2"));
        ht.put(new Item(1, "abc3"));
        ht.put(new Item(11, "abc4"));
        ht.put(new Item(2, "abc5"));
        //then
        Assert.assertEquals(ht.get(10).getValue(), "abc1");
        Assert.assertEquals(ht.get(0).getValue(), "abc2");
        Assert.assertEquals(ht.get(1).getValue(), "abc3");
        Assert.assertEquals(ht.get(11).getValue(), "abc4");
        Assert.assertEquals(ht.get(2).getValue(), "abc5");

        Assert.assertEquals(ht.get(3), null);
        Assert.assertEquals(ht.get(4), null);
        Assert.assertEquals(ht.get(5), null);
    }

    @Test
    public void testMultipleTimesTheSameItem() throws Exception {
        //given
        // when
        ht.put(new Item(10, "abc1"));
        ht.put(new Item(10, "abc2"));
        //then
        assertEquals(ht.get(10).getValue(),"abc2");
    }

    @Test
    public void testMultipleTimesTheSameItem2() throws Exception {
        //given
        // when
        for(int i=0;i<11;i++){
            ht.put(new Item(10, "abc1"));
        }
        //then
        assertEquals(ht.get(10).getValue(),"abc1");
    }

    @Test(expected = FullException.class)
    public void testExceededSize() throws Exception {
        //given
        // when
        for(int i=0;i<11;i++){
            ht.put(new Item(i, "abc1"));
        }
        //then
        // exception
    }

}
