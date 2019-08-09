package algobootcamp.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

        private LinkedList linkedList;

        @Before
        public void SetUp() throws Exception{
            linkedList = new LinkedList();
        }


        @Test
        public void AddFront(){

        }

        @Test
        public void GetFirst(){
            linkedList.addFront(1);
            Assert.assertEquals(1,linkedList.getFirst());

        }

        @Test
        public void GetLast(){
            linkedList.addFront(1);
            linkedList.addFront(2);
            linkedList.addFront(3);
            Assert.assertEquals(1,linkedList.getLast());
        }


        @Test
        public void AddBack(){
            linkedList.addBack(1);
            linkedList.addBack(2);
            linkedList.addBack(3);
            Assert.assertEquals(1,linkedList.getFirst());
            Assert.assertEquals(3,linkedList.getLast());
      }

      @Test
      public void size(){
           Assert.assertEquals(0,linkedList.size());
          linkedList.addBack(1);
          Assert.assertEquals(1,linkedList.size());
          linkedList.addBack(2);
          Assert.assertEquals(2,linkedList.size());
    }


    //O(n)
    @Test
    public void Clear() {
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.clear();
        Assert.assertEquals(0,linkedList.size());
  }


    //O(n)
    @Test
    public void deleteByValue() {
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);
        linkedList.addBack(3);


        Assert.assertEquals(4,linkedList.size());

        linkedList.delete(3);
        Assert.assertEquals(2,linkedList.size());
    }





}
