package priorityqueue;

import node.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @param <T>: this is type of the PriorityQueue array
 */
public class PriorityQueue<T> {
    private Node[] h;
    private HashMap<T, Integer> map = new HashMap<>();

    /**
     * Is a constructor the create a Node array type with only one cell
     * and it returns that
     */
    public PriorityQueue (){
        h = new Node[1];
    }//PriorityQueue

    /**
     *
     * @param i: this is the index of the element
     * @return: this method returns the element in the position i
     */
    public Node getElem(int i){
        return h[i];
    }//getElem

    /**
     *
     * @return: this method returns the priority max object
     */
    public Node getMax(){
        return h[1];
    }//getMax

    /**
     *
     * @return: this method returns the length of the Heap
     */
    public int size(){
        return h.length;
    }//heapSize

   //this method returns the parent of the object in the position i
    private int parent (int i){
        if (i!=0)
            return (i/2);
        else
            return 1;
    }//parent

    //this method the index of the object in the left branch
    private int left (int i){
        if (2*i<h.length)
            return 2*i;
        else
            return i;
    }//left

    //this method the index of the object in the right branch
    private int right (int i){
        if ((2*i)+1<h.length)
            return ((2*i)+1);
        else
            return i;
    }//right

    /**
     * This method creates a Node object verifying that the element is
     * not null and increment the array length by one to introduce the Node object
     * @param priority: this is the priority associated to the element
     * @param elem: this is the element to insert
     * @throws PriorityQueueException: it throw an error if the element is null
     */
    public void insert(double priority, T elem) throws PriorityQueueException{
        if(elem == null)
            throw new PriorityQueueException("Insert: the element cannot be null");
        if (!map.containsKey(elem)) {
            Node p = new Node<T>(priority, elem);
            int i = h.length;
            h = Arrays.copyOf(h, i + 1);
            h[i] = p;
            map.put(elem, i);
            control(i);
        } else {
            System.out.println("Element already exist");
        }
    }//insert

    //this method verifies the correct insertion of the new object
    private void control(int length) {
        while ((length > 1) && (h[parent(length)].compareTo(h[length]))){
            length = _switch(length);
        }
    }// control

    //this method changes the parent with the son
    private int _switch(int length){
        Node temp;
        temp = h[length];
        h[length] = h[parent(length)];
        map.put((T) h[length].getElem(), length);
        h[parent(length)] = temp;
        map.put((T) h[parent(length)], parent(length));
        return parent(length);
    }//_switch

    /**
     * this method extracts the highest priority object and replace it
     * with the second highest priority object in the array
     */
    public T extractMax(){
        int i = h.length;
        map.remove(h[1].getElem());
        Node tmp = h[1];
        h[1]=h[i-1];
        map.put((T)h[1].getElem(), 1);
        h = Arrays.copyOf(h, i-1);
        if (h.length>1)
            heapify(1);
        return (T)tmp.getElem();
    }//extractMax

    //this method reorganize the tree starting at index i
    private void heapify(int i){
        Node temp;
        int largest;
        if (h[left(i)].compareTo(h[i])){
            if (h[right(i)].compareTo(h[i]))
                largest = i;
            else
                largest = right(i);
        } else if (h[right(i)].compareTo(h[left(i)]))
            largest = left(i);
        else
            largest = right(i);
        if (largest != i){
            temp = h[i];
            h[i] = h[largest];
            map.put((T) h[i].getElem(), i);
            h[largest] = temp;
            map.put((T) h[largest].getElem(), largest);
            heapify(largest);
        }
    }// heapify

    /**
     *
     * @param elem: this is the elem to find in the map
     * @return: this method returns the index of the object
     * @throws PriorityQueueException: this is the error thrown when there is not the element in the map
     */
    public int getIndexOf(T elem) throws PriorityQueueException{
        if (!map.containsKey(elem))
            throw new PriorityQueueException("getIndexOf: there is not the element in the map or the map is empty");
        return map.get(elem);
    }//getIndexOf

    /**
     *
     * @param elem: this is the element to whom we have to decrease the key
     * @param newPr: this is the new key
     * @throws PriorityQueueException: this is the error thrown when there is not the element in the map
     */
    public void decreaseKey (T elem, double newPr) throws PriorityQueueException{
        int i = getIndexOf(elem);
        if (newPr<h[i].getPr()){
            System.out.println("ERROR: can't increase priority");
        } else{
            h[i].setPr(newPr);
            heapify(i);
        }
    }//decreaseKey

    /**
     *
     * @param elem: this is the element to whom we have to decrease the key
     * @param newPr: this is the new key
     * @throws PriorityQueueException: this is the error thrown when there is not the element in the map
     */
    public void updateKey (T elem, double newPr) throws PriorityQueueException {
        int i = getIndexOf(elem);
        h[i].setPr(newPr);
        if (i==1)
            return;
        Node temp;
        if (newPr>h[parent(i)].getPr())
            heapify(i);
        else {
            while (i>1 && newPr < h[parent(i)].getPr()) {
                temp = h[parent(i)];
                h[parent(i)] = h[i];
                map.put((T)h[parent(i)].getElem(), parent(i));
                h[i] = temp;
                map.put((T)h[i].getElem(), i);
                i = parent(i);
            }
        }
    }


    /**
     *
     * @param elem: this is the elem to delete
     */
    public void deleteElem (T elem) throws PriorityQueueException{
        int i = getIndexOf(elem);
        map.remove(elem);
        h[i] = h[h.length-1];
        h = Arrays.copyOf(h, h.length-1);
        if (h.length>1)
            heapify(1);
    }//deleteElem

    /**
     *
     * @param elem: this is the elem to find
     * @return: this method returns true if it finds the element, or false
     */
    public boolean contains (T elem) {
        return map.containsKey(elem);
    }//contains

}//class
