import static org.junit.Assert.*;

import org.junit.*;

public class MyArrayListHiddenTester {
    // Do not change the method signatures!
    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test 
     */

     private MyArrayList list1, list2, list3, list4, list5, list6, list7, list8;

    @Before
    public void setUp() throws Exception {
        list1 = new MyArrayList(3);
        list2 = new MyArrayList(3);
        list3 = new MyArrayList(3);
        list4 = new MyArrayList(3);
        list5 = new MyArrayList(3);
        list6 = new MyArrayList(3);
        list7 = new MyArrayList(3);
        list8 = new MyArrayList(3);
    }

    /**
     * Aims to test the constructor when the input argument
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        int test = 0;
        try{
            MyArrayList<String> list11 = new MyArrayList<String>(-1);
        }catch(IllegalArgumentException e){
            test+=1;
        }
        assertEquals("Check list size after the append",
                1, test);
    }

    /**
     * Aims to test the constructor when the input argument is null
     */
    @Test
    public void testConstructorNullArg(){
        MyArrayList<String> list10 = new MyArrayList<String>(null);
        assertArrayEquals("Check for successful append", 
        new String[]{null, null, null, null, null}, list10.data);
        assertEquals("Check list size after the append",
                0, list10.size);
    }

    /**
     * Aims to test the constructor when the input array has null elements
     */
    @Test
    public void testConstructorArrayWithNull(){
        String[] a = {"3",null,"4",null};
        MyArrayList<String> list9 = new MyArrayList<String>(a);
        assertArrayEquals("Check for successful append", 
        new String[]{"3", null, "4", null}, list9.data);
        assertEquals("Check list size after the append",
                4, list9.size);

    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     * WORKS
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
                4, list2.size);
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
        // assertEquals("Check list capacity after the append",
        //     6, list3.getCapacity());
    }
    
    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     * WORKS
     */
    @Test
    public void testPrependNull(){
        list4.append(5);
        list4.append(4);
        list4.append(3);
        list4.prepend(null);

        assertArrayEquals("Check for successful append", 
        new Integer[]{null, 5, 4, 3, null, null}, list4.data);
        assertEquals("Check list size after the append",
                4, list4.size);
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     * WORKS
     */
    @Test
    public void testInsertOutOfBound(){
        list5.append(5);
        list5.append(4);
        list5.append(3);
        int test = 0;
        try{
            list5.insert(6, 3);
        }catch(IndexOutOfBoundsException e){
            test += 1;
        }
       assertEquals("Check for exception",
               1, test);
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        for(int i = 0; i < 50; i++){
            list6.insert(i,50);
        }
        assertArrayEquals("Check for successful append", 
       new Integer[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, null}, list6.data);
       assertEquals("Check list size after the append",
               50, list6.size);
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        int test = 0;
        try{
            list1.get(10);
        }catch(IndexOutOfBoundsException e){
            test += 1;
        }
       assertEquals("Check for exception",
               1, test);
        
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
        int test = 0;
        try{
            list1.set(100, 5);
        }catch(IndexOutOfBoundsException e){
            test += 1;
        }
       assertEquals("Check for exception",
               1, test);
    }

    /**
     * Aims to test the remove method when removing multiple items from a list
     */
    @Test
    public void testRemoveMultiple(){
        list8.append(5);
        list8.append(5);
        list8.append(5);
        list8.append(5);
        list8.append(5);
        for(int i = 4; i > 0; i--){
            list8.remove(i);
        }
        assertArrayEquals("Check for successful append", 
       new Integer[]{5, null, null, null, null, null}, list8.data);
       assertEquals("Check list size after the append",
               1, list8.size);

    }

    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        int test = 0;
        try{
            list1.remove(100);
        }catch(IndexOutOfBoundsException e){
            test += 1;
        }
       assertEquals("Check for exception",
               1, test);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
       list7.append(1);
       list7.append(2);
       list7.append(3);
       int test = 0;
       try{
            list7.expandCapacity(1);
       }catch(IllegalArgumentException e){
            test+=1;
       }
       assertEquals("Check for exception",
               1, test);

    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than current capacity+3 and default capacity
     */
    @Test
    public void testExpandCapacityLarge(){
        list7.append(1);
       list7.append(2);
       list7.append(3);
       list7.expandCapacity(10);
       assertArrayEquals("Check for successful append", 
       new Integer[]{1, 2, 3, null, null, null, null, null, null, null}, list7.data);
       assertEquals("Check list size after the append",
               3, list7.size);

    }
    

}
