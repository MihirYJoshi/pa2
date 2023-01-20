import static org.junit.Assert.*;

import org.junit.*;

public class MyArrayListHiddenTester {
    // Do not change the method signatures!
    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test 
     */

     private MyArrayList list1, list2, list3, list4, list5;

    @Before
    public void setUp() throws Exception {
        list1 = new MyArrayList(3);
        list2 = new MyArrayList(3);
        list3 = new MyArrayList(3);
        list4 = new MyArrayList(3);
        list5 = new MyArrayList(3);

    }

    /**
     * Aims to test the constructor when the input argument
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        
    }

    /**
     * Aims to test the constructor when the input argument is null
     */
    @Test
    public void testConstructorNullArg(){

    }

    /**
     * Aims to test the constructor when the input array has null elements
     */
    @Test
    public void testConstructorArrayWithNull(){

    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        list1.append(5);
        list1.append(4);
        list1.append(3);
        list1.append(2);

        assertArrayEquals("Check for successful append", 
        new Integer[]{5, 4, 3, 2, null, null}, list1.data);
        assertEquals("Check list size after the append",
                4, list1.size);
    }

    /**
     * Aims to test the append method when null is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendNull(){
        list2.append(5);
        list2.append(4);
        list2.append(3);
        list2.append(null);

        assertArrayEquals("Check for successful append", 
        new Integer[]{5, 4, 3, null, null, null}, list2.data);
        assertEquals("Check list size after the append",
                3, list2.size);
    }

    /**
     * Aims to test the prepend method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testPrependAtCapacity(){
        list3.append(5);
        list3.append(4);
        list3.append(3);
        list3.prepend(2);

        assertArrayEquals("Check for successful append", 
        new Integer[]{2, 5, 4, 3, null, null}, list3.data);
        assertEquals("Check list size after the append",
                4, list3.size);
    }
    
    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        list4.append(5);
        list4.append(4);
        list4.append(3);
        list4.prepend(2);

        assertArrayEquals("Check for successful append", 
        new Integer[]{null, 5, 4, 3, null, null}, list4.data);
        assertEquals("Check list size after the append",
                3, list4.size);
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound(){
       list4.insert(6, 3);
       assertArrayEquals("Check for successful append", 
       new Integer[]{null, 5, 4, 3, null, null}, list4.data);
       assertEquals("Check list size after the append",
               3, list4.size);
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        for(int i = 0; i < 50; i++){
            list4.insert(10,50);
        }
        assertArrayEquals("Check for successful append", 
       new Integer[]{null, 5, 4, 3, null, null}, list4.data);
       assertEquals("Check list size after the append",
               3, list4.size);
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        list1.get(10);
        
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
        
    }

    /**
     * Aims to test the remove method when removing multiple items from a list
     */
    @Test
    public void testRemoveMultiple(){
        
    }

    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
       
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than current capacity+3 and default capacity
     */
    @Test
    public void testExpandCapacityLarge(){
        
    }
    

}
