/**
 * This file has the class of arraylist
 */
/**
 * This is my class ArrayList that implelets my list. It is used to
 * create an arraylist
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
    }

    /**
     * This is the constructor with an initial capactiy
     * @param initialCapacity
     * @throws IllegalArgumentException
     */
    public MyArrayList(int initialCapacity) throws IllegalArgumentException{
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
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
            this.size = 0;
        }else{
            this.data = new Object[arr.length];
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
        }else if(this.data.length == 0){
            this.data = new Object[5];
            this.data[0] = (E) element;
            size += 1;
            return;
        }else if(this.data.length == this.size){
            this.expandCapacity(this.data.length + 3);
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
            for(int i = index+1; i < copy.length+1; i++){
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
        this.insert(this.size-1, (E) element);
    }

    /**
     * Add an element to the beginning of the list 
     *
     * @param element the element to prepend
     */
    public void prepend(E element){
        this.insert(0, (E) element);
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
        }
        E stored = (E) this.data[index];
        for(int i = index; i <= this.data.length; i ++){
            this.data[index] = this.data[index+1];
        }
        size -= 1;
        return stored;
    }

    /**
     * Get the number of elements in the list
     *
     * @return number of elements in the list
     */
    public int size(){
        return this.size;
    }

}