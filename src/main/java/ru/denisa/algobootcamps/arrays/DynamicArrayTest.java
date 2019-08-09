package algobootcamp.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicArrayTest {
    private DynamicArray array;


    @Before
    public void SetUp() throws  Exception{
         array  = new DynamicArray <String> (2);
    }



    //O(1)
    @Test
    public void GetAndSet() throws Exception{
        array.set(0,"a");
        Assert.assertEquals("a", array.get(0));
     }


     //O(n)
     @Test
    public void Insert() throws  Exception{
         array.add("a"); //0
         array.add("b"); //1
         array.add("c"); //2

         array.insert(1,"d");

         Assert.assertEquals(4,array.getSize());
         Assert.assertEquals("a",array.get(0));
         Assert.assertEquals("d",array.get(1));
         Assert.assertEquals("b",array.get(2));
         Assert.assertEquals("c",array.get(3));
   }


    //O(n)
    @Test
    public void Delete() throws  Exception{
        array.add("a"); //0
        array.add("b"); //1
        array.add("c"); //2
        array.delete(1);
        Assert.assertEquals(2,array.getSize());
        Assert.assertEquals("a",array.get(0));
        Assert.assertEquals("c",array.get(1));
  }






}
