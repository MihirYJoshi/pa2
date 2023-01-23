/*
 * Name: Mihir Joshi
 * Email: myjoshi@ucsd.edu
 * PID: A17275299
 * This file is used for the My Arraylist class. It
 * is used to create my own arraylist
 */
/**
 * THis implements a MyList for the array
 * It is for the list
 */
public class MyArrayList<E> implements MyList<E>{

    Object[] data;
    int size;

    /**
     * THis is the default constritor
     */
    public MyArrayList(){
        this.data = new Object[5];
        this.size = 0;
        //Normal constructor
    }

    /**
     * This is the constructor with an initial capactiy
     * @param initialCapacity
     * @throws IllegalArgumentException
     */
    public MyArrayList(int initialCapacity) throws IllegalArgumentException
    {
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
            //throws exception
        }
        this.data = new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * Constructor with an array
     * @param arr
     */
    public MyArrayList (E[] arr){
        if(arr == null){
            this.data = new Object[5];
            //Checks for array null
            this.size = 0;
        }else{
            this.data = new Object[arr.length];
            //appends
            this.size = arr.length;
            for(int i = 0; i < this.data.length; i++){
                this.data[i] = (E) arr[i];
            }
        }
    }

    /**
     * Increase the capacity of underlying array if needed
     *
     * @param requiredCapacity minimum capacity after expanding
     */
    public void expandCapacity(int requiredCapacity){
        if(this.data.length == 0 || this.data.length < 0){
            if(requiredCapacity > 5){
                this.data = new Object[requiredCapacity];
            }else{
                this.data = new Object[5];
            }
        }else if(requiredCapacity < this.data.length){
            throw new IllegalArgumentException();
            //throws exception
        }else if(this.data.length + 3 < requiredCapacity){
            Object[] copy = new Object[this.data.length];
            for(int i = 0; i < (this.data.length); i ++){
                copy[i] = (E) this.data[i];
            }

            int prev = this.data.length;
            int length = requiredCapacity;
            this.data = new Object[length];
            for(int i = 0; i < prev; i ++){
                this.data[i] = (E) copy[i];
            }
        }else{
            Object[] copy = new Object[this.data.length];
            for(int i = 0; i < (this.data.length); i ++){
                copy[i] = (E) this.data[i];
            }

            int length = this.data.length + 3;
            this.data = new Object[length];
            for(int i = 0; i < (length-3); i ++){
                this.data[i] = (E) copy[i];
            }
        }
    }

    /**
     * Get the amount of elements array can hold
     *
     * @return number of elements that can be held
     */
    public int getCapacity(){
        return this.data.length;
        //Return capacity
    }

    /**
     * Add an element at the specified index
     *
     * @param index   position to insert the element
     * @param element the element to insert
     */
    public void insert(int index, E element){
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
            //throws exception
        }else if(this.data.length == 0){
            this.data = new Object[5];
            this.data[0] = (E) element;
            this.size += 1;
            return;
        }else if(this.data.length == this.size){
            this.expandCapacity(this.data.length + 3);
            //Increase the size
        }
        if(index == this.size){
            this.data[index] = (E) element;
            this.size += 1;
        }else{
            Object[] copy = new Object[this.data.length];
            for(int i = 0; i < (this.data.length); i ++){
                copy[i] = (E) this.data[i];
            }
            this.data[index] = (E) element;
            for(int i = index+1; i < copy.length; i++){
                this.data[i] = (E) copy[i-1];
            }
            this.size += 1;
        }
    }

    /**
     * Add an element to the end of the list
     *
     * @param element the element to append
     */
    public void append(E element){
        if(this.data.length == 0){
            this.data = new Object[5];
            this.data[0] = (E) element;
            this.size += 1;
        }else if(this.size == 0){
            this.data[0] = (E) element;
            this.size += 1;
        }else{
            this.insert(this.size, (E) element);
            //Calls insert to put at back
        }
    }

    /**
     * Add an element to the beginning of the list 
     *
     * @param element the element to prepend
     */
    public void prepend(E element){
        if(this.data.length == 0){
            this.data = new Object[5];
            this.data[0] = (E) element;
            this.size += 1;
        }else if(this.size == 0){
            this.data[0] = (E) element;
            this.size += 1;
        }else{
            this.insert(0, (E) element);
            //Calls insert to move stuff
        }
    }

    /**
     * Get the element at the given index
     *
     * @param index the index at which to return the element
     * @return the element at the index
     */
    public E get(int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
            //throws exception
        }
        return (E) this.data[index];
    }

    /**
     * Replaces an element at the specified index with a new 
     * element and return
     * the original element
     *
     * @param index   the index at which to replace
     * @param element the element with which to replace
     * @return the original element
     */
    public E set(int index, E element){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
            //throws exception
        }
        E stored = (E) this.data[index];
        this.data[index] = element;
        return stored;
    }

    /**
     * Remove the element at the specified index and return
     * the removed element
     *
     * @param index the index at which to remove the element
     * @return the removed element
     */
    public E remove(int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
            //throws exception
        }
        E stored = (E) this.data[index];

        for(int i = index; i < this.data.length-1; i ++){
            this.data[i] = (E) this.data[i+1];
            //moves forward
        }
        this.data[this.data.length-1] = null;
        size -= 1;
        return stored;
    }

    /**
     * Get the number of elements in the list
     *
     * @return number of elements in the list
     */
    public int size(){
        //returns size
        return this.size;
    }

}